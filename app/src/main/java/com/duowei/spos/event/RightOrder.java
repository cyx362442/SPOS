package com.duowei.spos.event;

/**
 * Created by Administrator on 2017-08-03.
 */

public class RightOrder {
    public int position;

    public int firstVisibleItem=-1;
    public int visibleItemCount=-1;
    public int totalItemCount=0;

    public boolean isFocusDown=false;

    public RightOrder(boolean isFocusDown) {
        this.isFocusDown = isFocusDown;
    }

    public RightOrder(int position) {
        this.position = position;
    }

    public RightOrder(int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.firstVisibleItem = firstVisibleItem;
        this.visibleItemCount = visibleItemCount;
        this.totalItemCount = totalItemCount;
    }
}
