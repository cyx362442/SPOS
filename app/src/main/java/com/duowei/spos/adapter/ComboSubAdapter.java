package com.duowei.spos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duowei.spos.R;
import com.duowei.spos.bean.TCSD;

import java.util.List;

/**
 * Created by Administrator on 2017-08-10.
 */

public class ComboSubAdapter extends BaseAdapter {
    private Context context;
    private List<TCSD> tcsdList;

    public ComboSubAdapter(Context context, List<TCSD> tcsdList) {
        this.context = context;
        this.tcsdList = tcsdList;
    }

    public void setTcsdList(List<TCSD> tcsdList){
        this.tcsdList=tcsdList;
    }

    @Override
    public int getCount() {
        return tcsdList.size();
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
       ViewHold hold=null;
        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.gridview_combo_item, null);
            hold=new ViewHold();
            hold.ll=convertView.findViewById(R.id.ll_combosub);
            hold.tvName = convertView.findViewById(R.id.tv_name);
            hold.tvNum=convertView.findViewById(R.id.tv_num);
            hold.tvPrice=convertView.findViewById(R.id.tv_price);
            convertView.setTag(hold);
        }else{
            hold= (ViewHold) convertView.getTag();
        }
        final TCSD tcsd = tcsdList.get(position);
        if("1".equals(tcsd.getSFXZ())){
            hold.ll.setBackground(context.getResources().getDrawable(R.drawable.shape_square_green));
        }else{
            hold.ll.setBackground(context.getResources().getDrawable(R.drawable.shape_square_white));
        }
        hold.tvName.setText(tcsd.getXMMC1());
        hold.tvNum.setText("×"+tcsd.getSL());
        hold.tvPrice.setText("￥"+tcsd.getDJ());

        hold.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<tcsdList.size();i++){
                    TCSD tcsd = tcsdList.get(i);
                    if("1".equals(tcsd.getSFXZ())){
                        tcsd.setSFXZ("0");
                    }
                }
                tcsd.setSFXZ("1");
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
    class ViewHold{
        public LinearLayout ll;
        public TextView tvName;
        public TextView tvNum;
        private TextView tvPrice;
    }
}
