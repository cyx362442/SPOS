package com.duowei.spos.fragment;


import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duowei.spos.R;
import com.duowei.spos.app.App;
import com.duowei.spos.bean.WMLSB;
import com.duowei.spos.event.Order;
import com.duowei.spos.event.ShowCartDetail;
import com.duowei.spos.greendao.gen.DMJYXMSSLBDao;
import com.duowei.spos.greendao.gen.WMLSBDao;
import com.duowei.spos.utils.BdUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment implements View.OnClickListener {

    private TextView mTvNum;
    private TextView mTvTotoalMoney;
    private ImageView mImgCart;

    public static boolean isShow=false;

    public CartFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_cart, container, false);
        EventBus.getDefault().register(CartFragment.this);

        mTvNum = inflate.findViewById(R.id.tv_num);
        mTvTotoalMoney = inflate.findViewById(R.id.tv_totoalMoney);
        mImgCart = inflate.findViewById(R.id.img_cart);
        inflate.findViewById(R.id.rl_cart).setOnClickListener(this);
        return inflate;
    }

    @Subscribe
    public void brushData(Order event){
        mImgCart.setImageResource(R.drawable.animcart);
        AnimationDrawable drawable = (AnimationDrawable) mImgCart.getDrawable();
        drawable.start();

        float num=0;
        float totoalMoney=0;
        List<WMLSB> wmlsbs = App.getDaoSession().getWMLSBDao().queryBuilder().
                where(WMLSBDao.Properties.Wmdbh.eq(event.wmdbh)).list();
        for(WMLSB w:wmlsbs){
            if(w.getTcbh()==null||"A".equals(w.getBy15())){
                num+=w.getSl();//单品及套餐主项
            }
            totoalMoney+=w.getXj();
        }
        mTvNum.setText(BdUtil.BD(num,2)+"");
        mTvTotoalMoney.setText(BdUtil.BD(totoalMoney,1)+"");
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(CartFragment.this);
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_cart:
                isShow=!isShow;
                EventBus.getDefault().post(new ShowCartDetail(isShow));
                break;
        }
    }
}
