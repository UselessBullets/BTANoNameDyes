package goocraft4evr.nonamedyes.item;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.UtilIdRegistrar;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFoodStackable;
import turniplabs.halplibe.helper.ItemHelper;

public class ModItems {

    public static Item dye = ItemModDye.createDyes("dye", UtilIdRegistrar.nextId()).setNotInCreativeMenu();

    public static Item bleachingPowder = ItemHelper.createItem(
            NoNameDyes.MOD_ID,
            new Item(UtilIdRegistrar.nextId()),
            "bleaching.powder",
            "bleaching_powder.png");

    public static Item foodSnickerdoodle = ItemHelper.createItem(
            NoNameDyes.MOD_ID,
            new ItemFoodStackable("snickerdoodle", UtilIdRegistrar.nextId(), 1, false, 8),
            "snickerdoodle",
            "snickerdoodle.png");

    public static Item vileShard = ItemHelper.createItem(
            NoNameDyes.MOD_ID,
            new Item(UtilIdRegistrar.nextId()),
            "vileshard",
            "vile_shard.png");

    public static Item ceramic = ItemHelper.createItem(
            NoNameDyes.MOD_ID,
            new Item(UtilIdRegistrar.nextId()),
            "ceramic",
            "ceramic.png");

    public static void register() {

    }
}
