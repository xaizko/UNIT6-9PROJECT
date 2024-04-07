public class Item {
    private String name;
    private Integer atk;
    private Integer increasedHealth;
    private int cost;
    public Item(String name, Integer atk, Integer increasedHealth, int cost, int idx) {
        this.name = name;
        this.atk = atk;
        this.increasedHealth = increasedHealth;
        this.cost = cost;
    }

    public int getAtk() {
        return atk;
    }

    public int getCost() {
        return cost;
    }
    public Integer getIncreasedHealth() {
        return increasedHealth;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        Integer attack = atk;
        Integer health = increasedHealth;
        if (attack == null) {
            attack = 0;
        }
        if (health == null) {
            health = 0;
        }
        return "Item name: " + name + "\nItem Attack: " + attack + "\nAdded Health: " + health;
    }
}
