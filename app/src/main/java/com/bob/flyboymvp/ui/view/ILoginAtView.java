package com.bob.flyboymvp.ui.view;

import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.bob.flyboymvp.widget.MyDelLayout;

/**
 * @创建者 CSDN_LQR
 * @描述 登录界面的View
 */
public interface ILoginAtView {

    MyDelLayout getEtDelPhone();

    MyDelLayout getEtDelPwd();

    LinearLayout getLlUserSel();
    LinearLayout llUsers();

    RecyclerView getRvUserList();
}
