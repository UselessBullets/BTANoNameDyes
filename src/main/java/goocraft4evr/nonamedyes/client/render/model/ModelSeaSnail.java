package goocraft4evr.nonamedyes.client.render.model;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;

public class ModelSeaSnail extends ModelBase {
	Cube[] body = new Cube[5];

	public ModelSeaSnail() {
		body[0] = new Cube(7, 0);
		body[0].addBox(4, -3, -2, 4, 3, 5);

		body[1] = new Cube(8, 8);
		body[1].addBox(-8, -12, -6, 10, 12, 12);

		body[2] = new Cube(0, 4);
		body[2].addBox(2, -8, -4, 2, 8, 8);

		body[3] = new Cube(21, 0);
		body[3].addBox(13, -10, 0, 4, 4, 4);
		body[3].rotateAngleY = (float)Math.PI;

		body[4] = new Cube(32,4);
		body[4].addBox(8, -11, -3, 5, 8, 8);
		body[4].rotateAngleY = (float)Math.PI;
	}

	@Override
	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		setRotationAngles(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		for (Cube cube: body) {
			cube.render(scale);
		}
	}
}
