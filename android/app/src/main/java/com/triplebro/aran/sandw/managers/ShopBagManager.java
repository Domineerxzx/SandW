package com.triplebro.aran.sandw.managers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.triplebro.aran.sandw.handlers.ShopBagHandler;
import com.triplebro.aran.sandw.services.NetworkCommunicationService;

public class ShopBagManager implements ServiceConnection {

    private Context context;
    private ShopBagHandler shopBagHandler;
    private String session;
    private int shopBagType;

    public ShopBagManager(Context context, ShopBagHandler shopBagHandler, String session) {
        this.context = context;
        this.shopBagHandler = shopBagHandler;
        this.session = session;
    }

    public void showShopBag() {
        Intent intent = new Intent(context, NetworkCommunicationService.class);
        context.bindService(intent, this, Context.BIND_AUTO_CREATE);
        shopBagType = 1;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        NetworkCommunicationService.MyBinder myBinder = (NetworkCommunicationService.MyBinder) service;
        switch (shopBagType) {
            case 1:
                myBinder.showShopBag(context, shopBagHandler, session);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
