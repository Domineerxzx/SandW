package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.adapters.ShopBagAdapter;
import com.triplebro.aran.sandw.views.InnerListView;

public class ShopBagActivity extends Activity implements View.OnClickListener{

    private ImageView iv_close_shop_bag;
    private InnerListView ilv_shop_content;

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
        ShopBagAdapter shopBagAdapter = new ShopBagAdapter(this, new String[]{"1", "2", "3", "4"});
        ilv_shop_content.setAdapter(shopBagAdapter);
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
