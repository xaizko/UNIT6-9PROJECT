import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MobEncounters extends Monster {
    AudioFile audioPlayer;
    private static String[] names = new String[]{"Aboleth", "Acolyte", "Alhoon", "Dragon",
            "Wandering Spirit", "Frost Mage", "Shadow Wizard",
            "Gorgon", "Aragog", "The Horde", "Evil Zebra", "The Kraken", "Siren","Mr Krabs in his army days"};

    public MobEncounters(String name, int health, int atk) {
        super("_", name, health, atk);
    }

    public void meetEncounter() throws UnsupportedAudioFileException, LineUnavailableException, IOException { // add music
        System.out.println("You have encountered "+ getName());
        playMusic();

    }
    public static Monster generateMonster(){
        int health = (int) (Math.random() * 100) ;
        int attack = (int) (Math.random() * 20) + 5;
        String name = names[(int) (Math.random() * names.length-1)];
        return new Monster("_",name, health,attack);
    }
    public void playMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        audioPlayer = new AudioFile("MobTheme.wav");
        audioPlayer.playSound();
    }

    public void pause() {
        if(audioPlayer != null) {
            audioPlayer.stop();
        }
    }
}
