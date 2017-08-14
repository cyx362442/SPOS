package com.duowei.spos.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**设置gridview最大高度
 * Created by Administrator on 2017-08-14.
 */

public class MaxGridView extends GridView {
    private int listViewHeight;

    public MaxGridView(Context context) {
        super(context);
    }

    public MaxGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaxGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MaxGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public int getListViewHeight() {
        return listViewHeight;
    }

    public void setListViewHeight(int listViewHeight) {
        this.listViewHeight = listViewHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (listViewHeight > -1) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(listViewHeight,
                    MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
