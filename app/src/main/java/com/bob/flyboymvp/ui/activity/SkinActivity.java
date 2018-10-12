package com.bob.flyboymvp.ui.activity;

import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.presenter.SkinAtPter;
import com.bob.flyboymvp.ui.view.ISkinAtView;

import butterknife.BindView;

/**
 * 皮肤设置
 * Created by Administrator on 2018/6/6.
 */

public class SkinActivity extends BaseActivity<ISkinAtView,SkinAtPter> implements ISkinAtView{
    @BindView(R.id.abslay_set)
    AbsoluteLayout abslaySet;
    @BindView(R.id.layout_skin_one)
    LinearLayout llSkinOne;
    @BindView(R.id.layout_skin_two)
    LinearLayout llSkinTwo;
    @BindView(R.id.layout_skin_three)
    LinearLayout llSkinThree;
    @BindView(R.id.layout_skin_four)
    LinearLayout llSkinFour;
    @BindView(R.id.layout_skin_five)
    LinearLayout llSkinFive;
    @BindView(R.id.layout_skin_six)
    LinearLayout llSkinSix;
    @BindView(R.id.layout_skin_seven)
    LinearLayout llSkinSeven;
    @BindView(R.id.layout_skin_eight)
    LinearLayout llSkinEight;
    @BindView(R.id.layout_skin_nine)
    LinearLayout llSkinNine;
    @BindView(R.id.layout_skin_ten)
    LinearLayout llSkinTen;
    @Override
    public void initView() {
        setToolbarTitle("皮肤设置");
        abslaySet.setPadding(M,M,M,M);
    }

    @Override
    public void initListener() {
        llSkinOne.setOnClickListener(v -> mPresenter.setSkinColor(0));
        llSkinTwo.setOnClickListener(v -> mPresenter.setSkinColor(1));
        llSkinThree.setOnClickListener(v -> mPresenter.setSkinColor(2));
        llSkinFour.setOnClickListener(v -> mPresenter.setSkinColor(3));
        llSkinFive.setOnClickListener(v -> mPresenter.setSkinColor(4));
        llSkinSix.setOnClickListener(v -> mPresenter.setSkinColor(5));
        llSkinSeven.setOnClickListener(v -> mPresenter.setSkinColor(6));
        llSkinEight.setOnClickListener(v -> mPresenter.setSkinColor(7));
        llSkinNine.setOnClickListener(v -> mPresenter.setSkinColor(8));
        llSkinTen.setOnClickListener(v -> mPresenter.setSkinColor(9));
    }

    @Override
    protected SkinAtPter createPresenter() {
        return new SkinAtPter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_skin;
    }
}
