package goocraft4evr.nonamedyes.item;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.helper.ModColors;
import net.minecraft.core.block.*;
import net.minecraft.core.block.entity.TileEntitySign;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.command.TextFormatting;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.season.Seasons;
import net.minecraft.core.world.type.WorldTypes;
import turniplabs.halplibe.helper.TextureHelper;
import useless.prismaticlibe.ColoredTexture;
import useless.prismaticlibe.IColored;

import java.awt.Color;

public class ItemPaintedPlaster extends Item implements IColored {
	private final int[] base =  TextureHelper.getOrCreateItemTexture(NoNameDyes.MOD_ID, "painted_wet_plaster.png");

	public ItemPaintedPlaster(int id) {
		super(id);
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
        int blockId = world.getBlockId(blockX, blockY, blockZ);
		if (blockId == Block.mud.id) {
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX,blockY,blockZ, ModBlocks.plasterPainted.id,itemstack.getMetadata());
				if (entityplayer.getGamemode().consumeBlocks()) {
					--itemstack.stackSize;
				}
			}
            return true;
        }
		return false;
	}

	@Override
	public String getLanguageKey(ItemStack itemstack) {
		int meta = itemstack.getMetadata();
		return super.getKey() + "." + (meta>15?ItemModDye.dyeColors[meta-16]: ItemDye.dyeColors[15-meta]);
	}

	@Override
	public ColoredTexture[] getTextures(ItemStack itemstack) {
		return new ColoredTexture[]{
			new ColoredTexture(base, new Color(ModColors.allPlasterColors[itemstack.getMetadata()].value))};
	}
}
