package com.bob.flyboymvp.witdiv;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bob.flyboymvp.util.SPUtils;
import com.bob.flyboymvp.util.UIUtils;

import org.json.JSONObject;

/**
 * 2015-10-22
 */
public class CSSwit {
    public static CSSwit mCssWit;
    public float M,CWH;
    public int CW,CH,H,HA,NB,IM,IM_2;
    public int F2,F3,F4,F5,F6,F7;
   // public int F2d,F3d,F4d,F5d,F6d,F7d;
    public int A11,A21,A31,A32,A41,A43,A51,A52,A53,A54,A1T2,W21,A21T2;
    public int B21,B31,B41,B51,B52,B53;
    public int C10,C21,C31,C41,C51,C52,C53,C51T2,C41T2,C31T2,C52T2,C61T2,C21T2;
    public int D51,D41,D31,D21;
    public int M2,M4,M3,M6,M7;
    public JSONObject cssObj;
    public LinearLayout.LayoutParams paramsWH;


    public CSSwit() {
        refCss();
    }

    public static CSSwit getInstance() {

        if (mCssWit == null) {
            synchronized (CSSwit.class) {
                if (mCssWit == null) {
                    mCssWit = new CSSwit();
                    return mCssWit;
                }
            }
        }
        return mCssWit;
    }

    /**
     * 刷新重新计算
     */
    public void refCss() {
        DisplayMetrics metrics = UIUtils.getResource().getDisplayMetrics();
        CW = metrics.widthPixels;// 屏幕宽度(px);
        CH = metrics.heightPixels;// 屏幕高度(px);
        // CW = (int) (wintype == 1 ? CH * 0.5625
        // : (wintype == 2 ? (CW - CH * 0.5625) : CW));// 1是小窗口，2是中窗口。
        CWH = (float) CW / CH;// 宽高比
        M = Math.max(CW, CH) / 64;// 间距
        HA = (int) (CW < CH * 0.7 ? M * 4 : (CW < CH * 1.4 ? M * 4 : M * 3.6));// 按键高度
        H = (int)(M*4);// 按键高度
        NB = CWH < 0.7 ? 4 : (CWH < 1 ? 6 : 8); // 动态列数
        IM = (int) M;
        IM_2 = (int) (M * 0.5);
//        //布局中字体大小
//        F2 = (int) (M * 1.2/ scale + 0.5f);
//        F3 = (int) (M * 1.4/ scale + 0.5f);
//        F4 = (int) (M * 1.6/ scale + 0.5f);
//        F5 = (int) (M * 1.8/ scale + 0.5f); // 字体大小
//        F6 = (int) (M * 2/ scale + 0.5f);
//        F7 = (int) (M * 2.2/ scale + 0.5f);
        //代码中字体大小
        F2 = (int) (M * 1.2);
        F3 = (int) (M * 1.4);
        F4 = (int) (M * 1.6);
        F5 = (int) (M * 1.8); // 字体大小
        F6 = (int) (M * 2);
        F7 = (int) (M * 2.2);
        A11 = (int) (CW - M * 2);
        A21 = (int) (CW * 0.5 - M * 1.5);
        A31 = (int) (CW * 0.333 - M * 1.33);
        A32 = (int) (CW -A31 - M * 3);
        A41 = (int) (CW * 0.25 - M * 1.25);
        A43 = (int) (CW -A41 - M * 3);
        A51 = (int) (CW * 0.2 - M * 1.2);
        A52 = (int) (CW * 0.4 - M * 1.4);
        A53 = (int) (CW * 0.6 - M * 1.6);
        A54 = (int) (CW * 0.8 - M * 1.8);
        A1T2 = (int) (CW < CH ? (CW - M * 2) : (CW * 0.5 - M * 1.5));
        A21T2=(int)(CW<CH?((CW-M*3)/2):((CW-M*5)/4));
        B21 = (int) ((CW - M) / (NB * 0.5) - M);
        B31 = (int) ((CW - M) / (NB * 0.5 + 1) - M);
        B41 = (int) ((CW - M) / NB - M);
        B51 = (int) ((CW - M) / (NB + 1) - M);
        B52 = (int) ((CW - M) * 2 / (NB + 1) - M);
        B53 = (int) ((CW - M) * 3 / (NB + 1) - M);
        C10 = (int) (CW < CH ? M * 36 : (CW - M * 36));
        C21 = (int) (CW - B21 - M * 3);
        C31 = (int) (CW - B31 - M * 3);
        C41 = (int) (CW - B41 - M * 3);
        C51 = (int) (CW - B51 - M * 3);
        C52 = (int) (CW - B52 - M * 3);
        C53 = (int) (CW - B53 - M * 3);
        C51T2 = (int) (CW < CH ? (CW - B51 - M * 3): (CW * 0.5 - B51 - M * 2.5));
        C61T2=(int)(CW<CH?(CW-M*7):(CW*0.5-M*6.5));
        C52T2 = (int) (CW < CH ? (CW - B52 - M * 3): (CW * 0.5 - B52 - M * 2.5));
        C41T2 = (int) (CW < CH ? (CW - B41 - M * 3): (CW * 0.5 - B41 - M * 2.5));
        C31T2 = (int) (CW < CH ? (CW - B31 -M * 3): (CW * 0.5 - B31 - M * 2.5));
        C21T2=(int)(CW<CH?(CW-M*2):((CW-M*3)/2));
        D51=(int)((CW-M)/ Math.floor((CW-M)/(M*7))-M-0.5);
        D41=(int)((CW-M)/ Math.floor((CW-M)/(M*8))-M-0.5);
        D31=(int)((CW-M)/ Math.floor((CW-M)/(M*10))-M-0.5);
        D21=(int)((CW-M)/ Math.floor((CW-M)/(M*14))-M-0.5);
        M2=(int)(M*2);
        M3=(int)(M*3);
        M4=(int)(M*4);
        M6=(int)(M*6);
        M7=(int)(M*7);
        try{
            cssObj=new JSONObject();
            cssObj.put("C51T2",C51T2);
            cssObj.put("H",H);
            cssObj.put("B51",B51);
            cssObj.put("CW",CW);
            cssObj.put("M",IM);
            cssObj.put("M2",M2);
            cssObj.put("M5",(IM*5));
            cssObj.put("M8",(IM*8));
            cssObj.put("A51",A51);
            cssObj.put("A11",A11);
            cssObj.put("B31",B31);
            cssObj.put("C21T2",C21T2);
            cssObj.put("F2",F2);
            cssObj.put("F3",F3);
            cssObj.put("F4",F4);
            cssObj.put("F5",F5);
            cssObj.put("F6",F6);
            cssObj.put("F7",F7);
        }catch (Exception e){}
    }

    /**是否横屏*/
    public boolean isHorScreen(){
        return CW>CH;
    }

}
