package goocraft4evr.nonamedyes.block.palm;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureTreeEbony;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureTreePalm;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class BlockSaplingPalm extends BlockSaplingBase {
    public BlockSaplingPalm(String key, int id) {
        super(key, id);
    }

    @Override
    public void growTree(World world, int x, int y, int z, Random random) {
        WorldFeatureTreePalm obj;
        world.setBlock(x, y, z, 0);
        obj = new WorldFeatureTreePalm(ModBlocks.leavesPalm.id, ModBlocks.logPalm.id);
        if (!((WorldFeature)obj).generate(world, random, x, y, z)) world.setBlock(x, y, z, this.id);
    }
}
