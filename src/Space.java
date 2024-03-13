public class Space {
    private String symbol;
    private Monster mob;

    public Space(String symbol, Monster mob) {
        this.symbol = symbol;
        this.mob = mob; //  this is to contain the monster in a certain square
    }

    public String getSymbol() {
        return symbol;
    }
}
