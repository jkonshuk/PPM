package com.practice.jacob.ppm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.List;

public class VideoSelect extends AppCompatActivity {
    private List<AudioPlayer> audios;
    private List<ImageButton> audioButtons;
    private List<ImageButton> videoButtons;
    private int[] identities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_select);
        initialize();
    }

    public void playAudio (AudioPlayer audio) {
        for (AudioPlayer a : audios) {
            if (!a.stopped())
                if (!a.equals(audio))
                    a.pause();
        }
        audio.play();
    }

    public void playVideo (int id){
        for (AudioPlayer a : audios) {
            if (!a.stopped())
                a.pause();
        }
        Intent intent = new Intent(this, FullScreenVideo.class);
        intent.putExtra("VIDEO", id);
        startActivity(intent);
    }

    private void initialize() {
        audios = new ArrayList<>();
        identities = new int[8];
        audioButtons = new ArrayList<>();
        videoButtons = new ArrayList<>();

        //Audio Initialization
        audios.add(new AudioPlayer(this, R.raw.patternsoflight));
        audios.add(new AudioPlayer(this, R.raw.abookofmormonstory));
        audios.add(new AudioPlayer(this, R.raw.flecksofgold));
        audios.add(new AudioPlayer(this, R.raw.goodthingstocome));
        audios.add(new AudioPlayer(this, R.raw.letusbemen));
        audios.add(new AudioPlayer(this, R.raw.wrongroads));
        audios.add(new AudioPlayer(this, R.raw.thewillofgod));
        audios.add(new AudioPlayer(this, R.raw.voiceofthespirit));

        //AudioButton Initialization
        audioButtons.add((ImageButton)findViewById(R.id.Audio1));
        audioButtons.add((ImageButton)findViewById(R.id.Audio2));
        audioButtons.add((ImageButton)findViewById(R.id.Audio3));
        audioButtons.add((ImageButton)findViewById(R.id.Audio4));
        audioButtons.add((ImageButton)findViewById(R.id.Audio5));
        audioButtons.add((ImageButton)findViewById(R.id.Audio6));
        audioButtons.add((ImageButton)findViewById(R.id.Audio7));
        audioButtons.add((ImageButton)findViewById(R.id.Audio8));

        //VideoButton Initialization
        videoButtons.add((ImageButton)findViewById(R.id.Video1));
        videoButtons.add((ImageButton)findViewById(R.id.Video2));
        videoButtons.add((ImageButton)findViewById(R.id.Video3));
        videoButtons.add((ImageButton)findViewById(R.id.Video4));
        videoButtons.add((ImageButton)findViewById(R.id.Video5));
        videoButtons.add((ImageButton)findViewById(R.id.Video6));
        videoButtons.add((ImageButton)findViewById(R.id.Video7));
        videoButtons.add((ImageButton)findViewById(R.id.Video8));

        //id Initialization
        identities[0] = (R.raw.patterns_of_light);
        identities[1] = (R.raw.a_book_of_mormon_story);
        identities[2] = (R.raw.flecks_of_gold);
        identities[3] = (R.raw.good_things_to_come);
        identities[4] = (R.raw.let_us_be_men);
        identities[5] = (R.raw.wrong_roads);
        identities[6] = (R.raw.the_will_of_god);
        identities[7] = (R.raw.voice_of_the_spirit);
    }

    public void mediaSelect (View v){
        //Audio Content
        for (int i = 0; i < audioButtons.size(); ++i)
            if(v.equals(audioButtons.get(i))) {
                playAudio(audios.get(i));
            }

        //Video Content
        for (int i = 0; i < videoButtons.size(); ++i)
            if(v.equals(videoButtons.get(i))) {
                playVideo(identities[i]);
            }
    }
}
