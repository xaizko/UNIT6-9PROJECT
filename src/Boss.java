import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Boss extends Monster {
    private int type;
    AudioPlayer audioPlayer;
    public Boss(String symbol, String name, int health, int atk,int type){
        super(symbol,name,health,atk);
        this.type = type;
    }
    public void meetEncounter() {
        System.out.println("You have encountered "  + getName());
    }
    public void playMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(type == 1){
            audioPlayer = new AudioPlayer("scion of ethiron theme extended (old).wav");
            audioPlayer.playSound();
        }else if(type == 2){
            audioPlayer = new AudioPlayer("If You Need The Most Epic Dark Boss Theme, Check This • ＂CTHULHU AWAKENS＂ by Apollon de Moura.wav");
            audioPlayer.playSound();
        } else if (type == 3) {
            audioPlayer = new AudioPlayer("Norway Theme - Atomic (Civilization 6 OST) ｜ Gjendines Bånlåt.wav");
            audioPlayer.playSound();
        }else if(type == 4){
            audioPlayer = new AudioPlayer("Science Blaster (Song Remix created by Nirre & Acid Usagi) Game Theory Audio Spectrum Tribute.wav");
            audioPlayer.playSound();
        }else{
            audioPlayer = new AudioPlayer("Two Steps from Hell - Heart of Courage.wav");
        }
    }
}
