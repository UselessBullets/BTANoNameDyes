package goocraft4evr.nonamedyes.world.worldgen;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;

import java.util.Random;

public class WorldFeatureTreeCinnamon extends WorldFeature {
    private int leavesID;
    private int logID;

    public WorldFeatureTreeCinnamon(int leavesID, int logID) {
        this.leavesID = leavesID;
        this.logID = logID;
    }

    //there's probably a better way to write this.
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        //tree height
        int treeHeight = random.nextInt(4) + 5;
        //check tree fits in bounds and can grow on the block below
        if (y < 1 ||
            y + treeHeight + 1 >= world.getHeightBlocks() ||
            !Block.hasTag(world.getBlockId(x, y - 1, z), BlockTags.GROWS_TREES)) return false;
        //check if trunk can spawn
        int blockId;
        for (int i=0;i<treeHeight-3;i++) {
            blockId = world.getBlockId(x, y+i, z);
            if (!(blockId == 0 || blockId == this.leavesID)) return false;
        }
        //check leaves can spawn
        for (int i=0;i<4;i++) {
            int radius = i>1?1:2;
            for (int j=-radius;j<=radius;j++) {
                for (int k=-radius;k<=radius;k++) {
                    if ((i&1)==1&&Math.abs(j)==radius&&Math.abs(k)==radius) continue;
                    blockId = world.getBlockId(x+j, y+treeHeight-3+i, z+k);
                    if (!(blockId == 0 || blockId == this.leavesID)) return false;
                }
            }
        }
        //at this point the tree can spawn
        WorldFeatureTree.onTreeGrown(world, x, y, z);
        //generate leaves
        for (int i=0;i<4;i++) {
            int radius = i>1?1:2;
            for (int j=-radius;j<=radius;j++) {
                for (int k=-radius;k<=radius;k++) {
                    if (Math.abs(j)==radius&&Math.abs(k)==radius&&((i&1)==1||random.nextBoolean())) continue;
                    world.setBlockWithNotify(x+j, y+treeHeight-3+i, z+k, this.leavesID);
                    if (i==0&&Math.abs(j)==radius||Math.abs(k)==radius) {
                        for (int l=0;l<random.nextInt(3);l++) {
                            world.setBlockWithNotify(x+j, y+treeHeight-4-l, z+k, this.leavesID);
                        }
                    }
                }
            }
        }
        //generate trunk
        for (int i=0;i<treeHeight;i++) {
            world.setBlockWithNotify(x, y + i, z, this.logID);
        }
        return true;
    }
}
