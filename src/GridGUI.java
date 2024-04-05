import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
public class GridGUI {
    private JLabel player;
    private JLabel coin;
    private JFrame frame;
    private JPanel mobFight;
    private JPanel bossFight;
    private JPanel sea;
    private JPanel shop;
    private JButton button;
    private ArrayList<Item> inventory;
    private AudioPlayer mainTheme = new AudioPlayer("Main Theme Pirates of the Caribbean.wav");
    private final Boss ethiron = new Boss("\uD83D\uDC7B","Ethiron - The Eye of Calamity", 3000, 50,1);
    private final Boss cthyllus = new Boss("\uD83E\uDD9C","Cthyllus - The Veiled Devourer", 2000, 65,2);
    private final Boss daveyJones = new Boss("\uD83D\uDC19","Davey Jones - The Swashbuckling Tempest", 1500, 80,3);
    private final Boss matPat =  new Boss("☠\uFE0F","Mathew Patrick - The Game Theorist ", 1000, 105,4);
    private boolean gameOver;
    public GridGUI() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        player = new JLabel(new ImageIcon("src/pirate.png"));
        coin = new JLabel(new ImageIcon("src/Shop.png"));
        frame = new JFrame("Pirate Cove");
        mobFight = new JPanel();
        bossFight = new JPanel();
        sea = new JPanel();
        shop = new JPanel();
        button = new JButton();
        gameOver = false;
        play();
    }

    private void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
//        AudioPlayer mainTheme = new AudioPlayer("Main Theme Pirates of the Caribbean.wav");
//        mainTheme.playSound();
        listenerInitializer();
        sea.setLayout(null);
        sea.setSize(1000,1000);
        sea.setBackground(Color.CYAN);

        shop.setSize(1000,1000);
        shop.setBackground(Color.GREEN);

        player.setBounds(450,450,50,50);

        coin.setBounds(500,500,50,50);

        makeGrid(sea, 0);
        sea.add(player);
        sea.add(coin);

        frame.setSize(1000,1000);
        frame.add(sea);
        frame.setVisible(true);
        int x = 0;
        mainTheme.playSound();
        while (true) {
            Thread.sleep(0);
            if (player.getX() == coin.getX() && player.getY() == coin.getY()) {
                buyGear();
            }
        }
    }

    private void buyGear() {
        frame.remove(sea);
        frame.add(shop);
    }

    private void listenerInitializer() {
        frame.addKeyListener(new KeyAdapter() {
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
