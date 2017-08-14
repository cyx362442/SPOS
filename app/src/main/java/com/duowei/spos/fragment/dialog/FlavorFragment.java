package com.duowei.spos.fragment.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;

import com.duowei.spos.R;
import com.duowei.spos.adapter.FlavorAdapter;
import com.duowei.spos.app.App;
import com.duowei.spos.bean.DMKWDYDP;
import com.duowei.spos.bean.DMPZSD;
import com.duowei.spos.bean.TCSD;
import com.duowei.spos.event.CartComboAnim;
import com.duowei.spos.greendao.gen.DMKWDYDPDao;
import com.duowei.spos.greendao.gen.DMPZSDDao;
import com.duowei.spos.utils.CartList;
import com.duowei.spos.view.MaxGridView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FlavorFragment extends DialogFragment {
    private List<DMPZSD> list_dmpzsd;

    public static FlavorFragment newInstance(String xmbh){
        FlavorFragment fragment = new FlavorFragment();
        Bundle bundle = new Bundle();
        bundle.putString("xmbh",xmbh);
        fragment.setArguments(bundle);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_flavor, null);
        MaxGridView gv = inflate.findViewById(R.id.gridView);
        gv.setListViewHeight(500);
        String xmbh = getArguments().getString("xmbh", "");

        list_dmpzsd=new ArrayList<>();
        List<DMKWDYDP> list = App.getDaoSession().getDMKWDYDPDao().
                queryBuilder().where(DMKWDYDPDao.Properties.XMBH.eq(xmbh)).list();
        if (list.size() > 0) {//单品对应的口味
            for (int i = 0; i < list.size(); i++) {
                String pzbm = list.get(i).getPZBM();
                List<DMPZSD> list1 = App.getDaoSession().getDMPZSDDao().
                        queryBuilder().where(DMPZSDDao.Properties.PZBM.eq(pzbm)).list();
                if (list1.size() > 0) {
                    list_dmpzsd.add(list1.get(0));
                }
            }
        } else {//下载全部口味
            list_dmpzsd = App.getDaoSession().getDMPZSDDao().loadAll();
        }
        //全部置选中状态false
        for(int i=0;i<list_dmpzsd.size();i++){
            list_dmpzsd.get(i).setSelect(false);
        }
        FlavorAdapter adapter = new FlavorAdapter(list_dmpzsd, getActivity());
        gv.setAdapter(adapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        return builder.setView(inflate).create();
    }
}
