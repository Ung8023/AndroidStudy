package com.androidaddicts.androidnet.retrofit.javasample.remote;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author feilang-liuyansong
 * @date 2018/4/18 16:57
 * @description
 */

public class RetrofitManager {
    private static final String BASE_URL = "http://127.0.0.1:8888/";

    private Retrofit retrofit;

    private static RetrofitManager manager;

    private RetrofitService service;

    private RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RetrofitService.class);
    }

    public static RetrofitManager getInstance() {
        synchronized (RetrofitManager.class) {
            if (manager == null) {
                synchronized (RetrofitManager.class) {
                    if (manager == null) {
                        manager = new RetrofitManager();
                    }
                }
            }
            return manager;
        }
    }

    public void helloWorld() {
        Call<String> stringCall = service.helloWorld();
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println("onResponse");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                System.out.println("onFailed");
            }
        });
    }

    public void aaa() {
        Call<String> stringCall = service.aaa();
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
