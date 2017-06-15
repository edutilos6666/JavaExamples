package com.edutilos.designpattern.adapter;

/**
 * Created by edutilos on 15.06.17.
 */
public class DefaultAudioPlayer implements AudioPlayer {
    @Override
    public void playAudio(String fileName) {
        System.out.println(String.format("Audio Playing: %s", fileName));
    }
}
