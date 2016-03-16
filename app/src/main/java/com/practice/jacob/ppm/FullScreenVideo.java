package com.practice.jacob.ppm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.io.IOException;

/**
 * This class handles all of the video playing in a separate activity from the main activity
 * VideoSelect. It has to implement the SurfaceHolder.Callback to override the SurfaceCreated
 * and SurfaceDestroyed methods to assure that the Surface (VideoView) used stays in scope for the duration
 * of the activity.
 */
public class FullScreenVideo extends AppCompatActivity implements SurfaceHolder.Callback {
    //member variables
    private MediaPlayer myVid;
    private SurfaceView surface;
    private SurfaceHolder holder;
    private Button button;
    private boolean isStopped = false;

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
        play(button);
    }

    private void initialize(){
        Intent intent = getIntent();
        surface = (SurfaceView)(findViewById(R.id.videoView));
        holder = surface.getHolder();
        holder.addCallback(this);
        myVid = MediaPlayer.create(this, intent.getIntExtra("VIDEO", R.raw.a_book_of_mormon_story));
        button = (Button)(findViewById(R.id.button));
    }

    /**
     * The play function is the heart of this class's functionality. It controls when
     * the video plays and needs to be an onClick function so it can be called to pause the
     * video or play the video if it is paused.
     * @param v not used in the logic but needed to be an onClick function
     */
    public void play(View v) {
        //if the video is stopped prepare it to be played and play it
        if (!myVid.isPlaying()) {
            if (isStopped) {
                try {
                    myVid.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isStopped = false;
            }
            //make sure the button is invisible
            myVid.start();
        }
        else {
            pause();
        }
    }

    private void pause(){
        myVid.stop();
        isStopped = true;
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
}
