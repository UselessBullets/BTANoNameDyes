package goocraft4evr.nonamedyes.world.biome;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.weather.Weather;

public abstract class ModBiomes {
    public static final Biome OVERWORLD_CINNAMON_FOREST =
            Biomes.register("minecraft:overworld.cinnamon_forest",
                    new BiomeCinnamonForest()
                    .setColor(588342)
                    .setBlockedWeathers(Weather.overworldSnow));

}
