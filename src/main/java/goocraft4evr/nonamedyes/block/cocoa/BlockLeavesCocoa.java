package goocraft4evr.nonamedyes.block.cocoa;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.TextureMap;
import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLeavesBase;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.helper.Side;

public class BlockLeavesCocoa extends BlockLeavesBase {
    private static TextureMap textures;

    public BlockLeavesCocoa(String key, int id) {
        super(key, id, Material.leaves, false);
    }

    public static Block createBlock(String key, int id) {
        textures = new TextureMap(NoNameDyes.MOD_ID,2);
        textures.addBlockTexture("leaves_cocoa_fancy.png");
        textures.addBlockTexture("leaves_cocoa.png");
        return new BlockLeavesCocoa(key,id);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(Side side, int j) {
        return textures.getTexture(!fancyGraphics ? 1 : 0);
    }

    @Override
    protected Block getSapling() {
        return ModBlocks.saplingCocoa;
    }
}
