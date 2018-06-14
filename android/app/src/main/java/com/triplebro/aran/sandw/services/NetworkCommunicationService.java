package com.triplebro.aran.sandw.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.triplebro.aran.sandw.activities.LoginActivity;
import com.triplebro.aran.sandw.activities.RegisterActivity;
import com.triplebro.aran.sandw.beans.LoginInfo;
import com.triplebro.aran.sandw.beans.RegisterInfo;
import com.triplebro.aran.sandw.beans.UserInfo;
import com.triplebro.aran.sandw.handlers.LoginHandler;
import com.triplebro.aran.sandw.handlers.RegisterHandler;
import com.triplebro.aran.sandw.handlers.UserHandler;
import com.triplebro.aran.sandw.properties.AppProperties;
import com.triplebro.aran.sandw.utils.httpUtils.HttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Response;


public class NetworkCommunicationService extends Service {
    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {

        public void login(Context context, LoginHandler loginHandler, String email, String password){
            NetworkCommunicationService.this.login(context,loginHandler,email,password);
        }
        public void register(Context context, RegisterHandler registerHandler, String nickname,String email, String password){
            NetworkCommunicationService.this.register(context,registerHandler,nickname,email,password);
        }
        public void showUserInfo(Context context, UserHandler userHandler, String session,int messageWhat){
            NetworkCommunicationService.this.showUserInfo(context,userHandler,session,messageWhat);
        }

    }

    private void showUserInfo(final Context context, final UserHandler userHandler, String session, final int messageWhat) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("session",session);
        new Thread(){
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_SHOW_USER_INFO, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
                        Gson gson = new Gson();
                        UserInfo userInfo = gson.fromJson(res, UserInfo.class);
                        if (userInfo.isSessionProve()) {
                            Log.i("ServerBackCode(服务器返回):", "显示成功");
                            Message message = new Message();
                            message.obj = userInfo.getUserInfo();
                            message.what = messageWhat;
                            userHandler.sendMessage(message);
                        } else {
                            Log.i("ServerBackCode(服务器返回):", "显示失败");
                            ((LoginActivity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(context, "显示失败", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });

            }
        }.start();
    }

    private void register(final Context context, final RegisterHandler registerHandler, final String nickname, final String email, final String password) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("nickname",nickname);
        builder.add("userName",email);
        builder.add("passWord",password);
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_REGISTER, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
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
                    }
                });
            }
        }.start();
    }

    private void login(final Context context, final LoginHandler loginHandler, String email, String password){

        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("userName",email);
        builder.add("passWord",password);
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_LOGIN, builder, new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        ((LoginActivity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "未连接到服务器，请检查网络！", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

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
                                    Toast.makeText(context, "输入的邮箱或密码不正确！", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
            }
        }.start();
    }

}
