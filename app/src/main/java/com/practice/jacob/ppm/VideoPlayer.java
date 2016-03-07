package com.practice.jacob.ppm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by taser_000 on 2/27/2016.
 */
public class VideoPlayer extends AppCompatActivity {
    private MediaPlayer myPlayer;
    private SurfaceView mySurface;
    private boolean isStopped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        Intent intent = getIntent();
        mySurface = (SurfaceView)(findViewById(R.id.surfaceView));
        myPlayer = MediaPlayer.create(this, intent.getIntExtra("VIDEO", R.raw.a_book_of_mormon_story));
        play();
    }

    public void play() {
        myPlayer.setDisplay(mySurface.getHolder());
        myPlayer.setSurface(mySurface.getHolder().getSurface());

        if (!myPlayer.isPlaying()) {
            if (isStopped) {
                try {
                    myPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isStopped = false;
            }
            myPlayer.start();
        }
        else {
            myPlayer.stop();
            isStopped = true;
        }
    }
}
