package com.triplebro.aran.sandw.utils.httpUtils;


import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Domineer on 2018/3/23.
 */

public class HttpUtils {

    public static void sendOkHttpRequest(final String address, final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

    public static void sendSessionOkHttpRequest(final String address, final Callback callback) {

        String session = "";
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder().add( "session", session ).build();

        Request request = new Request.Builder()
                .url( address ).post( requestBody )
                .build();
        client.newCall( request ).enqueue( callback );
    }
}
