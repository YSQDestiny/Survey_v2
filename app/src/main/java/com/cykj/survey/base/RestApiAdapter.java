package com.cykj.survey.base;

import com.cykj.survey.base.api.ConstantApi;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit的实体类
 */
public class RestApiAdapter {

    private static Retrofit retrofit = null;

    public static Retrofit getInstance() {
        if (retrofit == null){
            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
            OkHttpClient okHttpClient = new OkHttpClient();
            OkHttpClient.Builder builder = okHttpClient.newBuilder();
            builder.retryOnConnectionFailure(true);
            retrofit = new Retrofit.Builder().client(okHttpClient)
                    .baseUrl(ConstantApi.BaiduUrl)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
