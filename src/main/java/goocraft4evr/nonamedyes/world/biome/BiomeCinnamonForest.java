package goocraft4evr.nonamedyes.world.biome;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureTreeCinnamon;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class BiomeCinnamonForest extends Biome {
    @Override
    public WorldFeature getRandomWorldGenForTrees(Random random) {
        return new WorldFeatureTreeCinnamon(ModBlocks.leavesCocoa.id, ModBlocks.logCocoa.id);
    }
}
