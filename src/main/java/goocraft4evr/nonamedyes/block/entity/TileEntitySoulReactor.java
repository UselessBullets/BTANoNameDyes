package goocraft4evr.nonamedyes.block.entity;

import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.sound.SoundType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TileEntitySoulReactor extends TileEntity {
    private int killCount = 0;
    @Override
    public void updateEntity() {
        if (!worldObj.isClientSide&&
            worldObj.dimension == Dimension.nether) {
            List<Entity> list = this.worldObj.getEntitiesWithinAABB(Entity.class,
                    AABB.getBoundingBoxFromPool(xCoord-3, yCoord-3, zCoord-3, xCoord+3, yCoord+3, zCoord+3));
            if (!list.isEmpty()) {
                for (Entity e : list) {
                    if (!(e instanceof EntityLiving)) continue;
                    EntityLiving entity = (EntityLiving)e;
                    //hacky way to determine if entity just died
                    if (entity.deathTime==1) {
                        onEntityKilled(++killCount);
                    }
                }
            }
        }
    }

    private void onEntityKilled(int i) {
        if (i==1) {
            worldObj.setBlockWithNotify(xCoord,yCoord,zCoord,0);
            generateNetherrack(worldObj,worldObj.rand,xCoord,yCoord-1,zCoord);
            worldObj.playSoundEffect(SoundType.WORLD_SOUNDS,xCoord,yCoord,zCoord,"random.explode",1.0f,1.0f);
            double particleX = xCoord+0.5;
            double particleY = yCoord+0.5;
            double particleZ = zCoord+0.5;
            double motionY = 0.0f;
            double motionZ = 0.0f;
            double motionX = 0.0f;
            worldObj.spawnParticle("smoke", particleX,particleY,particleZ,motionX,motionY,motionZ);
            worldObj.spawnParticle("explode", xCoord,yCoord,zCoord,motionX,motionY,motionZ);
            worldObj.removeBlockTileEntity(xCoord,yCoord,zCoord);
            return;
        }
        worldObj.playSoundEffect(SoundType.WORLD_SOUNDS,xCoord,yCoord,zCoord,"random.fizz",1.0f,0.2f);
    }

    //this could be a world feature if I weren't lazy
    private void generateNetherrack(World world, Random random, int x, int y, int z) {
        int minrad = 1;
        int maxrad = 3;
        int mindepth = 2;
        int maxdepth = 5;
        int minradX = -minrad - random.nextInt(maxrad+1-minrad);
        int maxradX = minrad + random.nextInt(maxrad+1-minrad);
        int minradZ = -minrad - random.nextInt(maxrad+1-minrad);
        int maxradZ = minrad + random.nextInt(maxrad+1-minrad);
        int dist = Arrays.stream(new int[]{-minradX,-minradZ,maxradX,maxradZ}).max().getAsInt();
        int depth = mindepth+ random.nextInt(maxdepth+1-mindepth);
        for (int ix = minradX;ix <= maxradX;ix++) {
            for (int iz=minradZ;iz<=maxradZ;iz++) {
                int taxicab = Math.abs(ix)+Math.abs(iz);
                if (taxicab > dist) continue;
                int d = (dist-taxicab)*depth/dist+random.nextInt(3);
                for (int iy=random.nextInt(2)+random.nextInt(2);iy>=-d;iy--) {
                    if (world.getBlockId(x+ix,y+iy,z+iz) != Block.netherrack.id) continue;
                    world.setBlockWithNotify(x+ix,y+iy,z+iz,ModBlocks.netherrackVile.id);
                }
            }
        }
    }
}
