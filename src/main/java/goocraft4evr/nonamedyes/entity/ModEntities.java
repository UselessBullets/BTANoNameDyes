package goocraft4evr.nonamedyes.entity;

import goocraft4evr.nonamedyes.client.render.entity.SeaSnailRenderer;
import goocraft4evr.nonamedyes.entity.animal.EntitySeaSnail;
import turniplabs.halplibe.helper.EntityHelper;

public class ModEntities {

	public static void registerClientside() {
		EntityHelper.Core.createEntity(EntitySeaSnail.class, 200, "Seasnail");
	}

	public static void register() {
		EntityHelper.Client.assignEntityRenderer(EntitySeaSnail.class, new SeaSnailRenderer());

		/* RECIPE BOOK INFO
		MobInfoRegistry.register(EntitySeaSnail.class, "sea.snail.name", "sea.snail.desc",
			10, 400, new MobInfoRegistry.MobDrop[]{
				new MobInfoRegistry.MobDrop(new ItemStack(Item.bucketMilk),
					1.0f, 1, 1)});

		 */
	}
}
