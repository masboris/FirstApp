package com.example.multithread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AsyncDemo extends AppCompatActivity {

    Button execute;
    Button cancel;
    ProgressBar progressBar;
    TextView txt;

    private static final String TAG = "ASYNC_TASK";
    private MyTask myTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        execute = findViewById(R.id.execute);
        cancel = findViewById(R.id.cancel);
        progressBar = findViewById(R.id.progressBar);
        txt = findViewById(R.id.text_view);

        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myTask = new MyTask();
                myTask.execute("Baidu URL");
                execute.setEnabled(false);
                cancel.setEnabled(true);


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myTask.cancel(true);

            }
        });

    }

    private class MyTask extends AsyncTask<String, Integer, String>{
        @Override
        protected void onPreExecute() {
            //main thread
            Log.i(TAG, "onPreExecute() called  ------------- step 1");
            txt.setText("loading...");
        }


        @Override
        protected String doInBackground(String... strings) {
            //child thread
            Log.i(TAG, "doInBackground(String... strings) called  ------------- step 2 " + strings[0]);
            try {
                long total = 100;
                int count = 0;
                while (count < total) {
                    count++;
                    publishProgress(count);
                    Thread.sleep(500);
                }
                return new String("OK.");
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            return null;


        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, " onProgressUpdate(Integer... values) called ---------- step 3 in progress");
            progressBar.setProgress(values[0]);
            txt.setText("loading..." + values[0] + "%");
        }


        @Override
        protected void onPostExecute(String s) {
            //main thread
            //change ui
            Log.i(TAG, "onPostExecute(String s) called ------------ step 4");
            txt.setText(s);
            execute.setEnabled(true);
            cancel.setEnabled(false);
        }




        @Override
        protected void onCancelled() {
            Log.i(TAG, "onCancelled() called ----------stop");
            txt.setText("Cancelled");
            progressBar.setProgress(0);
            execute.setEnabled(true);
            cancel.setEnabled(false);
        }
    }


}
