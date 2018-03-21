package com.carpartsshow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by lizhe on 2018/3/14.
 */

public class SlideGridView extends GridView{

    public SlideGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideGridView(Context context) {
        super(context);
    }

    public SlideGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
