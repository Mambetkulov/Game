import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundUrl[] = new URL[30];

    public Sound(){
        soundUrl[0] = getClass().getResource("/musres/Playboi Carti - CANCUN [SEGA GENESIS].wav");

    }

    public void setFile(int i){
      try{
          AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl[i]);
          clip = AudioSystem.getClip();
          clip.open(ais);
      }catch (Exception e){

      }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
