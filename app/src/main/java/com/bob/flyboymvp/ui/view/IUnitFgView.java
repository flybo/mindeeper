package com.bob.flyboymvp.ui.view;


import com.bob.flyboymvp.widget.SideBar;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

/**
 * 名录个人view
 * Created on 2018/7/12.
 */

public interface IUnitFgView {
    SwipeMenuRecyclerView getRecyclerView();
    SideBar getSideBar();
}
