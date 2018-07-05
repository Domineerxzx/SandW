package com.triplebro.aran.sandw.modules;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.triplebro.aran.sandw.activities.GoodInfoActivity;

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
    private Context mContext;
    private String goodsInfo;
    public static String title;
    public static String commodityId;

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
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
        writableMap.putString("goods",goodsInfo);
        promise.resolve(writableMap);

    }

    @ReactMethod
    public void getGoodsInfo(Callback callback){
        callback.invoke(goodsInfo);
    }
//    @ReactMethod
//    public void getGoodsInfo(Promise promise){
//        promise.resolve(goodsInfo);
//    }
    @ReactMethod
    public void startNextActivity(){
        Intent intent = new Intent(mContext, GoodInfoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
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
