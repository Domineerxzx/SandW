package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.fragments.BottomFragment;
import com.triplebro.aran.sandw.fragments.FirstPageFragment;
import com.triplebro.aran.sandw.modules.AransPackage;


public class MainActivity extends Activity{

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private static final AransPackage mAranPackage = new AransPackage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, new FirstPageFragment());
        transaction.replace(R.id.fl_bottom, new BottomFragment());
        transaction.commit();

    }

    public String getAppPackageName(){
        return this.getPackageName();
    }
}
