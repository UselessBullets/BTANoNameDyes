package goocraft4evr.nonamedyes.client.render.model;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

public class ModelSeaSnail extends ModelBase {
	Cube[] body = new Cube[5];

	public ModelSeaSnail() {
		body[0] = new Cube(24, 0);
		body[0].addBox(0, -3+23, -8, 5, 3, 4);

		body[1] = new Cube(0, 10);
		body[1].addBox(-6, -12+23, -2, 12, 12, 10);

		body[2] = new Cube(0, 0);
		body[2].addBox(-3, -8+23, -4, 8, 8, 2);

		body[3] = new Cube(12, 2);
		body[3].addBox(0, -10+23, -17, 4, 4, 4);

		body[4] = new Cube(38, 0);
		body[4].addBox(-3, -11+23, -13, 8, 8, 5);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		for (int i=0;i<body.length;i++) {
			Cube cube = body[i];
			cube.rotateAngleY = headYaw / 57.29578f + (i>2 ? (float)Math.PI : 0);
		}
	}

	@Override
	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		setRotationAngles(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		for (Cube cube: body) {
			cube.render(scale);
		}
	}
}
