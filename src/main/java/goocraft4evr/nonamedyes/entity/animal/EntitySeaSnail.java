package goocraft4evr.nonamedyes.entity.animal;

import goocraft4evr.nonamedyes.NoNameDyes;
import net.minecraft.core.entity.animal.EntityWaterAnimal;
import net.minecraft.core.item.Item;
import net.minecraft.core.world.World;

public class EntitySeaSnail extends EntityWaterAnimal {
	public EntitySeaSnail(World world) {
		super(world);
		this.skinName = "seasnail";
		this.setSize(0.9f, 0.9f);
	}

	@Override
	public String getEntityTexture() {
		return String.format("assets/%s/mob/%s/0.png", NoNameDyes.MOD_ID,skinName);
	}

	@Override
	protected String getHurtSound() {
		return "mob.creeper";
	}

	@Override
	protected String getDeathSound() {
		return "mob.creeperdeath";
	}

	@Override
	protected int getDropItemId() {
		return Item.sulphur.id;
	}
}
