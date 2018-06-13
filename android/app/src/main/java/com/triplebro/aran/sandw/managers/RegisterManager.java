package com.triplebro.aran.sandw.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.triplebro.aran.sandw.activities.LoginActivity;
import com.triplebro.aran.sandw.activities.RegisterActivity;
import com.triplebro.aran.sandw.beans.RegisterInfo;
import com.triplebro.aran.sandw.handlers.RegisterHandler;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RegisterManager {

    private Context context;
    private RegisterHandler registerHandler;

    public RegisterManager(Context context, RegisterHandler registerHandler) {
        this.context = context;
        this.registerHandler = registerHandler;
    }

    public void register(String nickname, String email, String password) {
        sendRequest(nickname, email, password);
    }

    private void sendRequest(final String nickname, final String email, final String password) {
        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request;
                    request = new Request.Builder().url("http://120.25.96.141:8080//login/userRegister")
                            .post(new FormBody.Builder().add("nickname", nickname).add("userName", email)
                                    .add("passWord", password).build()).build();
                    Response response = client.newCall(request).execute();
                    String res = response.body().string();
                    Gson gson = new Gson();
                    RegisterInfo registerInfo = gson.fromJson(res, RegisterInfo.class);
                    if (registerInfo.isResult()) {
                        Log.i("ServerBackCode(服务器返回):", "注册成功");
                        SharedPreferences sharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("session", registerInfo.getSession());
                        edit.commit();
                        Message message = new Message();
                        message.obj = res;
                        registerHandler.sendMessage(message);
                    } else {
                        Log.i("ServerBackCode(服务器返回):", "注册失败");
                        ((RegisterActivity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "注册失败", Toast.LENGTH_SHORT).show();
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
