// push pls

public class Player extends Space {
    private String name;
    private int health;
    private Item item;
    public Player(String name) {
        super(name.substring(0, 1).toUpperCase()); // symbol is first initial
        this.name = name;
    }
    public int getHealth() {
        return health;
    }

    public int attack() {
        double damage = item.getAtk();
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

            System.out.println("Monster takes " + damage + " damage! 🐉");
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
}
