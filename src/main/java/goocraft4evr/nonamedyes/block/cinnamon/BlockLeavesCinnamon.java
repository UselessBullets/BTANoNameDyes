package goocraft4evr.nonamedyes.block.cinnamon;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.TextureMap;
import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLeavesBase;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.helper.Side;

public class BlockLeavesCinnamon extends BlockLeavesBase {
    private static TextureMap textures;

    public BlockLeavesCinnamon(String key, int id) {
        super(key, id, Material.leaves, false);
        textures = new TextureMap(NoNameDyes.MOD_ID,2);
        textures.addBlockTexture("leaves_cinnamon_fancy.png");
        textures.addBlockTexture("leaves_cinnamon.png");
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(Side side, int j) {
        return textures.getTexture(!fancyGraphics ? 1 : 0);
    }

    @Override
    protected Block getSapling() {
        return ModBlocks.saplingCinnamon;
    }
}
