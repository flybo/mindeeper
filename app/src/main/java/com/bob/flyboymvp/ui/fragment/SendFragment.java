package com.bob.flyboymvp.ui.fragment;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.ui.activity.MainActivity;
import com.bob.flyboymvp.ui.base.BaseFragment;
import com.bob.flyboymvp.ui.presenter.ChatFgPter;
import com.bob.flyboymvp.ui.presenter.SendFgPter;
import com.bob.flyboymvp.ui.view.IChatFgView;
import com.bob.flyboymvp.ui.view.ISendFgView;

/**
 * 云录模块
 * Created on 2018/5/30.
 */

public class SendFragment extends BaseFragment<ISendFgView,SendFgPter> implements ISendFgView{

    @Override
    protected SendFgPter createPresenter() {
        return new SendFgPter((MainActivity)getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_send;
    }
}
