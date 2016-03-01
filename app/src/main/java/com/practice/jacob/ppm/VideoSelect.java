package com.practice.jacob.ppm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class VideoSelect extends AppCompatActivity {
    private SurfaceView surface;
    private AudioPlayer audio;
    private VideoPlayer video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_select);
        surface = (SurfaceView) (findViewById(R.id.videoView));
        video = new VideoPlayer(this, surface, R.raw.patternsoflight);
        audio = new AudioPlayer(this, R.raw.uchtdorf);
    }

    public void playAudio (View v) {
        if (!video.stopped())
            video.pause();
        audio.play();
    }

    public void playVideo (View v){
        if (!audio.stopped())
            audio.pause();
        video.play();
    }

    public void changeButton (View v){
        Button button = (Button)(findViewById(v.getId()));
        if(button.getText().equals(""))
            button.setText("something else");
        if(button.getText().equals("something"))
            button.setText("something else");
        if(button.getText().equals("something"))
            button.setText("something else");
        if(button.getText().equals("something"))
            button.setText("something else");
        if(button.getText().equals("something"))
            button.setText("something else");
        if(button.getText().equals("something"))
            button.setText("something else");
        if(button.getText().equals("something"))
            button.setText("something else");
        if(button.getText().equals("something"))
            button.setText("something else");
        if(button.getText().equals("something"))
            button.setText("something else");
        if(button.getText().equals("something"))
            button.setText("something else");
    }

}
