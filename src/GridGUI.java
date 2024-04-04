import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GridGUI {
    private JLabel player;
    private JFrame frame;
    private JPanel sea;
    boolean testGameFinish;
    private ArrayList<Item> inventory;
    private Boss ethiron = new Boss("\uD83D\uDC7B","Ethiron - The Eye of Calamity", 3000, 50,1);
    private Boss cthyllus = new Boss("\uD83E\uDD9C","Cthyllus - The Veiled Devourer", 2000, 65,2);
    private Boss daveyJones = new Boss("\uD83D\uDC19","Davey Jones - The Swashbuckling Tempest", 1500, 80,3);
    private Boss matPat =  new Boss("☠\uFE0F","Mathew Patrick - The Game Theorist ", 1000, 105,4);
    public GridGUI() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        frame = new JFrame("Pirate Cove");
        frame.setSize(1000,1000);
        sea = new JPanel();
        sea.setLayout(null);
        sea.setSize(1000,1000);
        sea.setBackground(Color.CYAN);
        player = new JLabel(new ImageIcon("src/pirate.png"));
        player.setBounds(450,450,50,50);
        makeGrid(sea, 0);
        sea.add(player);
        frame.add(sea);
        frame.setVisible(true);
        testGameFinish = false; // BOOLEAN TO SATISFY WHILE LOOP SO WE CAN DECIDE ON THE GAME'S GOAL
        play();
    }

    private void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int currentRow = 10;
        int currentCol = 10;
        AudioPlayer mainTheme = new AudioPlayer("Main Theme Pirates of the Caribbean.wav");
        mainTheme.playSound();
        // PLACE HOLDER CONDITION (maybe, we can just set it to true when goal is met)
        while (!testGameFinish) {

        }
    }

    public static int makeGrid(JPanel gui, int X) {
        JPanel line = new JPanel();
        line.setBackground(Color.LIGHT_GRAY);
        line.setBounds(X, 0, 5, 1000);
        gui.add(line);
        if (X == 1000) {
            return finishGrid(gui, 0);
        } return makeGrid(gui, X + 50);
    }

    public static int finishGrid(JPanel gui, int Y) {
        JPanel line = new JPanel();
        line.setBackground(Color.LIGHT_GRAY);
        line.setBounds(0, Y, 1000, 5);
        gui.add(line);
        if (Y == 1000) {
            return 0;
        } return finishGrid(gui,Y + 50);
    }
}
