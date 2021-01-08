package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import databaseutil.MySQLiteHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but_shared = findViewById(R.id.data_sharedPref);
        but_shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SharedPref.class);
                startActivity(i);
            }
        });

        Button but_sqlite = findViewById(R.id.data_sqlite);

        but_sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySQLiteHelper myHelper = new MySQLiteHelper(MainActivity.this, "test.db", null, 1);

                myHelper.onCreate();



//                SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("test_db.db", null);
            }
        });
    }
}
