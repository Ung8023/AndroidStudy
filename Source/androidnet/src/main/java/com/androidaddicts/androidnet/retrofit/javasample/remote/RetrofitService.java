package com.androidaddicts.androidnet.retrofit.javasample.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author feilang-liuyansong
 * @date 2018/4/18 16:57
 * @description
 */

public interface RetrofitService {

    @GET("/")
    Call<String> helloWorld();

    Call<String> aaa();
}
