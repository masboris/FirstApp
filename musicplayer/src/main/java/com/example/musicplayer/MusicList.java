package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicList extends AppCompatActivity {

    ListView musiclist;
    List mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        musiclist = findViewById(R.id.list_inline);
        mlist = new ArrayList();

        for (int i=0; i<10; i++){
            Map map = new HashMap();
            map.put("music_name","music_name"+i);
            map.put("music_length","" + (int)(Math.random()*100));
            mlist.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                MusicList.this,
                mlist,
                R.layout.mlist_item,
                new String[]{"music_name","music_length"},
                new int[]{R.id.music_name, R.id.music_length}
        );

        musiclist.setAdapter(simpleAdapter);

    }
}