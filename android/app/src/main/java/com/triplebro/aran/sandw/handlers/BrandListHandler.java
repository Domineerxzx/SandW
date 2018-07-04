package com.triplebro.aran.sandw.handlers;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.triplebro.aran.sandw.managers.BrandListManager;

public class BrandListHandler extends Handler {

    private Context context;
    private BrandListManager brandListManager;
    private int sex;

    public BrandListHandler(Context context, BrandListManager brandListManager, int sex) {
        this.context = context;
        this.brandListManager = brandListManager;
        this.sex = sex;
    }

    public BrandListManager getBrandListManager() {
        return brandListManager;
    }

    public void setBrandListManager(BrandListManager brandListManager) {
        this.brandListManager = brandListManager;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
}
