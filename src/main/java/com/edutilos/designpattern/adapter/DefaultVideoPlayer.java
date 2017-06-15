package com.edutilos.designpattern.adapter;

/**
 * Created by edutilos on 15.06.17.
 */
public class DefaultVideoPlayer implements  VideoPlayer {
    @Override
    public void playVideo(String fileExt) {
        System.out.println(String.format("Video playing: %s", fileExt));
    }
}
