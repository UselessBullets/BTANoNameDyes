package goocraft4evr.nonamedyes.client.render.model;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;

public class ModelSeaSnail extends ModelBase {
	Cube squidBody;
	Cube[] squidTentacles = new Cube[8];

	public ModelSeaSnail() {
		int byte0 = -16;
		this.squidBody = new Cube(0, 0);
		this.squidBody.addBox(-6.0f, -8.0f, -6.0f, 12, 16, 12);
		this.squidBody.rotationPointY += (float)(24 + byte0);
		for (int i = 0; i < this.squidTentacles.length; ++i) {
			this.squidTentacles[i] = new Cube(48, 0);
			double d = (double)i * Math.PI * 2.0 / (double)this.squidTentacles.length;
			float f = (float)Math.cos(d) * 5.0f;
			float f1 = (float)Math.sin(d) * 5.0f;
			this.squidTentacles[i].addBox(-1.0f, 0.0f, -1.0f, 2, 18, 2);
			this.squidTentacles[i].rotationPointX = f;
			this.squidTentacles[i].rotationPointZ = f1;
			this.squidTentacles[i].rotationPointY = 31 + byte0;
			d = (double)i * Math.PI * -2.0 / (double)this.squidTentacles.length + 1.5707963267948966;
			this.squidTentacles[i].rotateAngleY = (float)d;
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		for (int i = 0; i < this.squidTentacles.length; ++i) {
			this.squidTentacles[i].rotateAngleX = limbPitch;
		}
	}

	@Override
	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.squidBody.render(scale);
		for (int i = 0; i < this.squidTentacles.length; ++i) {
			this.squidTentacles[i].render(scale);
		}
	}
}
