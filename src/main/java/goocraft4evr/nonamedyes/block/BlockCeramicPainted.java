package goocraft4evr.nonamedyes.block;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.TextureMap;
import goocraft4evr.nonamedyes.item.ItemModDye;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class BlockCeramicPainted extends Block {
    private static TextureMap textures;

    public BlockCeramicPainted(String key, int id, Material material, String path) {
        super(key, id, material);
        textures = new TextureMap(NoNameDyes.MOD_ID, ItemDye.dyeColors.length+ItemModDye.dyeColors.length);
        int idx = path.indexOf('*');
        String prefix = path.substring(0,idx);
        String postfix = path.substring(idx+1);
        for (int i = 0; i< ItemDye.dyeColors.length; i++) {
            //generate textures for the remaining dyes to ensure they're all contiguous
            textures.addBlockTexture( prefix+ItemDye.dyeColors[i^0xF]+postfix);
        }
        for (int i = 0; i< ItemModDye.dyeColors.length; i++) {
            //generate textures for the remaining dyes to ensure they're all contiguous
            textures.addBlockTexture( prefix+ItemModDye.getTextureName(ItemModDye.dyeColors[i])+postfix);
        }
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
        return textures.getTexture(meta);
    }

    @Override
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
