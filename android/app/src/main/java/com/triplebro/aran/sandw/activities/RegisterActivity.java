package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.handlers.RegisterHandler;
import com.triplebro.aran.sandw.managers.RegisterManager;

public class RegisterActivity extends Activity implements View.OnClickListener{

    private ImageView iv_close_create;
    private Button bt_create;
    private Button bt_login;
    private RegisterManager registerManager;
    private EditText et_username;
    private EditText et_email;
    private EditText et_password;
    private String nickname;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setOnClickListener();
        initData();
    }

    private void initData() {
        RegisterHandler registerHandler = new RegisterHandler(this);
        registerManager = new RegisterManager(this, registerHandler);
    }

    private void setOnClickListener() {
        iv_close_create.setOnClickListener(this);
        bt_create.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    private void initView() {
        iv_close_create = (ImageView) findViewById(R.id.iv_close_create);
        bt_create = (Button) findViewById(R.id.bt_create);
        bt_login = (Button) findViewById(R.id.bt_login);
        et_username = (EditText) findViewById(R.id.et_username);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_close_create:
                finish();
                break;
            case R.id.bt_create:
                nickname = et_username.getText().toString().trim();
                email = et_email.getText().toString().trim();
                password = et_password.getText().toString().trim();
                registerManager.register(nickname,email,password);
                break;
            case R.id.bt_login:
                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);
                finish();
                break;
        }
    }
}
