package com.bob.flyboymvp.ui.presenter;

import android.widget.TextView;

import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.base.BasePresenter;
import com.bob.flyboymvp.ui.view.IChartAtView;
import com.bob.flyboymvp.ui.view.IMainAtView;
import com.bob.flyboymvp.util.UIUtils;

/**
 * Created on 2018/5/30.
 */

public class ChartAtPter extends BasePresenter<IChartAtView>{
    public ChartAtPter(BaseActivity context) {
        super(context);
    }
}
