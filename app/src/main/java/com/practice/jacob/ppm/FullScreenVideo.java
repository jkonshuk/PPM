package com.practice.jacob.ppm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;

/**
 * This class handles all of the video playing in a separate activity from the main activity
 * VideoSelect. It has to implement the SurfaceHolder.Callback to override the SurfaceCreated
 * and SurfaceDestroyed methods to assure that the Surface (VideoView) used stays in scope for the duration
 * of the activity.
 */
public class FullScreenVideo extends AppCompatActivity implements SurfaceHolder.Callback, MediaController.MediaPlayerControl, MediaPlayer.OnPreparedListener {
    //member variables
    private MediaPlayer myVid;
    private SurfaceView surface;
    private SurfaceHolder holder;
    private MediaController controller;

    /**
     * This method keeps the screen on for the duration of the activity
     * and calls the initialize and play functions to start the video.
     * It's purpose is really just to get the activity started.
     * @param savedInstanceState Auto-generated parameter for an activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //keep the screen on while the activity is active
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_video);
        initialize();
        start();
    }

    private void initialize(){
        //this is needed to get the id passed from the VideoSelect activity
        Intent intent = getIntent();

        //The surface needs to be declared and the callback for creation set to this class
        surface = (SurfaceView)(findViewById(R.id.videoView));
        holder = surface.getHolder();
        holder.addCallback(this);

        //play, pause, seek, and other functionality for controlling the video
        controller = new MediaController(this);

        //create puts mediaPlayer in prepared state and the listener needs to be set to this class
        myVid = MediaPlayer.create(this, intent.getIntExtra("VIDEO", R.raw.a_book_of_mormon_story));
        myVid.setOnPreparedListener(this);
    }

    public void showMC(View v) {
        if (controller.isShowing()) {
            controller.hide();
        } else {
            controller.show();
        }
    }
    /**
     * In this class this method is used to keep the surface in scope for use in the
     * mediaPlayer. It is necessary to do anything we need with the surface between the
     * Created and Destroyed functions otherwise it will be out of scope and cause a runtime
     * error
     * @param holder The SurfaceHolder that was just recently initialized
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        myVid.setDisplay(holder);
        myVid.setSurface(holder.getSurface());
    }

    /**
     * Not used in this class
     * @param holder
     * @param format
     * @param width
     * @param height
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    /**
     * This method is used to clean up and free resources after the video is done playing
     * and the surface is no longer needed. This is important because the Surface will be
     * reinitialized each time the activity is started.
     * @param holder The SurfaceHolder to be released
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        myVid.setDisplay(null);
        myVid.setSurface(null);
        myVid.release();
    }

<<<<<<< HEAD
=======
    /**
     * Overrides for media player controls
     */
    @Override
    public void start() {
        myVid.start();
    }
    @Override
    public void pause(){
        myVid.pause();
    }
    @Override
    public int getDuration() {
        return myVid.getDuration();
    }
    @Override
    public int getCurrentPosition() {
        return myVid.getCurrentPosition();
    }
    @Override
    public void seekTo(int pos) {
        myVid.seekTo(pos);
    }
    @Override
    public boolean isPlaying() {
        return myVid.isPlaying();
    }
    @Override
    public int getBufferPercentage() {
        return 0;
    }
    @Override
    public boolean canPause() {
        return true;
    }
    @Override
    public boolean canSeekBackward() {
        return true;
    }
    @Override
    public boolean canSeekForward() {
        return true;
    }
    @Override
    public int getAudioSessionId() {
        return 0;
    }

    /**
     * Override for on prepared listener
     * @param mp
     */
    @Override
    public void onPrepared(MediaPlayer mp) {
        controller.setMediaPlayer(this);
        controller.setAnchorView(surface);
        controller.setEnabled(true);
        controller.show();
    }
>>>>>>> a0d49554621c9e09318dfc24584fa5f53f36e75c

}
