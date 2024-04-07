import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Space {
    private String name;
    private int health;
    private int heal;
    private int accessoryHealth;
    private Item weapon;
    private Item armor;
    private ArrayList<Item> inventory;
    private Shop shop;
    private int gold;
    private Scanner scan;
    private boolean inFight;
    private boolean won;
    private static boolean EthironDefeated = false;
    private static boolean CthyllusDefeated = false;
    private static boolean DaveyDefeated = false;
    private static boolean MatPatDefeated = false;
    private boolean[] bossesDefeated;
    public Player(String name) {
        super("😀"); // symbol is emoji
        this.name = name;
        inventory = new ArrayList<>();
        weapon = new Item("Base Sword", 10, null, 10, 0);
        armor = new Item("Leather Armor", null, 50, 200, 9);
        scan = new Scanner(System.in);
        inFight = false;
        health = 100 + armor.getIncreasedHealth();
        accessoryHealth = 0;
        heal = 50;
        shop = new Shop();
        gold = 1000;
        won = false;
        bossesDefeated = new boolean[4];
        bossesDefeated[0] = EthironDefeated;
        bossesDefeated[1] = CthyllusDefeated;
        bossesDefeated[2] = DaveyDefeated;
        bossesDefeated[3] = MatPatDefeated;
    }

    public boolean getInFight() {
        return inFight;
    }

    public int getHealth() {
        return health;
    }

    public boolean getWin() {
        return won;
    }

    public int attack() {
        double damage = weapon.getAtk();
        damage *= (Math.random() + 0.5);
        return (int) damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int usePotion() {
        health += 50;
        return heal;
    }
    public void setHealth() {
        health = 100 + armor.getIncreasedHealth() + accessoryHealth;
    }

    public void fightMonster(Monster monster) {
        inFight = true;
        while (inFight) {
            fightMenu(monster);
        }
    }

    public void fightMenu(Monster monster) {
        System.out.println("1) attack");
        System.out.println("2) switch item");
        System.out.println("3) run");
        String choice = scan.nextLine();
        if (choice.equals("1")) {
            int damage;
            int monsterDamage;
            damage = attack();
            monsterDamage = monster.attack();
            health -= monsterDamage;
            monster.takeDamage(damage);

            System.out.println(monster.getName() + " takes " + damage + " damage! \uD83D\uDC79");
            System.out.println(name + " takes " + monsterDamage + " damage! 🩸");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("error");
            }
            System.out.println(monster.getName() + " has " + monster.getHealth() + " health");
            System.out.println(name + " has " + health + " health\n");

            if (health < 0) {
                health = 1;
                inFight = false;
                won = false;
                System.out.println("YOU LOST!!!!!!!!!!!!!!!!!!!!!");
            }
            if (monster.isDead()) {
                inFight = false;
                won = true;
                if (monster instanceof Boss) {
                    bossThingy((Boss) monster);
                }
                System.out.println("You have won!");
            }

        } else if (choice.equals("2")) {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println(i + " " + inventory.get(i));
            }
            int itemChoice = scan.nextInt();
            inventory.add(0, inventory.remove(itemChoice));

        } else if (choice.equals("3")) {
            System.out.println("coward");
            inFight = false;
        } else {
            System.out.println("error");
            fightMenu(monster);
        }
        scan.nextLine();
    }

    /*
        public void bossMenu(Boss monster) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
            System.out.println("1) attack");
            System.out.println("2) switch item");
            System.out.println("3) run");
            String choice = scan.nextLine();
            if(!inFight){
                monster.pause();
            }
            if(inFight){
                monster.encounterBoss();
            }
            if (choice.equals("1")) {
                int damage;
                int monsterDamage;
                damage = attack();
                monsterDamage = monster.attack();
                health -= monsterDamage;
                monster.takeDamage(damage);

                System.out.println(monster.getName() + " takes " + damage + " damage! \uD83D\uDC79");
                System.out.println(name + " takes " + monsterDamage + " damage! 🩸");

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    System.out.println("error");
                }
                System.out.println(monster.getName() + " has " + monster.getHealth() + " health");
                System.out.println(name + " has " + health + " health\n");

                if (health < 0) {
                    health = 1;
                    inFight = false;
                    System.out.println("YOU LOST!!!!!!!!!!!!!!!!!!!!!");
                }

            } else if (choice.equals("2")) {
                for (int i = 0; i < inventory.size(); i++) {
                    System.out.println(i + " " + inventory.get(i));
                }
                int itemChoice = scan.nextInt();
                inventory.add(0, inventory.remove(itemChoice));

            } else if (choice.equals("3")) {
                System.out.println("coward");
                inFight = false;
            } else {
                System.out.println("error");
                fightMenu(monster);
            }
        }

     */
    public void bossThingy(Boss boss) {
        int type = boss.getType();
        if (type == 1) {
            EthironDefeated = true;
        } else if (type == 2) {
            CthyllusDefeated = true;
        } else if (type == 3) {
            DaveyDefeated = true;
        } else {
            MatPatDefeated = true;
        }
    }
    public void bossSlayed(int type) {
        if (type == 1) {
            EthironDefeated = true;
            weapon = Shop.CRYPT_BLADE;
        } else if (type == 2) {
            CthyllusDefeated = true;
            health += 500;
        } else if (type == 3) {
            DaveyDefeated = true;
        } else if (type == 4) {
            MatPatDefeated = true;
            heal = 200;
        }
    }

    public boolean getEthiornDefeated() {
        return EthironDefeated;
    }

    public boolean getCthyllusDefeated() {
        return CthyllusDefeated;
    }

    public boolean getDaveyDefeated() {
        return DaveyDefeated;
    }

    public boolean getMatPatDefeated() {
        return MatPatDefeated;
    }

    public boolean finalBoss() {
        return getMatPatDefeated() && getDaveyDefeated() && getCthyllusDefeated() && getEthiornDefeated();
    }
//    public void accessShop() {
//        shop.menu();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("what do you wanna buy?");
//        buy(shop.getCatalog()[scan.nextInt()]);
//    }

    public boolean buy(Item item) {
        if (gold > item.getCost()) {
            gold -= item.getCost();
            inventory.add(item);
            return true;
        }
        return false;
    }
    public void lifeCrystalUsed() {
        health += 50;
        gold -= 50;
    }

    public boolean buyWeapon(int item) {
        if (gold >= shop.getCatalogA()[item].getCost()) {
            gold -= shop.getCatalogA()[item].getCost();
            weapon = shop.getCatalogA()[item];
            System.out.println("Successfully bought: " + shop.getCatalogA()[item].getName());
            return true;
        }
        System.out.println("Insufficient Funds");
        return false;
    }

    public boolean buyArmor(int item) {
        if (gold >= shop.getCatalogB()[item].getCost()) {
            gold -= shop.getCatalogB()[item].getCost();
            armor = shop.getCatalogB()[item];
            health = 100 + armor.getIncreasedHealth() + accessoryHealth;
            System.out.println("Successfully bought: " + shop.getCatalogB()[item].getName());
            return true;
        }
        System.out.println("Insufficient Funds");
        return false;
    }

    public boolean buyAccessory(int item) {
        if (gold >= shop.getCatalogB()[item].getCost()) {
            gold -= shop.getCatalogB()[item].getCost();
            accessoryHealth += shop.getCatalogB()[item].getIncreasedHealth();
            System.out.println("Successfully bought, total health increased");
            return true;
        }
        System.out.println("Insufficient Funds");
        return false;
    }

    public int getGold() {
        return gold;
    }
    public void setGold(int goldWon) {
        gold += goldWon;
    }
    @Override
    public String toString() {
        String str = "\n\nInventory\n";
        str += "Weapon: " + weapon.getName() + ", Attack: " + weapon.getAtk();
        str += "\nArmor: " + armor.getName() + ", Health: " + (health) + "\n";
        return str;
    }
}