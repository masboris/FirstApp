package com.example.networkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class httpok extends AppCompatActivity implements View.OnClickListener {

    Button bget, bpost;
    TextView txt_content;
    EditText et_name, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpok);


        bget = findViewById(R.id.ok_get);
        bpost = findViewById(R.id.ok_post);
        txt_content = findViewById(R.id.ok_content);

        et_name = findViewById(R.id.ok_name);
        et_pass = findViewById(R.id.ok_pass);

        bget.setOnClickListener(this);
        bpost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        OkHttpClient okHttpClient = new OkHttpClient();
        Request request;
        final Call call;

        switch (view.getId()){
            case R.id.ok_get:

                request = new Request.Builder()
                        .url("http://10.0.2.2:8000/register/?name=Tom&password=1234")
                        .get()
                        .build();
                call = okHttpClient.newCall(request);
                new Thread(new Runnable() {
                    public void run() {
                        final Response response;
                        try {
                            response = call.execute();
                            final String content = response.body().string();
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    txt_content.setText("OKHTTP3 \n"+ content);
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


                break;

            case R.id.ok_post:

                String name = et_name.getText().toString();
                String pass = et_pass.getText().toString();

                RequestBody formBody = new FormBody.Builder()
                        .add("name", name)
                        .add("password", pass)
                        .build();

                request = new Request.Builder()
                        .url("http://10.0.2.2:8000/register/")
                        .post(formBody)
                        .build();
                call = okHttpClient.newCall(request);
                new Thread(new Runnable() {
                    public void run() {
                        final Response response;
                        try {
                            response = call.execute();
                            final String content = response.body().string();
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    txt_content.setText("OKHTTP3 \n"+ content);
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


                break;
        }

    }
}