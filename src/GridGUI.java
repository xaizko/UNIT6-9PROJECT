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
    private JPanel shopA;
    private JPanel shopB;
    private JLabel merchant;
    private JTextPane balanceA;
    private JTextPane balanceB;
    private JTextPane welcomeA;
    private JTextPane welcomeB;
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
        shopA = new JPanel();
        shopB = new JPanel();
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
                frame.add(shopA);
                frame.setVisible(true);
            }
            if (player.getX() == skeleton.getX() && player.getY() == skeleton.getY()) {
                fightBoss(ethiron, new JLabel(new ImageIcon("src/ImageSans.png")), Color.BLUE);
            }
            if (player.getX() == octopus.getX() && player.getY() == octopus.getY()) {
                fightBoss(cthyllus, new JLabel(new ImageIcon("src/ImageCthulhu(Cthyllus).png")), Color.WHITE);
            }
            if (player.getX() == ghost.getX() && player.getY() == ghost.getY()) {
                fightBoss(daveyJones, new JLabel(new ImageIcon("src/ImageDaveyJones.png")), Color.MAGENTA);
            }
            if (player.getX() == gameTheory.getX() && player.getY() == gameTheory.getY()) {
                fightBoss(matPat, new JLabel(new ImageIcon("src/ImageMatPat.png")), Color.GREEN);
            }
        }
    }
    private void fightBoss(Boss boss, JLabel img, Color color) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        boss.encounterBoss();
        frame.setVisible(false);
        player.setLocation(450,450);
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
        shopA.setLayout(null);
        shopA.setSize(1000,1000);
        shopA.setBackground(Color.LIGHT_GRAY);

        shopB.setLayout(null);
        shopB.setSize(1000,1000);
        shopB.setBackground(Color.LIGHT_GRAY);

        merchant.setBounds(100,0,500,500);

        welcomeA = new JTextPane();
        welcomeA.setText("Welcome to the Merchant, what weapons would you like to buy");
        welcomeA.setBackground(Color.LIGHT_GRAY);
        welcomeA.setBounds(600,180,300,50);

        balanceA = new JTextPane();
        balanceA.setText("You have " + attributes.getGold() + " Gold");
        balanceA.setBackground(Color.LIGHT_GRAY);
        balanceA.setBounds(600,300,100,50);

        JButton nextPage = new JButton();
        nextPage.setBounds(750,230,150,150);
        nextPage.setText("Next page");
        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                frame.remove(shopA);
                frame.add(shopB);
                frame.setVisible(true);
            }
        });

        JButton ironHook = new JButton();
        ironHook.setBounds(20,400,200,150);
        ironHook.setText("1. Iron Hook: 500 G");
        buttonInitializerShopA(ironHook);

        JButton katana = new JButton();
        katana.setBounds(20, 600, 200, 150);
        katana.setText("2. Katana: 100 G");
        buttonInitializerShopA(katana);

        JButton railBlade = new JButton();
        railBlade.setBounds(240,400,200,150);
        railBlade.setText("3. Railblade: 3000 G");
        buttonInitializerShopA(railBlade);

        JButton cryptBlade = new JButton();
        cryptBlade.setBounds(240,600,200,150);
        cryptBlade.setText("4. Crypt Blade: 10000 G");
        buttonInitializerShopA(cryptBlade);

        JButton shatteredKatana = new JButton();
        shatteredKatana.setBounds(470,400,200,150);
        shatteredKatana.setText("5. Shattered Katana: 500 G");
        buttonInitializerShopA(shatteredKatana);

        JButton bloodtideTrident = new JButton();
        bloodtideTrident.setBounds(470,600,200,150);
        bloodtideTrident.setText("6. Bloodtide Trident: 1000 G");
        buttonInitializerShopA(bloodtideTrident);

        JButton stormsEye = new JButton();
        stormsEye.setBounds(700,400,200,150);
        stormsEye.setText("7. Stormseye: 5000 G");
        buttonInitializerShopA(stormsEye);

        JButton shovel = new JButton();
        shovel.setBounds(700,600,200,150);
        shovel.setText("8. Shovel: 50 G");
        shovel.setText("1. Life Crystal: 50 G");
        buttonInitializerShopA(shovel);

        JButton exitA = new JButton();
        exitA.setBounds(50,50,100,100);
        exitA.setText("Exit Shop");
        exitA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(shopA);
                frame.add(sea);
                frame.setVisible(true);
            }
        });


        welcomeB = new JTextPane();
        welcomeB.setText("What armor shall thy don in battle");
        welcomeB.setBackground(Color.LIGHT_GRAY);
        welcomeB.setBounds(600,80,300,50);

        balanceB = new JTextPane();
        balanceB.setText("You have " + attributes.getGold() + " Gold");
        balanceB.setBackground(Color.LIGHT_GRAY);
        balanceB.setBounds(600,20,100,50);

        JButton prevPage = new JButton();
        prevPage.setBounds(250,30,150,150);
        prevPage.setText("Prev page");
        prevPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                frame.remove(shopB);
                frame.add(shopA);
                frame.setVisible(true);
            }
        });

        JButton lifeCrystal = new JButton();
        lifeCrystal.setBounds(210,250,200,150);
        lifeCrystal.setText("1. Life Crystal: 50 G");
        lifeCrystal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (attributes.getGold() >= 50) {
                    System.out.println("Life Crystal bought, increasing health points");
                    attributes.lifeCrystalUsed();
                    balanceA.setText("You have " + attributes.getGold() + " Gold");
                    balanceB.setText("You have " + attributes.getGold() + " Gold");
                    System.out.println(attributes.toString());
                } else {
                    System.out.println("Insufficient Balance");
                }
            }
        });

        JButton ironArmor = new JButton();
        ironArmor.setBounds(210,410,200,150);
        ironArmor.setText("2. Iron Armor: 500 G");
        buttonInitializerShopB(ironArmor);

        JButton pirateCoat = new JButton();
        pirateCoat.setBounds(210,570,200,150);
        pirateCoat.setText("3. Pirate Coat: 750 G");
        buttonInitializerShopB(pirateCoat);

        JButton sharkSkin = new JButton();
        sharkSkin.setBounds(430,250,200,150);
        sharkSkin.setText("4. Shark Skin: 1500 G");
        buttonInitializerShopB(sharkSkin);

        JButton krakenSkin = new JButton();
        krakenSkin.setBounds(430,410,200,150);
        krakenSkin.setText("5. Kraken Skin: 5000 G");
        buttonInitializerShopB(krakenSkin);

        JButton pirateHat = new JButton();
        pirateHat.setBounds(430,570,200,150);
        pirateHat.setText("6. Pirate Hat: 100 G");
        accessoryButton(pirateHat);

        JButton woodenPeg = new JButton();
        woodenPeg.setBounds(650,250,200,150);
        woodenPeg.setText("7. Wooden Peg: 100 G");
        accessoryButton(woodenPeg);

        JButton parrot = new JButton();
        parrot.setBounds(650,410,200,150);
        parrot.setText("8. Parrot: 500 G");
        accessoryButton(parrot);

        JButton eyePatch = new JButton();
        eyePatch.setBounds(650,570,200,150);
        eyePatch.setText("9. Eye Patch: 100 G");
        accessoryButton(eyePatch);

        JButton exitB = new JButton();
        exitB.setBounds(50,50,100,100);
        exitB.setText("Exit Shop");
        exitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(shopB);
                frame.add(sea);
                frame.setVisible(true);
            }
        });

        shopA.add(merchant);
        shopA.add(balanceA);
        shopA.add(welcomeA);
        shopA.add(ironHook);
        shopA.add(nextPage);
        shopA.add(katana);
        shopA.add(railBlade);
        shopA.add(cryptBlade);
        shopA.add(shatteredKatana);
        shopA.add(bloodtideTrident);
        shopA.add(stormsEye);
        shopA.add(shovel);
        shopA.add(exitA);

        shopB.add(balanceB);
        shopB.add(welcomeB);
        shopB.add(lifeCrystal);
        shopB.add(ironArmor);
        shopB.add(pirateCoat);
        shopB.add(sharkSkin);
        shopB.add(krakenSkin);
        shopB.add(pirateHat);
        shopB.add(woodenPeg);
        shopB.add(parrot);
        shopB.add(eyePatch);
        shopB.add(exitB);
        shopB.add(prevPage);
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

    private void buttonInitializerShopA(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (attributes.buyWeapon(Integer.parseInt(button.getText().substring(0,1)) - 1)) {
                    System.out.println(attributes.toString());
                    button.setVisible(false);
                    shopA.remove(button);
                    balanceA.setText("You have " + attributes.getGold() + " Gold");
                    balanceB.setText("You have " + attributes.getGold() + " Gold");
                    System.out.println(attributes.toString());
                }
            }
        } );
    }
    private void buttonInitializerShopB(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (attributes.buyArmor(Integer.parseInt(button.getText().substring(0,1)) - 1)) {
                    System.out.println(attributes.toString());
                    button.setVisible(false);
                    shopB.remove(button);
                    balanceA.setText("You have " + attributes.getGold() + " Gold");
                    balanceB.setText("You have " + attributes.getGold() + " Gold");
                    System.out.println(attributes.toString());
                }
            }
        } );
    }
    private void accessoryButton(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (attributes.buyAccessory(Integer.parseInt(button.getText().substring(0,1)) - 1)) {
                    System.out.println(attributes.toString());
                    button.setVisible(false);
                    shopB.remove(button);
                    balanceA.setText("You have " + attributes.getGold() + " Gold");
                    balanceB.setText("You have " + attributes.getGold() + " Gold");
                    attributes.toString();
                }
            }
        });
    }
    private static int makeGrid(JPanel gui, int X) {
        JPanel line = new JPanel();
        line.setBackground(Color.LIGHT_GRAY);
        line.setBounds(X, 0, 5, 1000);
        gui.add(line);
        if (X == 1000) {
            return finishGrid(gui, 0);
        } return makeGrid(gui, X + 50);
    }

    private static int finishGrid(JPanel gui, int Y) {
        JPanel line = new JPanel();
        line.setBackground(Color.LIGHT_GRAY);
        line.setBounds(0, Y, 1000, 5);
        gui.add(line);
        if (Y == 1000) {
            return 0;
        } return finishGrid(gui,Y + 50);
    }
}