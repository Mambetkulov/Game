import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL[] soundUrl = new URL[30];

    public Sound(){
        soundUrl[0] = getClass().getResource("/mus/mash-botoy--komuz.wav");
        soundUrl[1] = getClass().getResource("/mus/mixkit-winning-a-coin-video-game-2069.wav");
        soundUrl[2] = getClass().getResource("/mus/P5 OST 10 Encounter.wav");

    }

    public void setFile(int i){
      try{
          AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl[i]);
          clip = AudioSystem.getClip();
          clip.open(ais);
      }catch (Exception e){
          System.out.println(" ");
      }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
