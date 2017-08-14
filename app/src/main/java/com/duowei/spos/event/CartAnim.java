package com.duowei.spos.event;

import android.view.View;

/**
 * Created by Administrator on 2017-08-05.
 */

public class CartAnim {
    public View view;
    public int postion;

    public CartAnim(View view, int postion) {
        this.view = view;
        this.postion = postion;
    }
}
