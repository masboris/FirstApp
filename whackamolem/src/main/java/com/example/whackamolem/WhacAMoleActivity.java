package com.example.whackamolem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class WhacAMoleActivity extends AppCompatActivity {

    Handler handler = new Handler ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(WhacAMoleActivity.this, MainActivity.class));

                    }
                }, 3000);
            }
        }).start();
    }
}