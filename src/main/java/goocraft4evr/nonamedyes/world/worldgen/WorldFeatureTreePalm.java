package goocraft4evr.nonamedyes.world.worldgen;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;

import java.util.Random;

public class WorldFeatureTreePalm extends WorldFeature {
    private int leavesID;
    private int logID;

    public WorldFeatureTreePalm(int leavesID, int logID) {
        this.leavesID = leavesID;
        this.logID = logID;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
		//actual height is this +4
        int treeHeight = 3 + random.nextInt(2);
		if (y < 1 ||
			y + treeHeight + 5 >= world.getHeightBlocks() ||
			!Block.hasTag(world.getBlockId(x, y - 1, z), BlockTags.GROWS_TREES)) return false;

		int stem1 = 1 + random.nextInt(treeHeight+1);
		int stem2 = 1 + random.nextInt(treeHeight+2-stem1);
		int stem3 = treeHeight-stem1-stem2+4;
		int[] stemOffset = {random.nextInt(2),random.nextInt(2)};
		if (stemOffset[1]==0) {
			if ((stem2&1)==1) stem1++;
			stem1 += stem2>>1;
			stem2 >>= 1;
		}
		stemOffset[1] += stemOffset[0];
		int offset = random.nextInt(4);
		int xOff = (offset&1)==1?0:(1-offset);
		int zOff = (offset&1)==0?0:(2-offset);
		int[] coordOffset = {xOff*stemOffset[0],zOff*stemOffset[0],xOff*stemOffset[1],zOff*stemOffset[1]};


		//trunk check
		int blockId;
		for (int i=0;i<stem1;i++) {
			blockId = world.getBlockId(x, y+i, z);
			if (!(blockId == 0 || blockId == this.leavesID)) return false;
		}
		for (int i=0;i<stem2;i++) {
			blockId = world.getBlockId(x + coordOffset[0], y+stem1+i, z + coordOffset[1]);
			if (!(blockId == 0 || blockId == this.leavesID)) return false;
		}
		for (int i=0;i<stem3;i++) {
			blockId = world.getBlockId(x + coordOffset[2], y+stem1+stem2+i, z + coordOffset[3]);
			if (!(blockId == 0 || blockId == this.leavesID)) return false;
		}

		//leaves check
		int lx = x + coordOffset[2];
		int ly = y + treeHeight+4-1;
		int lz = z + coordOffset[3];
		for (int dy = -1;dy <= 1;dy+=2 ) {
			for (int dx = -1; dx <= 1; dx += 2) {
				for (int dz = -1; dz <= 1; dz += 2) {
					blockId = world.getBlockId(lx+dx, ly+dy, lz+dz);
					if (!(blockId == 0 || blockId == this.leavesID)) return false;
					world.getBlockId(lx+2*dx, ly+dy, lz+dz);
					if (!(blockId == 0 || blockId == this.leavesID)) return false;
					world.getBlockId(lx+2*dx, ly+dy, lz+2*dz);
					if (!(blockId == 0 || blockId == this.leavesID)) return false;
					world.getBlockId(lx+dx, ly+dy, lz+2*dz);
					if (!(blockId == 0 || blockId == this.leavesID)) return false;
				}
			}
		}
		for (int dx = -1; dx <= 1; dx++) {
			for (int dz = -1; dz <= 1; dz++) {
				if (dx==0&&dz==0) continue;
				blockId = world.getBlockId(lx+dx, ly, lz+dz);
				if (!(blockId == 0 || blockId == this.leavesID)) return false;
			}
		}
		blockId = world.getBlockId(lx, ly+1, lz);
		if (!(blockId == 0 || blockId == this.leavesID)) return false;

		//gen tree
		WorldFeatureTree.onTreeGrown(world, x, y, z);

		//gen trunk
		for (int i=0;i<stem1;i++) {
			world.setBlockWithNotify(x, y+i, z,logID);
		}
		for (int i=0;i<stem2;i++) {
			world.setBlockWithNotify(x + coordOffset[0], y+stem1+i, z + coordOffset[1],logID);
		}
		for (int i=0;i<stem3;i++) {
			world.setBlockWithNotify(x + coordOffset[2], y+stem1+stem2+i, z + coordOffset[3],logID);
		}

		//gen leaves
		for (int dy = -1;dy <= 1;dy+=2 ) {
			for (int dx = -1; dx <= 1; dx += 2) {
				for (int dz = -1; dz <= 1; dz += 2) {
					world.setBlockWithNotify(lx+dx,ly+dy,lz+dz,this.leavesID);
					world.setBlockWithNotify(lx+dx*2,ly+dy,lz+dz*2,this.leavesID);
					if (random.nextBoolean()) {
						world.setBlockWithNotify(lx+2*dx, ly+dy, lz+dz,this.leavesID);
						if (random.nextBoolean()) world.setBlockWithNotify(lx+dx, ly+dy, lz+2*dz,this.leavesID);
					} else {
						world.setBlockWithNotify(lx+dx, ly+dy, lz+2*dz,this.leavesID);
						if (random.nextBoolean()) world.setBlockWithNotify(lx+2*dx, ly+dy, lz+dz,this.leavesID);
					}
					if (random.nextBoolean()) world.setBlockWithNotify(lx+dx*2,ly+2*dy,lz+dz*2,this.leavesID);
 				}
			}
		}
		for (int dx = -1; dx <= 1; dx++) {
			for (int dz = -1; dz <= 1; dz++) {
				if (dx==0&&dz==0) continue;
				if (dx == dz) {
					if (random.nextBoolean()) world.setBlockWithNotify(lx+dx*3,ly+1,lz+dz*2,this.leavesID);
					if (random.nextBoolean()) world.setBlockWithNotify(lx+dx*2,ly+1,lz+dz*3,this.leavesID);
				}
				world.setBlockWithNotify(lx+dx,ly,lz+dz,this.leavesID);
			}
		}
		world.setBlockWithNotify(lx,ly+1,lz,this.leavesID);

		return true;
    }
}
