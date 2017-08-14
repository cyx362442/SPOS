package com.duowei.spos.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.duowei.spos.R;
import com.duowei.spos.adapter.CoverFlowAdapter;
import com.duowei.spos.app.App;
import com.duowei.spos.app.OrderActivity;
import com.duowei.spos.bean.YHJBQK;
import com.duowei.spos.event.ToLand;
import com.duowei.spos.greendao.gen.YHJBQKDao;
import com.duowei.spos.listener.RecyclerItemClickListener;
import com.duowei.spos.utils.Theme;
import com.duowei.spos.utils.ToastUtil;
import com.duowei.spos.view.CoverFlowView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployerFragment extends BaseFragment implements CoverFlowView.CoverFlowItemListener {
    private LinkedList<YHJBQK>mLinkedList;
    private CoverFlowAdapter mFlowAdapter;
    private CoverFlowView mCfv;
    private TextView mTvName;
    private String mYhbh;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_employer;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        EventBus.getDefault().register(EmployerFragment.this);
        mCfv = view.findViewById(R.id.cover_flow);
        mTvName = view.findViewById(R.id.tv_name);
        ImageView img = view.findViewById(R.id.arrow);
        img.setBackground(Theme.getInstance().getImgUp());
    }

    @Override
    protected void initData() {
        setLinkList();
        mFlowAdapter = new CoverFlowAdapter(mLinkedList, getActivity());
        mCfv.setAdapter(mFlowAdapter);
        initListener();
    }

    private void setLinkList() {
        mLinkedList = new LinkedList<>();
        List<YHJBQK> yhjbqks = App.getDaoSession().getYHJBQKDao().queryBuilder().
                where(YHJBQKDao.Properties.XTJSQX.notEq("1")).list();
        for(int i=0;i<yhjbqks.size();i++){
            YHJBQK yhjbqk = yhjbqks.get(i);
            mLinkedList.add(new YHJBQK(yhjbqk.getYHMC(),yhjbqk.getYHBH(),yhjbqk.getYHMM()));
        }
    }

    private void initListener() {
        mCfv.setCoverFlowListener(EmployerFragment.this);
        mCfv.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mCfv.scrollToCenter(position);
            }
        }));
        mCfv.getLayoutManager().scrollToPosition(mFlowAdapter.getItemCount() / 2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCfv.scrollToCenter(mFlowAdapter.getItemCount() / 2);
            }
        },200);
    }

    @Override
    public void onItemChanged(int position) {

    }
    @Override
    public void onItemSelected(int position) {
        mYhbh = mLinkedList.get(position).getYHBH();
        mTvName.setText(mLinkedList.get(position).getYHMC());
    }

    @Subscribe
    public void land(ToLand event){
        YHJBQK unique = App.getDaoSession().getYHJBQKDao().queryBuilder().
                where(YHJBQKDao.Properties.YHBH.eq(mYhbh))
                .unique();
        if(unique.getYHMM().equals(event.password)){
            Intent intent = new Intent(getActivity(), OrderActivity.class);
            startActivity(intent);
        }else{
            ToastUtil.show("密码错误!");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
