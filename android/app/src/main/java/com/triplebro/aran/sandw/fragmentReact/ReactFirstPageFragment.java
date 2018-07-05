package com.triplebro.aran.sandw.fragmentReact;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.triplebro.aran.sandw.BuildConfig;
import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.modules.AransPackage;


public class ReactFirstPageFragment extends Fragment{


    ReactRootView mReactRootView;
    ReactInstanceManager mReactInstanceManager;
    private TextView tv_title;
    public AransPackage aransPackage = new AransPackage();
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mReactRootView = new ReactRootView(getActivity());
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getActivity().getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .addPackage(aransPackage)
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "SandW", null);
        initView();
        initData();
        return mReactRootView;

    }


    public AransPackage getAransPackage(){
        return aransPackage;
    }

    private void initData() {
        tv_title.setText(R.string.title_first_page);
    }

    private void initView() {
        tv_title = getActivity().findViewById(R.id.tv_title);
    }
}
