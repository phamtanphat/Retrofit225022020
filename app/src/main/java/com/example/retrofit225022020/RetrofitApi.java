package com.example.retrofit225022020;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    private static Retrofit retrofit = null;
    private static RetrofitApi retrofitApi = null;

    private RetrofitApi() {
        retrofit = createRetrofit();
    }

    public static ApiRequest getInstance() {
        if (retrofitApi == null) {
            retrofitApi = new RetrofitApi();
        }
        return retrofit.create(ApiRequest.class);
    }

    private Retrofit createRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://serverwords.herokuapp.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
