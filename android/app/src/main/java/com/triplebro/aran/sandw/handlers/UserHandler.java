package com.triplebro.aran.sandw.handlers;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.triplebro.aran.sandw.activities.LoginActivity;
import com.triplebro.aran.sandw.beans.UserInfo;

public class UserHandler extends Handler {

    private Context context;
    private TextView tv_username;
    private TextView tv_email;
    private TextView tv_cancellation;

    public UserHandler(Context context, TextView tv_username, TextView tv_email, TextView tv_cancellation) {
        this.context = context;
        this.tv_username = tv_username;
        this.tv_email = tv_email;
        this.tv_cancellation = tv_cancellation;
    }

    @Override
    public void handleMessage(Message msg) {
        UserInfo.UserInfoBean userInfo = (UserInfo.UserInfoBean) msg.obj;
        this.tv_username.setText(userInfo.getNickname());
        this.tv_email.setText("/"+userInfo.getUserName());
        this.tv_cancellation.setText("不是"+userInfo.getNickname()+"吗？");
    }
}
