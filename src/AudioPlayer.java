import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class AudioPlayer {
    String sound;
    public AudioPlayer(String sound) {
        this.sound = sound;
    }
    public void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File file = new File(sound);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void pause(){
        System.out.println("");
    }
}
