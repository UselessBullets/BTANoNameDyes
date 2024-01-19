package goocraft4evr.nonamedyes.item;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.helper.ModColors;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
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
