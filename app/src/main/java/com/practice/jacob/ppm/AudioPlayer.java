package com.practice.jacob.ppm;

import android.content.Context;
import android.media.MediaPlayer;
import java.io.IOException;

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
            pause();
        }
    }

    public void pause () {
        audio.stop();
        isStopped = true;
    }

    public boolean stopped() {
        return isStopped;
    }

    private MediaPlayer audio;
    private boolean isStopped = false;
}
