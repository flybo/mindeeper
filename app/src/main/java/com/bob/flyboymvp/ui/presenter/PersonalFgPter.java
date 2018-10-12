package com.bob.flyboymvp.ui.presenter;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.model.PerAddrInfo;
import com.bob.flyboymvp.ui.adapter.ContentsAdapter;
import com.bob.flyboymvp.ui.adapter.SimpleItemTouchHelperCallback;
import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.base.BasePresenter;
import com.bob.flyboymvp.ui.view.IPersonalFgView;
import com.bob.flyboymvp.util.PinyinUtils;
import com.bob.flyboymvp.widget.PinyinComparator;
import com.bob.flyboymvp.widget.TitleItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 名录个人persenter
 * Created on 2018/5/30.
 */

public class PersonalFgPter extends BasePresenter<IPersonalFgView> {
    List<PerAddrInfo> listData;
    ContentsAdapter mAdapter;
    private LinearLayoutManager manager;
    private PinyinComparator mComparator=new PinyinComparator();

    public PersonalFgPter(BaseActivity context) {
        super(context);
    }

    public void initData(){
        try {
            manager=new LinearLayoutManager(mContext);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            getView().getRecyclerView().setLayoutManager(manager);
            getView().getRecyclerView().addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));

            listData = new ArrayList<>();
            String[] arr=mContext.getResources().getStringArray(R.array.date);
            for (String s : arr) {
                PerAddrInfo ent = new PerAddrInfo();
                ent.setPer_pinyin( PinyinUtils.getPingYin(s).substring(0,1).toUpperCase());
                ent.setPer_full_name(s);
                ent.setUser_phone("1375050511");
                listData.add(ent);
            }
            Collections.sort(listData, mComparator);

            mAdapter = new ContentsAdapter(mContext, listData);
            getView().getRecyclerView().setAdapter(mAdapter);

            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
            ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
            touchHelper.attachToRecyclerView(getView().getRecyclerView());

            getView().getRecyclerView().addItemDecoration(new TitleItemDecoration(mContext,listData));

            getView().getSideBar().setOnTouchingLetterChangedListener(s -> {
                int position = mAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    manager.scrollToPositionWithOffset(position, 0);
                }
            });
        }catch (Exception e){}
    }
}
