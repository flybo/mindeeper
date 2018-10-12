package com.bob.flyboymvp.ui.activity;

import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.presenter.RegisterPter;
import com.bob.flyboymvp.ui.view.IRegisterAtView;

/**
 * Created by bob on 2018/3/1.
 * 注册
 */

public class RegisterActivity extends BaseActivity<IRegisterAtView,RegisterPter>{

    @Override
    protected RegisterPter createPresenter() {
        return new RegisterPter(this);
    }

    @Override
    protected int provideContentViewId() {
        return 0;
    }
}
