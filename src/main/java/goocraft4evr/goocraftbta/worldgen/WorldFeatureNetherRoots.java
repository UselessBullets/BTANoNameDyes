package goocraft4evr.goocraftbta.worldgen;

import goocraft4evr.goocraftbta.GoocraftBTA;
import goocraft4evr.goocraftbta.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureNetherRoots extends WorldFeature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        //ensure proper spawning conditions
        if (world.isAirBlock(x,y,z)&&world.getBlockId(x,y-1,z) == Block.netherrack.id) {
            GoocraftBTA.LOGGER.info(String.format("Root at %d,%d,%d",x,y,z));
            //create starting block
            world.setBlock(x,y,z, ModBlocks.netherRoots.id);
            int max = 128+random.nextInt(384);
            for (int i=0;i<max;i++) {
                //pick a random direction
                int dir = random.nextInt(4);
                int dx=0,dz=0;
                switch(dir) {
                    case 0: dz++; break;
                    case 1: dx++; break;
                    case 2: dz--; break;
                    case 3: dx--; break;
                }
                //check if you can move in the direction
                if (world.isAirBlock(x+dx,y,z+dz)||world.getBlockId(x+dz,y,z+dz)== ModBlocks.netherRoots.id) {
                    x += dx;
                    z += dz;
                    if (world.isAirBlock(x,y,z)) {
                        if (world.getBlockId(x,y-1,z)==Block.netherrack.id||
                                (world.isAirBlock(x,--y,z)&&world.getBlockId(x,y-1,z)==Block.netherrack.id)) {
                            int ncount = 0;
                            if (dir==3||dir==0) ncount += world.getBlockId(x-1,y,z+1)== ModBlocks.netherRoots.id?1:0;
                            if (dir==0||dir==1) ncount += world.getBlockId(x+1,y,z+1)== ModBlocks.netherRoots.id?1:0;
                            if (dir==1||dir==2) ncount += world.getBlockId(x+1,y,z-1)== ModBlocks.netherRoots.id?1:0;
                            if (dir==2||dir==3) ncount += world.getBlockId(x-1,y,z-1)== ModBlocks.netherRoots.id?1:0;
                            if (ncount<2) {
                                world.setBlock(x,y,z, ModBlocks.netherRoots.id);
                                continue;
                            }
                        } else y++;
                        x -= dx;
                        z -= dz;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
