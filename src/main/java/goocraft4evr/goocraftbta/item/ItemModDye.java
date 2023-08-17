package goocraft4evr.goocraftbta.item;

import goocraft4evr.goocraftbta.GoocraftBTA;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.animal.EntitySheep;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.helper.TextureHelper;

public class ItemModDye extends Item {
    public static String[] dyeColors = {"crimson","maroon","ash.gray","olive"};
    private static int dyeIndex;

    //this method ensures all dye textures are contiguous
    public static Item createDyes(String name, int id) {
        //define main coords and register first texture
        int[] mainCoords = TextureHelper.getOrCreateItemTexture(GoocraftBTA.MOD_ID, getTextureName(dyeColors[0])+"_dye.png");
        //save the icon index for later
        dyeIndex = Item.iconCoordToIndex(mainCoords[0],mainCoords[1]);
        for (int i=1;i<dyeColors.length;i++) {
            TextureHelper.getOrCreateItemTexture(GoocraftBTA.MOD_ID, getTextureName(dyeColors[i])+"_dye.png");
        }
        //once that's done we just create the item lol
        ItemModDye item = new ItemModDye(name, id);
        item.setIconIndex(dyeIndex);
        item.setKey(HalpLibe.addModId(GoocraftBTA.MOD_ID, name));
        return item;
    }

    public static String getTextureName(String dyeName) {
        return dyeName.replace('.','_');
    }

    public ItemModDye(String name, int id) {
        super(name, id);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    public String getLanguageKey(ItemStack itemstack) {
        return super.getKey() + "." + dyeColors[itemstack.getMetadata()];
    }

    @Override
    public int getIconFromDamage(int id) {
        return dyeIndex+id;
    }

    @Override
    public boolean useItemOnEntity(ItemStack itemstack, EntityLiving entityliving, EntityPlayer entityPlayer) {
        if (entityliving instanceof EntitySheep) {
            EntitySheep entitysheep = (EntitySheep)entityliving;
            int dyeid = 16+itemstack.getMetadata(); //the +16 accounts for the vanilla dyes
            if (entitysheep.getFleeceColor() != dyeid && itemstack.consumeItem(entityPlayer)) {
                entitysheep.setFleeceColor(dyeid);
                return true;
            }
        }
        return false;
    }
}
