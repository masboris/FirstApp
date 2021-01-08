package com.example.homewor03_d;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);

        TextView success_username = findViewById(R.id.username);
        TextView success_password = findViewById(R.id.password);
        Button back = findViewById(R.id.but_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);

            }
        });

        Intent i = getIntent();
        String username = i.getStringExtra("username");
        String password = i.getStringExtra("password");

        success_username.setText(username);
        success_password.setText(password);




    }
}
