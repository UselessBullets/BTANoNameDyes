package goocraft4evr.nonamedyes.block.ebony;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureTreeEbony;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class BlockSaplingEbony extends BlockSaplingBase {
    public BlockSaplingEbony(String key, int id) {
        super(key, id);
    }

    @Override
    public void growTree(World world, int x, int y, int z, Random random) {
        WorldFeatureTreeEbony obj;
        world.setBlock(x, y, z, 0);
        obj = new WorldFeatureTreeEbony(ModBlocks.leavesEbony.id, ModBlocks.logEbony.id);
        if (!((WorldFeature)obj).generate(world, random, x, y, z)) world.setBlock(x, y, z, this.id);
    }
}
