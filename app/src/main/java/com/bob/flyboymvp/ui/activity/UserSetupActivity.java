package com.bob.flyboymvp.ui.activity;

import android.content.Intent;
import android.widget.AbsoluteLayout;
import android.widget.TextView;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.app.AppConst;
import com.bob.flyboymvp.manager.BroadcastManager;
import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.presenter.UserSetupAtPter;
import com.bob.flyboymvp.ui.view.IUserSetupAtView;
import com.bob.flyboymvp.util.SPUtils;
import com.bob.flyboymvp.util.UIUtils;

import butterknife.BindView;

/**
 * 用户设置
 * Created on 2018/6/1.
 */

public class UserSetupActivity extends BaseActivity<IUserSetupAtView,UserSetupAtPter> implements IUserSetupAtView{
    private final int SKIN_RESULT=100;//皮肤设置请求值
    @BindView(R.id.abslay_set)
    AbsoluteLayout abslaySet;
    @BindView(R.id.tv_tool)
    TextView tvTool;
    @BindView(R.id.tv_skin)
    TextView tvSkin;
    @BindView(R.id.tv_set_hand)
    TextView tvSetHand;
    @BindView(R.id.tv_set_screen)
    TextView tvSetScreen;
    @BindView(R.id.tv_set_choice)
    TextView tvSetChoice;
    @Override
    public void initView() {
        setToolbarTitle("用户设置");
        abslaySet.setPadding(M,M,M,M);
        tvTool.setBackgroundColor(UIUtils.getThemeColor());
        tvSkin.setBackgroundColor(UIUtils.getThemeColor());
        tvSetHand.setBackgroundColor(UIUtils.getThemeColor());
        tvSetScreen.setBackgroundColor(UIUtils.getThemeColor());
        tvSetChoice.setBackgroundColor(UIUtils.getThemeColor());
    }

    @Override
    public void initData() {
        tvSetScreen.setText(!SPUtils.getInstance(this).getBoolean(AppConst.User.FULL_SCREEN,false)?"全屏":"标屏");
    }

    @Override
    public void initListener() {
        tvTool.setOnClickListener(v -> jumpToActivity(new Intent(this,WebViewActivity.class)
                .putExtra("url","http://www.witknow.com/w/webcata.html")
                .putExtra("title","工具")));
        tvSkin.setOnClickListener(v -> jumpToActivityForResult(SkinActivity.class,SKIN_RESULT));
        tvSetScreen.setOnClickListener(v -> {
            SPUtils.getInstance(this).putBoolean(AppConst.User.FULL_SCREEN,tvSetScreen.getText().equals("全屏"));
            BroadcastManager.getInstance(this).sendBroadcast(AppConst.Broadcast.FULL_SCREEN);
            setResult(1);
            finish();
        });

    }

    @Override
    protected UserSetupAtPter createPresenter() {
        return new UserSetupAtPter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_user_setup;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==0) return;
        switch (requestCode){
            case SKIN_RESULT:
                finish();
                break;
        }
    }
}
