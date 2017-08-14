package com.duowei.spos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.duowei.spos.R;
import com.duowei.spos.adapter.MainSectionedAdapter;
import com.duowei.spos.bean.DMJYXMSSLB;
import com.duowei.spos.bean.JYXMSZ;
import com.duowei.spos.event.CartAnim;
import com.duowei.spos.event.CartComboAnim;
import com.duowei.spos.event.LeftOrder;
import com.duowei.spos.event.RightOrder;

import com.duowei.spos.fragment.dialog.ComboFragment;
import com.duowei.spos.utils.CartList;
import com.duowei.spos.view.PinnedHeaderListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderRightFragment extends BaseFragment implements AbsListView.OnScrollListener, MainSectionedAdapter.OnCartAddListener {
    private View view;
    private int position=0;

    private PinnedHeaderListView pinnedListView;
    private boolean isScroll = false;
    private MainSectionedAdapter mSectionedAdapter;

    private List<DMJYXMSSLB> mDmjyxmsslbList;

    public OrderRightFragment() {
        // Required empty public constructor
    }

    /*类别点击定位到单品*/
    @Subscribe
    public void notifyAdapter(LeftOrder event){
        isScroll=event.isScoll;
        int rightSection = 0;
        for (int i = 0; i < event.position; i++) {
            rightSection += mSectionedAdapter.getCountForSection(i) + 1;
        }
        pinnedListView.setSelection(rightSection);
    }

    @Subscribe
    public void ComboAnim(CartComboAnim event){
        if(view!=null){
            EventBus.getDefault().post(new CartAnim(view,position));
        }
    }

    @Override
    protected int getLayoutId() {
        EventBus.getDefault().register(OrderRightFragment.this);
        Bundle bundle = getArguments();
        mDmjyxmsslbList=bundle.getParcelableArrayList("list");
        return R.layout.fragment_order_right;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        pinnedListView = view.findViewById(R.id.pinnedListView);
        mSectionedAdapter = new MainSectionedAdapter(getActivity(), mDmjyxmsslbList);
        pinnedListView.setAdapter(mSectionedAdapter);
        mSectionedAdapter.setOnCartAddListener(this);
    }

    @Override
    protected void initData() {
        pinnedListView.setOnScrollListener(this);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(OrderRightFragment.this);
        super.onDestroy();
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        switch (scrollState) {
            // 当不滚动时
            case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                // 判断滚动到底部
                if (pinnedListView.getLastVisiblePosition() == (pinnedListView.getCount() - 1)) {
                    EventBus.getDefault().post(new RightOrder(ListView.FOCUS_DOWN));
                }
                // 判断滚动到顶部
                if (pinnedListView.getFirstVisiblePosition() == 0) {
                    EventBus.getDefault().post(new RightOrder(0));
                }
                break;
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (isScroll==true) {
             //正在滚动中
            EventBus.getDefault().post(new RightOrder(mSectionedAdapter.getSectionForPosition(pinnedListView.getFirstVisiblePosition())));
                if (firstVisibleItem + visibleItemCount == totalItemCount - 1) {
                    EventBus.getDefault().post(true);
                }
        } else {
            isScroll = true;
        }
    }

    @Override
    public void onAddItemClick(View view, int positon, JYXMSZ jyxmsz) {
        if("1".equals(jyxmsz.getSFTC())){//套餐
            this.view=view;
            this.position=positon;
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment fragment = getFragmentManager().findFragmentByTag(getResources().getString(R.string.dialog_combo));
            if(fragment!=null){
                ft.remove(fragment);
            }
            ComboFragment dialogFragment = ComboFragment.newInstance(jyxmsz);
            dialogFragment.show(ft,getResources().getString(R.string.dialog_combo));
        }else{//单品
            CartList.getInstance().cartAdd(jyxmsz);
            EventBus.getDefault().post(new CartAnim(view,positon));
        }
    }
}
