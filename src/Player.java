public class Player extends Space {
    private String name;

    public Player(String name) {
        super(name.substring(0, 1), new Monster(name, 100, 10)); // symbol is first initial
        this.name = name;
    }

}
