package com.triplebro.aran.sandw.managers;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import com.triplebro.aran.sandw.activities.LoginActivity;
import com.triplebro.aran.sandw.beans.UserInfo;
import com.triplebro.aran.sandw.handlers.UserHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UserManager {

    private Context context;
    private UserHandler userHandler;

    public UserManager(Context context, UserHandler userHandler) {
        this.context = context;
        this.userHandler = userHandler;
    }

    public void updateUserInfo(String session) {
        sendRequest(session);
    }

    private void sendRequest(final String session) {
        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request;
                    request = new Request.Builder().url("http://120.25.96.141:8080/login/userInit")
                            .post(new FormBody.Builder().add("session", session).build()).build();
                    Response response = client.newCall(request).execute();
                    String res = response.body().string();
                    Gson gson = new Gson();
                    UserInfo userInfo = gson.fromJson(res, UserInfo.class);
                    if (userInfo.isSessionProve()) {
                        Log.i("ServerBackCode(服务器返回):", "更新成功");
                        Message message = new Message();
                        message.obj = userInfo.getUserInfo();
                        userHandler.sendMessage(message);
                    } else {
                        Log.i("ServerBackCode(服务器返回):", "更新失败");
                        ((LoginActivity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "更新失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
