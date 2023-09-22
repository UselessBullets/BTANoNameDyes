package goocraft4evr.nonamedyes.item;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.UtilIdRegistrar;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.tag.ItemTags;
import turniplabs.halplibe.helper.ItemHelper;

public class ModItems {

    public static Item dye = ItemModDye.createDyes("dye", UtilIdRegistrar.nextId()).setNotInCreativeMenu();

    public static Item bleachingPowder = ItemHelper.createItem(
            NoNameDyes.MOD_ID,
            new Item(UtilIdRegistrar.nextId()),
            "bleaching.powder",
            "bleaching_powder.png");
    public static void register() {

    }
}
