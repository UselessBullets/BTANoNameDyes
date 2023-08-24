package goocraft4evr.nonamedyes;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.container.ContainerPlayerCreativeAppender;
import goocraft4evr.nonamedyes.crafting.ModCraftingManager;
import goocraft4evr.nonamedyes.crafting.ModFuelFurnace;
import goocraft4evr.nonamedyes.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NoNameDyes implements ModInitializer {
    public static final String MOD_ID = "nonamedyes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        UtilIdRegistrar.setIdToBlock();
        ModBlocks.register();

        UtilIdRegistrar.setIdToItem();
        ModItems.register();

        ModFuelFurnace.register();
        ModCraftingManager.register();

        ContainerPlayerCreativeAppender.appendItems();
        LOGGER.info("NoName Dyes initialized.");
    }
}
