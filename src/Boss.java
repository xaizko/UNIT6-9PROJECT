import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Boss extends Monster {
    private int type;
    AudioFile audioPlayer;
    public Boss(String symbol, String name, int health, int atk,int type){
        super(symbol,name,health,atk);
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
            audioPlayer = new AudioFile("Undertale - Megalovania.wav");
            audioPlayer.playSound();
        }else if(type == 2){
            audioPlayer = new AudioFile("If You Need The Most Epic Dark Boss Theme, Check This • ＂CTHULHU AWAKENS＂ by Apollon de Moura.wav");
            audioPlayer.playSound();
        } else if (type == 3) {
            audioPlayer = new AudioFile("Norway Theme - Atomic (Civilization 6 OST) ｜ Gjendines Bånlåt.wav");
            audioPlayer.playSound();
        }else if(type == 4){
            audioPlayer = new AudioFile("Science Blaster (Song Remix created by Nirre & Acid Usagi) Game Theory Audio Spectrum Tribute.wav");
            audioPlayer.playSound();
        }else{
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
