import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class GridGui {
    private Scanner scanner;
    boolean testGameFinish;
    private ArrayList<Item> inventory;
    private Boss ethiron = new Boss("\uD83D\uDC7B","Ethiron - The Eye of Calamity", 3000, 50,1);
    private Boss cthyllus = new Boss("\uD83E\uDD9C","Cthyllus - The Veiled Devourer", 2000, 65,2);
    private Boss daveyJones = new Boss("\uD83D\uDC19","Davey Jones - The Swashbuckling Tempest", 1500, 80,3);
    private Boss matPat =  new Boss("☠\uFE0F","Mathew Patrick - The Game Theorist ", 1000, 105,4);
    private GUI frame;
    private AudioPlayer mainTheme;
    private JFrame field;
    private JLabel player;

    public GridGui() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        field = new JFrame("Sea");
        field.setSize(1000,1000);
        frame = new GUI();
        scanner = new Scanner(System.in);
        createPlayer();
        testGameFinish = false; // BOOLEAN TO SATISFY WHILE LOOP SO WE CAN DECIDE ON THE GAME'S GOAL
        play();
    }

    private void createPlayer() {
        player = new JLabel(new ImageIcon("src/pirate.png"));
        player.setLayout(null);
        player.setBounds(450, 450, 50, 50);
    }

    private void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        AudioPlayer mainTheme = new AudioPlayer("Main Theme Pirates of the Caribbean.wav");
        mainTheme.playSound();
        // PLACE HOLDER CONDITION (maybe, we can just set it to true when goal is met)
        while (!testGameFinish) {
            field.add(frame.getOcean());
            field.setVisible(true);
            field.add(player);
            field.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
                        player.setLocation(player.getX(), player.getY() - 50);
                    }
                    else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
                        player.setLocation(player.getX(), player.getY() + 50);
                    }
                    else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
                        player.setLocation(player.getX() - 50, player.getY());
                    }
                    else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
                        player.setLocation(player.getX() + 50, player.getY());
                    }
                    if (player.getX() <  -50) {
                        player.setLocation(1050, player.getY());
                    }
                    if (player.getX() >  1050) {
                        player.setLocation(-50, player.getY());
                    }
                    if (player.getY() <  -50) {
                        player.setLocation(player.getX(), 1050);
                    }
                    if (player.getY() >  1050) {
                        player.setLocation(player.getX(), -50);
                    }
                }
            });
            Thread.sleep(50);
        }
    }
}
