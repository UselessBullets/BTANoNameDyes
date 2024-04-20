package goocraft4evr.nonamedyes.entity.animal;

import goocraft4evr.nonamedyes.NoNameDyes;
import net.minecraft.core.Global;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.animal.EntityWaterAnimal;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;

import java.util.List;

public class EntitySeaSnail extends EntityWaterAnimal {
	public EntitySeaSnail(World world) {
		super(world);
		skinName = "seasnail";
		setSize(0.9f, 0.9f);
		moveSpeed = 0.1f;
	}

	@Override
	public int getMaxHealth() {
		return 15;
	}

	@Override
	protected String getHurtSound() {
		return null;
	}

	@Override
	protected String getDeathSound() {
		return null;
	}

	@Override
	public void onLivingUpdate() {
		//vanilla code...
		if (this.newPosRotationIncrements > 0) {
			double d3;
			double d = this.x + (this.newPosX - this.x) / (double)this.newPosRotationIncrements;
			double d1 = this.y + (this.newPosY - this.y) / (double)this.newPosRotationIncrements;
			double d2 = this.z + (this.newPosZ - this.z) / (double)this.newPosRotationIncrements;
			for (d3 = this.newRotationYaw - (double)this.yRot; d3 < -180.0; d3 += 360.0) {
			}
			while (d3 >= 180.0) {
				d3 -= 360.0;
			}
			this.yRot = (float)((double)this.yRot + d3 / (double)this.newPosRotationIncrements);
			this.xRot = (float)((double)this.xRot + (this.newRotationPitch - (double)this.xRot) / (double)this.newPosRotationIncrements);
			--this.newPosRotationIncrements;
			this.setPos(d, d1, d2);
			this.setRot(this.yRot, this.xRot);
			List<AABB> list1 = this.world.getCubes(this, this.bb.getInsetBoundingBox(0.03125, 0.0, 0.03125));
			if (list1.size() > 0) {
				double d4 = 0.0;
				for (int j = 0; j < list1.size(); ++j) {
					AABB axisalignedbb = list1.get(j);
					if (!(axisalignedbb.maxY > d4)) continue;
					d4 = axisalignedbb.maxY;
				}
				this.setPos(d, d1 += d4 - this.bb.minY, d2);
			}
		}
		if (this.isMovementBlocked()) {
			this.isJumping = false;
			this.moveStrafing = 0.0f;
			this.moveForward = 0.0f;
			this.randomYawVelocity = 0.0f;
		} else if (!this.isMultiplayerEntity) {
			this.updatePlayerActionState();
		}
		//prevent jumping in water
		if (isJumping) {
			if (isInLava()) {
				yd += 0.04;
			} else if (this.onGround) {
				jump();
			}
		}
		//vanilla code...
		this.moveStrafing *= 0.98f;
		this.moveForward *= 0.98f;
		this.randomYawVelocity *= 0.9f;
		this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.bb.expand(0.2f, 0.0, 0.2f));
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); ++i) {
				Entity entity = list.get(i);
				if (!entity.isPushable()) continue;
				entity.push(this);
			}
		}
	}

	@Override
	protected void updatePlayerActionState() {
		super.updatePlayerActionState();
		if (isInWater() && !isMovementBlocked()) isJumping = false;
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
