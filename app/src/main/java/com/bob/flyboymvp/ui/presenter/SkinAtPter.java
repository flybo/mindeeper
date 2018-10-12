package com.bob.flyboymvp.ui.presenter;

import com.bob.flyboymvp.app.AppConst;
import com.bob.flyboymvp.manager.BroadcastManager;
import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.base.BasePresenter;
import com.bob.flyboymvp.ui.view.ISkinAtView;
import com.bob.flyboymvp.util.SPUtils;
import com.bob.flyboymvp.util.UIUtils;

/**
 * Created by Administrator on 2018/6/6.
 */

public class SkinAtPter extends BasePresenter<ISkinAtView>{
    String[] strColorL=new String[]{"#039EA1","#E66A12","#005C00","#3A64B3","#1F3D6E","#45484D","#8C4D30","#826471","#C2578D","#4C3370"};
    String[] strColorR=new String[]{"#86D9D3","#FFB663","#06CF27","#4FA8E8","#4E7DC4","#969A9C","#E0A48B","#B08C7D","#FC97E1","#B088DB"};
    public SkinAtPter(BaseActivity context) {
        super(context);
    }

    public void setSkinColor(int index){
        SPUtils.getInstance(mContext).putString(AppConst.User.COLOR_MAIN,strColorL[index]);
        SPUtils.getInstance(mContext).putString(AppConst.User.COLOR_LESS,strColorR[index]);
        BroadcastManager.getInstance(UIUtils.getContext()).sendBroadcast(AppConst.Broadcast.SKIN_BG_SET);
        mContext.setResult(1);
        mContext.finish();
    }
}
