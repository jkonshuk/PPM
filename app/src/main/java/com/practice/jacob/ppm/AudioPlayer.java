package com.practice.jacob.ppm;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

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
                try {
                    audio.prepare();
                    audio.seekTo(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isStopped = false;
            }
            audio.start();
        }
        else {
            audio.stop();
            isStopped = true;
        }
    }

    public void pause () {
        audio.stop();
        isStopped = true;
    }

    public boolean isPlaying() {
        return isStopped;
    }

    public MediaPlayer audio;
    public boolean isStopped = false;
}
