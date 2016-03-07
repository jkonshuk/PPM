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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        myPlayer = MediaPlayer.create(this, intent.getIntExtra("VIDEO", 0));
        mySurface = (SurfaceView)(findViewById(R.id.videoView));
        play();
    }

    public void play () {
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
            pause();
        }
    }

    public void pause() {
        myPlayer.stop();
        isStopped = true;
    }

    private MediaPlayer myPlayer;
    private SurfaceView mySurface;
    private Intent intent = getIntent();
    private boolean isStopped = false;
}
