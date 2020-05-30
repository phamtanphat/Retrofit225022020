package com.example.retrofit225022020;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImg = findViewById(R.id.imageview);

        RetrofitApi
                .getInstance()
                .getWord()
                .enqueue(new Callback<ResponseAPI>() {
                    @Override
                    public void onResponse(Call<ResponseAPI> call, Response<ResponseAPI> response) {
                        ResponseAPI responseAPI = response.body();
                        Toast.makeText(MainActivity.this, responseAPI.getWord().size() + "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseAPI> call, Throwable t) {

                    }
                });

    }
}
