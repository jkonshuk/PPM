package com.practice.jacob.ppm;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test //Ryan Satre
    public void isImageThere() throws Exception
    {
        File file = new File("D:\\AndroidApps\\PPM\\app\\src\\main\\res\\drawable\\audio.png");
        assert(file.exists());
    }
    //Jacob Konshuk
    @Test
    public void bothPlaying() throws Exception {
        assert (!isStopped && !videoStop);
    }

    @Test //Ryan Satre
    public void doesPlayButton() throws Exception
    {
        assert(audio.isPlaying() && !isStopped);
    /*
    * Jakob Mueller's test code
    */
    @Test
    public void audioFile() throws Exception {
        assert(new File("C:\\Users\\Jakob\\AndroidStudioProjects\\PPM\\app\\src\\main\\res\\raw\\uchtdorf.mp3").isFile());
    }

    /*
     * Jakob Mueller
     */
    @Test
    public void audioRunning() throws Exception {
        assert (audio.isPlaying() && !isStopped);
    }
}