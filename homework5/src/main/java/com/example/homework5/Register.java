package com.example.homework5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity {

    EditText name, phone;
    Button b_register;
    ImageButton imb;
    int imgid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        b_register = findViewById(R.id.b_register);

        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.putExtra("imgid", imgid);
                i.setClass(Register.this, MainActivity.class);
                i.putExtra("name", name.getText().toString());
                i.putExtra("phone", phone.getText().toString());
                startActivity(i);




            }
        });

        imb = findViewById(R.id.img_but);
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Register.this, avatar.class);
                Register.this.startActivityForResult(i,123);
//                startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        imgid = intent.getIntExtra("imgid", R.mipmap.ava01);
        imb.setImageResource(imgid);


    }
}
