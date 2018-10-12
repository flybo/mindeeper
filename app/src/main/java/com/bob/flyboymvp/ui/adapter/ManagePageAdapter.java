package com.bob.flyboymvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bob.flyboymvp.ui.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2018/9/25.
 */

public class ManagePageAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> mFragments;
    public ManagePageAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        mFragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
