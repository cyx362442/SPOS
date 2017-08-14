package com.duowei.spos.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duowei.spos.R;
import com.duowei.spos.app.App;
import com.duowei.spos.bean.TCSD;
import com.duowei.spos.greendao.gen.TCSDDao;

import java.util.List;

/**
 * Created by Administrator on 2017-08-10.
 */

public class ComboAdapter extends RecyclerView.Adapter<ComboAdapter.ViewHold> {
    private Context context;
    private List<String> listXmbh;
    private String xmbh;
    private LayoutInflater mLayoutInflater;
    private ComboSubAdapter mSubAdapter;

    public ComboAdapter(Context context, List<String>listXmbh,String xmbh) {
        this.context = context;
        this.listXmbh = listXmbh;
        this.xmbh=xmbh;
        mLayoutInflater=LayoutInflater.from(context);
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = mLayoutInflater.inflate(R.layout.combo_sub_item, parent, false);
        ViewHold hold = new ViewHold(inflate);
        hold.gridview=inflate.findViewById(R.id.gridView);
        return hold;
    }

    @Override
    public void onBindViewHolder(ViewHold holder, final int position) {
        String tm = listXmbh.get(position);
        List<TCSD> tcsdList = App.getDaoSession().getTCSDDao().queryBuilder().
                where(TCSDDao.Properties.XMBH.eq(xmbh), TCSDDao.Properties.TM.eq(tm)).list();
        mSubAdapter = new ComboSubAdapter(context, tcsdList);
        holder.gridview.setAdapter(mSubAdapter);
    }

    @Override
    public int getItemCount() {
        return listXmbh.size();
    }

    class ViewHold extends RecyclerView.ViewHolder{
        public ViewHold(View itemView) {
            super(itemView);
        }
        MyGridView gridview;
    }
}
