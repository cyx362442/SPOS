package com.duowei.spos.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duowei.spos.R;
import com.duowei.spos.app.App;
import com.duowei.spos.bean.WMLSB;
import com.duowei.spos.greendao.gen.WMLSBDao;
import com.duowei.spos.utils.BdUtil;
import com.duowei.spos.view.ChildListView;

import java.util.List;

/**
 * Created by Administrator on 2017-08-07.
 */

public class CartDetailAdapter extends RecyclerView.Adapter<CartDetailAdapter.ViewHold>{

    private Context context;
    private List<WMLSB>listWmlsb;
    private LayoutInflater mInflater;

    public static int index_tcsd=-1;
    public static boolean showClild=false;
    private List<WMLSB> mListSub;
    private ChildAdapter mChildAdapter;

    public CartDetailAdapter(Context context, List<WMLSB> listWmlsb) {
        this.context = context;
        this.listWmlsb = listWmlsb;
        mInflater = LayoutInflater.from(context);
    }

    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(View view,int positon);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener=listener;
    }

    public void setListWmlsb(List<WMLSB> listWmlsb) {
        this.listWmlsb = listWmlsb;
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = mInflater.inflate(R.layout.cartdetail_item, parent, false);
        ViewHold hold = new ViewHold(inflate);
        hold.subLisView=inflate.findViewById(R.id.lv_sub);
        hold.tvPosition=inflate.findViewById(R.id.tv_posttion);
        hold.tvName=inflate.findViewById(R.id.tv_name);
        hold.tvMoney=inflate.findViewById(R.id.tv_money);
        hold.tvNum=inflate.findViewById(R.id.tv_num);
        hold.tvFlavor=inflate.findViewById(R.id.tv_flavor);
        hold.llCombo=inflate.findViewById(R.id.ll_combo);
        hold.imgChevron=inflate.findViewById(R.id.img_chevron);

        hold.imgAdd=inflate.findViewById(R.id.img_add);
        hold.imgSub=inflate.findViewById(R.id.img_sub);
        return hold;
    }

    @Override
    public void onBindViewHolder(ViewHold holder, final int position) {
        WMLSB wmlsb = listWmlsb.get(position);
        holder.tvPosition.setText((position+1)+"");
        holder.tvName.setText(wmlsb.getXmmc());
        holder.tvMoney.setText("￥"+ BdUtil.BD(wmlsb.getXj(),2));
        holder.tvNum.setText(BdUtil.BD(wmlsb.getSl(),2)+"");

        //套餐主项
        if("A".equals(wmlsb.getBy15())){
            holder.imgChevron.setVisibility(View.VISIBLE);
            if(showClild&&index_tcsd==position){
                holder.imgChevron.setImageResource(R.mipmap.ic_keyboard_arrow_down_black_36dp);
                mListSub = App.getDaoSession().getWMLSBDao().queryBuilder().
                        where(WMLSBDao.Properties.Tcbh.eq(wmlsb.getTcbh()), WMLSBDao.Properties.By15.notEq("A"))
                        .list();
                mChildAdapter = new ChildAdapter(context, mListSub);
                holder.subLisView.setAdapter(mChildAdapter);
            }else{
                holder.imgChevron.setImageResource(R.mipmap.ic_chevron_left_black_36dp);
            }
        }else{
            holder.imgChevron.setVisibility(View.INVISIBLE);
        }

        holder.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//加
                mListener.onItemClick(view,position);
            }
        });
        holder.imgSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//减
                mListener.onItemClick(view,position);
            }
        });
        holder.tvNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//数量
                mListener.onItemClick(view,position);
            }
        });
        holder.tvFlavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(view,position);
            }
        });
        holder.llCombo.setOnClickListener(new View.OnClickListener() {//套餐伸缩
            @Override
            public void onClick(View view) {
                mListener.onItemClick(view,position);
            }
        });

        //子listView
        if("A".equals(wmlsb.getBy15())&&index_tcsd==position&&showClild){
            mListSub = App.getDaoSession().getWMLSBDao().queryBuilder().
                    where(WMLSBDao.Properties.Tcbh.eq(wmlsb.getTcbh()),WMLSBDao.Properties.By15.notEq("A"))
                    .list();
            mChildAdapter = new ChildAdapter(context,mListSub);
            holder.subLisView.setAdapter(mChildAdapter);
            holder.subLisView.setVisibility(View.VISIBLE);
        }else{
            holder.subLisView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listWmlsb.size();
    }

    class ViewHold extends RecyclerView.ViewHolder{
        public ViewHold(View itemView) {
            super(itemView);
        }
        ChildListView subLisView;
        TextView tvPosition;
        TextView tvName;
        TextView tvMoney;
        TextView tvNum;
        ImageView imgAdd;
        ImageView imgSub;
        TextView tvFlavor;
        LinearLayout llCombo;
        ImageView imgChevron;
    }
}
