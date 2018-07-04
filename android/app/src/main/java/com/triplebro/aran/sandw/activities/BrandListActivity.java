package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.adapters.BrandContentAdapter;
import com.triplebro.aran.sandw.properties.AppProperties;

import java.util.ArrayList;
import java.util.List;

public class BrandListActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {


    private ListView lv_brand_list_content;
    private LinearLayout ll_brand_title_f;
    private Button bt_brand_title_f;
    private View v_brand_title_f;
    private LinearLayout ll_brand_title_m;
    private Button bt_brand_title_m;
    private View v_brand_title_m;
    private LinearLayout ll_brand_title_c;
    private Button bt_brand_title_c;
    private View v_brand_title_c;
    private Button lastClickButton;
    private View lastClickView;
    private BrandContentAdapter brandContentAdapter_f;
    private BrandContentAdapter brandContentAdapter_m;
    private BrandContentAdapter brandContentAdapter_c;
    private ImageView iv_close_brand_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_list);
        initView();
        initData();
        setOnClickListener();
    }

    private void setOnClickListener() {
        ll_brand_title_f.setOnClickListener(this);
        bt_brand_title_f.setOnClickListener(this);
        ll_brand_title_m.setOnClickListener(this);
        bt_brand_title_m.setOnClickListener(this);
        ll_brand_title_c.setOnClickListener(this);
        bt_brand_title_c.setOnClickListener(this);
        lv_brand_list_content.setOnItemClickListener(this);
        iv_close_brand_list.setOnClickListener(this);
    }

    private void initData() {
    }

    private void initView() {

        lv_brand_list_content = findViewById(R.id.lv_brand_list_content);
        ll_brand_title_f = findViewById(R.id.ll_brand_title_f);
        bt_brand_title_f = findViewById(R.id.bt_brand_title_f);
        v_brand_title_f = findViewById(R.id.v_brand_title_f);
        ll_brand_title_m = findViewById(R.id.ll_brand_title_m);
        bt_brand_title_m = findViewById(R.id.bt_brand_title_m);
        v_brand_title_m = findViewById(R.id.v_brand_title_m);
        ll_brand_title_c = findViewById(R.id.ll_brand_title_c);
        bt_brand_title_c = findViewById(R.id.bt_brand_title_c);
        v_brand_title_c = findViewById(R.id.v_brand_title_c);
        lastClickButton = bt_brand_title_f;
        lastClickView = v_brand_title_f;
        iv_close_brand_list = (ImageView) findViewById(R.id.iv_close_brand_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_brand_title_f:
            case R.id.bt_brand_title_f:
                lastClickButton.setTextColor(Color.GRAY);
                lastClickView.setBackgroundColor(Color.GRAY);
                bt_brand_title_f.setTextColor(Color.BLACK);
                v_brand_title_f.setBackgroundColor(Color.BLACK);
                lastClickView = v_brand_title_f;
                lastClickButton = bt_brand_title_f;
                if (brandContentAdapter_f == null) {

                    //brandContentAdapter_f = new BrandContentAdapter(this, AppProperties.BRAND_WORD_LIST, brand_more);
                }
                lv_brand_list_content.setAdapter(brandContentAdapter_f);
                break;
            case R.id.ll_brand_title_m:
            case R.id.bt_brand_title_m:
                lastClickButton.setTextColor(Color.GRAY);
                lastClickView.setBackgroundColor(Color.GRAY);
                bt_brand_title_m.setTextColor(Color.BLACK);
                v_brand_title_m.setBackgroundColor(Color.BLACK);
                lastClickView = v_brand_title_m;
                lastClickButton = bt_brand_title_m;
                if (brandContentAdapter_m == null) {

                    //brandContentAdapter_m = new BrandContentAdapter(this, AppProperties.BRAND_WORD_LIST, brand_more);
                }
                lv_brand_list_content.setAdapter(brandContentAdapter_m);
                break;
            case R.id.ll_brand_title_c:
            case R.id.bt_brand_title_c:
                lastClickButton.setTextColor(Color.GRAY);
                lastClickView.setBackgroundColor(Color.GRAY);
                bt_brand_title_c.setTextColor(Color.BLACK);
                v_brand_title_c.setBackgroundColor(Color.BLACK);
                lastClickView = v_brand_title_c;
                lastClickButton = bt_brand_title_c;
                if (brandContentAdapter_c == null) {

                    //brandContentAdapter_c = new BrandContentAdapter(this, AppProperties.BRAND_WORD_LIST, brand_more);
                }
                lv_brand_list_content.setAdapter(brandContentAdapter_c);
                break;
            case R.id.iv_close_brand_list:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[] brand_more_content = new String[]{"1", "2", "3"};
        /*brand_more.add(brand_more_content);*/
    }
}
