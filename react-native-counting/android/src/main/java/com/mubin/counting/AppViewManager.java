package com.mubin.counting;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.image.ReactImageView;

import java.util.Map;

/**
 * Created by zmb on 11/3/17.
 */

public class AppViewManager extends SimpleViewManager<NumTextView>  {

    static private int v;

    static NumTextView tx;

    @Override
    public String getName() {
        return "SwipeMenuListView";

    }
//    字典
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @ReactProp(name="fontProperty")
    public void setFontProperty(NumTextView view,ReadableMap fontProperty){
        if (fontProperty.hasKey("fontSize")){
            int fontSize =  fontProperty.getInt("fontSize");
            view.setTextSize(fontSize);
        }

        if (fontProperty.hasKey("textAlignment")){
            String textAlignment = fontProperty.getString("textAlignment");
            if (!textAlignment.isEmpty()){
                if (textAlignment.equals("center")){
                    view.setTextAlignment(LinearLayout.TEXT_ALIGNMENT_CENTER);
                }else if(textAlignment.equals("left")){
                    view.setTextAlignment(LinearLayout.TEXT_ALIGNMENT_TEXT_START);
                }else if (textAlignment.equals("right")){
                    view.setTextAlignment(LinearLayout.TEXT_ALIGNMENT_TEXT_END);
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
    public void setText(NumTextView view,@Nullable String text)
    {
        view.setText(text);
    }

//设置文字颜色
    @ReactProp(name = "textColor", defaultInt = Color.TRANSPARENT, customType = "Color")
    public void setBackgroundColor(TextView view, int textColor) {
        view.setTextColor(textColor);
    }

    public void onReceiveNativeEvent() {

    }

    @Override
    protected NumTextView createViewInstance(ThemedReactContext reactContext) {

        tx = new NumTextView(reactContext);
        return tx;
    }

    @ReactMethod
    public void numberTimer(float start,float end,double dur) {
        tx.numberTimer(start,end,dur);

    }

}