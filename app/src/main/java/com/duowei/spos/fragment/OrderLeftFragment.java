package com.duowei.spos.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.duowei.spos.R;
import com.duowei.spos.adapter.LeftListAdapter;
import com.duowei.spos.bean.DMJYXMSSLB;
import com.duowei.spos.event.LeftOrder;
import com.duowei.spos.event.RightOrder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderLeftFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private ListView mLeftListview;
    private List<DMJYXMSSLB> mDmjyxmsslbList;
    private LeftListAdapter mAdapter;

    public OrderLeftFragment() {
        // Required empty public constructor
    }
    /*单品滑动定位到相应类别*/
    int y = 0;
    int x = 0;
    int z = 0;
    @Subscribe
    public void notifyAdapter(RightOrder event){
        for(int i=0;i<mDmjyxmsslbList.size();i++){
            if(i==event.position){
                mLeftListview.setSelection(event.position);
                mAdapter.setSelection(event.position);
                x=event.position;
            }
        }
        if (x != y) {
            mAdapter.notifyDataSetChanged();
            y = x;
            if (y == mLeftListview.getLastVisiblePosition()) {
                mLeftListview.setSelection(z);
            }
            if (x == mLeftListview.getFirstVisiblePosition()) {
                mLeftListview.setSelection(z);
            }
            if (event.isFocusDown==true) {
                mLeftListview.setSelection(ListView.FOCUS_DOWN);
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected int getLayoutId() {
        EventBus.getDefault().register(OrderLeftFragment.this);
        Bundle bundle = getArguments();
        mDmjyxmsslbList = bundle.getParcelableArrayList("list");
        return R.layout.fragment_oreder_left;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mLeftListview = view.findViewById(R.id.left_listview);
        mAdapter = new LeftListAdapter(getActivity(), mDmjyxmsslbList);
        mLeftListview.setAdapter(mAdapter);
        mLeftListview.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        mAdapter.setSelection(position);
        mAdapter.notifyDataSetChanged();
        EventBus.getDefault().post(new LeftOrder(position,false));
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(OrderLeftFragment.this);
        super.onDestroy();
    }
}
