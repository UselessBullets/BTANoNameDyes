package goocraft4evr.nonamedyes.mixin.core.entity.fx;

import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.entity.fx.EntityBubbleFX;
import net.minecraft.core.entity.fx.EntityFX;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = EntityBubbleFX.class, remap = false)
public abstract class EntityBubbleFXMixin extends EntityFX {

    public EntityBubbleFXMixin(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);
    }

    @Redirect(method = "tick",at=@At(value="INVOKE",target = "Lnet/minecraft/core/entity/fx/EntityBubbleFX;remove()V",ordinal = 0))
    private void redirect(EntityBubbleFX instance) {
        if (world.getBlockId(MathHelper.floor_double(this.x),
                         MathHelper.floor_double(this.y)-1,
                             MathHelper.floor_double(this.z)) != ModBlocks.bleacher.id) {
            this.remove();
        }
    }
}
