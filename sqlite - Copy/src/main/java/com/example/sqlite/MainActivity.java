package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.dao.UserDaoImpl;
import com.example.sqlite.entity.User;
import com.example.sqlite.util.MyAdapter;
import com.example.sqlite.util.MyHelper;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText et_name, et_pass, et_age;
    List<User> users;
    UserDaoImpl udi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        udi = new UserDaoImpl(MainActivity.this);

//        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(MainActivity.this.getFilesDir().getAbsolutePath() + "/test.db", null);
//        Log.e("demo", "path" + MainActivity.this.getFilesDir().getAbsolutePath());

        et_name = findViewById(R.id.username);
        et_pass = findViewById(R.id.userpass);
        et_age = findViewById(R.id.userage);


        Button b_create = findViewById(R.id.but_create);
        b_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper myHelper = new MyHelper(MainActivity.this);
                myHelper.getReadableDatabase();
                Toast.makeText(MainActivity.this, "Table Created", Toast.LENGTH_SHORT).show();
            }
        });

        Button b_insert = findViewById(R.id.but_insert);
        b_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = et_name.getText().toString();
                String s2 = et_pass.getText().toString();
                String s3 = et_age.getText().toString();

                User user = new User(s1, s2, Integer.parseInt(s3));
                long n = udi.insertUser(user);

                Toast.makeText(MainActivity.this, "Insert Successful \n Row ID : " + n, Toast.LENGTH_LONG).show();

            }
        });

        Button b_update = findViewById(R.id.but_update);
        b_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String s1 = et_name.getText().toString();
                String s2 = et_pass.getText().toString();
                String s3 = et_age.getText().toString();

                User user = new User(s1, s2, Integer.parseInt(s3));
                udi.updateUser(user);


            }
        });

        Button b_delete = findViewById(R.id.but_del);
        b_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = et_name.getText().toString();
                udi.deleteUser(s1);
            }
        });

        Button b_show = findViewById(R.id.but_show);
        b_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                users = udi.getAllUser();

                ListView lv = findViewById(R.id.row);

                lv.setAdapter(new MyAdapter(MainActivity.this, users));


            }
        });
    }

}
