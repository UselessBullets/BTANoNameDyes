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
	private ModelBase model = new ModelSeaSnail();

	public SeaSnailRenderer() {
		super(new ModelSeaSnail(), 0.7f);
	}

	@Override
	protected boolean shouldRenderPass(EntitySeaSnail entity, int renderPass, float partialTick) {
        if (renderPass == 1) {
            float f1 = (float) entity.tickCount + partialTick;
            this.loadTexture("/armor/power.png");
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            float f2 = f1 * 0.01f;
            float f3 = f1 * 0.01f;
            GL11.glTranslatef(f2, f3, 0.0f);
            this.setRenderPassModel(model);
            GL11.glMatrixMode(5888);
            GL11.glEnable(3042);
            float f4 = 0.5f;
            GL11.glColor4f(f4, f4, f4, 1.0f);
            GL11.glDisable(2896);
            GL11.glBlendFunc(1, 1);
            return true;
        }
        if (renderPass == 2) {
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
        }
        return false;
	}

	@Override
	protected boolean shouldRenderPassB(EntitySeaSnail entity, int renderPass, float partialTick) {
		return false;
	}
}
