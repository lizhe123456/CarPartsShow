package com.carpartsshow.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.carpartsshow.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lizhe on 2018/3/26.
 * 倒计时TextView
 */

@SuppressLint("AppCompatCustomView")
public class CountdownTextView extends TextView {

    private long mSeconds;
    private String mStrFormat;
    private Map<Integer,Timer> mTimerMap;
    private TimerTask mTimerTask;
    private final int what_count_down_tick = 1;
    private String TAG = "CountdownTextView";

    public CountdownTextView(Context context) {
        super(context);
    }

    public CountdownTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountdownTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @TargetApi(21)
    public CountdownTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     *
     * @param format  例如：剩余%s
     * @param seconds
     */
    public void init(String format,long seconds){
        mTimerMap = new HashMap<>();
        if(!TextUtils.isEmpty(format)){
            mStrFormat = format;
        }
        mSeconds = seconds; //设置总共的秒数
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                if(mSeconds > 0){
                    mSeconds --;
                    mHandler.sendEmptyMessage(what_count_down_tick);
                }
            }
        };
    }

    public void start(int position){
        if(mTimerMap.get(position) == null){
            Timer timer = new Timer();
            mTimerMap.put(position,timer);
            mTimerMap.get(position).schedule(mTimerTask,0,1000);
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what){
                case what_count_down_tick:
                    String time;
                    if(mSeconds <= 0){
                        time = String.format(mStrFormat,"00:00:00");
                    }else {
                        Log.e(TAG,"mSeconds="+mSeconds+"#what_count_down_tick:"+second2TimeSecond(mSeconds)+"#"+String.format(mStrFormat,second2TimeSecond(mSeconds)));
                        time = mStrFormat== null ? second2TimeSecond(mSeconds) : String.format(mStrFormat,second2TimeSecond(mSeconds));
                    }
                    SpannableStringBuilder style=new SpannableStringBuilder(time);
                    style.setSpan(new BackgroundColorSpan(Color.WHITE),1,3,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    style.setSpan(new BackgroundColorSpan(Color.WHITE),4,6,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    style.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.title_bg)),4,6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    style.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.title_bg)),1,3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    setText(style);
                    setText(time);
                    break;
            }
        }
    };

    @Override
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener) {
        Log.e(TAG,"removeOnLayoutChangeListener");
        super.removeOnLayoutChangeListener(listener);
    }

    @Override
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        Log.e(TAG,"removeOnAttachStateChangeListener");
        super.removeOnAttachStateChangeListener(listener);
    }

    /**
     * 转化为 hh:mm:ss 格式
     * @param second
     * @return
     */
    private String second2TimeSecond(long second) {
        long hours = second / 3600;
        long minutes = (second%3600)/ 60;
        long seconds = second % 60;

        String hourString = "";
        String minuteString = "";
        String secondString = "";
        if(hours < 10){
            hourString = "0";
            if(hours == 0){
                hourString += "0";
            }else{
                hourString += String.valueOf(hours);
            }
        }else{
            hourString = String.valueOf(hours);
        }
        if (minutes < 10) {
            minuteString = "0";
            if (minutes == 0) {
                minuteString += "0";
            }else {
                minuteString += String.valueOf(minutes);
            }
        }else{
            minuteString = String.valueOf(minutes);
        }
        if(seconds < 10){
            secondString = "0";
            if (seconds == 0) {
                secondString += "0";
            }else {
                secondString += String.valueOf(seconds);
            }
        }else {
            secondString = String.valueOf(seconds);
        }
        return hourString + ":" + minuteString+":"+secondString;
    }

}
