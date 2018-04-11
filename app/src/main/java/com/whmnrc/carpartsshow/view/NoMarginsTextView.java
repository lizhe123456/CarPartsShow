package com.whmnrc.carpartsshow.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by lizhe on 2018/3/16.
 * 取消TextView 自带内边距
 */

@SuppressLint("AppCompatCustomView")
public class NoMarginsTextView extends TextView {
    private boolean adjustTopForAscent = true;

    public NoMarginsTextView(Context context) {
        super(context);
    }

    public NoMarginsTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoMarginsTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    Paint.FontMetricsInt fontMetricsInt;

    @Override
    protected void onDraw(Canvas canvas) {
        if (adjustTopForAscent) {//设置是否remove间距，true为remove
            if (fontMetricsInt == null) {
                fontMetricsInt = new Paint.FontMetricsInt();
                getPaint().getFontMetricsInt(fontMetricsInt);
            }
            canvas.translate(0, fontMetricsInt.top - fontMetricsInt.ascent);
        }
        super.onDraw(canvas);
    }
}
