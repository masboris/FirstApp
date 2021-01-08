package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("LifeCycle","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle","onRestart");
    }
}
