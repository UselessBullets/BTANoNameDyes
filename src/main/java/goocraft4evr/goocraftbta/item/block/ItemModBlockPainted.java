package goocraft4evr.goocraftbta.item.block;

import goocraft4evr.goocraftbta.item.ItemModDye;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;

public class ItemModBlockPainted extends ItemBlock {
    private boolean upperMetadata;

    public ItemModBlockPainted(Block block) {
        this(block,false);
    }

    public ItemModBlockPainted(Block block, boolean upperMetadata) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.upperMetadata = upperMetadata;
    }

    @Override
    public int getPlacedBlockMetadata(int i) {
        return i;
    }

    @Override
    public String getLanguageKey(ItemStack itemstack) {
        String langkey = super.getKey() + ".";
        try {
            langkey += upperMetadata? ItemModDye.dyeColors[(itemstack.getMetadata()) >> 4]: ItemModDye.dyeColors[(itemstack.getMetadata())];
        } catch (ArrayIndexOutOfBoundsException e) {
            langkey += "meta"+itemstack.getMetadata();
        }
        return langkey;
    }
}
