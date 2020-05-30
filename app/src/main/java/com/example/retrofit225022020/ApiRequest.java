package com.example.retrofit225022020;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest{
    @GET("word")
    Call<ResponseAPI> getWord();


}
