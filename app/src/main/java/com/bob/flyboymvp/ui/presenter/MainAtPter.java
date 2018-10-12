package com.bob.flyboymvp.ui.presenter;

import android.widget.TextView;

import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.base.BasePresenter;
import com.bob.flyboymvp.ui.view.IMainAtView;
import com.bob.flyboymvp.util.UIUtils;

/**
 * Created on 2018/5/30.
 */

public class MainAtPter extends BasePresenter<IMainAtView>{
    public MainAtPter(BaseActivity context) {
        super(context);
    }

    public void changeTit(int index){
        int i=0;
        for (TextView view : getView().getTitList()) {
            view.setBackgroundColor(UIUtils.getColor(i==index?"#50ffffff":"#00000000"));
            i++;
        }
        getView().getViewPager().setCurrentItem(index);
    }

}
