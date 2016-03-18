package com.practice.jacob.ppm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the main activity for the application and contains methods
 * for choosing what media will play based on what is clicked on the main
 * layout. It also determines how media will be played whether on the spot
 * or in a different activity.
 */
public class VideoSelect extends AppCompatActivity {
    //member variables
    private List<AudioPlayer> audios;
    private List<ImageButton> audioButtons;
    private List<ImageButton> videoButtons;
    private int[] identities;

    /**
     * On create will call initialize to set up all buttons.
     * @param savedInstanceState automatically generated code for activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_select);
        initialize();
    }

    /**
     * The play audio takes the audio and plays it. It will check to see if
     * any other audios are playing, if so, they will be stopped.
     * @param audio receives the audio to play from media select
     */
    private void playAudio (AudioPlayer audio) {
        //stop all other audio players
        for (AudioPlayer a : audios) {
            if (!a.stopped())
                if (!a.equals(audio))
                    a.pause();
        }
        audio.play();
    }
    
    /**
     * play video creates a new intent and starts the fullscreen video class.
     * if there are other audio's being played it will stop those.
     * @param id The id received by media select
     */
    private void playVideo (int id){
        //stop any audio that is playing
        for (AudioPlayer a : audios) {
            if (!a.stopped())
                a.pause();
        }

        //videos are played in a different activity and needs the id of the button pressed
        Intent intent = new Intent(this, FullScreenVideo.class);
        intent.putExtra("VIDEO", id);
        startActivity(intent);
    }

    /**
     * Initialize will initialize the buttons the audio files and videos. This
     * Will help the program know what video or sound to play on button clicked
     */
    private void initialize() {
        //need to implement the List interface
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

    /**
     * mediaSelect will choose what videos and audio's will be played.
     * This will be decided based on the initialized id.
     * @param v is passed in from onclick.
     */
    public void mediaSelect (View v){
        //Audio Content
        //compare the button pressed against each audio button to see which file needs to be played
        for (int i = 0; i < audioButtons.size(); ++i)
            if(v.equals(audioButtons.get(i))) {
                playAudio(audios.get(i));
            }

        //Video Content
        //compare the button pressed against each video button to see which file needs to be played
        for (int i = 0; i < videoButtons.size(); ++i)
            if(v.equals(videoButtons.get(i))) {
                playVideo(identities[i]);
            }
    }
}
