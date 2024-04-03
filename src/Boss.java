import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Boss extends MobEncounters {
    private int type;
    AudioPlayer audioPlayer;
    String symbol;
    public Boss(String symbol, String name, int health, int atk,int type){
        super(name,health,atk);
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public void meetEncounter() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("You have encountered "  + getName());
        while(getHealth() > 0){
            playMusic();
        }


    }
    public void playMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(type == 1){
            audioPlayer = new AudioPlayer("Undertale - Megalovania.wav");
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
