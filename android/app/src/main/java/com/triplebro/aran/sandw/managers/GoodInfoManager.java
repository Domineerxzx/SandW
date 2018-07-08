package com.triplebro.aran.sandw.managers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.triplebro.aran.sandw.handlers.GoodInfoHandler;
import com.triplebro.aran.sandw.services.NetworkCommunicationService;

public class GoodInfoManager implements ServiceConnection {

    private Context context;
    private GoodInfoHandler goodInfoHandler;
    private String session;

    public GoodInfoManager(Context context, GoodInfoHandler goodInfoHandler, String session) {
        this.context = context;
        this.goodInfoHandler = goodInfoHandler;
        this.session = session;
        goodInfoHandler.setGoodInfoManager(this);
    }
    public void getGoodInfo(){
        Intent intent = new Intent(context, NetworkCommunicationService.class);
        context.bindService(intent,this, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        NetworkCommunicationService.MyBinder myBinder = (NetworkCommunicationService.MyBinder) service;
        myBinder.getGoodInfo(context,goodInfoHandler,session);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
