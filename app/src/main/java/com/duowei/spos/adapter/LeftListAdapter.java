package com.duowei.spos.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.duowei.spos.R;
import com.duowei.spos.bean.DMJYXMSSLB;
import com.duowei.spos.utils.Theme;

import java.util.List;

/**
 * 基本功能：左侧Adapter
 */
public class LeftListAdapter extends BaseAdapter {
    List<DMJYXMSSLB> dmjyxmsslbList;
    private Context context;
    private int selection=0;

    public LeftListAdapter(Context context, List<DMJYXMSSLB> dmjyxmsslbList) {
        this.dmjyxmsslbList = dmjyxmsslbList;
        this.context = context;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    @Override
    public int getCount() {
        return dmjyxmsslbList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return dmjyxmsslbList.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        Holder holder = null;
        if (arg1 == null) {
            holder = new Holder();
            arg1 = LayoutInflater.from(context).inflate(R.layout.left_list_item, null);
            holder.left_list_item = arg1.findViewById(R.id.left_list_item);
            holder.view=arg1.findViewById(R.id.view);
            arg1.setTag(holder);
        } else {
            holder = (Holder) arg1.getTag();
        }
        holder.view.setBackground(Theme.getInstance().getBgColor());
        holder.left_list_item.setText(dmjyxmsslbList.get(arg0).getLBMC());
        if(selection==arg0){
            holder.view.setVisibility(View.VISIBLE);
            holder.left_list_item.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }else{
            holder.view.setVisibility(View.GONE);
            holder.left_list_item.setBackgroundColor(Color.TRANSPARENT);
        }
        return arg1;
    }

    private class Holder {
        public TextView left_list_item;
        public View view;
    }
}
