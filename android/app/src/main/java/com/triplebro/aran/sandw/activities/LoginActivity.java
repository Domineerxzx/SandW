package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.triplebro.aran.sandw.R;

public class LoginActivity extends Activity implements View.OnClickListener{

    private ImageView iv_close_login;
    private EditText et_email;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setOnClickListener();
        getData();
    }

    private void getData() {
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();
    }

    private void setOnClickListener() {
        iv_close_login.setOnClickListener(this);
    }

    private void initView() {
        iv_close_login = (ImageView) findViewById(R.id.iv_close_login);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
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
