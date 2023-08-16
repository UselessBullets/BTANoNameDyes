package goocraft4evr.goocraftbta.block.wood;

import net.minecraft.core.block.BlockChest;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BlockModChestPainted extends BlockChest {

    public BlockModChestPainted(String key, int id, Material material) {
        super(key, id, material);
    }

    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(this, 1, meta)};
    }

    public int getBlockTexture(WorldSource blockAccess, int x, int y, int z, Side side) {
        return super.getBlockTexture(blockAccess, x, y, z, side) + texCoordToIndex(-9, 16);
    }

    public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
        return super.getBlockTextureFromSideAndMetadata(side, meta) + texCoordToIndex(-9, 16);
    }

    public static int getMetaForDyeColor(int i) {
        return i << 4;
    }
}
