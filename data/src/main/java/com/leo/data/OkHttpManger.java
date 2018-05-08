package com.leo.data;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function okHttp 单例
 */
public class OkHttpManger {

    private static class SingletonHolder {
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .addInterceptor(getHttpLoggingInterceptor())
                .build();
    }

    public static OkHttpClient getInsatance() {
        return SingletonHolder.OK_HTTP_CLIENT;
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("SuperBrokerApp", "body: "+message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
