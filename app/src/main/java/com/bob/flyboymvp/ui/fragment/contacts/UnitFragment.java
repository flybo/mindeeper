package com.bob.flyboymvp.ui.fragment.contacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.ui.activity.MainActivity;
import com.bob.flyboymvp.ui.base.BaseFragment;
import com.bob.flyboymvp.ui.presenter.PersonalFgPter;
import com.bob.flyboymvp.ui.presenter.UnitFgPter;
import com.bob.flyboymvp.ui.view.IPersonalFgView;
import com.bob.flyboymvp.ui.view.IUnitFgView;
import com.bob.flyboymvp.util.UIUtils;
import com.bob.flyboymvp.widget.MyDelLayout;
import com.bob.flyboymvp.widget.SideBar;
import com.bob.flyboymvp.witdiv.CSSwit;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 名录个人模块
 * Created on 2018/5/30.
 */

public class UnitFragment extends BaseFragment<IUnitFgView,UnitFgPter> implements IUnitFgView{
    @BindView(R.id.main)
    RelativeLayout layMain;
    @BindView(R.id.recyclerView)
    SwipeMenuRecyclerView recyclerView;
    @BindView(R.id.sideBar)
    SideBar sideBar;
    @BindView(R.id.tv_dialog)
    TextView tvLog;
    View handerView;
    @Override
    public void initView(View rootView) {
        sideBar.setVerticalScreen();
        sideBar.setTextView(tvLog);
        mPresenter.initData();
        recyclerView.addHeaderView(handerView=LayoutInflater.from(getContext()).inflate(R.layout.layout_header,null));
        MyDelLayout layoutHand=handerView.findViewById(R.id.lay_del_hand);
        layoutHand.setImageResourceLeft(R.mipmap.ar5);
        layoutHand.getEditText().setHint("搜索公司、地址、业务");
        layoutHand.getEditText().setTextSize(0, CSSwit.getInstance().F4);
        UIUtils.initViews(layMain);
    }

    @Override
    protected UnitFgPter createPresenter() {
        return new UnitFgPter((MainActivity)getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_contacts_unit;
    }

    @Override
    public SwipeMenuRecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public SideBar getSideBar() {
        return sideBar;
    }
}
