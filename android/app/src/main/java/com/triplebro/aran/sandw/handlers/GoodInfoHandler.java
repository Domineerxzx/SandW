package com.triplebro.aran.sandw.handlers;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class GoodInfoHandler extends Handler {

    private Context context;
    private TextView tv;

    public GoodInfoHandler(Context context, TextView tv) {
        this.context = context;
        this.tv = tv;
    }

    @Override
    public void handleMessage(Message msg) {
        tv.setText((String)msg.obj);
    }
}
