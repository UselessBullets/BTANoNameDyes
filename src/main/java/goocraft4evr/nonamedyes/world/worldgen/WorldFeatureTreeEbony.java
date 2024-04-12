package goocraft4evr.nonamedyes.world.worldgen;

import goocraft4evr.nonamedyes.NoNameDyes;
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
		int treeHeight = random.nextInt(4) + 4;
		if (y < 1 ||
			y + treeHeight + 1 >= world.getHeightBlocks() ||
			!Block.hasTag(world.getBlockId(x, y - 1, z), BlockTags.GROWS_TREES)) return false;

		int blockId;
		//log check
		for (int i=1;i<treeHeight-1;i++) {
			blockId = world.getBlockId(x, y+i, z);
			if (!(blockId == 0 || blockId == this.leavesID)) return false;
		}

		//leaves check
		for (int i=0;i<4;i++) {
			int y1 = y + treeHeight + 1 - i;
			int radius = i==3?3:i+1;
			for (int x1=x-radius;x1<=x+radius;x1++) {
				for (int z1=z-radius;z1<=z+radius;z1++) {
					blockId = world.getBlockId(x1, y1, z1);
					if (!(blockId == 0 || blockId == this.leavesID)) return false;
				}
			}
		}

		WorldFeatureTree.onTreeGrown(world, x, y, z);

		//leaves generate
		for (int i=0;i<4;i++) {
			int y1 = y + treeHeight + 1 - i;
			int radius = i==3?3:i+1;
			for (int xo=-radius;xo<=radius;xo++) {
				for (int zo=-radius;zo<=radius;zo++) {
					if (Math.abs(xo)==radius && Math.abs(xo) == Math.abs(zo) && random.nextInt(2)==0) continue;
					world.setBlockWithNotify(x+xo, y1, z+zo,leavesID);
				}
			}
		}
		for (int dx = -1;dx<=1;dx+=2) {
			for (int dz = -1;dz<=1;dz+=2) {
				world.setBlockWithNotify(x+dx*3, y + treeHeight - 1, z+dz*3,0);
				if (random.nextInt(2)==0) world.setBlockWithNotify(x+dx*2, y + treeHeight - 1, z+dz*3,0);
				if (random.nextInt(2)==0) world.setBlockWithNotify(x+dx*3, y + treeHeight - 1, z+dz*2,0);
			}
		}

		//log generate
		for (int i=0;i<treeHeight;i++) {
			world.setBlockWithNotify(x, y + i, z, this.logID);
		}
		for (int i=0;i<4;i++) {
			int dx = 0;
			int dz = 0;
			switch (i) {
				case 0: dx++; break;
				case 1: dx--; break;
				case 2: dz++; break;
				case 3: dz--; break;
			}
			world.setBlockWithNotify(x+dx, y+treeHeight-2, z+dz, this.logID);
			world.setBlockWithNotify(x+dx, y+treeHeight-1, z+dz, this.logID);
			if (random.nextInt(2)==0) world.setBlockWithNotify(x+dx, y+treeHeight, z+dz, this.logID);
			if (random.nextInt(2)==0) world.setBlockWithNotify(x+2*dx, y+treeHeight-2, z+2*dz, this.logID);
		}
		return true;
	}

	/*
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        int treeHeight = random.nextInt(4) + 4;
        if (y < 1 ||
                y + treeHeight + 1 >= world.getHeightBlocks() ||
                !Block.hasTag(world.getBlockId(x, y - 1, z), BlockTags.GROWS_TREES)) return false;
        int blockId;
        for (int i=0;i<treeHeight-2;i++) {
            blockId = world.getBlockId(x, y+i, z);
            if (!(blockId == 0 || blockId == this.leavesID)) return false;
        }
        for (int i=0;i<4;i++) {
            int radius = i==3?1:2;
            for (int ix = -radius;ix<=radius;ix++) {
                for (int iz = -radius;iz<=radius;iz++) {
                    blockId = world.getBlockId(x+ix, y+treeHeight-2+i, z+iz);
                    if (!(blockId == 0 || blockId == this.leavesID)) return false;
                }
            }
        }
        int upperLog = (treeHeight>5?2:1)+random.nextInt(4);
        for (int i=0;i<upperLog-3;i++) {
            for (int o=-1;o<2;o+=2) {
                blockId = world.getBlockId(x+o, y+upperLog-i, z);
                if (!(blockId == 0 || blockId == this.leavesID)) return false;
                blockId = world.getBlockId(x, y+upperLog-i, z+o);
                if (!(blockId == 0 || blockId == this.leavesID)) return false;
            }
        }
        WorldFeatureTree.onTreeGrown(world, x, y, z);
        for (int i=0;i<4;i++) {
            int radius = i==3?1:2;
            for (int ix = -radius;ix<=radius;ix++) {
                for (int iz = -radius;iz<=radius;iz++) {
                    if (Math.abs(ix)==Math.abs(iz)&&Math.abs(ix)==radius&&random.nextInt(2)==0) continue;
                    world.setBlockWithNotify(x+ix, y+treeHeight-2+i, z+iz,leavesID);
                }
            }
        }
        for (int i=0;i<=treeHeight;i++) {
            world.setBlockWithNotify(x, y + i, z, this.logID);
        }
        for (int i=0;i<4;i++) {
            int logLen = upperLog-random.nextInt(upperLog);
            for (int iy=0;iy<logLen;iy++) {
                int ix = (i&1)==1?(i-2):0;
                int iz = (i&1)==1?0:(i-1);
                world.setBlockWithNotify(x+ix, y + treeHeight-iy, z+iz, this.logID);
            }
        }
        return true;
    }

	 */
}
