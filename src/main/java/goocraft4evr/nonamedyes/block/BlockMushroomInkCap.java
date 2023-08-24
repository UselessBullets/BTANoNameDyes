package goocraft4evr.nonamedyes.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockMushroom;
import net.minecraft.core.world.World;
import net.minecraft.core.world.weather.Weather;

import java.util.Random;

public class BlockMushroomInkCap extends BlockMushroom {
    public BlockMushroomInkCap(String key, int id) {
        super(key, id);
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        if (y < 0 || y >= world.getHeightBlocks()) {
            return false;
        }
        return world.getFullBlockLightValue(x, y, z) > 9 && canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z));
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        int blockX,blockY,blockZ;
        if (world.isAirBlock(blockX = x + rand.nextInt(3) - 1,
                             blockY = y + rand.nextInt(2) - rand.nextInt(2),
                             blockZ = z + rand.nextInt(3) - 1)
            && canBlockStay(world, blockX, blockY, blockZ)) {
            int spawnChance = 75;
            if (isAdjacentToPath(world,blockX,blockY,blockZ)) spawnChance >>= 2;
            if (world.getCurrentWeather()== Weather.overworldRain) spawnChance >>= 1;
            if (rand.nextInt(spawnChance)==0) {
                world.setBlockWithNotify(blockX, blockY, blockZ, id);
            }
        }
    }

    private boolean isPath(World world, int blockX, int blockY, int blockZ) {
        int blockId = world.getBlockId(blockX,blockY-1,blockZ);
        return blockId == Block.gravel.id ||
                blockId == Block.pathDirt.id ||
                world.getBlockId(blockX,blockY,blockZ) == Block.overlayPebbles.id;
    }

    private boolean isAdjacentToPath(World world, int blockX, int blockY, int blockZ) {
        return !isPath(world,blockX,blockY,blockZ)&&(
                    isPath(world,blockX+1,blockY,blockZ)||
                    isPath(world,blockX,blockY,blockZ+1)||
                    isPath(world,blockX-1,blockY,blockZ)||
                    isPath(world,blockX,blockY,blockZ-1)
                );
    }
}
