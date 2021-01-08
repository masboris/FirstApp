package com.example.multithread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button handler_but = findViewById(R.id.handler);
        handler_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, HandlerDemo.class);
                startActivity(i);

            }
        });

        Button async_but = findViewById(R.id.async_task);
        async_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, AsyncDemo.class);
                startActivity(i);

            }
        });

        Button game_but = findViewById(R.id.game);
        game_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, game.class);
                startActivity(i);

            }
        });



    }
}
