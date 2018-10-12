package com.bob.flyboymvp.ui.view;

import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.List;

/**
 * Created on 2018/5/30.
 */

public interface IMainAtView {
    List<TextView> getTitList();
    ViewPager getViewPager();
}
