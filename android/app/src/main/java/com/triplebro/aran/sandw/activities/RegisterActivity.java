package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.triplebro.aran.sandw.R;

public class RegisterActivity extends Activity implements View.OnClickListener{

    private ImageView iv_close_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setOnClickListener();
    }

    private void setOnClickListener() {
        iv_close_create.setOnClickListener(this);
    }

    private void initView() {
        iv_close_create = (ImageView) findViewById(R.id.iv_close_create);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_close_create:
                finish();
                break;
        }
    }
}
