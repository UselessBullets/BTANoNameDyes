package goocraft4evr.nonamedyes.block.cocoa;

import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockLogCocoaRipe extends Block {

    public BlockLogCocoaRipe(String key, int id) {
        super(key, id, Material.wood);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK: {
                return new ItemStack[]{new ItemStack(this)};
            }
        }
        return new ItemStack[]{new ItemStack(ModBlocks.logCocoa), new ItemStack(Item.dye, 2 +  world.rand.nextInt(6), 3)};
    }
}
