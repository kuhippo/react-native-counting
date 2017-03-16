package com.mubin.counting;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.view.Gravity;
import android.widget.TextView;

import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by zmb on 11/3/17.
 */

public class CountingViewManager extends SimpleViewManager<CountingNumTextView>  {

    static private int v;

    static CountingNumTextView tx;

    @Override
    public String getName() {
        return "SwipeMenuListView";

    }
//    字典
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @ReactProp(name="fontProperty")
    public void setFontProperty(CountingNumTextView view, ReadableMap fontProperty){
        if (fontProperty.hasKey("fontSize")){
            int fontSize =  fontProperty.getInt("fontSize");
            view.setTextSize(fontSize);
        }

        if (fontProperty.hasKey("textAlignment")){
            String textAlignment = fontProperty.getString("textAlignment");
            if (!textAlignment.isEmpty()){
                if (textAlignment.equals("center")){
                    view.setGravity(Gravity.CENTER);
                }else if(textAlignment.equals("left")){
                    view.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
                }else if (textAlignment.equals("right")){
                    view.setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
                }
            }
        }

        if (fontProperty.hasKey("boldSystem")){
            boolean boldSystem = fontProperty.getBoolean("boldSystem");
            if (boldSystem){
                TextPaint paint = view.getPaint();
                paint.setFakeBoldText(true);
            }else{
                TextPaint tp = view.getPaint();
                tp.setFakeBoldText(false);
            }
        }
        if (fontProperty.hasKey("method")){
            String method = fontProperty.getString("method");
            view.setMethod(method);
        }
    }

//设置文字
    @ReactProp(name="text")
    public void setText(CountingNumTextView view, @Nullable String text)
    {
        view.setText(text);
    }

//设置文字颜色
    @ReactProp(name = "textColor", defaultInt = Color.TRANSPARENT, customType = "Color")
    public void setTextColor(TextView view, int textColor) {
        view.setTextColor(textColor);
    }

    public void onReceiveNativeEvent() {

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected CountingNumTextView createViewInstance(ThemedReactContext reactContext) {

        tx = new CountingNumTextView(reactContext);
        return tx;
    }

    @ReactMethod
    public void numberTimer(float start,float end,double dur) {
        tx.numberTimer(start,end,dur);

    }

}