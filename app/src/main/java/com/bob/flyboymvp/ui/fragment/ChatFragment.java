package com.bob.flyboymvp.ui.fragment;

import android.view.View;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.app.AppConst;
import com.bob.flyboymvp.manager.BroadcastManager;
import com.bob.flyboymvp.ui.activity.MainActivity;
import com.bob.flyboymvp.ui.base.BaseFragment;
import com.bob.flyboymvp.ui.presenter.ChatFgPter;
import com.bob.flyboymvp.ui.presenter.CloudFgPter;
import com.bob.flyboymvp.ui.view.IChatFgView;
import com.bob.flyboymvp.ui.view.ICloudFgView;
import com.bob.flyboymvp.util.SPUtils;
import com.bob.flyboymvp.util.UIUtils;
import com.bob.flyboymvp.widget.DLMultipleFingerScrollLayout;

import butterknife.BindView;

/**
 * 聊天、电话、短信模块
 * Created on 2018/5/30.
 */

public class ChatFragment extends BaseFragment<IChatFgView,ChatFgPter> implements IChatFgView{
    @BindView(R.id.dl_layout)
    DLMultipleFingerScrollLayout dlLayout;
    int mPercent;

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        UIUtils.initViews(dlLayout);
    }

    @Override
    public void initListener() {
        super.initListener();
        dlLayout.setCallback(new DLMultipleFingerScrollLayout.ScrollCallback() {
            @Override
            public void onFingerStart() {
                mPercent=0;
            }

            @Override
            public void onFingerEnd() {
                SPUtils.getInstance(getContext()).putBoolean(AppConst.User.FULL_SCREEN,mPercent>0);
                BroadcastManager.getInstance(getContext()).sendBroadcast(AppConst.Broadcast.FULL_SCREEN);
            }

            @Override
            public void onFingerScrolling(int percent) {
                System.out.println(percent+"..........");
                mPercent=percent;
            }
        });

    }

    @Override
    protected ChatFgPter createPresenter() {
        return new ChatFgPter((MainActivity)getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_chat;
    }
}
