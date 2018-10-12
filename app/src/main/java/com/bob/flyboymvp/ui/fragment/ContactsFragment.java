package com.bob.flyboymvp.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.ui.activity.MainActivity;
import com.bob.flyboymvp.ui.adapter.TabFragmentPagerAdapter;
import com.bob.flyboymvp.ui.base.BaseFragment;
import com.bob.flyboymvp.ui.fragment.contacts.PersonalFragment;
import com.bob.flyboymvp.ui.fragment.contacts.UnitFragment;
import com.bob.flyboymvp.ui.presenter.ContactsFgPter;
import com.bob.flyboymvp.ui.view.IContactsFgView;
import com.bob.flyboymvp.util.UIUtils;
import com.bob.flyboymvp.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 名录模块
 * Created on 2018/5/30.
 */

public class ContactsFragment extends BaseFragment<IContactsFgView,ContactsFgPter> implements IContactsFgView{
    @BindView(R.id.vp_cts)
    NoScrollViewPager mVpCts;
    @BindView(R.id.ll_topbar)
    LinearLayout layoutToolbar;
    @BindView(R.id.main)
    LinearLayout layoutMain;
    @BindView(R.id.lay_a)
    LinearLayout layA;
    @BindView(R.id.lay_b)
    LinearLayout layB;
    @BindView(R.id.lay_c)
    LinearLayout layC;
    @BindView(R.id.lay_d)
    LinearLayout layD;
    @BindView(R.id.lay_e)
    LinearLayout layE;
    private List<LinearLayout> mToolList=new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    public void initView(View rootView) {
        mToolList.add(layA);
        mToolList.add(layB);
        mToolList.add(layC);
        mToolList.add(layD);
        mToolList.add(layE);
        mFragmentList.add(new PersonalFragment());
        mFragmentList.add(new UnitFragment());
        mVpCts.setAdapter(new TabFragmentPagerAdapter(getChildFragmentManager(), mFragmentList));
        mVpCts.setNoScroll(true);
        UIUtils.initViews(layoutMain);
        changeTit(4);
    }

    @Override
    public void initListener() {
        super.initListener();
        layA.setOnClickListener(v -> changeTit(0));
        layB.setOnClickListener(v -> changeTit(1));
        layC.setOnClickListener(v -> changeTit(2));
        layD.setOnClickListener(v -> changeTit(3));
        layE.setOnClickListener(v -> changeTit(4));
    }

    @Override
    protected ContactsFgPter createPresenter() {
        return new ContactsFgPter((MainActivity)getActivity());
    }
    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_contacts;
    }

    public void changeTit(int index){
        int i=0;
        for (LinearLayout view : mToolList) {
            view.setBackgroundColor(UIUtils.getColor(i==index?"#50ffffff":"#00000000"));
            i++;
        }
        mVpCts.setCurrentItem(index);
    }
}
