package com.practice.jacob.ppm;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;

public class VideoSelect extends AppCompatActivity {

    private MediaPlayer audio;
    private boolean isStopped = false;
    private SurfaceView mySurface;
    private MediaPlayer myPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_select);
        audio = MediaPlayer.create(this, R.raw.uchtdorf);
    }

    public void playSound(View v) {
        if (!audio.isPlaying()) {
            if (isStopped){
                audio = MediaPlayer.create(this, R.raw.uchtdorf);
                isStopped = false;
            }
            audio.start();
        }
        else {
            audio.stop();
            isStopped = true;
        }
    }
    
    public void playMovie (View v) {
        mySurface = (SurfaceView)(findViewById(R.id.videoView));
        myPlayer = MediaPlayer.create(this, R.raw.patternsoflight);

        myPlayer.setDisplay(mySurface.getHolder());
        //try {
            //myPlayer.setDataSource(this.getResources().getResourceName(R.raw.patternsoflight));
            //myPlayer.prepare();
       // } //catch (IOException e) {
            //e.printStackTrace();
        //}
        myPlayer.start();

        //myPlayer.release();
    }
}
