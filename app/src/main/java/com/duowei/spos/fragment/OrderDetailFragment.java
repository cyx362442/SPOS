package com.duowei.spos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.duowei.spos.R;
import com.duowei.spos.adapter.CartDetailAdapter;
import com.duowei.spos.app.App;
import com.duowei.spos.bean.POS;
import com.duowei.spos.bean.WMLSB;
import com.duowei.spos.event.Order;
import com.duowei.spos.event.ShowCartDetail;
import com.duowei.spos.event.UpdateOrder;
import com.duowei.spos.fragment.dialog.FlavorFragment;
import com.duowei.spos.greendao.gen.WMLSBDao;
import com.duowei.spos.utils.CartList;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderDetailFragment extends BaseFragment implements CartDetailAdapter.OnItemClickListener, View.OnClickListener {
    private List<WMLSB>listWmlsb;
    private RecyclerView mRv;
    private CartDetailAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        EventBus.getDefault().register(OrderDetailFragment.this);
        listWmlsb=new ArrayList<>();
        return R.layout.fragment_order_detail;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mRv = view.findViewById(R.id.recycleView);
        view.findViewById(R.id.tv_clear).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRv.addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.VERTICAL));

        mAdapter = new CartDetailAdapter(getActivity(), listWmlsb);
        mRv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(OrderDetailFragment.this);
    }

    @Subscribe
    public void setListWmlsb(ShowCartDetail event){
        brushList();
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(OrderDetailFragment.this);
        super.onDestroy();
    }

    @Subscribe
    public void updateOrder(UpdateOrder event){
        brushList();
        EventBus.getDefault().post(new Order(POS.wmdbh));//刷新购物车金额数量
        if(listWmlsb.size()<=0){
            EventBus.getDefault().post(new ShowCartDetail(CartFragment.isShow=false));
        }
    }

    private void brushList() {
        WMLSBDao wmlsbDao = App.getDaoSession().getWMLSBDao();
        listWmlsb = wmlsbDao.queryRaw("where wmdbh=? and (tcbh is null  or by15='A')", POS.wmdbh);
        mAdapter.setListWmlsb(listWmlsb);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, int positon) {
        WMLSB wmlsb = listWmlsb.get(positon);
        switch (view.getId()){
            case R.id.img_add:
                CartList.getInstance().orderUpdate(wmlsb,1);
                break;
            case R.id.img_sub:
                CartList.getInstance().orderUpdate(wmlsb,-1);
                break;
            case R.id.tv_flavor:
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment fragment = getFragmentManager().findFragmentByTag(getResources().getString(R.string.dialog_flavor));
                if(fragment!=null){
                    ft.remove(fragment);
                }
                FlavorFragment flavorFragment = FlavorFragment.newInstance(wmlsb.getXmbh());
                flavorFragment.show(ft,getResources().getString(R.string.dialog_flavor));
                break;
            case R.id.ll_combo:
                //套餐子项伸缩
                if(mAdapter.index_tcsd==positon&&mAdapter.showClild==true){
                    mAdapter.showClild=false;
                }else{
                    mAdapter.showClild=true;
                }
                mAdapter.index_tcsd=positon;
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        App.getDaoSession().getWMLSBDao().deleteInTx(listWmlsb);
        for(int i=0;i<listWmlsb.size();i++){//套餐子项
            WMLSB wmlsb = listWmlsb.get(i);
            if(wmlsb.getTcbh()!=null){
                List<WMLSB> wmlsbList = App.getDaoSession().getWMLSBDao().queryBuilder().
                        where(WMLSBDao.Properties.Tcbh.eq(wmlsb.getTcbh())).list();
                App.getDaoSession().getWMLSBDao().deleteInTx(wmlsbList);
            }
        }
        EventBus.getDefault().post(new Order(POS.wmdbh));//刷新购物车金额数量
        EventBus.getDefault().post(new ShowCartDetail(CartFragment.isShow=false));
    }
}
