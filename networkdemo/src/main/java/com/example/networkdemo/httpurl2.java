package com.example.networkdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class httpurl2 extends AppCompatActivity implements View.OnClickListener {

    Button bget, bpost;
    TextView txt_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpurl);

        bget = findViewById(R.id.http_get);
        bpost = findViewById(R.id.http_post);
        txt_content = findViewById(R.id.http_content);

        bget.setOnClickListener(this);

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String s = (String) msg.obj;
            txt_content.setText(s);
        }
    };

    @Override
    public void onClick(View view) {
//        final String content = null;
        switch (view.getId()) {
            case R.id.http_get:

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            final String content;
                            URL url = new URL("http://localhost:8000/register/");
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setDoInput(true);
                            conn.setRequestMethod("GET");
                            conn.setConnectTimeout(10*1000);
                            conn.connect();

                            InputStream inputStream = conn.getInputStream();
//                    byte b[] = new byte[1024];
//                    StringBuffer sb = new StringBuffer();
//                    int len = 0;
//                    while ((len = inputStream.read(b)) != -1 ) {
//                        String s = new String(b);
//                        sb.append(s);
//                    }

                            StringBuffer sb = new StringBuffer();
                            String s = null;
                            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                            while ( (s=br.readLine()) !=null ){
                                sb.append(s);
                            }

                            content = sb.toString();
                            inputStream.close();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txt_content.setText(content);
                                    Log.e("urldemo", "runOnUIThread");
                                }
                            });

//                            Message msg = Message.obtain();
//                            msg.what = 1;
//                            msg.obj=content;
//                            handler.sendMessage(msg);
//                            txt_content.setText(content);


                        } catch (MalformedURLException e){
                            e.printStackTrace();

                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;

            case R.id.http_post:


                break;

            case R.id.http_content:


                break;
        }
    }



}