// PLACE FOR PLAYER TO BUY BETTER GEAR WIP

import java.util.Scanner;

public class Shop extends Space {
    private static final Item LIFE_CRYSTAL = new Item("Life Crystal", null, 50, 20, 1);
    private static final Item KATANA = new Item("Katana", 25, null, 100, 2);
    private static final Item RAILBLADE = new Item("Railblade",200 , null, 3000, 3);
    private static final Item CRYPT_BLADE = new Item("Crypt Blade",500 , null, 10000, 4);
    private static final Item SHATTERED_KATANA = new Item("Shattered Katana", 70, null, 500, 5);
    private static final Item BlOODTIDE_TRIDENT = new Item("Bloodtide Trident",120 , null, 1000, 5);
    private static final Item STORMSEYE = new Item("Stormseye", 300, null, 5000, 7);
    private static final Item SHOVEL = new Item("Shovel", 15, null, 50, 8);

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

    private Item[] catalog = {LIFE_CRYSTAL, KATANA, RAILBLADE, CRYPT_BLADE, SHATTERED_KATANA, BlOODTIDE_TRIDENT,
            STORMSEYE, SHOVEL};
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

    public Item[] getCatalog() {
        return catalog;
    }
}
