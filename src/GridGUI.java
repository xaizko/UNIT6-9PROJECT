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
    private JLabel merchant;
    private JFrame frame;
    private JPanel mobFight;
    private JPanel bossFight;
    private JPanel sea;
    private JPanel shop;
    private ArrayList<Item> inventory;
    private Player attributes;
    private AudioPlayer mainTheme = new AudioPlayer("Main Theme Pirates of the Caribbean.wav");
    private final Boss ethiron = new Boss("\uD83D\uDC7B","Ethiron - The Eye of Calamity", 3000, 50,1);
    private final Boss cthyllus = new Boss("\uD83E\uDD9C","Cthyllus - The Veiled Devourer", 2000, 65,2);
    private final Boss daveyJones = new Boss("\uD83D\uDC19","Davey Jones - The Swashbuckling Tempest", 1500, 80,3);
    private final Boss matPat =  new Boss("☠\uFE0F","Mathew Patrick - The Game Theorist ", 1000, 105,4);
    private boolean gameOver;
    public GridGUI() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        player = new JLabel(new ImageIcon("src/ImagePirate.png"));
        coin = new JLabel(new ImageIcon("src/ImageShop.png"));
        merchant = new JLabel(new ImageIcon("src/ImageMerchant.png"));
        frame = new JFrame("Pirate Cove");
        mobFight = new JPanel();
        bossFight = new JPanel();
        sea = new JPanel();
        shop = new JPanel();
        attributes = new Player("Traveler");
        gameOver = false;
        play();
    }

    private void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
//        AudioPlayer mainTheme = new AudioPlayer("Main Theme Pirates of the Caribbean.wav");
//        mainTheme.playSound();
        listenerInitializer();
        initializeShop();
        initializeSea();

        frame.setSize(1000,1000);
        frame.add(sea);
        frame.setVisible(true);

        mainTheme.playSound();
        while (!gameOver) {
            Thread.sleep(0);
            if (player.getX() == coin.getX() && player.getY() == coin.getY()) {
                player.setLocation(450,450);
                frame.setVisible(false);
                frame.remove(sea);
                buyGear();
                frame.remove(shop);
                frame.add(sea);
            }
        }
    }

    private void initializeSea() {
        shop.setLayout(null);
        shop.setSize(1000,1000);
        shop.setBackground(Color.LIGHT_GRAY);

        merchant.setBounds(100,0,500,500);

        shop.add(merchant);

        sea.setLayout(null);
        sea.setSize(1000,1000);
        sea.setBackground(Color.CYAN);

        player.setBounds(450,450,50,50);

        coin.setBounds(500,500,50,50);

        makeGrid(sea, 0);
        sea.add(player);
        sea.add(coin);
    }

    private void initializeShop() {
        JTextField welcome = new JTextField();
        welcome.setText("Welcome to the Merchant, what would you like to buy");
        welcome.setBackground(Color.LIGHT_GRAY);
        welcome.setBounds(600,200,300,50);

        JTextField balance = new JTextField();
        balance.setText("You have " + attributes.getGold() + " Gold");
        balance.setBackground(Color.LIGHT_GRAY);
        balance.setBounds(600,300,100,50);

        JButton lifeCrystal = new JButton();
        lifeCrystal.setBounds(20,400,150,150);
        lifeCrystal.setText("1. Life Crystal: 50 G");
        buttonInitializer(lifeCrystal);

        JButton katana = new JButton();
        katana.setBounds(20, 600, 150, 150);
        katana.setText("2. Katana: 100 G");
        buttonInitializer(katana);

        JButton railBlade = new JButton();
        railBlade.setBounds(200,400,150,150);
        railBlade.setText("3. Railblade: 3000 G");
        buttonInitializer(railBlade);

        JButton cryptBlade = new JButton();
        cryptBlade.setBounds(200,600,200,150);
        cryptBlade.setText("4. Crypt Blade: 10000 G");
        buttonInitializer(cryptBlade);

        JButton shatteredKatana = new JButton();
        shatteredKatana.setBounds(380,400,200,150);
        shatteredKatana.setText("5. Shattered Katana: 500 G");
        buttonInitializer(shatteredKatana);

        JButton bloodtideTrident = new JButton();
        bloodtideTrident.setBounds(420,600,200,150);
        bloodtideTrident.setText("6. Bloodtide Trident: 1000 G");
        buttonInitializer(bloodtideTrident);

        JButton stormsEye = new JButton();
        stormsEye.setBounds(610,400,200,150);
        stormsEye.setText("7. Stormseye: 5000 G");
        buttonInitializer(stormsEye);

        JButton shovel = new JButton();
        shovel.setBounds(650,600,150,150);
        shovel.setText("8. Shovel: 50 G");
        buttonInitializer(shovel);

        shop.add(balance);
        shop.add(welcome);
        shop.add(lifeCrystal);
        shop.add(katana);
        shop.add(railBlade);
        shop.add(cryptBlade);
        shop.add(shatteredKatana);
        shop.add(bloodtideTrident);
        shop.add(stormsEye);
        shop.add(shovel);
    }
    private void buyGear() {
        boolean browsing = true;
        frame.add(shop);
        frame.setVisible(true);
        while (browsing) {

        }
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

    private void buttonInitializer(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        } );
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