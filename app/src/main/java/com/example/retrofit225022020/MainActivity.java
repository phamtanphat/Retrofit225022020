package com.example.retrofit225022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cach su dung lib retrofit
        // 1 : Khởi tạo ra retrofit

        // OkHttpClient : Config các connection
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                    .readTimeout(30, TimeUnit.SECONDS)
                                    .connectTimeout(30, TimeUnit.SECONDS)
                                    .writeTimeout(30, TimeUnit.SECONDS)
                                    .retryOnConnectionFailure(true)
                                    .protocols(Arrays.asList(Protocol.HTTP_1_1))
                                    .build();

        // Gson : parse dư liệu về dạng object của java
        Gson gson = new GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://khoapham.vn/KhoaPhamTraining/json/tien/")
                            .client(okHttpClient)
                            .addConverterFactory()

        // 2 : Định nghĩa các request call http
        // 3 : Gọi request muốn thực thi
        // 4 : Nhận dữ liệu từ request thông qua phương thức Call

    }
}
