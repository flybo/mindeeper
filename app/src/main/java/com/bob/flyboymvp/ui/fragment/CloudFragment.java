package com.bob.flyboymvp.ui.fragment;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.ui.activity.MainActivity;
import com.bob.flyboymvp.ui.base.BaseFragment;
import com.bob.flyboymvp.ui.presenter.CloudFgPter;
import com.bob.flyboymvp.ui.view.ICloudFgView;

/**
 * 云录模块
 * Created on 2018/5/30.
 */

public class CloudFragment extends BaseFragment<ICloudFgView,CloudFgPter> implements ICloudFgView{
    @Override
    protected CloudFgPter createPresenter() {
        return new CloudFgPter((MainActivity)getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_cloud;
    }
}
