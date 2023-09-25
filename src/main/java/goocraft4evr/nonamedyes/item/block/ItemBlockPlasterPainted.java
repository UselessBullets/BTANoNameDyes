package goocraft4evr.nonamedyes.item.block;

import goocraft4evr.nonamedyes.item.ItemModDye;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;

public class ItemBlockPlasterPainted extends ItemBlock {

    public ItemBlockPlasterPainted(Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getPlacedBlockMetadata(int i) {
        return i;
    }

    @Override
    public String getLanguageKey(ItemStack itemstack) {
        String langkey = super.getKey() + ".";
        try {
            langkey += itemstack.getMetadata() < 15? ItemDye.dyeColors[(itemstack.getMetadata())]:ItemModDye.dyeColors[(itemstack.getMetadata()-16)];
        } catch (ArrayIndexOutOfBoundsException e) {
            langkey += "meta"+itemstack.getMetadata();
        }
        return langkey;
    }
}
