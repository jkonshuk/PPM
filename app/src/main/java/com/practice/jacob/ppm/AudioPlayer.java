package com.practice.jacob.ppm;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by taser_000 on 2/27/2016.
 */
public class AudioPlayer {

    public AudioPlayer (Context context, int resource){
        audio = MediaPlayer.create(context, resource);
    }

    public void play() {
        if (!audio.isPlaying()) {
            if (isStopped){
                //audio = MediaPlayer.create();
                isStopped = false;
            }
            audio.start();
        }
        else {
            audio.stop();
            isStopped = true;
        }
    }

    public MediaPlayer audio;
    public boolean isStopped = false;
}
