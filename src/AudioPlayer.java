import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class AudioPlayer {
    public AudioPlayer(File audio) throws UnsupportedAudioFileException,
    IOException, LineUnavailableException
    {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
