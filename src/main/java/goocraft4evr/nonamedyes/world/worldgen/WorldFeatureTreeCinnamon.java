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

    private boolean validateCol(World world, int x, int y, int z, int height) {
        for (int i=0;i<height;i++) {
            int blockId = world.getBlockId(x, y+i, z);
            if (!(blockId == 0 || blockId == this.leavesID)) return false;
        }
        return true;
    }

    private boolean validateLeaves(World world,int x, int y, int z) {
        //check upper layer
        int blockId = world.getBlockId(x,y,z);
        if (!(blockId==0 || blockId==leavesID)) return false;
        for (int i=-1;i<2;i+=2) {
            blockId = world.getBlockId(x+i,y,z);
            if (!(blockId==0 || blockId==leavesID)) return false;
            blockId = world.getBlockId(x,y,z+i);
            if (!(blockId==0 || blockId==leavesID)) return false;
        }
        //check middle layer
        for (int i=-1;i<2;i++) {
            for (int j=-1;j<2;j++) {
                if (i==0&&j==0) continue;
                blockId = world.getBlockId(x+i,y-1,z+j);
                if (!(blockId==0 || blockId==leavesID)) return false;
            }
        }
        //lower layers are optional
        return true;
    }

    private void generateLeaves(World world, Random random, int x, int y, int z) {
        world.setBlockWithNotify(x, y, z, leavesID);
        for (int i=-1;i<2;i+=2) if (random.nextBoolean()) world.setBlockWithNotify(x+i,y,z, leavesID);
        for (int i=-1;i<2;i+=2) if (random.nextBoolean()) world.setBlockWithNotify(x,y,z+i, leavesID);
        for (int i=-1;i<2;i+=2) {
            for (int j=-1;j<2;j+=2) {
                if (random.nextBoolean()) {
                    generateLeafCol(world,x+i,y-1,z+j,1+random.nextInt(3));
                }
            }
        }
        for (int i=-1;i<2;i+=2) generateLeafCol(world,x+i,y-1,z,2+random.nextInt(4));
        for (int i=-1;i<2;i+=2) generateLeafCol(world,x,y-1,z+i,2+random.nextInt(4));
    }

    private void generateLeafCol(World world, int x, int y, int z, int len) {
        int blockId;
        for (int i=0;i<len;i++) {
            blockId = world.getBlockId(x,y-i,z);
            if (!(blockId==0 || blockId==leavesID)) break;
            else world.setBlockWithNotify(x, y-i, z, leavesID);
        }
    }

    //there's probably a better way to write this.
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        int treeHeight = random.nextInt(5) + 6;
        //make sure the tree fits within the world
        if (y < 1 || y + treeHeight + 1 >= world.getHeightBlocks())  return false;
        //check the tree can grow here
        int idBelow = world.getBlockId(x, y - 1, z);
        if (!Block.hasTag(idBelow, BlockTags.GROWS_TREES)) return false;
        //validate layer 0
        int baseHeight = 1+random.nextInt(3);
        if (!validateCol(world,x,y,z,baseHeight)) return false;
        //validate other layers
        boolean xAligned = random.nextBoolean();
        int l1logs = 3 - random.nextInt(3);
        int l2logs = random.nextInt(16);
        int l1h1=0,l1h2=0,l2h1=0,l2h2=0,l2h3=0,l2h4=0;
        int x1,y1,z1;
        if ((l1logs&1)==1) {
            l1h1 = 2+random.nextInt(3);
            if (l1h1 > treeHeight-baseHeight) l1h1 = treeHeight-baseHeight;
            if (xAligned) {
                x1 = x+1;
                z1 = z;
            }
            else {
                x1 = x;
                z1 = z+1;
            }
            y1 = y+baseHeight;
            if (!validateCol(world,x1,y1,z1,l1h1)) return false;
            y1 += l1h1;
            if (l1h1 == treeHeight-baseHeight) {
                l2logs &= 12;
                if (!validateLeaves(world,x1,y1,z1)) return false;
            }
            if ((l2logs&1)==1) {
                l2h1 = 1+random.nextInt(3);
                if (l2h1 > treeHeight-baseHeight-l1h1) l2h1 = treeHeight-baseHeight-l1h1;
                x1 = x+1;
                z1 = z+1;
                if (!validateCol(world,x1,y1,z1,l2h1)) return false;
                if (!validateLeaves(world,x1,y1+l2h1,z1)) return false;
            }
            if ((l2logs&2)==2) {
                l2h2 = 1+random.nextInt(3);
                if (l2h2 > treeHeight-baseHeight-l1h1) l2h2 = treeHeight-baseHeight-l1h1;
                if (xAligned) {
                    x1 = x+1;
                    z1 = z-1;
                }
                else {
                    x1 = x-1;
                    z1 = z+1;
                }
                if (!validateCol(world,x1,y1,z1,l2h2)) return false;
                if (!validateLeaves(world,x1,y1+l2h2,z1)) return false;
            }
        }
        if ((l1logs&2)==2) {
            l1h2 = 2+random.nextInt(3);
            if (l1h2 > treeHeight-baseHeight) l1h2 = treeHeight-baseHeight;
            if (xAligned) {
                x1 = x-1;
                z1 = z;
            }
            else {
                x1 = x;
                z1 = z-1;
            }
            y1 = y+baseHeight;
            if (!validateCol(world,x1,y1,z1,l1h2)) return false;
            y1 += l1h2;
            if (l1h2 == treeHeight-baseHeight) {
                l2logs &= 3;
                if (!validateLeaves(world,x1,y1,z1)) return false;
            }
            if ((l2logs&4)==4) {
                l2h3 = 1+random.nextInt(3);
                if (l2h3 > treeHeight-baseHeight-l1h2) l2h3 = treeHeight-baseHeight-l1h2;
                if (xAligned) {
                    x1 = x-1;
                    z1 = z+1;
                }
                else {
                    x1 = x+1;
                    z1 = z-1;
                }
                if (!validateCol(world,x1,y1,z1,l2h3)) return false;
                if (!validateLeaves(world,x1,y1+l2h3,z1)) return false;
            }
            if ((l2logs&8)==8) {
                l2h4 = 1+random.nextInt(3);
                if (l2h4 > treeHeight-baseHeight-l1h2) l2h4 = treeHeight-baseHeight-l1h2;
                x1 = x-1;
                z1 = z-1;
                if (!validateCol(world,x1,y1,z1,l2h4)) return false;
                if (!validateLeaves(world,x1,y1+l2h4,z1)) return false;
            }
        }
        //if you get past the clusterfuck it means the tree can generate, yay!
        WorldFeatureTree.onTreeGrown(world, x, y, z);
        for (int i=0;i<baseHeight;i++) world.setBlockWithNotify(x, y + i, z, logID);
        if ((l1logs&1)==1) {
            if (xAligned) {
                x1 = x+1;
                z1 = z;
            }
            else {
                x1 = x;
                z1 = z+1;
            }
            y1 = y+baseHeight;
            for (int i=0;i<l1h1;i++) world.setBlockWithNotify(x1, y1 + i, z1, logID);
            y1 += l1h1;
            if ((l2logs&3)==0) {
                generateLeaves(world,random,x1,y1,z1);
            } else {
                if ((l2logs&1)==1) {
                    x1 = x+1;
                    z1 = z+1;
                    for (int i=0;i<l2h1;i++) world.setBlockWithNotify(x1, y1 + i, z1, logID);
                    generateLeaves(world,random,x1,y1+l2h1,z1);
                }
                if ((l2logs&2)==2) {
                    if (xAligned) {
                        x1 = x+1;
                        z1 = z-1;
                    }
                    else {
                        x1 = x-1;
                        z1 = z+1;
                    }
                    for (int i=0;i<l2h2;i++) world.setBlockWithNotify(x1, y1 + i, z1, logID);
                    generateLeaves(world,random,x1,y1+l2h2,z1);
                }
            }
        }
        if ((l1logs&2)==2) {
            if (xAligned) {
                x1 = x-1;
                z1 = z;
            }
            else {
                x1 = x;
                z1 = z-1;
            }
            y1 = y+baseHeight;
            for (int i=0;i<l1h2;i++) world.setBlockWithNotify(x1, y1 + i, z1, logID);
            y1 += l1h2;
            if ((l2logs&12)==0) {
                generateLeaves(world,random,x1,y1,z1);
            } else {
                if ((l2logs&4)==4) {
                    if (xAligned) {
                        x1 = x-1;
                        z1 = z+1;
                    }
                    else {
                        x1 = x+1;
                        z1 = z-1;
                    }
                    for (int i=0;i<l2h3;i++) world.setBlockWithNotify(x1, y1 + i, z1, logID);
                    generateLeaves(world,random,x1,y1+l2h3,z1);
                }
                if ((l2logs&8)==8) {
                    x1 = x-1;
                    z1 = z-1;
                    for (int i=0;i<l2h4;i++) world.setBlockWithNotify(x1, y1 + i, z1, logID);
                    generateLeaves(world,random,x1,y1+l2h4,z1);
                }
            }
        }
        return true;
    }
}
