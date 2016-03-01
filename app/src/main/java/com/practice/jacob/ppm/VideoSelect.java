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
        audio = new AudioPlayer(this, R.raw.uchtdorf);
    }

    public void playAudio (View v) {
        if (!video.stopped())
            video.pause();
        audio.play();
    }

    public void playVideo (){
        if (!audio.stopped())
            audio.pause();
        video.play();
    }

    public void changeButton (View v){
        Button button = (Button)(findViewById(v.getId()));
        if(button.getText().equals("Audio1"))
            button.setText("something else");
        if(button.getText().equals("Audio2"))
            button.setText("something else");
        if(button.getText().equals("Audio3"))
            button.setText("something else");
        if(button.getText().equals("Audio4"))
            button.setText("something else");
        if(button.getText().equals("Audio5"))
            button.setText("something else");
        if(button.getText().equals("Audio6"))
            button.setText("something else");
        if(button.getText().equals("Audio7"))
            button.setText("something else");
        if(button.getText().equals("Audio8"))
            button.setText("something else");
        if(button.getText().equals("Audio9"))
            button.setText("something else");
        if(button.getText().equals("Video1")) {
            video = new VideoPlayer(this, surface, R.raw.patterns_of_light);
            playVideo();
        }
        if(button.getText().equals("Video2")) {
            video = new VideoPlayer(this, surface, R.raw.a_book_of_mormon_story);
            playVideo();
        }
        if(button.getText().equals("Video3")) {
            video = new VideoPlayer(this, surface, R.raw.flecks_of_gold);
            playVideo();
        }
        if(button.getText().equals("Video4")) {
            video = new VideoPlayer(this, surface, R.raw.good_things_to_come);
            playVideo();
        }
        if(button.getText().equals("Video5")) {
            video = new VideoPlayer(this, surface, R.raw.let_us_be_men);
            playVideo();
        }
        if(button.getText().equals("Video6"))
            video = new VideoPlayer(this, surface, R.raw.patternsoflight);
        if(button.getText().equals("Video7"))
            video = new VideoPlayer(this, surface, R.raw.patternsoflight);
        if(button.getText().equals("Video8"))
            video = new VideoPlayer(this, surface, R.raw.patternsoflight);
        if(button.getText().equals("Video9"))
            video = new VideoPlayer(this, surface, R.raw.patternsoflight);

    }

}
