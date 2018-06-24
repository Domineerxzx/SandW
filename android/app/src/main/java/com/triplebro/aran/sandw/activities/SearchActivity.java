package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.adapters.MaybeAdapter;

public class SearchActivity extends Activity implements View.OnClickListener{

    private TextView tv_cancel;
    private RecyclerView rv_maybe_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        initData();
        setOnClickListener();
    }

    private void setOnClickListener() {
        tv_cancel.setOnClickListener(this);
    }

    private void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_maybe_content.setLayoutManager(linearLayoutManager);
        MaybeAdapter maybeAdapter = new MaybeAdapter(this);
        rv_maybe_content.setAdapter(maybeAdapter);
    }

    private void initView() {
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        rv_maybe_content = (RecyclerView) findViewById(R.id.rv_maybe_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                finish();
                break;
        }
    }
}
