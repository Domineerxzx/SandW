package com.triplebro.aran.sandw.modules;

import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by Aran on 2018/6/11.
 * 那当自己都萎靡到
 * 无法被依靠的时候该如何振作？
 * <p>
 * 除过自己心中笃信的那一点不灭的光亮
 * 我觉得这世间再没有别的东西比它值得被如此依靠。
 */

public class AransModules extends ReactContextBaseJavaModule {
    private ReactApplicationContext mContext;
    private static final String MODULE_NAME="aransModules";


    public AransModules(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mContext=reactContext;
    }

    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }
    /*@ReactMethod
    public void show(String aaa){
        Toast.makeText(mContext, aaa, Toast.LENGTH_SHORT).show();
    }*/
    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> params = new HashMap<>();
        params.put("Constant",250);
        return params;
    }
}
