// PLACE FOR PLAYER TO BUY BETTER GEAR WIP

import java.util.Scanner;

public class Shop {
    public static final Item KATANA = new Item("Katana", 50, null, 100, 2);
    public static final Item RAILBLADE = new Item("Railblade",400 , null, 3000, 3);
    public static final Item CRYPT_BLADE = new Item("Crypt Blade",1000 , null, 10000, 4);
    public static final Item SHATTERED_KATANA = new Item("Shattered Katana", 140, null, 500, 5);
    public static final Item BlOODTIDE_TRIDENT = new Item("Bloodtide Trident",240 , null, 1000, 6);
    public static final Item STORMSEYE = new Item("Stormseye", 600, null, 5000, 7);
    public static final Item SHOVEL = new Item("Shovel", 30, null, 50, 8);
    public static final Item IRON_HOOK = new Item("Iron Hook", 50, null, 200, 15);

    //ARMOR + ACCESSORIES TO HEALTH INCREASE
    public static final Item LIFE_CRYSTAL = new Item("Life Crystal", null, 50, 20, 1);
    public static final Item IRON_ARMOR = new Item("Iron Armor", null, 100, 500, 10);
    public static final Item PIRATE_COAT = new Item("Pirate Coat", null, 150, 750, 11);
    public static final Item SHARK_SKIN = new Item("Shark Skin", null, 250, 1500, 12);
    public static final Item KRAKEN_SKIN = new Item("Kraken Skin", null, 500, 5000, 13);
    public static final Item PIRATE_HAT = new Item("Pirate Hat", null, 25, 100, 14);
    public static final Item WOODEN_PEG = new Item("Wooden Peg", null, 25, 100, 16);
    public static final Item PARROT = new Item("Parrot", null, 25, 500, 17);
    public static final Item EYE_PATCH = new Item("Eye Patch", null, 25, 100, 18);

    private Item[] catalogA = {IRON_HOOK, KATANA, RAILBLADE, CRYPT_BLADE, SHATTERED_KATANA, BlOODTIDE_TRIDENT,
            STORMSEYE, SHOVEL};
    private Item[] catalogB = {LIFE_CRYSTAL, IRON_ARMOR, PIRATE_COAT, SHARK_SKIN, KRAKEN_SKIN, PIRATE_HAT, WOODEN_PEG, PARROT, EYE_PATCH};
    public Shop() {

    }

    public void menu() {
        System.out.println(printShop());
    }


    public String printShop() {
        String str = "Weapons:\n";
        for (int i = 0; i < catalogA.length; i++) {
            str += i + ") " + catalogA[i].getName() + ": " + catalogA[i].getCost() + "gold\n";
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

    public Item[] getCatalogA() {
        return catalogA;
    }
    public Item[] getCatalogB() {
        return catalogB;
    }
}
