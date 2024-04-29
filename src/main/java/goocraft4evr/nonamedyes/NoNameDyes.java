package goocraft4evr.nonamedyes;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.entity.ModEntities;
import goocraft4evr.nonamedyes.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;

import java.util.Properties;


public class NoNameDyes implements ModInitializer, ClientStartEntrypoint, GameStartEntrypoint {
    public static final String MOD_ID = "nonamedyes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private void handleConfig() {
        Properties prop = new Properties();
        prop.setProperty("starting_block_id","1000");
        prop.setProperty("starting_item_id","17000");
        prop.setProperty("starting_gui_id","8");
        ConfigHandler config = new ConfigHandler(MOD_ID,prop);
        UtilIdRegistrar.initIds(config.getInt("starting_block_id")
                ,config.getInt("starting_item_id")
                ,config.getInt("starting_gui_id"));
        config.updateConfig();
    }

    @Override
    public void onInitialize() {
        handleConfig();

        UtilIdRegistrar.setIdToBlock();
        ModBlocks.register();

        UtilIdRegistrar.setIdToItem();
        ModItems.register();

        UtilIdRegistrar.setIdToGUI();
        ModGuis.register();

        //ModFuelFurnace.register();
        //ModSmeltingManager.register();
        //ModCraftingManager.register();



        LOGGER.info("NoName Dyes initialized.");
    }

	@Override
	public void beforeGameStart() {
		ModEntities.register();
	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void beforeClientStart() {
		ModEntities.registerClientside();
	}

	@Override
	public void afterClientStart() {

	}
}
