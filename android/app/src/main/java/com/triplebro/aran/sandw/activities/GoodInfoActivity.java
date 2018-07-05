package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;
import com.triplebro.aran.sandw.BuildConfig;
import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.handlers.GoodInfoHandler;
import com.triplebro.aran.sandw.managers.GoodInfoManager;

/**
 * Created by Aran on 2018/7/5.
 * 那当自己都萎靡到
 * 无法被依靠的时候该如何振作？
 * <p>
 * 除过自己心中笃信的那一点不灭的光亮
 * 我觉得这世间再没有别的东西比它值得被如此依靠。
 */

public class GoodInfoActivity extends Activity implements DefaultHardwareBackBtnHandler {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    private SharedPreferences sharedPreferences;
    private GoodInfoHandler goodInfoHandler;
    private GoodInfoManager goodInfoManager;
    private String session;
    private TextView tv_good_info;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "SandW3", null);
        setContentView(mReactRootView);
        initView();
        initData();
    }

    private void initView() {
        tv_good_info = (TextView) findViewById(R.id.tv_good_info);
    }

    private void initData() {
        sharedPreferences = getSharedPreferences("session",MODE_PRIVATE);
        session = sharedPreferences.getString("session", null);
        goodInfoHandler = new GoodInfoHandler(this,tv_good_info);
        goodInfoManager = new GoodInfoManager(this, goodInfoHandler, session);
        goodInfoManager.getGoodInfo();
    }

    //生命周期代码
    @Override
    protected void onPause() {
        super.onPause();
        if(mReactInstanceManager!=null){
            mReactInstanceManager.onHostPause();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(this, this);
        }
    }
    @Override
    public void onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(goodInfoManager);
        super.onDestroy();
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }
}
