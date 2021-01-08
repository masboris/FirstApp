package com.example.whackamolem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int CODE = 123;

    private ImageView img;
    private Button startButton;
    private TextView resultTxt;


    public int [][] img_position = new int[][]{
            {370,250}, {850,250}, {1400,250},
            {350,450}, {850,450}, {1400,400},
            {320,650}, {850,650}, {1400,650},
    };

    private int totalCount;
    private int successCount;

    public static final int MAX_COUNT = 10;

    MyHandler handler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        initView();


//        img = findViewById(R.id.hamster_img);
//        img.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                img.setVisibility(View.GONE);
//                return false;
//            }
//        });
//
//        Message msg = Message.obtain();
//        msg.what = 123;
//        msg.arg1 = 5;
//
//        handler.sendEmptyMessage(123);


    }

    private void initView(){
        img = findViewById(R.id.hamster_img);
        resultTxt = findViewById(R.id.result_txt);
        startButton = findViewById(R.id.start_but);
        img.setVisibility(View.INVISIBLE);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                img.setVisibility(View.GONE);
                successCount++;
                resultTxt.setText(successCount + " of " + MAX_COUNT + " were hit.");
                return false;
            }
        });

    }

    private void start(){
        startButton.setText("Loading....");
        startButton.setVisibility(View.INVISIBLE);
        startButton.setEnabled(false);
        resultTxt.setText("");
        next(0);
    }

    private void next(int delayTime){
        int position = new Random().nextInt(img_position.length);

        Message msg = Message.obtain();
        msg.what = CODE;
        msg.arg1 = position;
        handler.sendMessageDelayed(msg, delayTime);
        totalCount++;
    }



    public static class MyHandler extends Handler {

        public static final int RANDOM_NUMBER = 500;
        public final WeakReference<MainActivity> myWeakRef;

        public MyHandler(MainActivity activity){
            myWeakRef = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            MainActivity activity = myWeakRef.get();

            switch (msg.what){
                case CODE:
                    if(activity.totalCount > MAX_COUNT){
                        activity.clear();
                        Toast.makeText(activity, "Game Over！", Toast.LENGTH_LONG).show();
                        activity.startButton.setVisibility(View.VISIBLE);
                        return;
                    }

                    int position = msg.arg1;
                    activity.img.setX(activity.img_position[position][0]);
                    activity.img.setY(activity.img_position[position][1]);
                    activity.img.setVisibility(View.VISIBLE);

                    int randomTime = new Random().nextInt(RANDOM_NUMBER) + RANDOM_NUMBER;
                    activity.next(randomTime);
                    break;


            }

        }
    }

    private void clear(){
        totalCount = 0;
        successCount = 0;
        img.setVisibility(View.GONE);
        startButton.setText("Play");
        startButton.setEnabled(true);
    }
}
