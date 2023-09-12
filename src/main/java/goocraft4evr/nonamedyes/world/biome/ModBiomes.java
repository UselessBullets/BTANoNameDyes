package goocraft4evr.nonamedyes.world.biome;

import goocraft4evr.nonamedyes.NoNameDyes;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.weather.Weather;

public abstract class ModBiomes {
    public static final Biome OVERWORLD_CINNAMON_FOREST =
            Biomes.register(NoNameDyes.MOD_ID+":overworld.cinnamon_forest",
                    new BiomeCinnamonForest()
                    .setColor(588342)
                    .setBlockedWeathers(Weather.overworldSnow));

}
