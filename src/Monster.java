public class Monster {
    private String name;
    private int health;
    private int atk;

    public Monster(String name, int health, int atk) {
        this.name = name;
        this.health = health;
        this.atk = atk;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAtk() {
        return atk;
    }
}
