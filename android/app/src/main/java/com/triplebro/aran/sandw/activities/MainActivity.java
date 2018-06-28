package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.fragments.BottomFragment;
import com.triplebro.aran.sandw.fragments.ReactFirstPageFragment;


public class MainActivity extends Activity implements View.OnClickListener{

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private ImageView iv_search;
    ReactFirstPageFragment reactFirstPageFragment=new ReactFirstPageFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, reactFirstPageFragment,"rFragment");
        transaction.replace(R.id.fl_bottom, new BottomFragment());
        transaction.commit();
        initView();
        initData();
        setOnClickListener();
    }

    private void setOnClickListener() {
        iv_search.setOnClickListener(this);
    }

    private void initData() {

    }

    private void initView() {
        iv_search = (ImageView) findViewById(R.id.iv_search);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_search:
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
