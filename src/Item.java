public class Item {
    private String name;
    private Integer atk;
    private Integer increasedHealth;
    private int cost;
    public Item(String name, Integer atk, Integer increasedHealth, int cost) {
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
}
