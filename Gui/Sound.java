package Gui;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundUrl;

    /**
     * Constructor for the sound class.
     */
    public Sound() {
        soundUrl = getClass().getResource("/resources/music/music.wav");
    }

    /**
     * Sets the file to be used in for the game.
     */
    public void setFile() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function starts the music. 
     */
    public void play() {
        clip.start();
    }

    /**
     * This fucntion loops the song continuously.
     */
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * This function stops the music.
     */
    public void stop() {
        clip.stop();
    }
}