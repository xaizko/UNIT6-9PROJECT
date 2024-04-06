// push pls

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Space {
    private String name;
    private int health;
    private Shop shop;
    private int gold;
    private ArrayList<Item> inventory;
    private Scanner scan;
    private boolean inFight;
    private boolean won;
    private boolean EthironDefeated;
    private boolean CthyllusDefeated;
    private boolean MatPatDefeated;
    private boolean DavyDefeated;
    public Player(String name) {
        super("😀"); // symbol is emoji
        this.name = name;
        inventory = new ArrayList<>();
        inventory.add(new Item("Base Sword", 5000, null, 10, 0));
        scan = new Scanner(System.in);
        inFight = false;
        health = 100;
        shop = new Shop();
        gold = 100000;
        won = false;
    }
    public boolean getInFight(){
        return inFight;
    }
    public int getHealth() {
        return health;
    }
    public boolean getWin(){
        return won;
    }

    public int attack() {
        double damage = inventory.get(0).getAtk();
        damage *= (Math.random() + 0.5);
        return (int) damage;
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
            if(monster.isDead()){
                inFight = false;
                won = true;
                if(monster instanceof Boss){
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
    public void bossThingy(Boss boss){
        int type = boss.getType();
        if (type == 1) {
            EthironDefeated = true;
        } else if (type == 2) {
            CthyllusDefeated = true;
        }else if(type == 3){
            DavyDefeated = true;
        }else{
            MatPatDefeated = true;
        }
    }
//    public void accessShop() {
//        shop.menu();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("what do you wanna buy?");
//        buy(shop.getCatalog()[scan.nextInt()]);
//    }

    public void buy(int item) {
        if (gold > shop.getCatalog()[item].getCost()) {
            gold -= shop.getCatalog()[item].getCost();
            inventory.add(shop.getCatalog()[item]);
            System.out.println("Sucessfully bought");
            return;
        }
        System.out.println("Insufficient Funds");
    }

    public int getGold() {
        return gold;
    }
}
