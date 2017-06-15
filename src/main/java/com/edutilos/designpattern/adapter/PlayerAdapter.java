package com.edutilos.designpattern.adapter;

/**
 * Created by edutilos on 15.06.17.
 */
public class PlayerAdapter implements  Player{
   private AudioPlayer audioPlayer;
   private VideoPlayer videoPlayer;

    public PlayerAdapter(AudioPlayer audioPlayer, VideoPlayer videoPlayer) {
        this.audioPlayer = audioPlayer;
        this.videoPlayer = videoPlayer;
    }


    @Override
    public void play(String fileName, String fileExt) {
        if(isAudioFile(fileExt)) audioPlayer.playAudio(fileName);
        else if(isVideoFile(fileExt)) videoPlayer.playVideo(fileName);
        else System.err.println(String.format("Could not play %s", fileName));
    }


    private boolean isAudioFile(String fileExt) {
      if(fileExt.equalsIgnoreCase("mp3") ||
              fileExt.equalsIgnoreCase("wav") ||
              fileExt.equalsIgnoreCase("ogg"))
          return true ;

      return false ;
    }

    private boolean isVideoFile(String fileExt) {
      if(fileExt.equalsIgnoreCase("mp4") ||
              fileExt.equalsIgnoreCase("ogv") ||
              fileExt.equalsIgnoreCase("flv"))
          return true;
      return false;
    }
}
