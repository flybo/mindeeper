package com.bob.flyboymvp.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.app.AppConst;
import com.bob.flyboymvp.manager.BroadcastManager;
import com.bob.flyboymvp.ui.adapter.TabFragmentPagerAdapter;
import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.fragment.FragmentFactory;
import com.bob.flyboymvp.ui.presenter.MainAtPter;
import com.bob.flyboymvp.ui.view.IMainAtView;
import com.bob.flyboymvp.util.UIUtils;
import com.bob.flyboymvp.widget.NoScrollViewPager;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<IMainAtView,MainAtPter> implements IMainAtView{
    private final int SETUP_RESULT=100;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<TextView> mTitList=new ArrayList<>();
    @BindView(R.id.vpContent)
    NoScrollViewPager mVpContent;
    @BindView(R.id.ll_topbar)
    LinearLayout mLlTopBar;
    @BindView(R.id.tv_chat)
    TextView tvChat;
    @BindView(R.id.tv_contacts)
    TextView tvContacts;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.tv_cloud)
    TextView tvCloud;
    @BindView(R.id.ivLog)
    ImageView ivLog;
    @Override
    public void init() {
        BroadcastManager.getInstance(this).register(AppConst.Broadcast.SKIN_BG_SET, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                StatusBarUtil.setColor(MainActivity.this, UIUtils.getThemeColor(), 10);
                layoutToolbar.setBackgroundColor(UIUtils.getThemeColor());
                mLlTopBar.setBackgroundColor(UIUtils.getThemeColor());
            }
        });
        BroadcastManager.getInstance(this).register(AppConst.Broadcast.FULL_SCREEN, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                setFullScreen();
            }
        });

    }


    @Override
    public void initView() {
        mAppBar.setVisibility(View.GONE);
        mLlTopBar.setBackgroundColor(UIUtils.getThemeColor());
        mFragmentList.add(FragmentFactory.getInstance().getChatFragment());
        mFragmentList.add(FragmentFactory.getInstance().getContactsFragment());
        mFragmentList.add(FragmentFactory.getInstance().getSendFragment());
        mFragmentList.add(FragmentFactory.getInstance().getCloudFragment());
        mVpContent.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList));
        mVpContent.setNoScroll(true);
        tvChat.setBackgroundColor(UIUtils.getColor("#50ffffff"));
        mTitList.add(tvChat);
        mTitList.add(tvContacts);
        mTitList.add(tvSend);
        mTitList.add(tvCloud);
        mVpContent.setOffscreenPageLimit(4);
    }

    @Override
    public void initListener() {
        tvChat.setOnClickListener(v -> mPresenter.changeTit(0));
        tvContacts.setOnClickListener(v -> mPresenter.changeTit(1));
        tvSend.setOnClickListener(v -> mPresenter.changeTit(2));
        tvCloud.setOnClickListener(v -> mPresenter.changeTit(3));
        ivLog.setOnClickListener(v -> jumpToActivity(UserSetupActivity.class));
    }

    @Override
    protected MainAtPter createPresenter() {
        return new MainAtPter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public List<TextView> getTitList() {
        return mTitList;
    }

    @Override
    public ViewPager getViewPager() {
        return mVpContent;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==0) return;
        switch (requestCode){
            case SETUP_RESULT:
                setFullScreen();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BroadcastManager.getInstance(this).unregister(AppConst.Broadcast.SKIN_BG_SET);
        BroadcastManager.getInstance(this).unregister(AppConst.Broadcast.FULL_SCREEN);
    }
}
