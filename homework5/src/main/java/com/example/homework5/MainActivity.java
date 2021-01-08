package com.example.homework5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button b_call, b_msg, b_add, b_fragment;
    TextView txt_name, txt_phone;
    LinearLayout contact;
    ImageView img;


//    ArrayList<Contact> contactlist = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_call = findViewById(R.id.b_call);
        b_msg = findViewById(R.id.b_msg);
        b_add = findViewById(R.id.b_add);
        b_fragment = findViewById(R.id.b_fragment);
        txt_name = findViewById(R.id.txt_name);
        txt_phone = findViewById(R.id.txt_phone);
        contact = findViewById(R.id.contact);
        img = findViewById(R.id.img);


        Intent intent = getIntent();

        if( intent.getExtras() == null)
        {
            contact.setVisibility(View.GONE);
        }

        else {
            String phone = intent.getStringExtra("phone");
            String name = intent.getStringExtra("name");
            int imgid = intent.getIntExtra("imgid", R.mipmap.ava01);
            txt_phone.setText(phone);
            txt_name.setText(name);
            img.setImageResource(imgid);
        }

        b_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, fragment.class);
                startActivity(i);
            }
        });

        b_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+txt_phone.getText().toString()));
                startActivity(i);
            }
        });

        b_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("smsto:"+txt_phone.getText().toString()));
                startActivity(i);

            }
        });

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, Register.class);
                startActivity(i);
            }
        });


    }
}
