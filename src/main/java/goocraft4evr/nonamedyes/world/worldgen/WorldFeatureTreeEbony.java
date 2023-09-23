package goocraft4evr.nonamedyes.world.worldgen;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;

import java.util.Random;

public class WorldFeatureTreeEbony extends WorldFeature {
    private int leavesID;
    private int logID;

    public WorldFeatureTreeEbony(int leavesID, int logID) {
        this.leavesID = leavesID;
        this.logID = logID;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        int treeHeight = random.nextInt(4) + 7;
        if (y < 1 ||
                y + treeHeight + 1 >= world.getHeightBlocks() ||
                !Block.hasTag(world.getBlockId(x, y - 1, z), BlockTags.GROWS_TREES)) return false;
        int blockId;
        for (int i=0;i<treeHeight-3;i++) {
            blockId = world.getBlockId(x, y+i, z);
            if (!(blockId == 0 || blockId == this.leavesID)) return false;
        }
        for (int i=0;i<4;i++) {
            int radius = i==3?1:2;
            for (int ix = -radius;ix<=radius;ix++) {
                for (int iz = -radius;iz<=radius;iz++) {
                    blockId = world.getBlockId(x+ix, y+treeHeight-3+i, z+iz);
                    if (!(blockId == 0 || blockId == this.leavesID)) return false;
                }
            }
        }
        WorldFeatureTree.onTreeGrown(world, x, y, z);
        for (int i=0;i<4;i++) {
            int radius = i==3?1:2;
            for (int ix = -radius;ix<=radius;ix++) {
                for (int iz = -radius;iz<=radius;iz++) {
                    if (Math.abs(ix)==Math.abs(iz)&&Math.abs(ix)==radius&&random.nextInt(2)==0) continue;
                    world.setBlockWithNotify(x+ix, y+treeHeight-3+i, z+iz,leavesID);
                }
            }
        }
        for (int i=0;i<treeHeight;i++) {
            world.setBlockWithNotify(x, y + i, z, this.logID);
        }
        return true;
    }
}
