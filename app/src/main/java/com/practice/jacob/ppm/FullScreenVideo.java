package com.practice.jacob.ppm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.io.IOException;

public class FullScreenVideo extends AppCompatActivity implements SurfaceHolder.Callback {
    private MediaPlayer myVid;
    private SurfaceView surface;
    private SurfaceHolder holder;
    private Button button;
    private boolean isStopped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_video);
        initialize();
        play(button);
    }

    public void initialize(){
        Intent intent = getIntent();
        surface = (SurfaceView)(findViewById(R.id.videoView));
        holder = surface.getHolder();
        holder.addCallback(this);
        myVid = MediaPlayer.create(this, intent.getIntExtra("VIDEO", R.raw.a_book_of_mormon_story));
        button = (Button)(findViewById(R.id.button));
    }

    public void play(View v) {
        if (!myVid.isPlaying()) {
            if (isStopped) {
                try {
                    myVid.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isStopped = false;
            }
            button.setBackgroundColor(0x00ffff);
            myVid.start();
        }
        else {
            pause();
        }
    }

    public void pause(){
        myVid.stop();
        isStopped = true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        myVid.setDisplay(holder);
        myVid.setSurface(holder.getSurface());
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        myVid.setDisplay(null);
        myVid.setSurface(null);
        myVid.release();
    }
}
