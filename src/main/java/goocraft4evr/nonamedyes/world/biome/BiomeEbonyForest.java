package goocraft4evr.nonamedyes.world.biome;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureTreeEbony;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.*;

import java.util.Random;

public class BiomeEbonyForest extends Biome {
    @Override
    public WorldFeature getRandomWorldGenForTrees(Random random) {
        if (random.nextInt(4) == 0) {
            if (random.nextInt(4) == 0) {
                return new WorldFeatureTreeFancy(Block.leavesOak.id, Block.logOak.id);
            }
            return new WorldFeatureTree(Block.leavesOak.id, Block.logOak.id, 4);
        }
        if (random.nextInt(6) == 0) {
            return new WorldFeatureTreeFancy(ModBlocks.leavesEbony.id, ModBlocks.logEbony.id);
        }
        return new WorldFeatureTreeEbony(ModBlocks.leavesEbony.id, ModBlocks.logEbony.id);
    }
}
