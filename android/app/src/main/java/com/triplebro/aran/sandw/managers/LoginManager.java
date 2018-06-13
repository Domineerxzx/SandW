package com.triplebro.aran.sandw.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.triplebro.aran.sandw.activities.LoginActivity;
import com.triplebro.aran.sandw.beans.LoginInfo;
import com.triplebro.aran.sandw.handlers.LoginHandler;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class LoginManager {

    private Context context;
    private LoginHandler loginHandler;

    public LoginManager(Context context, LoginHandler loginHandler) {
        this.context = context;
        this.loginHandler = loginHandler;
    }

    public void login(String email, String password) {
        sendRequest(email, password);
    }

    private void sendRequest(final String email, final String password) {
        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request;
                    request = new Request.Builder().url("http://120.25.96.141:8080/login/loginprove")
                            .post(new FormBody.Builder().add("userName", email)
                                    .add("passWord", password).build()).build();
                    Response response = client.newCall(request).execute();
                    String res = response.body().string();
                    Gson gson = new Gson();
                    LoginInfo loginInfo = gson.fromJson(res, LoginInfo.class);
                    if (loginInfo.isResult()) {
                        Log.i("ServerBackCode(服务器返回):", "登录成功");
                        SharedPreferences sharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("session", loginInfo.getSession());
                        edit.commit();
                        Message message = new Message();
                        message.obj = res;
                        loginHandler.sendMessage(message);
                    } else {
                        Log.i("ServerBackCode(服务器返回):", "登录失败");
                        ((LoginActivity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
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
