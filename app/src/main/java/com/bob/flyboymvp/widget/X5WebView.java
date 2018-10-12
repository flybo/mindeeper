package com.bob.flyboymvp.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.TextView;

import com.bob.flyboymvp.api.ApiRetrofit;
import com.bob.flyboymvp.app.AppConst;
import com.bob.flyboymvp.db.PerAddrDaoOpe;
import com.bob.flyboymvp.db.PerSocialDaoOpe;
import com.bob.flyboymvp.manager.JsonMananger;
import com.bob.flyboymvp.model.PerAddrInfo;
import com.bob.flyboymvp.model.PerSocialInfor;
import com.bob.flyboymvp.util.MD5Utils;
import com.bob.flyboymvp.util.SPUtils;
import com.bob.flyboymvp.util.UIUtils;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class X5WebView extends WebView {
	TextView title;
	private WebViewClient client = new WebViewClient() {
		/**
		 * 防止加载网页时调起系统浏览器
		 */
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	};

	@SuppressLint("SetJavaScriptEnabled")
	public X5WebView(Context context, AttributeSet arg1) {
		super(context, arg1);
		this.setWebViewClient(client);
		// this.setWebChromeClient(chromeClient);
		// WebStorage webStorage = WebStorage.getInstance();
		addJavascriptInterface(new MyJavaScriptInterface(context),"witwebview");
		initWebViewSettings();
		this.getView().setClickable(true);
	}

	public X5WebView(Activity context) {
		super(context);
		try {
			this.setWebViewClient(client);
			addJavascriptInterface(new MyJavaScriptInterface(context),"witwebview");
			initWebViewSettings();
			this.getView().setClickable(true);
		}catch (Exception e){}
	}

	private void initWebViewSettings() {
		WebSettings webSetting = this.getSettings();
		webSetting.setJavaScriptEnabled(true);
		webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
		webSetting.setAllowFileAccess(true);
		webSetting.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
		webSetting.setSupportZoom(true);
		webSetting.setBuiltInZoomControls(true);
		webSetting.setUseWideViewPort(true);
		webSetting.setSupportMultipleWindows(true);
		// webSetting.setLoadWithOverviewMode(true);
		webSetting.setAppCacheEnabled(true);
		// webSetting.setDatabaseEnabled(true);
		webSetting.setDomStorageEnabled(true);
		webSetting.setGeolocationEnabled(true);
		webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
		// webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
		webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
		// webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
		webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);

		// this.getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
		// settings 的设计
		String strua = "Mozilla/5.0 (Linux; U; Android 6.0.1; zh-cn; Redmi 3X Build/MMB29M) AppleWebKit/537.36 (KHTML, like Gecko witknowc)Version/4.0 Chrome/37.0.0.0 MQQBrowser/7.2 Mobile Safari/537.36";
		webSetting.setUserAgentString(strua);
	}

	public X5WebView(Context arg0) {
		super(arg0);
		setBackgroundColor(85621);
	}

	public class MyJavaScriptInterface{
		public Object resultMsg;//回调web消息
		public int resultState = 1;//回调状态-1失败,1成功
		Context mContext;
		public MyJavaScriptInterface(Context context){
			mContext=context;
		}
		@JavascriptInterface
		public void postMessage(String json) {
			Log.d("pastMessage",json);
			String className = "", functioName = "";
			JSONObject params = null, objjson = null;
			try {
				objjson = new JSONObject(json);
				functioName = objjson.getString("functionname");
				functioName = functioName.replaceAll(":", "");
				if (objjson.has("witparams")) {
					params = new JSONObject(objjson.getString("witparams"));
				} else {
					params = new JSONObject();
				}
				params.put("callBackFun", objjson.has("callback") ? objjson.getString("callback") : "");
				params.put("callBackParam", objjson.has("callbackparam") ? objjson.getString("callbackparam") : "");
			} catch (Exception e) {
				//测试解析失败，则直接保存数据
				resultMsg = "json解析失败";
				callBackWebJs(params);
				return;
			}
			Class[] paramTypes = null;
			try {
				Method[] fields = this.getClass().getDeclaredMethods();//获取对象属性
				for (int z = 0; z < fields.length; z++) {
					Method field = fields[z];
					if (field.getName().toString().equals(functioName)) {
						paramTypes = field.getParameterTypes();//获得一个方法参数数组（getparameterTypes用于返回一个描述参数类型的Class对象数组）
						this.getClass().getMethod(functioName, paramTypes).invoke(this, params);
						return;
					}
				}
				resultMsg = functioName + " 方法不存在";
				callBackWebJs(params);
			} catch (Exception e) {
				resultMsg = "异常:方法不存在" + e.getMessage().toString();
				callBackWebJs(params);
			}
		}
		//web回调
		public void callBackWebJs(final JSONObject jsonParams) {
			try {
				final JSONObject returnObj = new JSONObject();
				returnObj.put("status", "0");
				returnObj.put("result", resultState);
				returnObj.put("message", resultMsg);
				UIUtils.getMainThreadHandler().post(() -> {
					try {
						String strJs = "javascript:" + jsonParams.getString("callBackFun") + "(" + returnObj.toString() + ",'" + jsonParams.getString("callBackParam") + "')";
						Log.d("javascript", strJs);
						loadUrl(strJs);
					}catch (Exception e){}
				});


			} catch (Exception e) {
			}
		}
		//1获取用户信息
		public void getuserinfo(JSONObject jsonParams) {
			try {
				PerAddrInfo perEnt= PerAddrDaoOpe.queryMyselfItem(mContext);
				PerSocialInfor socEnt= PerSocialDaoOpe.queryItem(mContext,perEnt.getId().intValue());
				JSONObject sum = new JSONObject(JsonMananger.beanToJson(perEnt));
				String strguid= SPUtils.getInstance(mContext).getString(AppConst.User.USER_GUID,"");
				sum.put("user_guid", strguid);
				sum.put("token", SPUtils.getInstance(mContext).getString(AppConst.User.TOKEN,""));
				sum.put("usertype", SPUtils.getInstance(mContext).getInt(AppConst.User.USER_TYPE,-1));
				sum.put("userpower", SPUtils.getInstance(mContext).getInt(AppConst.User.USER_POWER,-1));
				sum.put("per_birthday", socEnt.getPer_birth_date());
				sum.put("per_birth_lunar", socEnt.getPer_birth_lunar());
				String mp = MD5Utils.decode16(strguid);
				String urlimg = AppConst.pathUserImg + mp + "/";
				sum.put("serverpath", urlimg);
				resultMsg = sum;
				callBackWebJs(jsonParams);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		public void eplogin(final JSONObject jsonObject){
			try{
				Map<String, String> map=new HashMap<>();
				map.put("userguid",SPUtils.getInstance(mContext).getString(AppConst.User.USER_GUID,""));
				map.put("token",SPUtils.getInstance(mContext).getString(AppConst.User.TOKEN,""));
				map.put("userid",jsonObject.getString("companylicense"));
				map.put("sn",jsonObject.getString("password"));
				ApiRetrofit.getInstance().cloudLogin(map)
						.subscribeOn(Schedulers.io())
						.observeOn(AndroidSchedulers.mainThread())
						.subscribe(responseBody -> {
							try{
								JSONObject object = new JSONObject(responseBody.string());
								if (object.getInt("result") >= 0) {//成功
									UIUtils.getMainThreadHandler().post(() -> {
										try {
											String strJs = "javascript:" + jsonObject.getString("callBackFun") + "(" + object.toString() + ",'" + jsonObject.getString("callBackParam") + "')";
											Log.d("javascript", strJs);
											loadUrl(strJs);
										}catch (Exception e){}
									});
								}else{
									resultState = -1;
									resultMsg = "失败";
									callBackWebJs(jsonObject);
								}
							}catch (Exception e){
								resultState = -1;
								resultMsg = "失败";
								callBackWebJs(jsonObject);
							}
						});
			}catch (Exception e){}
		}

	}

}
