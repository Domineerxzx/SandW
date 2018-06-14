package com.triplebro.aran.sandw.handlers;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.TextView;

import com.triplebro.aran.sandw.beans.UserInfo;
import com.triplebro.aran.sandw.managers.UserManager;
import com.triplebro.aran.sandw.properties.AppProperties;

public class UserHandler extends Handler {

    private Context context;
    private TextView tv_username;
    private TextView tv_email;
    private TextView tv_cancellation;
    private TextView tv_birth;
    private EditText et_username;
    private TextView et_email;
    private UserManager userManager;

    public UserHandler(Context context,TextView tv_username, TextView tv_email, TextView tv_cancellation) {
        this.context = context;
        this.tv_username = tv_username;
        this.tv_email = tv_email;
        this.tv_cancellation = tv_cancellation;
    }

    public UserHandler(Context context, TextView tv_birth, EditText et_username, TextView et_email) {
        this.context = context;
        this.tv_birth = tv_birth;
        this.et_username = et_username;
        this.et_email = et_email;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void handleMessage(Message msg) {
        UserInfo.UserInfoBean userInfo = (UserInfo.UserInfoBean) msg.obj;
        switch (msg.what) {
            case AppProperties.UPDATE_USER_INFO_WHAT_OUTSIDE:
                this.tv_username.setText(userInfo.getNickname());
                this.tv_email.setText("/" + userInfo.getUserName());
                this.tv_cancellation.setText("不是" + userInfo.getNickname() + "吗？");
                context.unbindService(userManager);
                break;
            case AppProperties.UPDATE_USER_INFO_WHAT_INSIDE:
                this.et_username.setText(userInfo.getNickname());
                this.et_email.setText(userInfo.getUserName());
                break;
        }
    }
}
