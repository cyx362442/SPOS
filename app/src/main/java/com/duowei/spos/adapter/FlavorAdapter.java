package com.duowei.spos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.duowei.spos.R;
import com.duowei.spos.bean.DMPZSD;

import java.util.List;

/**
 * Created by Administrator on 2017-08-14.
 */

public class FlavorAdapter extends BaseAdapter {
    private List<DMPZSD> list_dmpzsd;
    private Context context;
    private LayoutInflater mLayoutInflater;

    public FlavorAdapter(List<DMPZSD> list_dmpzsd, Context context) {
        this.list_dmpzsd = list_dmpzsd;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list_dmpzsd.size();
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
        ViewHod hold=null;
        if(convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.layout, null);
            hold = new ViewHod();
            hold.tvFlavor=convertView.findViewById(R.id.tv_flavor);
            convertView.setTag(hold);
        }else{
            hold= (ViewHod) convertView.getTag();
        }
        hold.tvFlavor.setText(list_dmpzsd.get(position).getNR());
        return convertView;
    }
    class ViewHod{
        public TextView tvFlavor;
    }
}
