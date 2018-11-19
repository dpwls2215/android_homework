package com.example.jiwon.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity {
    Intent loginIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        startLoading();
        loginIntent = new Intent(this, LoginActivity.class);
    }

    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(loginIntent);
            }
        }, 3000);
    }
}
