package com.practice.jacob.ppm;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;

public class VideoSelect extends AppCompatActivity {

    private MediaPlayer audio;
    private boolean isStopped = false;
    private boolean videoStop = false;
    private SurfaceView mySurface;
    private MediaPlayer myPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_select);
        audio = MediaPlayer.create(this, R.raw.uchtdorf);
        myPlayer = MediaPlayer.create(this, R.raw.patternsoflight);
        mySurface = (SurfaceView)(findViewById(R.id.videoView));
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
        myPlayer.setDisplay(mySurface.getHolder());
        myPlayer.setSurface(mySurface.getHolder().getSurface());

        if (!myPlayer.isPlaying()) {
            if (videoStop) {
                videoStop = false;
            }
            myPlayer.start();
        }
        else {
            myPlayer.pause();
            videoStop = true;
        }
    }

    public static MediaPlayer getAudio()
    {
        return null;
    }
}
