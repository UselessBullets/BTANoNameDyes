package goocraft4evr.nonamedyes.entity.animal;

import goocraft4evr.nonamedyes.NoNameDyes;
import net.minecraft.core.Global;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.animal.EntityWaterAnimal;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;

import java.util.List;

public class EntitySeaSnail extends EntityWaterAnimal {
	public EntitySeaSnail(World world) {
		super(world);
		this.skinName = "seasnail";
		this.setSize(0.9f, 0.9f);
		moveSpeed = 0.1f;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//prevent floating in water
		if (isJumping && isInWater()) yd -= 0.04;
	}

	@Override
	public String getEntityTexture() {
		return String.format("assets/%s/mob/%s/%d.png", NoNameDyes.MOD_ID,skinName,getSkinVariant());
	}

	@Override
	public int getSkinVariant() {
		int skinVariantCount = 1;
		return entityData.getByte(1) % skinVariantCount;
	}

	@Override
	protected int getDropItemId() {
		return Item.sulphur.id;
	}

	@Override
	protected boolean makeStepSound() {
		return false;
	}
}
