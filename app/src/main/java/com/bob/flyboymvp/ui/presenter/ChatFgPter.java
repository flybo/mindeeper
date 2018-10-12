package com.bob.flyboymvp.ui.presenter;

import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.base.BasePresenter;
import com.bob.flyboymvp.ui.view.IChatFgView;
import com.bob.flyboymvp.ui.view.ICloudFgView;

/**
 * Created on 2018/5/30.
 */

public class ChatFgPter extends BasePresenter<IChatFgView> {
    public ChatFgPter(BaseActivity context) {
        super(context);
    }
}
