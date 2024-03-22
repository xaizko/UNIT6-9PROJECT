// push pls

import java.util.ArrayList;

public class Player extends Space {
    private String name;
    private int health;
    private Shop shop;
    private int gold;
    private ArrayList<Item> inventory;
    private boolean EthironDefeated;
    private boolean ChaserDefeated;
    private boolean MaestroDefeated;
    private boolean DavyDefeated;
    public Player(String name) {
        super("😀"); // symbol is emoji
        this.name = name;
        inventory = new ArrayList<>();
        inventory.add(new Item("Base Sword", 10));
        health = 100;
        shop = new Shop();
        gold = 0;
    }
    public int getHealth() {
        return health;
    }

    public int attack() {
        double damage = inventory.get(0).getAtk();
        damage *= (Math.random() + 0.5);
        return (int) damage;
    }
    public boolean fightMonster(Monster monster) {
        int damage;
        int monsterDamage;
        while (health > 0 && monster.getHealth() > 0) {
            damage = attack();
            monsterDamage = monster.attack();
            health -= monsterDamage;
            monster.takeDamage(damage);

            System.out.println("Monster takes " + damage + " damage! \uD83D\uDC79");
            System.out.println(name + " takes " + monsterDamage + " damage! 🩸");

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("error");
            }
            System.out.println("Dragon has " + monster.getHealth() + " health");
            System.out.println(name + " has " + health + " health\n");
        }
        return health <= 0;
    }

    public void accessShop() {
        shop.menu(gold);
    }
}
