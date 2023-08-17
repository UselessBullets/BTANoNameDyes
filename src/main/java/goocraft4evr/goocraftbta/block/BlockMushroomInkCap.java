package goocraft4evr.goocraftbta.block;

import net.minecraft.core.block.BlockMushroom;
import net.minecraft.core.world.World;

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
}
