package goocraft4evr.goocraftbta.block;

import goocraft4evr.goocraftbta.GoocraftBTA;
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
    private static int woolIndex;

    public static Block createWool(String key, int id) {
        //define main coords and register first texture
        int[] mainCoords = TextureHelper.getOrCreateBlockTexture(GoocraftBTA.MOD_ID, ItemModDye.getTextureName(ItemModDye.dyeColors[0])+"_wool.png");
        //save the icon index for later
        woolIndex = Item.iconCoordToIndex(mainCoords[0],mainCoords[1]);
        for (int i = 1; i< ItemModDye.dyeColors.length; i++) {
            //generate textures for the remaining dyes to ensure they're all contiguous
            TextureHelper.getOrCreateBlockTexture(GoocraftBTA.MOD_ID, ItemModDye.getTextureName(ItemModDye.dyeColors[i])+"_wool.png");
        }
        Block block = new BlockModWool(key,id);
        for (int i=0;i<6;i++) block.atlasIndices[i] = woolIndex;
        return block;
    }

    public BlockModWool(String key, int id) {
        super(key, id, Material.cloth);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
        return woolIndex+meta;
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(this, 1, meta)};
    }

    public static int getMetadataForColour(int i) {
        return i;
    }
}
