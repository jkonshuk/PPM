package com.practice.jacob.ppm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;

public class FullScreenVideo extends AppCompatActivity {
    VideoPlayer myVid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_video);
        Intent intent = getIntent();
        SurfaceView surface = (SurfaceView)(findViewById(R.id.videoView));
        myVid = new VideoPlayer(this, surface, intent.getIntExtra("VIDEO", R.raw.a_book_of_mormon_story));
        myVid.play();
    }

    public void play(){
    }
}
