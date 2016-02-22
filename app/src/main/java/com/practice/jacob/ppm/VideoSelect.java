package com.practice.jacob.ppm;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VideoSelect extends AppCompatActivity {
    private MediaPlayer audio;
    private boolean isStopped = false;

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
}
