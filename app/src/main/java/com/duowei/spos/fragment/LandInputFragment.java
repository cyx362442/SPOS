package com.duowei.spos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.duowei.spos.R;
import com.duowei.spos.event.ToLand;
import com.duowei.spos.utils.Theme;

import org.greenrobot.eventbus.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandInputFragment extends BaseFragment implements View.OnClickListener {

    private TextView mTvInput;
    private String password="";
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_land_input;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTvInput = view.findViewById(R.id.tv_input);
        view.findViewById(R.id.tv_zero).setOnClickListener(this);
        view.findViewById(R.id.tv_one).setOnClickListener(this);
        view.findViewById(R.id.tv_two).setOnClickListener(this);
        view.findViewById(R.id.tv_three).setOnClickListener(this);
        view.findViewById(R.id.tv_four).setOnClickListener(this);
        view.findViewById(R.id.tv_five).setOnClickListener(this);
        view.findViewById(R.id.tv_six).setOnClickListener(this);
        view.findViewById(R.id.tv_seven).setOnClickListener(this);
        view.findViewById(R.id.tv_eight).setOnClickListener(this);
        view.findViewById(R.id.tv_nine).setOnClickListener(this);
        view.findViewById(R.id.tv_exit).setOnClickListener(this);
        TextView tvLogin = view.findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(this);
        view.findViewById(R.id.tv_clear).setOnClickListener(this);
        view.findViewById(R.id.tv_back).setOnClickListener(this);
        tvLogin.setBackground(Theme.getInstance().getBgLogin());
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_zero:
                inputPassword("0");
                break;
            case R.id.tv_one:
                inputPassword("1");
                break;
            case R.id.tv_two:
                inputPassword("2");
                break;
            case R.id.tv_three:
                inputPassword("3");
                break;
            case R.id.tv_four:
                inputPassword("4");
                break;
            case R.id.tv_five:
                inputPassword("5");
                break;
            case R.id.tv_six:
                inputPassword("6");
                break;
            case R.id.tv_seven:
                inputPassword("7");
                break;
            case R.id.tv_eight:
                inputPassword("8");
                break;
            case R.id.tv_nine:
                inputPassword("9");
                break;
            case R.id.tv_back:
                if(password.length()>0){
                    password=password.substring(0,password.length()-1);
                    mTvInput.setText(password);
                }
                break;
            case R.id.tv_clear:
                password="";
                mTvInput.setText(password);
                break;
            case R.id.tv_login:
                EventBus.getDefault().post(new ToLand(password));
                break;
            case R.id.tv_exit:
                getActivity().finish();
                break;
        }
    }

    private void inputPassword(String str) {
        password+=str;
        mTvInput.setText(password);
    }
}
