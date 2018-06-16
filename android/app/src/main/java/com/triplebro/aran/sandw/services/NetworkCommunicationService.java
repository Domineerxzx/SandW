package com.triplebro.aran.sandw.services;

import android.app.Activity;
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
import com.triplebro.aran.sandw.beans.ChangePasswordBean;
import com.triplebro.aran.sandw.beans.ChangeUserInfoBean;
import com.triplebro.aran.sandw.beans.LoginInfoBean;
import com.triplebro.aran.sandw.beans.RegisterInfoBean;
import com.triplebro.aran.sandw.beans.UserInfo;
import com.triplebro.aran.sandw.handlers.ChangeInfoHandler;
import com.triplebro.aran.sandw.handlers.ChangePassWordHandler;
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

    private Gson gson = new Gson();

    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {

        public void login(Context context, LoginHandler loginHandler, String email, String password) {
            NetworkCommunicationService.this.login(context, loginHandler, email, password);
        }

        public void register(Context context, RegisterHandler registerHandler, String nickname, String email, String password) {
            NetworkCommunicationService.this.register(context, registerHandler, nickname, email, password);
        }

        public void showUserInfo(Context context, UserHandler userHandler, String session, int messageWhat) {
            NetworkCommunicationService.this.showUserInfo(context, userHandler, session, messageWhat);
        }

        public void changeInfo(Context context, ChangeInfoHandler changeInfoHandler, String nickname, String email, String birthday, String sex, String session) {
            NetworkCommunicationService.this.changeInfo(context, changeInfoHandler, nickname, email, birthday, sex, session);
        }

        public void changePassword(Context context, ChangePassWordHandler changePassWordHandler, String old_password, String new_password, String session) {
            NetworkCommunicationService.this.changePassword(context, changePassWordHandler, old_password, new_password, session);
        }
    }

    private void changePassword(final Context context, final ChangePassWordHandler changePassWordHandler, String old_password, String new_password, String session) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("session", session);
        builder.add("oldPassWd", old_password);
        builder.add("changePassWd", new_password);
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_CHANGE_PASSWORD, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Message message = new Message();
                        changePassWordHandler.sendMessage(message);
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "修改密码成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }.start();
    }

    private void changeInfo(final Context context, final ChangeInfoHandler changeInfoHandler, String nickname, String email, String birthday, String sex, String session) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("nickName", nickname);
        builder.add("birthday", birthday);
        builder.add("userName", email);
        builder.add("sex", sex);
        builder.add("session", session);
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_CHANGE_USER_INFO, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Message message = new Message();
                        changeInfoHandler.sendMessage(message);
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "修改成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }.start();
    }

    private void showUserInfo(final Context context, final UserHandler userHandler, String session, final int messageWhat) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("session", session);
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_SHOW_USER_INFO, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
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
        builder.add("nickName", nickname);
        builder.add("userName", email);
        builder.add("passWord", password);
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
                        RegisterInfoBean registerInfoBean = gson.fromJson(res, RegisterInfoBean.class);
                        if (registerInfoBean.isResult()) {
                            Log.i("ServerBackCode(服务器返回):", "注册成功");
                            SharedPreferences sharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE);
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString("session", registerInfoBean.getSession());
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

    private void login(final Context context, final LoginHandler loginHandler, String email, String password) {

        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("userName", email);
        builder.add("passWord", password);
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
                        LoginInfoBean loginInfoBean = gson.fromJson(res, LoginInfoBean.class);
                        if (loginInfoBean.isResult()) {
                            Log.i("ServerBackCode(服务器返回):", "登录成功");
                            SharedPreferences sharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE);
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString("session", loginInfoBean.getSession());
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
