package com.duowei.spos.app;

import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.duowei.spos.R;
import com.duowei.spos.bean.DMJYXMSSLB;
import com.duowei.spos.event.CartAnim;
import com.duowei.spos.event.ShowCartDetail;
import com.duowei.spos.fragment.CartFragment;
import com.duowei.spos.fragment.OrderDetailFragment;
import com.duowei.spos.fragment.OrderRightFragment;
import com.duowei.spos.fragment.OrderLeftFragment;
import com.duowei.spos.fragment.OrderTopFragment;
import com.duowei.spos.greendao.gen.DMJYXMSSLBDao;
import com.duowei.spos.greendao.gen.JYXMSZDao;
import com.duowei.spos.view.ShoppingCartAnimationView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity{

    private ImageView mImgCart;
    private View mVCartDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        EventBus.getDefault().register(this);

        List<DMJYXMSSLB> dmjyxmsslbList = getDMJYXMSSLBList();
        initFragment((ArrayList<DMJYXMSSLB>) dmjyxmsslbList);
        mImgCart = (ImageView) findViewById(R.id.img_cart2);
        mVCartDetail = findViewById(R.id.frame_detail);
    }

    private void initFragment(ArrayList<DMJYXMSSLB> dmjyxmsslbList) {
        FragmentManager fm = getSupportFragmentManager();
        OrderLeftFragment leftFragment = new OrderLeftFragment();
        OrderRightFragment rightFragment = new OrderRightFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", dmjyxmsslbList);
        leftFragment.setArguments(bundle);
        rightFragment.setArguments(bundle);

        fm.beginTransaction().replace(R.id.frameLeft, leftFragment).commit();
        fm.beginTransaction().replace(R.id.frameRight, rightFragment).commit();
        fm.beginTransaction().replace(R.id.frame3,new CartFragment()).commit();
        fm.beginTransaction().replace(R.id.frame_top,new OrderTopFragment()).commit();
        fm.beginTransaction().replace(R.id.frame_detail,new OrderDetailFragment()).commit();
    }

    @Subscribe
    public void showCartDetail(ShowCartDetail event){
        if(event.isShow){
            mVCartDetail.setVisibility(View.VISIBLE);
            Animation anim = AnimationUtils.loadAnimation(OrderActivity.this, R.anim.animup);
            mVCartDetail.startAnimation(anim);
        }else{
            Animation anim = AnimationUtils.loadAnimation(OrderActivity.this, R.anim.downanim);
            mVCartDetail.startAnimation(anim);
            mVCartDetail.setVisibility(View.GONE);
        }
    }

    @NonNull
    private List<DMJYXMSSLB> getDMJYXMSSLBList() {
        List<DMJYXMSSLB> dmjyxmsslbList = App.getDaoSession().getDMJYXMSSLBDao().queryBuilder().
                orderAsc(DMJYXMSSLBDao.Properties.XL).where(DMJYXMSSLBDao.Properties.SFTY.eq("1")).list();
        for(int i=0;i<dmjyxmsslbList.size();i++){
            DMJYXMSSLB dmjyxmsslb = dmjyxmsslbList.get(i);
            long count = App.getDaoSession().getJYXMSZDao().queryBuilder().
                    where(JYXMSZDao.Properties.LBBM.eq(dmjyxmsslb.getLBBM())).count();
            if(count<=0){
                dmjyxmsslbList.remove(i);
            }
        }
        return dmjyxmsslbList;
    }

    /*飞入购物车动画*/
    @Subscribe
    public void setCartAnim(CartAnim event){
        ShoppingCartAnimationView shoppingCartAnimationView = new ShoppingCartAnimationView(this);
        int position[] = new int[2];
        event.view.getLocationInWindow(position);
        shoppingCartAnimationView.setStartPosition(new Point(position[0], position[1]));
        ViewGroup rootView = (ViewGroup) this.getWindow().getDecorView();
        rootView.addView(shoppingCartAnimationView);
        int endPosition[] = new int[2];
        mImgCart.getLocationInWindow(endPosition);
        shoppingCartAnimationView.setEndPosition(new Point(endPosition[0], endPosition[1]));
        shoppingCartAnimationView.startBeizerAnimation();
    }
    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
