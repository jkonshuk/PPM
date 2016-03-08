package com.practice.jacob.ppm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by taser_000 on 2/27/2016.
 */
public class VideoPlayer extends AppCompatActivity {
    private SurfaceView mySurface;
    private MediaPlayer myPlayer;
    private SurfaceHolder holder;
    private boolean isStopped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        mySurface = (SurfaceView)(findViewById(R.id.surfaceView));
        holder = mySurface.getHolder();
        play();
    }

    public void play() {
        Intent intent = getIntent();
        myPlayer = MediaPlayer.create(this, intent.getIntExtra("VIDEO", R.raw.a_book_of_mormon_story));

        try {
            //myPlayer.setDisplay(mySurface.getHolder());
            myPlayer.setSurface(mySurface.getHolder().getSurface());
        }
        catch (Exception e){
            Log.w("HolderError", mySurface.getHolder().toString());
            Log.w("HolderError", mySurface.getHolder().getSurface().toString());
            Log.e("HolderError", e.getMessage());
            Log.e("HolderError", e.toString());
            Log.e("HolderError", e.getLocalizedMessage());
        }

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
