package com.example.homewor03_d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button register = findViewById(R.id.but_register);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("username", username.getText().toString());
                i.putExtra("password", password.getText().toString());
                startActivity(i);

            }
        });




    }
}
