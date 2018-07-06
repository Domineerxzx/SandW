package com.triplebro.aran.sandw.modules;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.triplebro.aran.sandw.activities.GoodInfoActivity;
import com.triplebro.aran.sandw.handlers.GoodInfoHandler;
import com.triplebro.aran.sandw.managers.GoodInfoManager;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Aran on 2018/6/11.
 * 那当自己都萎靡到
 * 无法被依靠的时候该如何振作？
 * <p>
 * 除过自己心中笃信的那一点不灭的光亮
 * 我觉得这世间再没有别的东西比它值得被如此依靠。
 */

public class AransModules extends ReactContextBaseJavaModule {
    private Context mContext;
    private Object data;
    public static String title;
    public static String commodityId;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public AransModules(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
    }

    @Override
    public String getName() {
        return "AransModules";
    }

    @ReactMethod
    public void setTitle(String msg){
        title = msg;
    }


    @ReactMethod
    public void setCommodityId(String msg){
        commodityId = msg;
    }
    @ReactMethod
    public void SEND_LOG(String o){
        System.out.println("======================这里是log============="+o);
    }

    @ReactMethod
    public void sendPromiseTime(Promise promise) {
        WritableMap writableMap=new WritableNativeMap();
        writableMap.putString("goods", String.valueOf(data));
        promise.resolve(writableMap);

    }

    @ReactMethod
    public void getGoodsInfo(Callback callback){
        callback.invoke(String.valueOf(data));
    }
    @ReactMethod
    public void getGoodInfo(Callback callback){
        callback.invoke(String.valueOf(data));
    }
//    @ReactMethod
//    public void getGoodsInfo(Promise promise){
//        promise.resolve(goodsInfo);
//    }
    @ReactMethod
    public void startNextActivity(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("session",MODE_PRIVATE);
        String session = sharedPreferences.getString("session", null);
        GoodInfoHandler goodInfoHandler = new GoodInfoHandler(mContext);
        GoodInfoManager goodInfoManager = new GoodInfoManager(mContext, goodInfoHandler, session);
        goodInfoManager.getGoodInfo();

        Toast.makeText(mContext, "aaa", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> params = new HashMap<>();
        params.put("aa","hahaha");
        params.put("bb","xixixi");
        return params;
    }
}
