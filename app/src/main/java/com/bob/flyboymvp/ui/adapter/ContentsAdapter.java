package com.bob.flyboymvp.ui.adapter;

import android.content.Context;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.model.PerAddrInfo;
import com.bob.flyboymvp.ui.adapter.baseadapter.BaseRecyclerViewAdapter;
import com.bob.flyboymvp.ui.adapter.baseadapter.BaseRecyclerViewHolder;
import com.bob.flyboymvp.util.UIUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/9/11.
 */

public class ContentsAdapter extends BaseRecyclerViewAdapter<PerAddrInfo> implements ItemTouchHelperAdapter{

    List<PerAddrInfo> mList;
    public ContentsAdapter(Context context, List<PerAddrInfo> list) {
        super(context, list, R.layout.item_person);
        mList=list;
    }

    @Override
    public void convert(BaseRecyclerViewHolder holder, PerAddrInfo item, int position, boolean isScrolling) {
        UIUtils.initViews(holder.getView(R.id.lay_bg));
        holder.setText(R.id.person_name,item.getPer_full_name());
        holder.setText(R.id.person_sign,item.getUser_phone());
        holder.setImageResource(R.id.person_face, R.mipmap.ic_launcher);
    }

    @Override
    public void getInfo(int position) {
        notifyDataSetChanged();
        UIUtils.showToast("aaa");
    }

    @Override
    public void telPhone(int position) {
        notifyDataSetChanged();
        UIUtils.showToast("bbb");
    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(int section) {
        for (int i = 0; i < getItemCount(); i++) {

            String sortStr =mList.get(i).getPer_pinyin();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }
}
