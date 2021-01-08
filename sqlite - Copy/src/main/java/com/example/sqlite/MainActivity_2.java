package com.example.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlite.util.MyHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity_2 extends AppCompatActivity {

    EditText et_name, et_pass, et_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(MainActivity.this.getFilesDir().getAbsolutePath() + "/test.db", null);
//        Log.e("demo", "path" + MainActivity.this.getFilesDir().getAbsolutePath());

        et_name = findViewById(R.id.username);
        et_pass = findViewById(R.id.userpass);
        et_age = findViewById(R.id.userage);


        Button b_create = findViewById(R.id.but_create);
        b_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper myHelper = new MyHelper(MainActivity_2.this);
                myHelper.getReadableDatabase();
                Toast.makeText(MainActivity_2.this, "Table Created", Toast.LENGTH_SHORT).show();
            }
        });

        Button b_insert = findViewById(R.id.but_insert);
        b_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper myHelper = new MyHelper(MainActivity_2.this);
                SQLiteDatabase db = myHelper.getWritableDatabase();
//                String sql = "insert into userinfo (username,userpass,age) values('" + et_name.getText().toString() + "','" + et_pass.getText().toString() + "','" + et_age.getText().toString() + "')";
//                String sql = "insert into userinfo(username, userpass, age) values('tom', '1234', 20)";
//               Log.e("demo", "sql : " + sql);
//                db.execSQL(sql);

                String s1 = et_name.getText().toString();
                String s2 = et_pass.getText().toString();
                String s3 = et_age.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put("username", s1);
                cv.put("userpass", s2);
                cv.put("age", s3);
                long n = db.insert("userinfo", null, cv);
                Toast.makeText(MainActivity_2.this, "Insert Successful", Toast.LENGTH_LONG).show();
                db.close();
            }
        });

        Button b_update = findViewById(R.id.but_update);
        b_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper myHelper = new MyHelper(MainActivity_2.this);
                SQLiteDatabase db = myHelper.getWritableDatabase();
//                String sql = "update userinfo set userpass='qwerty' where _id = 1";
//                db.execSQL(sql);

                String s1 = et_name.getText().toString();
                String s2 = et_pass.getText().toString();
                String s3 = et_age.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put("userpass", s2);
                cv.put("age", s3);
                int i = db.update("userinfo", cv, "username = ?", new String[]{s1});
                if (i > 0) {
                    Toast.makeText(MainActivity_2.this, "Update Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity_2.this, "Name not found", Toast.LENGTH_SHORT).show();
                }

                db.close();
            }
        });

        Button b_delete = findViewById(R.id.but_del);
        b_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper myHelper = new MyHelper(MainActivity_2.this);
                SQLiteDatabase db = myHelper.getWritableDatabase();
                String s1 = et_name.getText().toString();
                String sql = "delete from userinfo where username = '"+ s1 + "'";
                try {
                    Log.e("sql :", ""+sql);
                    db.execSQL(sql);
                    Toast.makeText(MainActivity_2.this, "Delete Successful", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(MainActivity_2.this, "Name not found", Toast.LENGTH_SHORT).show();
                }
                db.close();

            }
        });

        Button b_show = findViewById(R.id.but_show);
        b_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper myHelper = new MyHelper(MainActivity_2.this);
                SQLiteDatabase db = myHelper.getReadableDatabase();
                String sql = "select * from userinfo";
                Cursor cursor = db.rawQuery(sql, null);
                List<String> id = new ArrayList<String>();
                List<String> username = new ArrayList<String>();
                List<String> pass = new ArrayList<String>();
                List<String> age = new ArrayList<String>();

                while (cursor.moveToNext()){
                    String s0 = cursor.getString(0);
                    String s1 = cursor.getString(1);
                    String s2 = cursor.getString(2);
                    String s3 = cursor.getString(3);

                    id.add(s0);
                    username.add(s1);
                    pass.add(s2);
                    age.add(s3);

                    Log.e("demo", "info: " + s0 + s1 + s2 + s3 );
                }
                cursor.close();

                ListView lv = findViewById(R.id.row);

                List<Map<String, Object>> users = new ArrayList<Map<String, Object>>();
                for (int i=0; i<id.size();i++){
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("s0", id.get(i));
                    map.put("s1", username.get(i));
                    map.put("s2", pass.get(i));
                    map.put("s3", age.get(i));
                    users.add(map);
                }

                SimpleAdapter adapter = new SimpleAdapter(
                        MainActivity_2.this,
                        users,
                        R.layout.tablerow,
                        new String[] {"s0", "s1", "s2", "s3"},
                        new int[] { R.id.s0, R.id.s1, R.id.s2, R.id.s3 }
                );

                lv.setAdapter(adapter);
                db.close();
            }
        });

        //                SimpleCursorAdapter sca = new SimpleCursorAdapter(
//                        MainActivity.this,
//                        R.layout.showitem,
//                        cursor,
//                        new String[] {"_id", "username", "userpass", "age"},
//                        new int[] { R.id.s0, R.id.s1, R.id.s2, R.id.s3 },
//                        SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
//                );


    }
}
