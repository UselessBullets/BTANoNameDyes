package goocraft4evr.nonamedyes.item;

import goocraft4evr.nonamedyes.UtilIdRegistrar;
import net.minecraft.core.item.Item;

public class ModItems {

    public static Item dye = ItemModDye.createDyes("dye", UtilIdRegistrar.nextId());
    public static void register() {

    }
}
