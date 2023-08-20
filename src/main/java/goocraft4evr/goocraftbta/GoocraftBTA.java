package goocraft4evr.goocraftbta;

import goocraft4evr.goocraftbta.block.ModBlocks;
import goocraft4evr.goocraftbta.container.ContainerPlayerCreativeAppender;
import goocraft4evr.goocraftbta.crafting.ModCraftingManager;
import goocraft4evr.goocraftbta.crafting.ModFuelFurnace;
import goocraft4evr.goocraftbta.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GoocraftBTA implements ModInitializer {
    public static final String MOD_ID = "goocraft";
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
        LOGGER.info("Goocraft initialized.");
    }
}
