package com.duowei.spos.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.duowei.spos.app.App;

/**
 * Created by Administrator on 2017-08-02.
 */

public class ToastUtil {
    private static Toast mToast=null;
    public static void show(String str){
        if (mToast == null){
            mToast = Toast.makeText(App.getContext(), str , Toast.LENGTH_SHORT);
        }else {
            //如果当前Toast没有消失， 直接显示内容，不需要重新设置
            mToast.setText(str);
        }
        mToast.setGravity(Gravity.CENTER , 0 , 0);
        mToast.show();
    }
}
