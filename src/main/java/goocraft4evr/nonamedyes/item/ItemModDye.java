package goocraft4evr.nonamedyes.item;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.TextureMap;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntitySign;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.animal.EntitySheep;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.command.TextFormatting;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import turniplabs.halplibe.HalpLibe;

public class ItemModDye extends Item {
    public static String[] dyeColors = {
            "crimson",
            "maroon",
            "ash.gray",
            "olive",
            "ochre",
            "buff",
            "verdigris",
            "light.yellow",
            "indigo",
            "xanthic",
            "cinnamon",
            "navy.blue",
			"royal.purple"};
    public static final int NUM_DYES = dyeColors.length;
    private static TextureMap textures;

    //this method ensures all dye textures are contiguous
    public static Item createDyes(String name, int id) {
        textures = new TextureMap(NoNameDyes.MOD_ID,dyeColors.length);
        for (int i = 0; i< textures.length(); i++) {
            //generate textures for the remaining dyes to ensure they're all contiguous
            textures.addItemTexture(getTextureName(dyeColors[i])+"_dye.png");
        }
        //once that's done we just create the item lol
        ItemModDye item = new ItemModDye(name, id);
        item.setKey(HalpLibe.addModId(NoNameDyes.MOD_ID, name));
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
        return super.getKey() + "." + dyeColors[itemstack.getMetadata()%dyeColors.length];
    }

    @Override
    public int getIconFromDamage(int id) {
        return textures.getTexture(id);
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
        if (world.getBlockId(blockX, blockY, blockZ) == Block.signPostPlanksOak.id || world.getBlockId(blockX, blockY, blockZ) == Block.signWallPlanksOak.id) {
            TileEntitySign sign = (TileEntitySign) world.getBlockTileEntity(blockX, blockY, blockZ);
            //TODO: this will break if signs can have obfuscated text
            if (16+itemstack.getMetadata() != sign.getColor().id) {
                sign.setColor(TextFormatting.get(16 + itemstack.getMetadata()));
                if (entityplayer.getGamemode().consumeBlocks()) --itemstack.stackSize;
                return true;
            }
        }
        return false;
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
