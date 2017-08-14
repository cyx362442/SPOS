package com.duowei.spos.utils;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.duowei.spos.R;
import com.duowei.spos.app.App;

/**
 * Created by Administrator on 2017-08-04.
 */

public class Theme {
    private Theme() {
    }

    private static Theme singleton = null;

    public static Theme getInstance() {
        if (singleton == null) {
            singleton = new Theme();
        }
        return singleton;
    }
    public  int bgColor=0;

    public int textColor(){
        String[] array = App.getContext().getResources().getStringArray(R.array.textcolor);
        return Color.parseColor(array[bgColor]);
    }
    public  Drawable getBgColor(){
        TypedArray colorArray = App.getContext().getResources().obtainTypedArray(R.array.colorbg);
        return colorArray.getDrawable(bgColor);
    }
    public  Drawable getBgLogin(){
        TypedArray loginArray = App.getContext().getResources().obtainTypedArray(R.array.loginbg);
        return loginArray.getDrawable(bgColor);
    }
    public  Drawable getImgUp(){
        TypedArray loginArray = App.getContext().getResources().obtainTypedArray(R.array.img_up);
        return loginArray.getDrawable(bgColor);
    }
//    public Drawable getBgAdd(){
//        TypedArray loginArray = App.getContext().getResources().obtainTypedArray(R.array.img_add);
//        return loginArray.getDrawable(bgColor);
//    }
//    public Drawable getBgSub(){
//        TypedArray loginArray = App.getContext().getResources().obtainTypedArray(R.array.img_sub);
//        return loginArray.getDrawable(bgColor);
//    }
}
