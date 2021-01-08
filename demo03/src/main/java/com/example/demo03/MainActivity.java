package com.example.demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public void ABC(View v){
        Log.e("Tag","your click b04.");
    }

    @Override
    public void onClick(View v) {
        Log.e("Tag","your click b03.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but01 = (Button)findViewById(R.id.b01);
        MyClick01 mc = new MyClick01();
        but01.setOnClickListener( mc );

        Button but02 = findViewById(R.id.b02);
        but02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Tag","your click b02.");
            }
        });

        Button but03 = findViewById(R.id.b03);
        but03.setOnClickListener(this);


    }

    class MyClick01 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.e("Tag","your click b01.");
        }
    }

}
