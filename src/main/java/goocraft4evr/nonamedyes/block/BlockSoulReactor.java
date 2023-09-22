package goocraft4evr.nonamedyes.block;

import goocraft4evr.nonamedyes.block.entity.TileEntitySoulReactor;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

public class BlockSoulReactor extends BlockTileEntity {
    public BlockSoulReactor(String key, int id) {
        super(key,id,Material.stone);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntitySoulReactor();
    }
}
