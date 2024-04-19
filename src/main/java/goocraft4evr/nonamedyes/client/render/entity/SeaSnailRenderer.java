package goocraft4evr.nonamedyes.client.render.entity;

import goocraft4evr.nonamedyes.client.render.model.ModelSeaSnail;
import goocraft4evr.nonamedyes.entity.animal.EntitySeaSnail;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.FontRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.client.render.model.ModelCreeper;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.monster.EntityCreeper;
import net.minecraft.core.util.helper.MathHelper;
import org.lwjgl.opengl.GL11;

public class SeaSnailRenderer extends LivingRenderer<EntitySeaSnail> {

	public SeaSnailRenderer() {
		super(new ModelSeaSnail(), 0.7f);
	}
}
