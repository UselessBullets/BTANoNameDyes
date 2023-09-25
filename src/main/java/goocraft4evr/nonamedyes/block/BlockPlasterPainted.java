package goocraft4evr.nonamedyes.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockPlasterPainted extends Block {
    public BlockPlasterPainted(String key, int id) {
        super(key, id, Material.stone);
    }

    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        if (dropCause != EnumDropCause.IMPROPER_TOOL) {
            return new ItemStack[]{new ItemStack(this,1,meta)};
        }
        return null;
    }

    public static int getMetadataForColour(int i) {
        return i;
    }
}
