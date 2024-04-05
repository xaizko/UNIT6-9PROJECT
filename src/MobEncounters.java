import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MobEncounters extends Monster {
    private String[] names;

    public MobEncounters(String name, int health, int atk) {
        super("_", name, health, atk);
        names = new String[]{"Aboleth", "Acolyte", "Alhoon", "Dragon",
                "Wandering Spirit", "Frost Mage", "Shadow Wizard",
        "Gorgon", "Aragog", "The Horde", "Evil Zebra", "The Kraken", "Siren","Mr Krabs in his army days"};

    }

    public void meetEncounter() throws UnsupportedAudioFileException, LineUnavailableException, IOException { // add music
        System.out.println("You have encountered "+ getName());
    }
    public Monster generateMonster(){
        int health = (int) (Math.random() * 100) ;
        int attack = (int) (Math.random() * 20) + 5;
        String name = names[(int) (Math.random() * names.length-1)];
        return new Monster("_",name, health,attack);
    }

}
