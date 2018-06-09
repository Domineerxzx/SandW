package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.triplebro.aran.sandw.R;

public class LoginActivity extends Activity implements View.OnClickListener{

    private ImageView iv_close_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setOnClickListener();
    }

    private void setOnClickListener() {
        iv_close_login.setOnClickListener(this);
    }

    private void initView() {
        iv_close_login = (ImageView) findViewById(R.id.iv_close_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_close_login:
                finish();
                break;
        }
    }
}
