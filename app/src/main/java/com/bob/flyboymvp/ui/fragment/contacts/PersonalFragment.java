package com.bob.flyboymvp.ui.fragment.contacts;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.ui.activity.MainActivity;
import com.bob.flyboymvp.ui.base.BaseFragment;
import com.bob.flyboymvp.ui.presenter.PersonalFgPter;
import com.bob.flyboymvp.ui.view.IPersonalFgView;
import com.bob.flyboymvp.util.UIUtils;
import com.bob.flyboymvp.widget.SideBar;

import butterknife.BindView;

/**
 * 名录个人模块
 * Created on 2018/5/30.
 */

public class PersonalFragment extends BaseFragment<IPersonalFgView,PersonalFgPter> implements IPersonalFgView{
    @BindView(R.id.main)
    RelativeLayout layMain;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.sideBar)
    SideBar sideBar;
    @BindView(R.id.tv_dialog)
    TextView tvLog;

    @Override
    public void initView(View rootView) {
        sideBar.setVerticalScreen();
        sideBar.setTextView(tvLog);
        mPresenter.initData();
        UIUtils.initViews(layMain);
    }

    @Override
    protected PersonalFgPter createPresenter() {
        return new PersonalFgPter((MainActivity)getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_contacts_personal;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public SideBar getSideBar() {
        return sideBar;
    }
}
