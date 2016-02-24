package com.practice.jacob.ppm;

import android.media.MediaPlayer;

import org.junit.Test;

import java.io.File;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest extends VideoSelect {

    //Jacob Konshuk
    @Test
    public void videoFileExists() throws Exception {
        File file = new File("C:\\Users\\taser_000\\AndroidStudioProjects\\PPM\\app\\src\\main\\res\\raw\\patternsoflight.mp4");
        assert (file.exists());
    }

    //Jacob Konshuk
    @Test
    public void bothPlaying() throws Exception {
        assert (!isStopped && !videoStop);
    }

    /*
    * Jakob Mueller's test code
    */
    @Test
    public void audioFile() throws Exception {
        assert (new File("C:\\Users\\taser_000\\AndroidStudioProjects\\PPM\\app\\src\\main\\res\\raw\\uchtdorf.mp3").isFile());
    }

    /*
     * Jakob Mueller
     */
    @Test
    public void audioRunning() throws Exception {
        assert (audio.isPlaying() && !isStopped);
    }
}