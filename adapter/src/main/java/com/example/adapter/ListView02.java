package com.example.adapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListView02 extends AppCompatActivity {

    String uname[] = {
            "Tom",
            "Mike",
            "Kevin",
            "Ben",
            "Jack",
            "Boris"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv02);

        ListView lv02 = findViewById(R.id.lv02);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, uname);
        lv02.setAdapter(adapter);
        lv02.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("view",""+view);
                Log.e("position",""+i);
                Log.e("uname", ""+uname[i]);
                Toast toast = Toast.makeText(ListView02.this, ""+uname[i], Toast.LENGTH_LONG);
            }
        });
    }
}
