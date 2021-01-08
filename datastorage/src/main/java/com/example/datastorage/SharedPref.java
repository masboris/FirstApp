package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPref extends AppCompatActivity {
    EditText name;
    SharedPreferences userinfo;
    SharedPreferences.Editor et;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        Button but_save = findViewById(R.id.but_save);
        Button but_read = findViewById(R.id.but_read);
        Button clear01 = findViewById(R.id.clear01);
        Button clear02 = findViewById(R.id.clear02);

        name = findViewById(R.id.data_input);
        final TextView outputname = findViewById(R.id.outputname);

        but_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userinfo = SharedPref.this.getSharedPreferences("sharedfile01", MODE_PRIVATE);
                et = userinfo.edit();

                uname = name.getText().toString();
                et.putString("unameKey", uname);

                et.commit();
//                et.apply();

            }
        });

        but_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = userinfo.getString("unameKey", "jack");
                et.commit();
                outputname.setText(a);

            }
        });

        clear01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.remove("unameKey");
                et.commit();
            }
        });

        clear02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.clear();
                et.commit();
            }
        });

    }
}
