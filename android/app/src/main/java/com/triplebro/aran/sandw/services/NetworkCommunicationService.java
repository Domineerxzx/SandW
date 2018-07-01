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
import com.triplebro.aran.sandw.beans.AddAddressInfoBean;
import com.triplebro.aran.sandw.beans.AddressInfoBean;
import com.triplebro.aran.sandw.beans.ChangeAddressInfoBean;
import com.triplebro.aran.sandw.beans.LoginInfoBean;
import com.triplebro.aran.sandw.beans.RegisterInfoBean;
import com.triplebro.aran.sandw.beans.ShowAddressInfoBean;
import com.triplebro.aran.sandw.beans.TypeInfo;
import com.triplebro.aran.sandw.beans.UserInfo;
import com.triplebro.aran.sandw.handlers.AddAddressHandler;
import com.triplebro.aran.sandw.handlers.AddressHandler;
import com.triplebro.aran.sandw.handlers.ChangeAddressHandler;
import com.triplebro.aran.sandw.handlers.ChangeInfoHandler;
import com.triplebro.aran.sandw.handlers.ChangePassWordHandler;
import com.triplebro.aran.sandw.handlers.DeleteAddressHandler;
import com.triplebro.aran.sandw.handlers.FirstPageHandler;
import com.triplebro.aran.sandw.handlers.LoginHandler;
import com.triplebro.aran.sandw.handlers.RegisterHandler;
import com.triplebro.aran.sandw.handlers.ShowAddressInfoHandler;
import com.triplebro.aran.sandw.handlers.TypeHandler;
import com.triplebro.aran.sandw.handlers.UserHandler;
import com.triplebro.aran.sandw.modules.AransModules;
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

        public void showAddress(Context context, AddressHandler addressHandler, String session) {
            NetworkCommunicationService.this.showAddress(context, addressHandler, session);
        }

        public void addAddress(Context context, AddAddressHandler addAddressHandler, AddAddressInfoBean addAddressInfoBean, String session) {
            NetworkCommunicationService.this.addAddress(context, addAddressHandler, addAddressInfoBean, session);
        }

        public void changeAddress(Context context, ChangeAddressHandler changeAddressHandler, ChangeAddressInfoBean changeAddressInfoBean, String session) {
            NetworkCommunicationService.this.changeAddress(context, changeAddressHandler, changeAddressInfoBean, session);
        }

        public void showAddressInfo(Context context, ShowAddressInfoHandler showAddressInfoHandler, String address_id) {
            NetworkCommunicationService.this.showAddressInfo(context, showAddressInfoHandler, address_id);
        }

        public void deleteAddress(Context context, DeleteAddressHandler deleteAddressHandler, String session, String address_id) {
            NetworkCommunicationService.this.deleteAddress(context, deleteAddressHandler, session, address_id);
        }

        public void getType(Context context, TypeHandler typeHandler) {
            NetworkCommunicationService.this.getType(context,typeHandler);
        }

        public void getGoodsInfo(Context context, FirstPageHandler firstPageHandler) {
            NetworkCommunicationService.this.getGoodsInfo(context,firstPageHandler);
        }
    }

    private void getGoodsInfo(final Context context, final FirstPageHandler firstPageHandler) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("recommendation", "T恤"/*AransModules.title*/);
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_GET_GOODS_INFO, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
                        System.out.println(res);
                        Message message = Message.obtain();
                        message.obj = res;
                        message.what = AppProperties.GET_GOODS_INFO;
                        firstPageHandler.sendMessage(message);
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "获取商品四格推荐成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }.start();
    }

    private void getType(final Context context, final TypeHandler typeHandler) {
        final FormBody.Builder builder = new FormBody.Builder();
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_GET_TYPE, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
                        System.out.println(res);
                        TypeInfo typeInfo = gson.fromJson(res, TypeInfo.class);
                        Message message = new Message();
                        message.obj = typeInfo;
                        typeHandler.sendMessage(message);
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "获取类别成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }.start();
    }

    private void deleteAddress(final Context context, final DeleteAddressHandler deleteAddressHandler, String session, String address_id) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("session", session);
        builder.add("addressId", address_id);
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_DELETE_ADDRESS, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Message message = Message.obtain();
                        deleteAddressHandler.sendMessage(message);
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "删除地址成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }.start();
    }

    private void showAddressInfo(final Context context, final ShowAddressInfoHandler showAddressInfoHandler, String address_id) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("addressId", address_id);
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_SHOW_ADDRESS_MORE, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
                        ShowAddressInfoBean showAddressInfoBean = gson.fromJson(res, ShowAddressInfoBean.class);
                        Message message = Message.obtain();
                        message.obj = showAddressInfoBean;
                        showAddressInfoHandler.sendMessage(message);
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "显示详细地址成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }.start();
    }

    private void changeAddress(final Context context, final ChangeAddressHandler changeAddressHandler, ChangeAddressInfoBean changeAddressInfoBean, String session) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("session", session);
        builder.add("addressId", changeAddressInfoBean.getAddressId());
        builder.add("surName", changeAddressInfoBean.getSurName());
        builder.add("name", changeAddressInfoBean.getName());
        builder.add("country", changeAddressInfoBean.getCountry());
        builder.add("province", changeAddressInfoBean.getProvince());
        builder.add("city", changeAddressInfoBean.getCity());
        builder.add("address", changeAddressInfoBean.getAddress());
        builder.add("postCode", changeAddressInfoBean.getPostCode());
        builder.add("phone", changeAddressInfoBean.getPhone());
        builder.add("option", changeAddressInfoBean.getOption());
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_CHANGE_ADDRESS, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Message message = new Message();
                        changeAddressHandler.sendMessage(message);
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "修改地址成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }.start();
    }

    private void addAddress(final Context context, final AddAddressHandler addAddressHandler, AddAddressInfoBean addAddressInfoBean, String session) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("session", session);
        builder.add("surName", addAddressInfoBean.getSurName());
        builder.add("name", addAddressInfoBean.getName());
        builder.add("country", addAddressInfoBean.getCountry());
        builder.add("province", addAddressInfoBean.getProvince());
        builder.add("city", addAddressInfoBean.getCity());
        builder.add("address", addAddressInfoBean.getAddress());
        builder.add("postCode", addAddressInfoBean.getPostCode());
        builder.add("phone", addAddressInfoBean.getPhone());
        builder.add("option", addAddressInfoBean.getOption());
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_ADD_ADDRESS, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Message message = new Message();
                        addAddressHandler.sendMessage(message);
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "添加地址成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }.start();
    }

    private void showAddress(final Context context, final AddressHandler addressHandler, String session) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("session", session);
        new Thread() {
            @Override
            public void run() {
                HttpUtils.sendOkHttpRequest(AppProperties.SERVER_ADDRESS_OF_SHOW_ADDRESS, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();

                        if (!res.contains("\"ListNull\":false")) {
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(context, "地址列表为空", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            AddressInfoBean addressInfoBean = gson.fromJson(res, AddressInfoBean.class);
                            Message message = new Message();
                            message.obj = addressInfoBean;
                            addressHandler.sendMessage(message);
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(context, "显示地址成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
            }
        }.start();
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
                            ((Activity) context).runOnUiThread(new Runnable() {
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
