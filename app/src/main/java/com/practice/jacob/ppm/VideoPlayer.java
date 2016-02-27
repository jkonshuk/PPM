package com.practice.jacob.ppm;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;

/**
 * Created by taser_000 on 2/27/2016.
 */
public class VideoPlayer {

    public VideoPlayer(Context context, SurfaceView surface, int resource) {
        myPlayer = MediaPlayer.create(context, resource);
        mySurface = surface;
    }

    public void play () {
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
            myPlayer.stop();
            isStopped = true;
        }
    }

    public void pause() {
        myPlayer.stop();
        isStopped = true;
    }

    public boolean isPlaying() {
        return isStopped;
    }

    public MediaPlayer myPlayer;
    private SurfaceView mySurface;
    public boolean isStopped = false;
}
