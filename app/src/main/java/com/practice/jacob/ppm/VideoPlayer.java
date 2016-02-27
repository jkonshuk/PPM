package com.practice.jacob.ppm;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceView;
import android.view.View;

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

    public MediaPlayer myPlayer;
    private SurfaceView mySurface;
    public boolean videoStop = false;
}
