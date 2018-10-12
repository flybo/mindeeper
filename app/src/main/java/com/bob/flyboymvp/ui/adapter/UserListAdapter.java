package com.bob.flyboymvp.ui.adapter;

import android.content.Context;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.model.UserInfo;
import com.bob.flyboymvp.ui.adapter.baseadapter.BaseRecyclerViewAdapter;
import com.bob.flyboymvp.ui.adapter.baseadapter.BaseRecyclerViewHolder;
import com.bob.flyboymvp.witdiv.CSSwit;

import java.util.List;

/**
 * Created by Administrator on 2018/9/11.
 */

public class UserListAdapter extends BaseRecyclerViewAdapter<UserInfo>{

    public UserListAdapter(Context context, List<UserInfo> list) {
        super(context, list, R.layout.item_user_sel);
    }

    @Override
    public void convert(BaseRecyclerViewHolder holder, UserInfo item, int position, boolean isScrolling) {
        holder.getView(R.id.tv_phone).setPadding(CSSwit.getInstance().IM,CSSwit.getInstance().IM,0,0);
        holder.setText(R.id.tv_phone,item.getUserPhone());
    }
}
