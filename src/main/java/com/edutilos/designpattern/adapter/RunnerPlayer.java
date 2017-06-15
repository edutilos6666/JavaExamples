package com.edutilos.designpattern.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by edutilos on 15.06.17.
 */
public class RunnerPlayer {
    public static void main(String[] args) {
        Player player = new PlayerAdapter(new DefaultAudioPlayer(),
                new DefaultVideoPlayer());
        Map<String, String> files = new HashMap<>();
        files.put("foo.mp3", "mp3");
        files.put("bar.wav", "wav");
        files.put("bim.ogg", "ogg");

        files.put("edu.mp4", "mp4");
        files.put("tilos.ogv", "ogv");
        files.put("pako.flv", "flv");

        files.put("deko.jpg", "jpg");
        files.forEach((k, v)-> {
            player.play(k,v);
        });
    }
}
