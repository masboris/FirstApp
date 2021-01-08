package com.example.multithread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HandlerDemo extends AppCompatActivity {

    TextView txt;
    Button but;
    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        txt = findViewById(R.id.mt_handler_text);
        but = findViewById(R.id.mt_handler_change);

        handler = new Handler();

//        handler = new Handler(){
//            @Override
//            public void handleMessage(@NonNull Message msg) {
//                super.handleMessage(msg);
//                if(msg.what == 10001){
//                    txt.setText("Handler change text!");
//                }
//                Log.e("HandlerDemo", "handleMessage : "+ msg.arg1 + msg.arg2 + msg.obj);
//            }
//        };



        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //child thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        handler.sendEmptyMessage(1234);
//                        handler.sendEmptyMessageDelayed(1234,2000);
//
//                        Message msg = Message.obtain();
//                        msg.what = 10001;
//                        msg.arg1 = 100;
//                        msg.arg2 = 200;
//                        msg.obj = HandlerDemo.this;
//                        handler.sendMessage(msg);

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                txt.setText("Changed by post");
                            }
                        });

//                        handler.postDelayed()


                    }
                }).start();

            }
        });

    }






}
