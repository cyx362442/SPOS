package com.duowei.spos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import com.duowei.spos.R;
import com.duowei.spos.bean.POS;
import com.duowei.spos.utils.DateTimes;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderTopFragment extends BaseFragment implements View.OnClickListener {

    private EditText mEt;

    @Override
    protected int getLayoutId() {
        POS.wmdbh=POS.model+DateTimes.getInstance().getTime();
        return R.layout.fragment_order_top;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mEt = view.findViewById(R.id.et_search);
        view.findViewById(R.id.tv_open).setOnClickListener(this);
        view.findViewById(R.id.img_back).setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_open:
                POS.wmdbh=POS.model+DateTimes.getInstance().getTime();
                break;
            case R.id.img_back:
                getActivity().finish();
                break;
        }
    }
}
