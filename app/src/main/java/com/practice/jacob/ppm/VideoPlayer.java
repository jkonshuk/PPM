package com.practice.jacob.ppm;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by Jacob Konshuk on 2/27/2016.
 */
public class VideoPlayer {
    private SurfaceView mySurface;
    private MediaPlayer myPlayer;
    private boolean isStopped = false;

    public VideoPlayer (Context context, SurfaceView surface, int resource) {
        myPlayer = MediaPlayer.create(context,resource);
        mySurface = surface;
    }

    public void play() {
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

    public void pause(){
        myPlayer.stop();
        isStopped = true;
    }

    public boolean stopped(){
        return isStopped;
    }
}
