package com.whmnrc.carpartsshow.widgets;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * Created by lizhe on 2018/4/9.
 */

public class MyNestedScrollView extends NestedScrollView {
    private ScrollViewListener scrollViewListener = null;

    public MyNestedScrollView(Context context) {
        super(context);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }

    public interface ScrollViewListener{
        void onScrollChanged(MyNestedScrollView myNestedScrollView, int x, int y, int oldx, int oldy);
    }
}
