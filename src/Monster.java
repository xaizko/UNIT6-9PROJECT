import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Monster extends Space {
    AudioFile audioPlayer;
    private String name;
    private int health;
    private int atk;
    private boolean dead;

    public Monster(String symbol, String name, int health, int atk) {
        super(symbol);
        this.name = name;
        this.health = health;
        this.atk = atk;
        dead = false;
    }
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAtk()
    {
        return atk;
    }

    public int attack() {
        double damage = atk;
        damage *= (Math.random() + 0.2);
        return (int) damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
    public boolean isDead(){
        if(health <= 0){
            dead = true;
        }
        return dead;
    }
    public void playMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        audioPlayer = new AudioFile("MobTheme.wav");
        audioPlayer.playSound();
    }
}
