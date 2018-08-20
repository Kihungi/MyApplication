package com.example.ironlady.myapplication;

import android.accounts.AccountAuthenticatorActivity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ironlady.myapplication.AccountActvity.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 8000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent SplashScreenIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(SplashScreenIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

