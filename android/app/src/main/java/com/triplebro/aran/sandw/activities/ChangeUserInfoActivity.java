package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.handlers.UserHandler;
import com.triplebro.aran.sandw.managers.UserManager;
import com.triplebro.aran.sandw.properties.AppProperties;
import com.triplebro.aran.sandw.views.DatePickerListener;

import java.util.Calendar;

public class ChangeUserInfoActivity extends Activity implements View.OnClickListener {

    private TextView tv_birth;
    private EditText et_email;
    private EditText et_username;
    private ImageView iv_close_user_info;
    private ImageView iv_birth;
    private int year_now;
    private int month_now;
    private int day_now;
    private Button bt_change_password;
    private UserHandler userHandler;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_info);
        initView();
        initData();
        setOnClickListener();
    }


    private void setOnClickListener() {
        iv_close_user_info.setOnClickListener(this);
        tv_birth.setOnClickListener(this);
        iv_birth.setOnClickListener(this);
        bt_change_password.setOnClickListener(this);
    }

    private void initData() {
        SharedPreferences session = getSharedPreferences("session", MODE_PRIVATE);
        String sessions = session.getString("session", null);
        if (sessions != null) {
            userHandler = new UserHandler(this, tv_birth, et_username, et_email);
            userManager = new UserManager(this, userHandler,sessions, AppProperties.UPDATE_USER_INFO_WHAT_INSIDE);
            userManager.showUserInfo();
        }
        Calendar calendar = Calendar.getInstance();
        year_now = calendar.get(Calendar.YEAR);
        month_now = calendar.get(Calendar.MONTH);
        day_now = calendar.get(Calendar.DAY_OF_MONTH);

    }

    private void initView() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_email = (EditText) findViewById(R.id.et_email);
        tv_birth = (TextView) findViewById(R.id.tv_birth);
        iv_birth = (ImageView) findViewById(R.id.iv_birth);
        iv_close_user_info = (ImageView) findViewById(R.id.iv_close_user_info);
        bt_change_password = (Button) findViewById(R.id.bt_change_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close_user_info:
                finish();
                break;
            case R.id.tv_birth:
            case R.id.iv_birth:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.MyDatePickerDialogTheme,
                        new DatePickerListener(tv_birth,year_now,month_now,day_now), year_now, month_now, day_now);
                datePickerDialog.show();
                break;
            case R.id.bt_change_password:
                Intent intent = new Intent(this, ChangePassWordActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(userManager);
    }
}
