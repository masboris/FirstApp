package com.example.networkdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class httpurl extends AppCompatActivity implements View.OnClickListener {

    Button bget, bpost;
    TextView txt_content;
    EditText et_name, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpurl);

        bget = findViewById(R.id.http_get);
        bpost = findViewById(R.id.http_post);
        txt_content = findViewById(R.id.http_content);

        et_name = findViewById(R.id.et_name);
        et_pass = findViewById(R.id.et_pass);

        bget.setOnClickListener(this);
        bpost.setOnClickListener(this);

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
//                            URL url = new URL("http://10.0.2.2:8000/register/");
                            URL url = new URL("http://10.0.2.2:8000/register/?name=Tom&password=1234");
//                            URL url = new URL("http://192.168.56.1:8000/register/?name=Tom&password=1234");
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setDoInput(true);
                            conn.setRequestMethod("GET");
                            conn.setConnectTimeout(10*1000);
                            conn.setReadTimeout(5*1000);
//                            conn.setRequestProperty("Content-type", "application/x-javascript->json");
                            conn.connect();

                            InputStream inputStream = conn.getInputStream();


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
                                    txt_content.setText("HTTP URL \n"+ content);
                                    Log.e("urldemo", "runOnUIThread");
                                }
                            });


                        } catch (MalformedURLException e){
                            e.printStackTrace();

                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;

            case R.id.http_post:
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            final String content;

                            URL url = new URL("http://10.0.2.2:8000/register/");
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setDoInput(true);
                            conn.setDoOutput(true);
                            conn.setRequestMethod("POST");
                            conn.setUseCaches(false);
                            conn.setReadTimeout(5*1000);
                            conn.setConnectTimeout(10*1000);
                            conn.connect();

                            OutputStream outputStream = conn.getOutputStream();
                            String name = et_name.getText().toString();
                            String pass = et_pass.getText().toString();
                            String param = "name="+name+"&password="+pass;
                            outputStream.write(param.getBytes());

                            outputStream.flush();
                            outputStream.close();

                            InputStream inputStream = conn.getInputStream();


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
                                    txt_content.setText("HTTP URL \n"+ content);
                                    Log.e("urldemo", "runOnUIThread");
                                }
                            });


                        } catch (MalformedURLException e){
                            e.printStackTrace();

                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;


            case R.id.http_content:


                break;
        }
    }



}