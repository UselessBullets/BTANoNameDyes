package goocraft4evr.nonamedyes.block.cinnamon;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureTreeCinnamon;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class BlockSaplingCinnamon extends BlockSaplingBase {
    public BlockSaplingCinnamon(String key, int id) {
        super(key, id);
    }

    @Override
    public void growTree(World world, int x, int y, int z, Random random) {
        WorldFeatureTreeCinnamon obj;
        world.setBlock(x, y, z, 0);
        obj = new WorldFeatureTreeCinnamon(ModBlocks.leavesCocoa.id, ModBlocks.logCocoa.id);
        if (!((WorldFeature)obj).generate(world, random, x, y, z)) world.setBlock(x, y, z, this.id);
    }
}
