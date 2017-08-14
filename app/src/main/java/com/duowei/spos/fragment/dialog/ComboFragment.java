package com.duowei.spos.fragment.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.duowei.spos.R;
import com.duowei.spos.adapter.ComboAdapter;
import com.duowei.spos.app.App;
import com.duowei.spos.bean.JYXMSZ;
import com.duowei.spos.bean.TCSD;

import com.duowei.spos.event.CartComboAnim;
import com.duowei.spos.greendao.gen.TCSDDao;
import com.duowei.spos.utils.CartList;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * A simple subclass.
 */
public class ComboFragment extends DialogFragment{
    private HashMap<String,String> linkedMap;
    private List<String>listXmbh=new ArrayList<>();
    private List<TCSD> mTcsdList;
    private JYXMSZ mJyxmsz;

    public interface DialogFragmentDataImp{
        void show(String xmbh);
    }

    public static ComboFragment newInstance(JYXMSZ jyxmsz){
        ComboFragment fragment = new ComboFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("jyxmsz",jyxmsz);
        fragment.setArguments(bundle);//把参数传递给该DialogFragment
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.combo_item, null);
        linkedMap=new LinkedHashMap<>();

        RecyclerView rv = inflate.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.VERTICAL));
        mJyxmsz = getArguments().getParcelable("jyxmsz");
        mTcsdList = App.getDaoSession().getTCSDDao().queryBuilder().
                orderAsc(TCSDDao.Properties.TM).
                where(TCSDDao.Properties.XMBH.eq(mJyxmsz.getXMBH())).list();
        for(int i = 0; i< mTcsdList.size(); i++){
            TCSD tcsd = mTcsdList.get(i);
            linkedMap.put(tcsd.getTM(), mJyxmsz.getXMBH());
        }
        listXmbh.clear();
        for(String key:linkedMap.keySet()){
           listXmbh.add(key);
        }
        ComboAdapter adapter = new ComboAdapter(getActivity(), listXmbh, mJyxmsz.getXMBH());
        rv.setAdapter(adapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                List<TCSD>tcsdList=new ArrayList<>();
                for(int i=0;i<mTcsdList.size();i++){
                    TCSD tcsd = mTcsdList.get(i);
                    if("1".equals(tcsd.getSFXZ())){
                        tcsdList.add(tcsd);
                    }
                }
                dismiss();
                CartList.getInstance().cartAdd(mJyxmsz,tcsdList);
                EventBus.getDefault().post(new CartComboAnim());
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
