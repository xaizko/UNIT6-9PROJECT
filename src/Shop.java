// PLACE FOR PLAYER TO BUY BETTER GEAR WIP

public class Shop extends Space {
    private static final int LIFE_CRYSTAL = 20;
    private static final int KATANA_COST = 100;
    private static final int RAILBLADE_COST = 3000;
    private static final int CRYPT_BLADE_COST = 10000;
    private static final int SHATTERED_KATANA = 500;
    private static final int BlOODTIDE_TRIDENT_COST = 1000;
    private static final int STORMSEYE_COST = 5000;
    private static final int SHOTEL_COST = 50;

    //ARMOR + ACCESSORIES TO HEALTH INCREASE
    private static final int LEATHER_ARMOR_COST = 100;
    private static final int IRON_ARMOR_COST = 500;
    private static final int PIRATE_COAT_COST = 1000;
    private static final int SHARK_SKIN_COST = 3000;
    private static final int KRAKEN_SKIN_COST = 10000;
    private static final int PIRATE_HAT_COST = 100;
    private static final int IRON_HOOK_COST = 1500;
    private static final int WOODEN_PEG_COST = 500;
    private static final int PARROT_COST = 2000;
    private static final int EYE_PATCH_COST = 250;
    public Shop() {
        super("\uD83D\uDED2");
    }

    public void menu(int goldAvailable) {

    }

    public String printShop() {
        String str = "Weapons:\n";
        str += "Shotel: " + SHOTEL_COST + " gold\n";
        str += "Katana: " + KATANA_COST + " gold\n";
        str += "Shattered Katana: " + SHATTERED_KATANA + " gold\n";
        str += "Bloodtide Trident: " + BlOODTIDE_TRIDENT_COST + " gold\n";
        str += "Railblade: " + RAILBLADE_COST + " gold\n";
        str += "Stormseye: " + STORMSEYE_COST + " gold\n";
        str += "Crypt Blade: " + CRYPT_BLADE_COST + " gold\n";
        str += "\nArmor:\n";
        str += "Leather armor: " + LEATHER_ARMOR_COST + "gold\n";
        str += "Iron armor: " + IRON_ARMOR_COST + "gold\n";
        str += "Pirate Coat: " + PIRATE_COAT_COST + "gold\n";
        str += "Shark Skin armor: " + SHARK_SKIN_COST + "gold\n";
        str += "Kraken Skin armor: " + KRAKEN_SKIN_COST + "gold\n";
        str += "\nAccessories:\n";
        str += "Pirate Hat: " + PIRATE_HAT_COST + "gold\n";
        str += "Eye Patch: " + EYE_PATCH_COST + "gold\n";
        str += "Wooden Peg: " + WOODEN_PEG_COST + "gold\n";
        str += "Iron Hook: " + IRON_HOOK_COST + "gold\n";
        str += "Parrot Pet: " + PARROT_COST + "gold\n";


        return str;
    }
}
