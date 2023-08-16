package goocraft4evr.goocraftbta.item.block;

import goocraft4evr.goocraftbta.item.ItemModDye;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlockSlab;

public class ItemModBlockSlabPainted extends ItemBlockSlab {
    private boolean upperMetadata;

    public ItemModBlockSlabPainted(Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.upperMetadata = true;
    }

    public int getPlacedBlockMetadata(int i) {
        return i;
    }

    @Override
    public String getLanguageKey(ItemStack itemstack) {
        String langkey = super.getKey() + ".";
        try {
            langkey += ItemModDye.dyeColors[(itemstack.getMetadata()) >> 4];
        } catch (ArrayIndexOutOfBoundsException e) {
            langkey += "unknown";
        }
        return langkey;
    }
}