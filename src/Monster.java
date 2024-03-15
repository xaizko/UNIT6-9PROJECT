public class Monster extends Space{
    private String name;
    private int health;
    private int atk;

    public Monster(String symbol, String name, int health, int atk) {
        super(symbol);
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
