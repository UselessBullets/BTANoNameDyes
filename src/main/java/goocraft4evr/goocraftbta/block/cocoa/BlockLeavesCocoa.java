package goocraft4evr.goocraftbta.block.cocoa;

import goocraft4evr.goocraftbta.GoocraftBTA;
import goocraft4evr.goocraftbta.block.ModBlocks;
import goocraft4evr.goocraftbta.item.ItemModDye;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLeavesBase;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.helper.TextureHelper;

public class BlockLeavesCocoa extends BlockLeavesBase {

    public BlockLeavesCocoa(String key, int id) {
        super(key, id, Material.leaves, false);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(Side side, int j) {
        return !fancyGraphics ? this.atlasIndices[side.getId()] + 1 : this.atlasIndices[side.getId()];
    }

    @Override
    protected Block getSapling() {
        return ModBlocks.saplingCocoa;
    }
}
