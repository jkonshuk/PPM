package com.practice.jacob.ppm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class VideoSelect extends AppCompatActivity {
    private List<VideoPlayer> videos;
    private List<AudioPlayer> audios;
    private List<SurfaceView> surfaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_select);
        initialize();
    }

    public void playAudio (AudioPlayer audio) {
        for (VideoPlayer v : videos) {
            if (!v.stopped())
                v.pause();
        }
        for (AudioPlayer a : audios) {
            if (!a.stopped())
                if (!a.equals(audio))
                    a.pause();
        }
        audio.play();
    }

    public void playVideo (VideoPlayer video){
        for (VideoPlayer v : videos) {
            if (!v.stopped())
                if(!v.equals(video))
                    v.pause();
        }
        for (AudioPlayer a : audios) {
            if (!a.stopped())
                a.pause();
        }
        video.play();
    }

    private void initialize() {
        videos = new ArrayList<>();
        audios = new ArrayList<>();
        surfaces = new ArrayList<>();

        //SurfaceView Initialization
        surfaces.add((SurfaceView)(findViewById(R.id.videoView)));
        surfaces.add((SurfaceView)(findViewById(R.id.videoView1)));
        surfaces.add((SurfaceView)(findViewById(R.id.videoView2)));
        surfaces.add((SurfaceView)(findViewById(R.id.videoView3)));
        surfaces.add((SurfaceView)(findViewById(R.id.videoView4)));
        surfaces.add((SurfaceView)(findViewById(R.id.videoView5)));
        surfaces.add((SurfaceView)(findViewById(R.id.videoView6)));
        surfaces.add((SurfaceView)(findViewById(R.id.videoView7)));
        surfaces.add((SurfaceView)(findViewById(R.id.videoView8)));

        //Audio Initialization
        audios.add(new AudioPlayer(this, R.raw.uchtdorf));

        //Video Initialization
        videos.add(new VideoPlayer(this, surfaces.get(0), R.raw.patterns_of_light));
        videos.add(new VideoPlayer(this, surfaces.get(1), R.raw.a_book_of_mormon_story));
        videos.add(new VideoPlayer(this, surfaces.get(2), R.raw.flecks_of_gold));
        videos.add(new VideoPlayer(this, surfaces.get(3), R.raw.good_things_to_come));
        videos.add(new VideoPlayer(this, surfaces.get(4), R.raw.let_us_be_men));
        videos.add(new VideoPlayer(this, surfaces.get(5), R.raw.mountains_to_climb));
        videos.add(new VideoPlayer(this, surfaces.get(6), R.raw.the_will_of_god));
        videos.add(new VideoPlayer(this, surfaces.get(7), R.raw.voice_of_the_spirit));
        videos.add(new VideoPlayer(this, surfaces.get(8), R.raw.wrong_roads));
    }

    public void mediaSelect (View v){
        Button button = (Button)(v);

        //Audio Content
        if(button.getText().equals("Audio1"))
            playAudio(audios.get(0));
        if(button.getText().equals("Audio2"))
            playAudio(audios.get(0));
        if(button.getText().equals("Audio3"))
            playAudio(audios.get(0));
        if(button.getText().equals("Audio4"))
            playAudio(audios.get(0));
        if(button.getText().equals("Audio5"))
            playAudio(audios.get(0));
        if(button.getText().equals("Audio6"))
            playAudio(audios.get(0));
        if(button.getText().equals("Audio7"))
            playAudio(audios.get(0));
        if(button.getText().equals("Audio8"))
            playAudio(audios.get(0));
        if(button.getText().equals("Audio9"))
            playAudio(audios.get(0));

        //Video content
        if(button.getText().equals("Video1"))
            playVideo(videos.get(0));
        if(button.getText().equals("Video2"))
            playVideo(videos.get(1));
        if(button.getText().equals("Video3"))
            playVideo(videos.get(2));
        if(button.getText().equals("Video4"))
            playVideo(videos.get(3));
        if(button.getText().equals("Video5"))
            playVideo(videos.get(4));
        if(button.getText().equals("Video6"))
            playVideo(videos.get(5));
        if(button.getText().equals("Video7"))
            playVideo(videos.get(6));
        if(button.getText().equals("Video8"))
            playVideo(videos.get(7));
        if(button.getText().equals("Video9"))
            playVideo(videos.get(8));
    }
}
