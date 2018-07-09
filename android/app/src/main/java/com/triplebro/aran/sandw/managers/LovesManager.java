package com.triplebro.aran.sandw.managers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.triplebro.aran.sandw.handlers.LovesHandler;
import com.triplebro.aran.sandw.services.NetworkCommunicationService;

public class LovesManager implements ServiceConnection {

    private Context context;
    private LovesHandler lovesHandler;
    private String session;

    public LovesManager(Context context, LovesHandler lovesHandler, String session) {
        this.context = context;
        this.lovesHandler = lovesHandler;
        this.session = session;
        lovesHandler.setLovesManager(this);
    }

    public void getLovesList(){
        Intent intent = new Intent(context, NetworkCommunicationService.class);
        context.bindService(intent,this,Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        NetworkCommunicationService.MyBinder myBinder = (NetworkCommunicationService.MyBinder) service;
        myBinder.getLovesList(context,lovesHandler,session);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
