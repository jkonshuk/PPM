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

    @Test //Ryan Satre
    public void doesPlayButton() throws Exception
    {
        assert(VideoSelect.getAudio().isPlaying());
    }
}