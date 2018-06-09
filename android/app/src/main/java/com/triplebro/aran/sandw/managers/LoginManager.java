package com.triplebro.aran.sandw.managers;

import android.content.Context;
import android.os.Message;
import android.util.Log;

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
                    request = new Request.Builder().url("https://thethreestooges.cn:1225/login/change/pwd")
                            .post(new FormBody.Builder().add("email", email)
                                    .add("password", password).build()).build();
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        String res = response.body().string();
                        Log.i("ServerBackCode(服务器返回):", res);
                        Message message = new Message();
                        message.obj = res;
                        loginHandler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
