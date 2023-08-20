package goocraft4evr.goocraftbta.block;

import goocraft4evr.goocraftbta.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockOreMalachite extends Block {
    public BlockOreMalachite(String key, int id) {
        super(key, id, Material.stone);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK: {
                return new ItemStack[]{new ItemStack(this)};
            }
            case PROPER_TOOL: {
                return new ItemStack[]{new ItemStack(ModItems.dye, 4 + world.rand.nextInt(5), 6)};
            }
        }
        return null;
    }
}
