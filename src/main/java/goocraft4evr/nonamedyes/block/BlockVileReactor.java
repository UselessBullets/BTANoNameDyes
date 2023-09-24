package goocraft4evr.nonamedyes.block;

import goocraft4evr.nonamedyes.block.entity.TileEntityVileReactor;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockVileReactor extends BlockTileEntity {
    public BlockVileReactor(String key, int id) {
        super(key,id,Material.stone);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityVileReactor();
    }

    public static void updateReactorBlockState(World world, int x, int y, int z) {
        TileEntity tileentity = world.getBlockTileEntity(x,y,z);
        int blockId = world.getBlockId(x,y,z);
        if (blockId == ModBlocks.vileReactorActive.id) {
            world.setBlockWithNotify(x, y, z, ModBlocks.vileReactorVeryActive.id);
        } else if (blockId == ModBlocks.vileReactorIdle.id) {
            world.setBlockWithNotify(x, y, z, ModBlocks.vileReactorActive.id);
        }
        tileentity.validate();
        world.setBlockTileEntity(x,y,z,tileentity);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case PICK_BLOCK:
            case PROPER_TOOL:
            case SILK_TOUCH: {
                return new ItemStack[]{new ItemStack(ModBlocks.vileReactorIdle)};
            }
        }
        return null;
    }
}
