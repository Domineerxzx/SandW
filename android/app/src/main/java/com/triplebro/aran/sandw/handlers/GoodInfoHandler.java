package com.triplebro.aran.sandw.handlers;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.facebook.react.ReactRootView;
import com.triplebro.aran.sandw.activities.GoodInfoActivity;
import com.triplebro.aran.sandw.modules.AransPackage;

public class GoodInfoHandler extends Handler {

    private Context context;
    private ReactRootView mReactRootView;

    public GoodInfoHandler(Context context, ReactRootView mReactRootView) {
        this.context = context;
        this.mReactRootView = mReactRootView;
    }

    @Override
    public void handleMessage(Message msg) {
        String goodInfo = (String) msg.obj;
        AransPackage reactPackage = ((GoodInfoActivity) context).getReactPackage();
        reactPackage.setGoodInfo(goodInfo);
        ((GoodInfoActivity)context).setContentView(mReactRootView);
    }
}
