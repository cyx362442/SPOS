package com.duowei.spos.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2017-07-31.
 */

public class MyVolley {
    public static RequestQueue queue=null;
    public static  void getQueue(Context context){
        queue= Volley.newRequestQueue(context);
    }
}
