// PLACE FOR PLAYER TO BUY BETTER GEAR WIP

public class Shop extends Space {
    private static final int LIFE_CRYSTAL = 20;
    private static final int ROPE_COST = 4;
    private static final int RAILBLADE_COST = 1000;
    private static final int CRYPT_BLADE_COST = 10000;
    private static final int HORSE_COST = 12;
    private static final int BOAT_COST = 20;
    private static final int SHOVEL_COST = 8;
    private static final int CANNON_COST = 0;
    public Shop() {
        super("\uD83D\uDED2");
    }

    public void menu(int goldAvailable) {

    }

    public String printShop() {
        String str = "Water: " + WATER_COST + " gold\n";
        str += "Rope: " + ROPE_COST + " gold\n";
        str += "Machete: " + MACHETE_COST + " gold\n";
        str += "Boots: " + BOOTS_COST + " gold\n";
        str += "Horse: " + HORSE_COST + " gold\n";
        str += "Boat: " + BOAT_COST + " gold\n";
        str += "Shovel: " + SHOVEL_COST + " gold\n";
        return str;
    }
}
