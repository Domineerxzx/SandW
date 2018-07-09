package com.triplebro.aran.sandw.handlers;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.fragmentReact.ReactLovesFragment;
import com.triplebro.aran.sandw.managers.LovesManager;
import com.triplebro.aran.sandw.modules.AransPackage;

public class LovesHandler extends Handler {
    private Context context;
    private ReactLovesFragment reactLovesFragment;
    private LovesManager lovesManager;
    public LovesHandler(Context context, ReactLovesFragment reactLovesFragment) {
        this.context = context;
        this.reactLovesFragment = reactLovesFragment;
    }

    public void setLovesManager(LovesManager lovesManager) {
        this.lovesManager = lovesManager;
    }

    @Override
    public void handleMessage(Message msg) {
        String lovesList = (String) msg.obj;
        AransPackage aransPackage = ((ReactLovesFragment)reactLovesFragment).getAransPackage();
        aransPackage.setData(lovesList);
        FragmentTransaction transaction = ((Activity) context).getFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_content, reactLovesFragment);
        transaction.commit();
    }
}
