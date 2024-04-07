import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Boss extends Monster {
    private int type;
    AudioFile audioPlayer;
    public Boss(String name, int health, int atk,int type){
        super(name,health,atk);
        this.type = type;
    }
    public void encounterBoss() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("You have encountered "  + getName());
        playMusic();
        if(isDead()){
            pause();
        }
    }
    public void playMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(type == 1){
            audioPlayer = new AudioFile("ethiron'sCalling.wav");
            audioPlayer.playSound();
        }else if(type == 2){
            audioPlayer = new AudioFile("cthyllusAwakens.wav");
            audioPlayer.playSound();
        } else if (type == 3) {
            audioPlayer = new AudioFile("daveyJonesLocker.wav");
            audioPlayer.playSound();
        }else if(type == 4){
            audioPlayer = new AudioFile("matPat'sConcierto.wav");
            audioPlayer.playSound();
        }else {
            audioPlayer = new AudioFile("Two Steps from Hell - Heart of Courage.wav");
        }
    }
    public void pause() {
        if(audioPlayer != null) {
            audioPlayer.stop();
        }
    }
    public int getType(){
        return type;
    }
}
