public class Boss extends Monster {
    private int type;
    public Boss(String symbol, String name, int health, int atk,int type){
        super(symbol,name,health,atk);
        this.type = type;
    }
    public void meetEncounter() {
        System.out.println("You have encountered "  + getName());
    }
}
