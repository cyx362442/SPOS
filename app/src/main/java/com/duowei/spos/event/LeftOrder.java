package com.duowei.spos.event;

/**
 * Created by Administrator on 2017-08-03.
 */

public class LeftOrder {
    public int position=0;
    public boolean isScoll=true;

    public LeftOrder(int position, boolean isScoll) {
        this.position = position;
        this.isScoll = isScoll;
    }
}
