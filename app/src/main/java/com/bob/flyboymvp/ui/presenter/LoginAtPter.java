package com.bob.flyboymvp.ui.presenter;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.api.ApiRetrofit;
import com.bob.flyboymvp.app.AppConst;
import com.bob.flyboymvp.db.PerAddrDaoOpe;
import com.bob.flyboymvp.db.PerSocialDaoOpe;
import com.bob.flyboymvp.db.UserInfoDaoOpe;
import com.bob.flyboymvp.manager.JsonMananger;
import com.bob.flyboymvp.model.PerAddrInfo;
import com.bob.flyboymvp.model.PerSocialInfor;
import com.bob.flyboymvp.model.UserInfo;
import com.bob.flyboymvp.model.cache.UserCache;
import com.bob.flyboymvp.ui.activity.FaceTestActivity;
import com.bob.flyboymvp.ui.activity.MainActivity;
import com.bob.flyboymvp.ui.activity.WebViewActivity;
import com.bob.flyboymvp.ui.adapter.UserListAdapter;
import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.base.BasePresenter;
import com.bob.flyboymvp.ui.view.ILoginAtView;
import com.bob.flyboymvp.util.LogUtils;
import com.bob.flyboymvp.util.PinyinUtils;
import com.bob.flyboymvp.util.SPUtils;
import com.bob.flyboymvp.util.UIUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginAtPter extends BasePresenter<ILoginAtView> {
    UserListAdapter mAdapter;
    public LoginAtPter(BaseActivity context) {
        super(context);
    }

    public void login() {
//        View view = View.inflate(mContext, R.layout.dialog_exit, null);
//        CustomDialog dialog = new CustomDialog(mContext, view, R.style.MyDialog);
//        dialog.show();
        String phone = getView().getEtDelPhone().getEditTextValue().trim();
        String pwd = getView().getEtDelPwd().getEditTextValue().trim();
        if (TextUtils.isEmpty(phone)) {
            UIUtils.showToast(UIUtils.getString(R.string.phone_not_empty));
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            UIUtils.showToast(UIUtils.getString(R.string.password_not_empty));
            return;
        }
        //本地验证
        UserInfo user= UserInfoDaoOpe.queryItem(phone,pwd,mContext);
        if(user==null){
            mContext.showWaitingDialog(UIUtils.getString(R.string.please_wait));
            Map<String, String> maps=new HashMap<>();
            maps.put("userphone",phone);
            maps.put("userpassword",pwd);
            ApiRetrofit.getInstance().login(maps)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(loginResponse -> {
                        try {
                            mContext.hideWaitingDialog();
                            JSONObject obj = new JSONObject(loginResponse.string());
                            int code = obj.getInt("result");
                            if (code == -5) {//表示没有guid，应跳转到选号界面

                            } else if (code < 0) {// 失败
                                UIUtils.showToast(obj.getString("message"));
                            } else {
                                String strguid=obj.getString("userguid");
                                String strToken=obj.getString("token");
                                String strUserPhone= obj.getString("userphone");
                                UserCache.save(strguid, phone, strToken);
                                UserInfo userinfo = new UserInfo();
                                userinfo.setUserGuid(strguid);
                                userinfo.setUserPhone(strUserPhone);
                                userinfo.setUserPassword(pwd);
                                UserInfoDaoOpe.saveData(mContext, userinfo);
                                SPUtils.getInstance(mContext).putString(AppConst.User.USER_GUID,strguid);
                                SPUtils.getInstance(mContext).putString(AppConst.User.TOKEN,strToken);
                                if (obj.has("usertype")) SPUtils.getInstance(mContext).putInt(AppConst.User.USER_TYPE,obj.getInt("usertype"));
                                if (obj.has("userpower") && !obj.getString("userpower").equals("null")) {
                                    SPUtils.getInstance(mContext).putInt(AppConst.User.USER_POWER,obj.getInt("userpower"));
                                }
                                Map<String, String> mapAll=new HashMap<>();
                                mapAll.put("token",strToken);
                                mapAll.put("userguid",strguid);
                                //获取用户详细信息
                                ApiRetrofit.getInstance().userAllInfo(mapAll)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(responseBody -> {
                                            try{
                                                JSONObject objPer = new JSONObject(responseBody.string());
                                                if(objPer.getInt("result")>=0){
                                                    JSONObject objPerList = new JSONObject(objPer.getString("peraddrlistModel"));
                                                    if (objPerList.getString("per_sex").equals("")) {
                                                        objPerList.put("per_sex", 0);
                                                    }
                                                    if (objPerList.getString("per_range").equals("")) {
                                                        objPerList.put("per_range", 100);
                                                    }
                                                    if(objPerList.has("per_phone1") && objPerList.getString("per_phone1").equals("0")){
                                                        objPerList.put("per_phone1", "");
                                                    }
                                                    if(objPerList.has("per_phone2") && objPerList.getString("per_phone2").equals("0")){
                                                        objPerList.put("per_phone2", "");
                                                    }
                                                    PerAddrInfo entity = JsonMananger.jsonToBean(objPerList.toString(),PerAddrInfo.class);
                                                    if (TextUtils.isEmpty(entity.getPer_full_name())) {
                                                        entity.setPer_phone0(phone);
                                                        entity.setPer_phone1("");
                                                        entity.setPer_phone2("");
                                                    } else {
                                                        if (!TextUtils.isEmpty(entity.getPer_phone0()) && entity.getPer_phone0().equals("0")) {
                                                            entity.setPer_phone0("");
                                                        }
                                                        if (!TextUtils.isEmpty(entity.getPer_phone1()) && entity.getPer_phone1().equals("0")) {
                                                            entity.setPer_phone1("");
                                                        }
                                                        if (!TextUtils.isEmpty(entity.getPer_phone2()) && entity.getPer_phone2().equals("0")) {
                                                            entity.setPer_phone2("");
                                                        }
                                                    }
                                                    if (!TextUtils.isEmpty(entity.getPer_unit_name())) {
                                                        entity.setPer_unit_py_short(PinyinUtils.getFirstSpell(entity.getPer_unit_name()));
                                                    }
                                                    entity.setUser_phone(strUserPhone);
                                                    entity.setPer_private(1);
                                                    entity.setPer_range(0);
                                                    entity.setPer_pinyin(PinyinUtils.getFirstSpell(entity.getPer_full_name()));
                                                    if(entity.getPer_phone0().equals(strguid)) entity.setPer_phone0(strUserPhone);
                                                    PerAddrDaoOpe.saveData(mContext,entity);
                                                    JSONObject jsonSoc = new JSONObject(objPer.getString("persocialinforModel"));
                                                    if(jsonSoc.has("per_birth_date") && jsonSoc.getString("per_birth_date").equals("null")){
                                                        jsonSoc.put("per_birth_date", "");
                                                    }
                                                    if (jsonSoc.getString("per_marriage").equals("")) {
                                                        jsonSoc.put("per_marriage", -1);
                                                    }
                                                    if (jsonSoc.getString("per_children").equals("")) {
                                                        jsonSoc.put("per_children", -1);
                                                    }
                                                    if (jsonSoc.getString("per_zodiac").equals("")) {
                                                        jsonSoc.put("per_zodiac", -1);
                                                    }
                                                    if (jsonSoc.getString("per_constellation").equals("")) {
                                                        jsonSoc.put("per_constellation", -1);
                                                    }
                                                    if (jsonSoc.getString("per_read_time").equals("")) {
                                                        jsonSoc.put("per_read_time", -1);
                                                    }
                                                    if (jsonSoc.getString("per_tv_time").equals("")) {
                                                        jsonSoc.put("per_tv_time", -1);
                                                    }
                                                    PerSocialInfor socEnt= JsonMananger.jsonToBean(jsonSoc.toString(), PerSocialInfor.class);
                                                    socEnt.setPer_addr_list_id(entity.getId().intValue());
                                                    PerSocialDaoOpe.saveData(mContext,socEnt);
                                                    Intent intent=new Intent(mContext,WebViewActivity.class);
                                                    intent.putExtra("url","file:///android_asset/yl/medi0.html");
                                                    mContext.jumpToActivity(intent);
                                                }else{
                                                    UIUtils.showToast(objPer.getString("message"));
                                                }
                                            }catch (Exception e){}
                                        },this::loginError);
                            }
                        }catch (Exception e){}
                    }, this::loginError);
        }else{
            mContext.jumpToActivity(MainActivity.class);
        }
    }

    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        mContext.hideWaitingDialog();
    }

    boolean issee=false;
    public void pwdVisible(){
        getView().getEtDelPwd().getEditText().setTransformationMethod(issee? PasswordTransformationMethod.getInstance(): HideReturnsTransformationMethod.getInstance());
        getView().getEtDelPwd().setImageResourceLeft(issee?R.mipmap.see1:R.mipmap.see2);
        getView().getEtDelPwd().getEditText().setSelection(getView().getEtDelPwd().getEditTextValue().length());
        issee=!issee;
    }

    boolean isLoad=false;
    public void userSelWindow(){
        getView().getLlUserSel().setVisibility(getView().getLlUserSel().getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        if(!isLoad) {
            isLoad=true;
            List<UserInfo> list= UserInfoDaoOpe.queryAll(mContext);
            mAdapter=new UserListAdapter(mContext,list);
            getView().getRvUserList().setAdapter(mAdapter);
            mAdapter.setOnItemClickListener((parent, view, position) -> {
                getView().getEtDelPhone().setEditTextValue(list.get(position).getUserPhone());
                getView().getLlUserSel().setVisibility(View.GONE);
            });
            //添加Android自带的分割线
            getView().getRvUserList().addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
            //getView().llUsers().getLayoutParams().height= CSSwit.getInstance().H*list.size();
        }
    }

    // 更好的办法
    public void filter(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }
}
