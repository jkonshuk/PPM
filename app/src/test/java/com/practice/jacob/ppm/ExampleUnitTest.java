package com.practice.jacob.ppm;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest extends VideoSelect{

    @Test
    public void videoPlaying () throws Exception {

    }

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
        assert(audio.isPlaying() && isStopped);
    }
}