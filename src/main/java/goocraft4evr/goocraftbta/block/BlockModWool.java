package goocraft4evr.goocraftbta.block;

import goocraft4evr.goocraftbta.GoocraftBTA;
import goocraft4evr.goocraftbta.TextureMap;
import goocraft4evr.goocraftbta.item.ItemModDye;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.TextureHelper;

public class BlockModWool extends Block {
    private static TextureMap textures;

    public static Block createWool(String key, int id) {
        textures = new TextureMap(GoocraftBTA.MOD_ID,ItemModDye.dyeColors.length);
        for (int i = 0; i< textures.length(); i++) {
            //generate textures for the remaining dyes to ensure they're all contiguous
            textures.addBlockTexture( ItemModDye.getTextureName(ItemModDye.dyeColors[i])+"_wool.png");
        }
        return new BlockModWool(key,id);
    }

    public BlockModWool(String key, int id) {
        super(key, id, Material.cloth);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
        return textures.getTexture(meta);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(this, 1, meta)};
    }

    public static int getMetadataForColour(int i) {
        return i;
    }
}
