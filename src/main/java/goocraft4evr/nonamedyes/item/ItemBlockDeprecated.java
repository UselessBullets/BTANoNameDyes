package goocraft4evr.nonamedyes.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.world.World;

public class ItemBlockDeprecated extends ItemBlock {
	private Block alt;
	public ItemBlockDeprecated(Block block, Block alt) {
		super(block);
		this.alt = alt;
	}

	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		itemstack.itemID = alt.id;
	}
}
