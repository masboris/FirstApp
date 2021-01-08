package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);

        A a = new A();
        b1.setOnClickListener(a);
        b2.setOnClickListener(a);
    }

    class A implements View.OnClickListener{
        @Override
        public void onClick(View view) {
//            Log.e("which:", ""+view.getId());

            switch (view.getId()){
                case R.id.button1:
                    Log.e("which:", "Button 01 Clicked");
                    break;
                case R.id.button2:
                    Log.e("which:", "Button 02 Clicked");
                    break;
            }
        }
    }
}
