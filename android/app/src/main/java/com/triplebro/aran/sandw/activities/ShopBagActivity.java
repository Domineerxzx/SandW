package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.adapters.ShopBagAdapter;
import com.triplebro.aran.sandw.handlers.ShopBagHandler;
import com.triplebro.aran.sandw.managers.ShopBagManager;
import com.triplebro.aran.sandw.views.InnerListView;

public class ShopBagActivity extends Activity implements View.OnClickListener{

    private ImageView iv_close_shop_bag;
    private InnerListView ilv_shop_content;
    private ShopBagHandler shopBagHandler;
    private SharedPreferences sharedPreferences;
    private String session;
    private ShopBagManager shopBagManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_bag);
        initView();
        initData();
        setOnClickListener();
    }

    private void initView() {
        iv_close_shop_bag = (ImageView) findViewById(R.id.iv_close_shop_bag);
        ilv_shop_content = (InnerListView) findViewById(R.id.ilv_shop_content);
    }

    private void initData() {
        sharedPreferences = getSharedPreferences("session",MODE_PRIVATE);
        session = sharedPreferences.getString("session", null);
        shopBagHandler = new ShopBagHandler(this, ilv_shop_content);
        shopBagManager = new ShopBagManager(this, shopBagHandler, session);
        shopBagManager.showShopBag();
    }

    private void setOnClickListener() {
        iv_close_shop_bag.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_close_shop_bag:
                finish();
                break;
        }
    }
}
