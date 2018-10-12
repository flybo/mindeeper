package com.bob.flyboymvp.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bob.flyboymvp.R;
import com.bob.flyboymvp.api.ApiRetrofit;
import com.bob.flyboymvp.app.AppConst;
import com.bob.flyboymvp.app.MyApp;
import com.bob.flyboymvp.app.base.BaseApp;
import com.bob.flyboymvp.widget.MyDelLayout;
import com.bob.flyboymvp.widget.StateButton;
import com.bob.flyboymvp.witdiv.CSSwit;
import com.bob.flyboymvp.witdiv.DivFL;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rx.schedulers.Schedulers;

import static com.zhy.autolayout.utils.ScreenUtils.getStatusBarHeight;


/**
 * @创建者 CSDN_LQR
 * @描述 和ui相关的工具类
 */
public class UIUtils {

    public static Toast mToast;
    public static int screenWidth;
    public static int screenHeight;
    public static int screenMin;// 宽高中，小的一边
    public static int screenMax;// 宽高中，较大的值
    public static float density;
    public static float scaleDensity;
    public static float xdpi;
    public static float ydpi;
    public static int densityDpi;
    public static int statusbarheight;
    public static int navbarheight;

    public static void showToast(String msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }

    public static void showToast(String msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), "", duration);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 用于在线程中执行弹土司操作
     */
    public static void showToastSafely(final String msg) {
        UIUtils.getMainThreadHandler().post(new Runnable() {

            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(getContext(), "", Toast.LENGTH_SHORT);
                }
                mToast.setText(msg);
                mToast.show();
            }
        });
    }


    /**
     * 得到上下文
     *
     * @return
     */
    public static Context getContext() {
        return BaseApp.getContext();
    }

    /**
     * 得到resources对象
     *
     * @return
     */
    public static Resources getResource() {
        return getContext().getResources();
    }

    /**
     * 得到string.xml中的字符串
     *
     * @param resId
     * @return
     */
    public static String getString(int resId) {
        return getResource().getString(resId);
    }

    /**
     * 得到string.xml中的字符串，带点位符
     *
     * @return
     */
    public static String getString(int id, Object... formatArgs) {
        return getResource().getString(id, formatArgs);
    }

    /**
     * 得到string.xml中和字符串数组
     *
     * @param resId
     * @return
     */
    public static String[] getStringArr(int resId) {
        return getResource().getStringArray(resId);
    }

    /**
     * 得到colors.xml中的颜色
     *
     * @param colorId
     * @return
     */
    public static int getColor(int colorId) {
        return getResource().getColor(colorId);
    }

    public static int getColor(String colorVal) {
        return Color.parseColor(colorVal);
    }

    //获取主题背景色
    public static int getThemeColor(){
        return getColor(SPUtils.getInstance(getContext()).getString(AppConst.User.COLOR_MAIN,AppConst.DEFAULT_BG_COLOR));
    }

    /**
     * 得到应用程序的包名
     *
     * @return
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**
     * 得到主线程Handler
     *
     * @return
     */
    public static Handler getMainThreadHandler() {
        return MyApp.getMainHandler();
    }

    /**
     * 得到主线程id
     *
     * @return
     */
    public static long getMainThreadId() {
        return MyApp.getMainThreadId();
    }

    /**
     * 安全的执行一个任务
     *
     * @param task
     */
    public static void postTaskSafely(Runnable task) {
        int curThreadId = android.os.Process.myTid();
        // 如果当前线程是主线程
        if (curThreadId == getMainThreadId()) {
            task.run();
        } else {
            // 如果当前线程不是主线程
            getMainThreadHandler().post(task);
        }
    }

    /**
     * 延迟执行任务
     *
     * @param task
     * @param delayMillis
     */
    public static void postTaskDelay(Runnable task, int delayMillis) {
        getMainThreadHandler().postDelayed(task, delayMillis);
    }

    /**
     * 移除任务
     */
    public static void removeTask(Runnable task) {
        getMainThreadHandler().removeCallbacks(task);
    }

    /**
     * dip-->px
     */
    public static int dip2Px(int dip) {
        // px/dip = density;
        // density = dpi/160
        // 320*480 density = 1 1px = 1dp
        // 1280*720 density = 2 2px = 1dp

        float density = getResource().getDisplayMetrics().density;
        int px = (int) (dip * density + 0.5f);
        return px;
    }

    /**
     * px-->dip
     */
    public static int px2dip(int px) {

        float density = getResource().getDisplayMetrics().density;
        int dip = (int) (px / density + 0.5f);
        return dip;
    }

    /**
     * sp-->px
     */
    public static int sp2px(int sp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResource().getDisplayMetrics()) + 0.5f);
    }


    public static int getDisplayWidth() {
        if (screenWidth == 0) {
            GetInfo(UIUtils.getContext());
        }
        return screenWidth;
    }

    public static int getDisplayHeight() {
        if (screenHeight == 0) {
            GetInfo(UIUtils.getContext());
        }
        return screenHeight;
    }

    public static void GetInfo(Context context) {
        if (null == context) {
            return;
        }
        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        screenMin = (screenWidth > screenHeight) ? screenHeight : screenWidth;
        screenMax = (screenWidth < screenHeight) ? screenHeight : screenWidth;
        density = dm.density;
        scaleDensity = dm.scaledDensity;
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;
        densityDpi = dm.densityDpi;
        statusbarheight = getStatusBarHeight(context);
        navbarheight = getNavBarHeight(context);
    }

    public static int getNavBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    public static int getCssWitVal(String name){
        try {
            return CSSwit.getInstance().cssObj.getInt(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }




    public static List<View> initViews(ViewGroup viewGroup){
        try{
            List<View> views= getAllChildViews(viewGroup);
            List<View> viewLays=new ArrayList<>();
            for (View v : views) {
                if(v.getTag()!=null) {
                    if(v instanceof AbsoluteLayout){
                        viewLays.add(v);
                    }else {
                        String strTag = v.getTag().toString();
                        if(!strTag.contains(",")){
                            if (v instanceof TextView) {
                                ((TextView) v).setTextSize(0, getCssWitVal(strTag));
                            }
                        }else {
                            String[] tags = strTag.split(",");
                            if(!tags[0].equals("w")) v.getLayoutParams().width = getCssWitVal(tags[0]);
                            if(!tags[1].equals("w")) v.getLayoutParams().height = getCssWitVal(tags[1]);
                            if (tags.length == 3) {
                                if (v instanceof TextView) {
                                    ((TextView) v).setTextSize(0, getCssWitVal(tags[2]));
                                } else if (v instanceof MyDelLayout) {
                                    ((MyDelLayout) v).getEditText().setTextSize(0, getCssWitVal(tags[2]));
                                } else if (v instanceof StateButton) {
                                    ((StateButton) v).setTextSize(0, getCssWitVal(tags[2]));
                                }
                            }else if(tags.length == 2){
                                if(v instanceof ImageView){
                                    if(!tags[0].equals("w")) v.getLayoutParams().width = getCssWitVal(tags[0]);
                                    if(!tags[1].equals("w")) v.getLayoutParams().height = getCssWitVal(tags[1]);
                                }else if(v instanceof LinearLayout){
                                    if(!tags[0].equals("w")) v.getLayoutParams().width = getCssWitVal(tags[0]);
                                    if(!tags[1].equals("w")) v.getLayoutParams().height = getCssWitVal(tags[1]);
                                }
                            }
                        }
                    }
                }
            }
            for (View v : viewLays) {
                String strTag = v.getTag().toString();
                String[] tags = strTag.split(",");
                if(tags.length==3) {
                    DivFL.getInstance().divlayout((AbsoluteLayout) v,getCssWitVal(tags[0]),getCssWitVal(tags[1]),getCssWitVal(tags[2]));
                }
            }
            return viewLays;
        }catch (Exception e){}
        return null;
    }
    /**
     * 获取所有子控件
     * @param view
     * @return
     */
    public static List<View> getAllChildViews(View view) {
        List<View> allchildren = new ArrayList<>();
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                allchildren.add(viewchild);
                allchildren.addAll(getAllChildViews(viewchild));
            }
        }
        return allchildren;
    }

    public static void downImg(String mUrl){

        ApiRetrofit.getInstance()
                .mApi
                .downloadPic(mUrl)
                .subscribeOn(Schedulers.newThread())
                .subscribe(responseBody -> {
                    try {
                        InputStream in = null;
                        FileOutputStream out = null;
                        try {
                            in = responseBody.byteStream();
                            out = new FileOutputStream(new File(AppConst.HEADER_SAVE_DIR, SystemClock.currentThreadTimeMillis() + "_header.jpg"));
                            int c;

                            while ((c = in.read()) != -1) {
                                out.write(c);
                            }
                        } catch (IOException e) {
                        } finally {
                            if (in != null) {
                                in.close();
                            }
                            if (out != null) {
                                out.close();
                            }
                        }
                    } catch (IOException e) {
                    }
                });
    }
}