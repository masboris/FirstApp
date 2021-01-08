package com.example.adapter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListView03 extends AppCompatActivity {

    int photos[] = {
            R.drawable.ava01,
            R.drawable.ava02,
            R.drawable.ava03,
            R.drawable.ava04,
            R.drawable.ava05,
            R.drawable.ava06,
    };

    String uname[] = {
            "Tom",
            "Jack",
            "Mike",
            "Ben",
            "Felix",
            "Steven"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv03);

        List<Map<String, Object>> users = new ArrayList<Map<String, Object>>();
        for (int i=0; i<photos.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("photo", photos[i]);
            map.put("uname", uname[i]);
            users.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                users,
                R.layout.usersinfo,
                new String[] {"photo", "uname"},
                new int[] { R.id.img, R.id.txt }

        );

        ListView lv03 = findViewById(R.id.lv03);
        lv03.setAdapter(adapter);
        lv03.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Map map = (Map) parent.getItemAtPosition(i);
                String un = (String) map.get("uname");
                Toast toast = Toast.makeText(ListView03.this, un, Toast.LENGTH_LONG);
//                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//                v.setTextColor(Color.RED);
                toast.show();
            }
        });

    }
}
