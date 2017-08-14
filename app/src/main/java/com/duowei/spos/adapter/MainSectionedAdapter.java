package com.duowei.spos.adapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.duowei.spos.R;
import com.duowei.spos.app.App;
import com.duowei.spos.bean.DMJYXMSSLB;
import com.duowei.spos.bean.JYXMSZ;
import com.duowei.spos.greendao.gen.JYXMSZDao;
import com.duowei.spos.utils.CartList;
import com.duowei.spos.utils.Theme;

import java.util.List;

/**
 * 基本功能：右侧Adapter
 */
public class MainSectionedAdapter extends SectionedBaseAdapter{
    private Context mContext;
    private List<DMJYXMSSLB>mDMJYXMSSLBList;

    private int[]imgRes={R.mipmap.food1,R.mipmap.food2,R.mipmap.food3};
    private int[]imgAdds={R.mipmap.ic_add_circle_green_36dp,
            R.mipmap.ic_add_circle_orange_36dp,
            R.mipmap.ic_add_circle_blue_36dp};
    private int[]imgSubs={R.mipmap.ic_remove_circle_outline_green_36dp,
            R.mipmap.ic_remove_circle_outline_orange_36dp,
            R.mipmap.ic_remove_circle_outline_blue_36dp};

    public MainSectionedAdapter(Context context,List<DMJYXMSSLB>mDMJYXMSSLBList){
        this.mContext=context;
        this.mDMJYXMSSLBList=mDMJYXMSSLBList;
    }

    public interface OnCartAddListener{
        void onAddItemClick(View view,int positon,JYXMSZ jyxmsz);
    }
    private OnCartAddListener addListener;
    public void setOnCartAddListener(OnCartAddListener listener){
        this.addListener=listener;
    }

    @Override
    public Object getItem(int section, int position) {
        return 0;
    }

    @Override
    public long getItemId(int section, int position) {
        return position;
    }

    @Override
    public int getSectionCount() {
        return mDMJYXMSSLBList.size();
    }

    @Override
    public int getCountForSection(int section) {
        String lbbm = mDMJYXMSSLBList.get(section).getLBBM();
        List<JYXMSZ> list = App.getDaoSession().getJYXMSZDao().queryBuilder().where(JYXMSZDao.Properties.LBBM.eq(lbbm)).list();
        return list.size();
    }

    @Override
    public View getItemView(final int section, final int position, View convertView, ViewGroup parent) {
        RelativeLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (RelativeLayout) inflator.inflate(R.layout.right_list_item, null);
        } else {
            layout = (RelativeLayout) convertView;
        }
        String lbbm = mDMJYXMSSLBList.get(section).getLBBM();
        final JYXMSZ jyxmsz = App.getDaoSession().getJYXMSZDao().queryBuilder().where(JYXMSZDao.Properties.LBBM.eq(lbbm)).list().get(position);

        ((TextView) layout.findViewById(R.id.textItem)).setText(jyxmsz.getXMMC());
        ImageView img = layout.findViewById(R.id.imageItem);
        Glide.with(mContext).load(imgRes[position%imgRes.length]).into(img);
        TextView tvPrice = layout.findViewById(R.id.tv_price);
        tvPrice.setText("￥"+jyxmsz.getXSJG());
        tvPrice.setTextColor(Theme.getInstance().textColor());
        ImageView imgAdd = layout.findViewById(R.id.img_add);
        imgAdd.setImageResource(imgAdds[Theme.getInstance().bgColor]);
        ImageView imgSub = layout.findViewById(R.id.img_sub);
        imgSub.setImageResource(imgSubs[Theme.getInstance().bgColor]);

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListener.onAddItemClick(view,position,jyxmsz);
            }
        });
        return layout;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator.inflate(R.layout.header_item, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        layout.setClickable(false);
        TextView text = layout.findViewById(R.id.textItem);
        DMJYXMSSLB dmjyxmsslb = mDMJYXMSSLBList.get(section);
        long count = App.getDaoSession().getJYXMSZDao().queryBuilder().
                where(JYXMSZDao.Properties.LBBM.eq(dmjyxmsslb.getLBBM())).count();
        if(count>0){
            text.setVisibility(View.VISIBLE);
            text.setText(dmjyxmsslb.getLBMC());
        }else{
            text.setVisibility(View.GONE);
        }
        return layout;
    }
}
