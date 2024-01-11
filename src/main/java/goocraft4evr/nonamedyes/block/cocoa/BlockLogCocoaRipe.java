package goocraft4evr.nonamedyes.block.cocoa;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogCocoaRipe extends Block {

    public BlockLogCocoaRipe(String key, int id) {
        super(key, id, Material.wood);
    }
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		updateTick(world, x, y, z, null);
	}
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		updateTick(world, x, y, z, null);
	}
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		world.setBlockWithNotify(x, y, z, Block.logOakMossy.id);
	}
}
