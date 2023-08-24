package goocraft4evr.nonamedyes.block.cocoa;

import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;

import java.util.Random;

public class BlockSaplingCocoa extends BlockSaplingBase {

    public BlockSaplingCocoa(String key, int id) {
        super(key, id);
    }

    @Override
    public void growTree(World world, int x, int y, int z, Random random) {
        WorldFeatureTree obj = null;
        world.setBlock(x, y, z, 0);
        int treeHeight = 5;
        obj = new WorldFeatureTree(ModBlocks.leavesCocoa.id, ModBlocks.logCocoa.id, treeHeight);
        if (((WorldFeature)obj).generate(world, random, x, y, z)) {
            int numCocoa = 1 + random.nextInt(3);
            for (int i=0;i<numCocoa;i++) {
                int yoff = random.nextInt(treeHeight);
                if (world.getBlockId(x,y+yoff,z) == ModBlocks.logCocoa.id) {
                    world.setBlock(x,y+yoff,z,ModBlocks.logCocoaRipe.id);
                }
            }
        } else {
            world.setBlock(x, y, z, this.id);
        }
    }
}
