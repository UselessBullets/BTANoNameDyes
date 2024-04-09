package goocraft4evr.nonamedyes.world.biome;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureTreePalm;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class BiomePalmBeach extends Biome {
	public BiomePalmBeach(String key) {
		super(key);
	}

	@Override
    public WorldFeature getRandomWorldGenForTrees(Random random) {
        return new WorldFeatureTreePalm(ModBlocks.leavesPalm.id, ModBlocks.logPalm.id);
    }
}
