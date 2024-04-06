// PLACE FOR PLAYER TO BUY BETTER GEAR WIP

import java.util.Scanner;

public class Shop extends Space {
    private static final Item LIFE_CRYSTAL = new Item("Life Crystal", null, 50, 20, 1);
    private static final Item KATANA = new Item("Katana", 25, null, 100, 2);
    private static final Item RAILBLADE = new Item("Railblade",200 , null, 3000, 3);
    private static final Item CRYPT_BLADE = new Item("Crypt Blade",500 , null, 10000, 4);
    private static final Item SHATTERED_KATANA = new Item("Shattered Katana", 70, null, 500, 5);
    private static final Item BlOODTIDE_TRIDENT = new Item("Bloodtide Trident",120 , null, 1000, 6);
    private static final Item STORMSEYE = new Item("Stormseye", 300, null, 5000, 7);
    private static final Item SHOVEL = new Item("Shovel", 15, null, 50, 8);

    //ARMOR + ACCESSORIES TO HEALTH INCREASE
    private static final Item LEATHER_ARMOR = new Item("Leather Armor", null, 50, 200, 9);
    private static final Item IRON_ARMOR = new Item("Iron Armor", null, 100, 500, 10);
    private static final Item PIRATE_COAT = new Item("Pirate Coat", null, 150, 750, 11);
    private static final Item SHARK_SKIN = new Item("Shark Skin Armor", null, 250, 1500, 12);
    private static final Item KRAKEN_SKIN = new Item("Kraken Skin Armor", null, 500, 5000, 13);
    private static final Item PIRATE_HAT = new Item("Pirate Hat", 0, 25, 100, 14);
    private static final Item IRON_HOOK = new Item("Iron Hook", 25, null, 200, 15);
    private static final Item WOODEN_PEG = new Item("Wooden Peg", 0, 25, 100, 16);
    private static final Item PARROT = new Item("Parrot", 25, null, 500, 17);
    private static final Item EYE_PATCH = new Item("Eye Patch", 0, 25, 100, 18);

    private Item[] catalog = {LIFE_CRYSTAL, KATANA, RAILBLADE, CRYPT_BLADE, SHATTERED_KATANA, BlOODTIDE_TRIDENT,
            STORMSEYE, SHOVEL};
    private Item[] catalogB = {LEATHER_ARMOR, IRON_ARMOR, PIRATE_COAT, SHARK_SKIN, KRAKEN_SKIN, PIRATE_HAT, IRON_HOOK, WOODEN_PEG, PARROT, EYE_PATCH};
    public Shop() {
        super("\uD83D\uDED2");
    }

    public void menu() {
        System.out.println(printShop());
    }


    public String printShop() {
        String str = "Weapons:\n";
        for (int i = 0; i < catalog.length; i++) {
            str += i + ") " + catalog[i].getName() + ": " + catalog[i].getCost() + "gold\n";
        }
        return str;
    }

    public String printShop2() {
        String str = "Accessories:\n";
        for (int i = 0; i < catalogB.length; i++) {
            str += i + ") " + catalogB[i].getName() + ": " + catalogB[i].getCost() + "gold\n";
        }
        return str;
    }

    public Item[] getCatalog() {
        return catalog;
    }
    public Item[] getCatalogB() {return catalogB};
}
