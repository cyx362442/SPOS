package com.duowei.spos.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duowei.spos.R;
import com.duowei.spos.bean.WMLSB;
import com.duowei.spos.utils.BdUtil;

import java.util.List;

/**
 * Created by Administrator on 2017-08-12.
 */

public class ChildAdapter extends BaseAdapter{
    private Context context;
    private List<WMLSB>mWMLSBList;
    private LayoutInflater mLayoutInflater;

    public ChildAdapter(Context context, List<WMLSB> WMLSBList) {
        this.context = context;
        mWMLSBList = WMLSBList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mWMLSBList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHold hold;
        if(convertView==null){
            convertView =mLayoutInflater.inflate(R.layout.cartdetail_sub_item, null);
            hold = new ViewHold();
            hold.llSub= convertView.findViewById(R.id.ll_sub);
            hold.tvName = convertView.findViewById(R.id.tv_name);
            hold.tvMoney = convertView.findViewById(R.id.tv_money);
            hold.tvNum = convertView.findViewById(R.id.tv_num);
            convertView.setTag(hold);
        }else{
            hold = (ViewHold) convertView.getTag();
        }
        WMLSB wmlsb = mWMLSBList.get(position);
        if(TextUtils.isEmpty(wmlsb.getPz())){
            hold.tvName.setText(wmlsb.getXmmc());
        }else{
            hold.tvName.setText(wmlsb.getXmmc()+"\n"+wmlsb.getPz());
        }
        hold.tvNum.setText("×"+ BdUtil.BD(wmlsb.getSl(),2));
        hold.tvMoney.setText("￥"+BdUtil.BD(wmlsb.getXj(),2));
        return convertView;
    }

    class ViewHold {
        LinearLayout llSub;
        TextView tvName;
        TextView tvMoney;
        TextView tvNum;
    }
}
