package com.whmnrc.carpartsshow.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by lizhe on 2018/4/7.
 */

@SuppressLint("AppCompatCustomView")
public class BmpImageView extends ImageView {

    public BmpImageView (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            System.out
                    .println("BmpImageView  -> onDraw() Canvas: trying to use a recycled bitmap");
        }
    }
}
