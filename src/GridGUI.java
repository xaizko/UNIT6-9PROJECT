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
    private JLabel captain1;
    private JLabel captain2;
    private JLabel captain3;
    private JLabel captain4;
    private JLabel captain5;
    private JLabel captain6;
    private JLabel captain7;
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
    private Player attributes;
    private AudioFile mainTheme;
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
        octopus = new JLabel(new ImageIcon("src/ImageOctopus.png"));
        ghost = new JLabel(new ImageIcon("src/ImageGhost.png"));
        gameTheory = new JLabel(new ImageIcon("src/ImageGameTheory.png"));
        captain1 = new JLabel(new ImageIcon("src/ImageMobMap.png"));
        captain2 = new JLabel(new ImageIcon("src/ImageMobMap.png"));
        captain3 = new JLabel(new ImageIcon("src/ImageMobMap.png"));
        captain4 = new JLabel(new ImageIcon("src/ImageMobMap.png"));
        captain5 = new JLabel(new ImageIcon("src/ImageMobMap.png"));
        captain6 = new JLabel(new ImageIcon("src/ImageMobMap.png"));
        captain7 = new JLabel(new ImageIcon("src/ImageMobMap.png"));
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
        mainTheme = new AudioFile("mainTheme.wav");
        mainTheme.playSound();
        frame.add(sea);
        frame.setVisible(true);
        while (!gameOver) {
            Thread.sleep(0);
            if (attributes.finalBoss()) {
                System.exit(0);
            }
            if (player.getX() == captain1.getX() && player.getY() == captain1.getY()) {
                fightMob();
            }
            if (player.getX() == captain2.getX() && player.getY() == captain2.getY()) {
                fightMob();
            }
            if (player.getX() == captain3.getX() && player.getY() == captain3.getY()) {
                fightMob();
            }
            if (player.getX() == captain4.getX() && player.getY() == captain4.getY()) {
                fightMob();
            }
            if (player.getX() == captain5.getX() && player.getY() == captain5.getY()) {
                fightMob();
            }
            if (player.getX() == captain6.getX() && player.getY() == captain6.getY()) {
                fightMob();
            }
            if (player.getX() == captain7.getX() && player.getY() == captain7.getY()) {
                fightMob();
            }

            if (player.getX() == coin.getX() && player.getY() == coin.getY()) {
                mainTheme.pause();
                mainTheme = new AudioFile("shopkeeper'sTangle.wav");
                mainTheme.playSound();
                balanceA.setText("You have " + attributes.getGold() + " Gold");
                balanceB.setText("You have " + attributes.getGold() + " Gold");
                player.setLocation(450,450);
                frame.setVisible(false);
                frame.remove(sea);
                frame.remove(mobFight);
                frame.add(shopA);
                frame.setVisible(true);
            }
            if (!attributes.getEthiornDefeated() && player.getX() == skeleton.getX() && player.getY() == skeleton.getY()) {
                mainTheme.pause();
                fightBoss(ethiron, new JLabel(new ImageIcon("src/ImageEthiron.png")), Color.BLUE);
            }
            if (!attributes.getCthyllusDefeated() && player.getX() == octopus.getX() && player.getY() == octopus.getY()) {
                mainTheme.pause();
                fightBoss(cthyllus, new JLabel(new ImageIcon("src/ImageCthulhu(Cthyllus).png")), Color.DARK_GRAY);
            }
            if (!attributes.getDaveyDefeated() && player.getX() == ghost.getX() && player.getY() == ghost.getY()) {
                mainTheme.pause();
                fightBoss(daveyJones, new JLabel(new ImageIcon("src/ImageDaveyJones.png")), Color.MAGENTA);
            }
            if (!attributes.getMatPatDefeated() && player.getX() == gameTheory.getX() && player.getY() == gameTheory.getY()) {
                mainTheme.pause();
                fightBoss(matPat, new JLabel(new ImageIcon("src/ImageMatPat.png")), Color.GREEN);
            }
        }
    }
    private void fightMob() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Monster monster = new Monster("_", "Pirate Captain",500, 25);        mainTheme = new AudioFile("mainTheme.wav");
        mainTheme.playSound();
        frame.setVisible(false);
        player.setLocation(450,450);
        frame.remove(sea);
        mobFight = new JPanel();
        mobFight.setLayout(null);
        mobFight.setBackground(Color.WHITE);
        mobFight.setSize(1000,1000);
        mobFight.setBackground(Color.YELLOW);

        JLabel mob = new JLabel(new ImageIcon("src/ImageMob.png"));
        mob.setBounds(500,200,600,400);
        mobFight.add(mob);

        JTextPane playerHealth = new JTextPane();
        playerHealth.setText("Health Remaining: " + attributes.getHealth());
        playerHealth.setBounds(50,450,150,20);
        playerHealth.setBackground(Color.LIGHT_GRAY);

        JTextPane bossHealth = new JTextPane();
        bossHealth.setText("Health Remaining " +  monster.getHealth());
        bossHealth.setBounds(700,700,150,20);
        bossHealth.setBackground(Color.LIGHT_GRAY);

        JButton atk = new JButton();
        atk.setBounds(100,100,200,200);
        atk.setText("Attack");
        atk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int damageDone = attributes.attack();
                int damageTaken = monster.attack();
                monster.takeDamage(damageDone);
                System.out.println(monster.getName() + " has taken " + damageDone + " points of damage");
                System.out.println("You have taken " + damageTaken + " points of damage\n");
                if (attributes.getHealth() <= 0) {
                    playerHealth.setText("Health Remaining: " + 0);
                    System.out.println("YOU LOSE");
                    System.out.println("You don't belong in the domain of the gods");
                    System.exit(0);
                } else {
                    playerHealth.setText("Health Remaining: " + attributes.getHealth());
                }
                if (monster.getHealth() <= 0) {
                    bossHealth.setText("Health Remaining: " + 0);
                    System.out.println("YOU WIN, " + monster.getName() + " is defeated");
                    int gold = (int) (Math.random() * 401) + 100;
                    System.out.println("You are given " + gold + " gold");
                    attributes.setGold(gold);
                    mainTheme.pause();
                    try {
                        mainTheme = new AudioFile("mainTheme.wav");
                        mainTheme.playSound();
                    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    attributes.setHealth();
                    frame.setVisible(false);
                    frame.remove(mobFight);
                    frame.add(sea);
                    frame.setVisible(true);
                } else {
                    attributes.takeDamage(damageTaken);
                    playerHealth.setText("Health Remaining: " + attributes.getHealth());
                    bossHealth.setText("Health Remaining: " + monster.getHealth());
                }
            }
        });

        JButton heal = new JButton();
        heal.setBounds(250,350,200,200);
        heal.setText("Use Heal Pot");
        heal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("You drink a potion and gain " + attributes.usePotion() + " health");
                int damageTaken = monster.attack();
                attributes.takeDamage(damageTaken);
                System.out.println("You have taken " + damageTaken + " points of damage");
                if (attributes.getHealth() <= 0) {
                    playerHealth.setText("Health Remaining: " + 0);
                    System.out.println("YOU LOSE");
                    System.out.println("You don't belong in the domain of the gods");
                    System.exit(0);
                } else {
                    playerHealth.setText("Health Remaining: " + attributes.getHealth());
                }
            }
        });

        JButton run = new JButton();
        run.setBounds(100,600,200,200);
        run.setText("Run");
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainTheme.pause();
                try {
                    mainTheme = new AudioFile("mainTheme.wav");
                    mainTheme.playSound();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                    throw new RuntimeException(e);
                }
                player.setLocation(450,450);
                frame.setVisible(false);
                frame.remove(mobFight);
                frame.add(sea);
                frame.setVisible(true);
            }
        });

        mobFight.add(atk);
        mobFight.add(heal);
        mobFight.add(run);
        mobFight.add(bossHealth);
        mobFight.add(playerHealth);

        frame.add(mobFight);
        frame.setVisible(true);
    }
    private void fightBoss(Boss boss, JLabel img, Color color) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        boss.encounterBoss();
        frame.remove(mobFight);
        frame.setVisible(false);
        player.setLocation(450,450);
        frame.remove(sea);
        bossFight = new JPanel();
        bossFight.setLayout(null);
        bossFight.setBackground(color);
        bossFight.setSize(1000,1000);

        img.setBounds(500,200,600,400);
        bossFight.add(img);

        JTextPane playerHealth = new JTextPane();
        playerHealth.setText("Health Remaining: " + attributes.getHealth());
        playerHealth.setBounds(50,450,150,20);
        playerHealth.setBackground(Color.LIGHT_GRAY);

        JTextPane bossHealth = new JTextPane();
        bossHealth.setText("Health Remaining " + boss.getHealth());
        bossHealth.setBounds(700,700,150,20);
        bossHealth.setBackground(Color.LIGHT_GRAY);

        JButton atk = new JButton();
        atk.setBounds(100,100,200,200);
        atk.setText("Attack");
        atk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int damageDone = attributes.attack();
                int damageTaken = boss.attack();
                boss.takeDamage(damageDone);
                System.out.println(boss.getName() + " has taken " + damageDone + " points of damage");
                System.out.println("You have taken " + damageTaken + " points of damage\n");
                if (attributes.getHealth() <= 0) {
                    playerHealth.setText("Health Remaining: " + 0);
                    System.out.println("YOU LOSE");
                    System.out.println("You don't belong in the domain of the gods");
                    System.exit(0);
                } else {
                    playerHealth.setText("Health Remaining: " + attributes.getHealth());
                }
                if (boss.getHealth() <= 0) {
                    bossHealth.setText("Health Remaining: " + 0);
                    System.out.println("YOU WIN, " + boss.getName() + " is defeated");
                    if (boss.getType() == 1) {
                        System.out.println("Ethiron sees promise in you and replenishes your health and gives you the CRYPT BLADE");
                        sea.remove(skeleton);
                        attributes.bossSlayed(1);
                    } else if (boss.getType() == 2) {
                        System.out.println("You ravage Cthyllus's corpse and take the KRAKEN SKIN. You are healed to full");
                        sea.remove(octopus);
                        attributes.bossSlayed(2);
                    } else if (boss.getType() == 3) {
                        System.out.println("You absorb Davey Jones' soul and you are healed to full");
                        sea.remove(ghost);
                        attributes.bossSlayed(3);
                    } else if (boss.getType() == 4) {
                        System.out.println("You have caused Mathew to retire. He gives you the GAMER JUICE (Heal now heals 100 Health), You are healed to full");
                        sea.remove(gameTheory);
                        attributes.bossSlayed(4);
                    }
                    int gold = (int) (Math.random() * 1001) + 1000;
                    System.out.println("You are given " + gold + " gold");
                    attributes.setGold(gold);
                    boss.pause();
                    try {
                        mainTheme = new AudioFile("mainTheme.wav");
                        mainTheme.playSound();
                    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    attributes.setHealth();
                    frame.setVisible(false);
                    frame.remove(bossFight);
                    frame.add(sea);
                    frame.setVisible(true);
                } else {
                    attributes.takeDamage(damageTaken);
                    playerHealth.setText("Health Remaining: " + attributes.getHealth());
                    bossHealth.setText("Health Remaining: " + boss.getHealth());
                }
            }
        });

        JButton heal = new JButton();
        heal.setBounds(250,350,200,200);
        heal.setText("Use Heal Pot");
        heal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("You drink a potion and gain " + attributes.usePotion() + " health");
                int damageTaken = boss.attack();
                attributes.takeDamage(damageTaken);
                System.out.println("You have taken " + damageTaken + " points of damage");
                if (attributes.getHealth() <= 0) {
                    playerHealth.setText("Health Remaining: " + 0);
                    System.out.println("YOU LOSE");
                    System.out.println("You don't belong in the domain of the gods");
                    System.exit(0);
                } else {
                    playerHealth.setText("Health Remaining: " + attributes.getHealth());
                }
            }
        });

        JButton run = new JButton();
        run.setBounds(100,600,200,200);
        run.setText("Run");
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainTheme.pause();
                try {
                    mainTheme = new AudioFile("mainTheme.wav");
                    mainTheme.playSound();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                    throw new RuntimeException(e);
                }
                player.setLocation(450,450);
                frame.setVisible(false);
                frame.remove(bossFight);
                frame.add(sea);
                frame.setVisible(true);
            }
        });

        bossFight.add(atk);
        bossFight.add(heal);
        bossFight.add(run);
        bossFight.add(bossHealth);
        bossFight.add(playerHealth);

        frame.add(bossFight);
        frame.setVisible(true);
    }
    private void initializeSea() {
        sea.setLayout(null);
        sea.setSize(1000,1000);
        sea.setBackground(Color.CYAN);

        player.setBounds(450,450,50,50);

        coin.setBounds(500,500,50,50);

        captain1.setBounds(250,250,50,50);
        captain2.setBounds(350,450,50,50);
        captain3.setBounds(100,500,50,50);
        captain4.setBounds(200,100,50,50);
        captain5.setBounds(800,200,50,50);
        captain6.setBounds(600,600,50,50);
        captain7.setBounds(550,100,50,50);

        skeleton.setBounds(500,0,50,50);

        gameTheory.setBounds(0,500,50,50);

        ghost.setBounds(950,500,50,50);

        octopus.setBounds(500,900,50,50);
        makeGrid(sea, 0);

        sea.add(player);
        sea.add(coin);
        sea.add(captain1);
        sea.add(captain2);
        sea.add(captain3);
        sea.add(captain4);
        sea.add(captain5);
        sea.add(captain6);
        sea.add(captain7);

        sea.add(skeleton);
        sea.add(gameTheory);
        sea.add(ghost);
        sea.add(octopus);
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
        buttonInitializerShopA(shovel);

        JButton exitA = new JButton();
        exitA.setBounds(50,50,100,100);
        exitA.setText("Exit Shop");
        exitA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainTheme.pause();
                try {
                    mainTheme = new AudioFile("mainTheme.wav");
                    mainTheme.playSound();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                    throw new RuntimeException(ex);
                }
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
                try {
                    mainTheme = new AudioFile("mainTheme.wav");
                    mainTheme.playSound();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException f) {
                    throw new RuntimeException(f);
                }
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