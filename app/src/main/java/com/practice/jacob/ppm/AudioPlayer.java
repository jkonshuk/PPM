package com.practice.jacob.ppm;

import android.content.Context;
import android.media.MediaPlayer;
import java.io.IOException;

public class AudioPlayer {

    /**
     * AudioPlayer creates a MediaPlayer with its constructor
     * @param context of where video was called
     * @param resource audio file to be played
     */
    public AudioPlayer (Context context, int resource){
        audio = MediaPlayer.create(context, resource);
}

    /**
     * checks conditions of the MediaPlayer if playable it plays
     * the audio
     */
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

    /**
     * stops audio if sets isStopped is true
     */
    public void pause () {
        audio.stop();
        isStopped = true;
    }

    /**
     * checks to see if video is stopped
     * @return boolean value of isStopped
     */
    public boolean stopped() {
        return isStopped;
    }

    private MediaPlayer audio;
    private boolean isStopped = false;
}
