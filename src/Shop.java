// PLACE FOR PLAYER TO BUY BETTER GEAR WIP

public class Shop extends Space {
    private static final Item LIFE_CRYSTAL = new Item("Life Crystal", null, 50, 20);
    private static final Item KATANA = new Item("Katana", 25, null, 100);
    private static final Item RAILBLADE = new Item("Railblade",200 , null, 3000);
    private static final Item CRYPT_BLADE = new Item("Crypt Blade",500 , null, 10000);
    private static final Item SHATTERED_KATANA = new Item("Shattered Katana", 70, null, 500);
    private static final Item BlOODTIDE_TRIDENT = new Item("Bloodtide Trident",120 , null, 1000);
    private static final Item STORMSEYE = new Item("Stormseye", 300, null, 5000);
    private static final Item SHOVEL = new Item("Shovel", 15, null, 50);

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
        printShop();
    }

    public String printShop() {
        String str = "Weapons:\n";
        str += "Shotel: " + SHOVEL.getCost() + " gold\n";
        str += "Katana: " + KATANA.getCost() + " gold\n";
        str += "Shattered Katana: " + SHATTERED_KATANA.getCost() + " gold\n";
        str += "Bloodtide Trident: " + BlOODTIDE_TRIDENT.getCost() + " gold\n";
        str += "Railblade: " + RAILBLADE.getCost() + " gold\n";
        str += "Stormseye: " + STORMSEYE.getCost() + " gold\n";
        str += "Crypt Blade: " + CRYPT_BLADE.getCost() + " gold\n";
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
