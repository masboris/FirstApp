package com.example.multithread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HandlerDemo_old extends AppCompatActivity {

    TextView txt;
    Handler handler;
    SeekBar seekBar;
    int x = 1;
    int flag = 123;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        txt = findViewById(R.id.mt_handler_text);
        seekBar = findViewById(R.id.seekBar);
        Button but = findViewById(R.id.mt_handler_change);

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                x= x+1;
                txt.setText("After");
                seekBar.setProgress(x);
                handler.sendEmptyMessageDelayed(flag, 50);
            }
        };



        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handler.sendEmptyMessage(flag);
//
//                Thread t = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        handler.sendEmptyMessage(123);
//
//                    }
//                });
//                t.start();

            }
        });
    }




}
