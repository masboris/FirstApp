package com.example.homework03_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework03);


        TextView txt = findViewById(R.id.text1);
        txt.setSelected(true);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void playmovie(View v) {
        VideoView vv = (VideoView)this.findViewById(R.id.video1);
        String uri = "android.resource://" + getPackageName() + "/" + + R.raw.beach;
        vv.setVideoURI(Uri.parse(uri));
        vv.start();
    }
}
