import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
public class GridGUI {
    // frame
    private JFrame frame;
    // sea and attributes
    private JPanel sea;
    private JLabel player;
    private JLabel coin;
    private JLabel skeleton;
    private JLabel octopus;
    private JLabel ghost;
    private JLabel gameTheory;
    // mob fight
    private JPanel mobFight;
    // boss fight and attributes
    private JPanel bossFight;
    // shop and attributes
    private JPanel shop;
    private JLabel merchant;
    private JTextPane balance;
    private JTextPane welcome;
    private ArrayList<Item> inventory;
    private Player attributes;
    private AudioFile mainTheme = new AudioFile("Main Theme Pirates of the Caribbean.wav");
    private final Boss ethiron = new Boss("\uD83D\uDC7B","Ethiron - The Eye of Calamity", 3000, 50,1);
    private final Boss cthyllus = new Boss("\uD83E\uDD9C","Cthyllus - The Veiled Devourer", 2000, 65,2);
    private final Boss daveyJones = new Boss("\uD83D\uDC19","Davey Jones - The Swashbuckling Tempest", 1500, 80,3);
    private final Boss matPat =  new Boss("☠\uFE0F","Mathew Patrick - The Game Theorist ", 1000, 105,4);
    private boolean gameOver;
    public GridGUI() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        player = new JLabel(new ImageIcon("src/ImagePirate.png"));
        coin = new JLabel(new ImageIcon("src/ImageShop.png"));
        merchant = new JLabel(new ImageIcon("src/ImageMerchant.png"));
        skeleton = new JLabel(new ImageIcon("src/ImageSkeleton.png"));
        octopus = new JLabel();
        ghost = new JLabel();
        gameTheory = new JLabel();
        frame = new JFrame("Pirate Cove");
        mobFight = new JPanel();
        sea = new JPanel();
        shop = new JPanel();
        attributes = new Player("Traveler");
        gameOver = false;
        listenerInitializer();
        initializeShop();
        initializeSea();
        frame.setSize(1000,1000);
        play();
    }
    private void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
//        AudioPlayer mainTheme = new AudioPlayer("Main Theme Pirates of the Caribbean.wav");
//        mainTheme.playSound();
        frame.add(sea);
        frame.setVisible(true);
        while (!gameOver) {
            Thread.sleep(0);
            if (player.getX() == coin.getX() && player.getY() == coin.getY()) {
                player.setLocation(450,450);
                frame.setVisible(false);
                frame.remove(sea);
                frame.add(shop);
                frame.setVisible(true);
            }
            if (player.getX() == skeleton.getX() && player.getY() == skeleton.getY()) {
                player.setLocation(450,450);
                fightBoss(ethiron, new JLabel(new ImageIcon("src/ImageSans.png")), Color.BLUE);
            }
            if (player.getX() == octopus.getX() && player.getY() == octopus.getY()) {
                player.setLocation(450,450);
                fightBoss(cthyllus, new JLabel(new ImageIcon("src/ImageCthulhu(Cthyllus).png")), Color.WHITE);
            }
            if (player.getX() == ghost.getX() && player.getY() == ghost.getY()) {
                player.setLocation(450,450);
                fightBoss(daveyJones, new JLabel(new ImageIcon("src/ImageDaveyJones.png")), Color.MAGENTA);
            }
            if (player.getX() == gameTheory.getX() && player.getY() == gameTheory.getY()) {
                player.setLocation(450,450);
                fightBoss(matPat, new JLabel(new ImageIcon("src/ImageMatPat.png")), Color.GREEN);
            }
        }
    }
    private void fightBoss(Boss boss, JLabel img, Color color) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        boss.encounterBoss();
        frame.setVisible(false);
        frame.remove(sea);
        bossFight = new JPanel();
        bossFight.setBackground(color);
        bossFight.setSize(1000,1000);
        bossFight.add(img);
        frame.add(bossFight);
        frame.setVisible(true);
    }

    private void initializeSea() {
        sea.setLayout(null);
        sea.setSize(1000,1000);
        sea.setBackground(Color.CYAN);

        player.setBounds(450,450,50,50);

        coin.setBounds(500,500,50,50);

        skeleton.setBounds(450,0,50,50);

        makeGrid(sea, 0);

        sea.add(player);
        sea.add(coin);
        sea.add(skeleton);
    }

    private void initializeShop() {
        shop.setLayout(null);
        shop.setSize(1000,1000);
        shop.setBackground(Color.LIGHT_GRAY);

        merchant.setBounds(100,0,500,500);

        welcome = new JTextPane();
        welcome.setText("Welcome to the Merchant, what would you like to buy");
        welcome.setBackground(Color.LIGHT_GRAY);
        welcome.setBounds(600,200,300,50);

        balance = new JTextPane();
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

        JButton exit = new JButton();
        exit.setBounds(50,50,100,100);
        exit.setText("Exit Shop");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(shop);
                frame.add(sea);
                frame.setVisible(true);
            }
        } );
        shop.add(merchant);
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
        shop.add(exit);
    }
    private void listenerInitializer() {
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
                        player.setLocation(player.getX(), player.getY() - 50);
                    } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
                        player.setLocation(player.getX(), player.getY() + 50);
                    } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
                        player.setLocation(player.getX() - 50, player.getY());
                    } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
                        player.setLocation(player.getX() + 50, player.getY());
                    } else if (keyCode == KeyEvent.VK_I) {
                        System.out.println(attributes.toString());
                    }
                    if (player.getX() < 0) {
                        player.setLocation(950, player.getY());
                    }
                    if (player.getX() > 950) {
                        player.setLocation(0, player.getY());
                    }
                    if (player.getY() < 0) {
                        player.setLocation(player.getX(), 950);
                    }
                    if (player.getY() > 950) {
                        player.setLocation(player.getX(), 0);
                    }
                }
        });
    }

    private void buttonInitializer(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(attributes.buy(Integer.parseInt(button.getText().substring(0,1)) - 1)) {
                    System.out.println(attributes.toString());
                    button.setVisible(false);
                    shop.remove(button);
                    balance.setText("You have " + attributes.getGold() + " Gold");
                }
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