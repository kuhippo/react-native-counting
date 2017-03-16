package com.mubin.counting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.text.DecimalFormat;

/**
 * Created by zmb on 11/3/17.
 */

public class CountingNumTextView extends TextView {

//    模式
    public String method;
//    动画间隔
    public double anDuration;

    public CountingNumTextView(Context context) {
        super(context);

    }

    public CountingNumTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountingNumTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CountingNumTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void numberTimer(float start,float end,double dur){
        final CountingNumTextView view = this;
        final DecimalFormat df = new DecimalFormat("###.00");

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(start,end);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                boolean post = view.post(new Runnable() {
                    @Override
                    public void run() {
                        view.setText(df.format(valueAnimator.getAnimatedValue()) + "");
                    }
                });
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                onReceiveNativeEvent();
            }
        });
        valueAnimator.setInterpolator(this.seTime());
        valueAnimator.setDuration((long) dur);
        valueAnimator.start();
    }

    private TimeInterpolator seTime(){
        if (method != null){
            if (method.equals("EaseIn")){
                new DecelerateInterpolator(3f);
            }else if(method.equals("EaseInOut")){
                return new AccelerateDecelerateInterpolator();
            }else if (method.equals("EaseOut")){
                new CycleInterpolator(3f);
            }else if (method.equals("Linear")){
                return new LinearInterpolator();
            }else {
                return new LinearInterpolator();
            }
            return new DecelerateInterpolator(3);
        }
        return new LinearInterpolator();

    }


// GetSeting
    public void setMethod(String method) {
        this.method = method;
    }

    public void setAnDuration(double anDuration) {
        this.anDuration = anDuration;
    }

    public String getMethod() {

        return method;
    }

    public double getAnDuration() {
        return anDuration;
    }

//    回调给js
    public void onReceiveNativeEvent() {
        WritableMap event = Arguments.createMap();
        ReactContext reactContext = (ReactContext)getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                getId(),
                "topChange",
                event);
    }



}
