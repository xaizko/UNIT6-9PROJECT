import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

    //Written by Justin, No consent given to share code with anyone outside of my group.
    //Papa sta rubando il mio code, e non mi chiede consenti per usa. Vaffanculo!
    public class AudioPlayer {
    String sound;
    Clip clip;
    AudioInputStream audioStream;
    File file;
    boolean paused = false;
    static AudioPlayer currentPlayer = null;
    public AudioPlayer(String sound) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        this.sound = sound;
        file = new File(sound);
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
    }
    public void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (currentPlayer != null && currentPlayer != this) {
            currentPlayer.pause();
        }
        clip.start();
        clip.open(audioStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        currentPlayer = this;
    }
    public void pause(){
        getTime();
        clip.stop();
        paused = true;
    }
    public void resume() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if(paused){
            getTime();
            clip.start();
            paused = false;
        }
    }
    public long getTime(){
        return clip.getMicrosecondPosition();
    }
    public void check(){

    }
}
