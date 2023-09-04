package goocraft4evr.nonamedyes.mixin.core.entity.animal;

import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.animal.EntitySheep;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.data.SynchedEntityData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntitySheep.class, remap=false)
public abstract class EntitySheepMixin
        extends EntityAnimal {
    public EntitySheepMixin(World world) {
        super(world);
    }

    //byte 16 = CCCS CCCC
    //byte 17 = 0000 000E

    @Redirect(method="dropFewItems",at=@At(value="INVOKE",target="Lnet/minecraft/core/entity/animal/EntitySheep;spawnAtLocation(Lnet/minecraft/core/item/ItemStack;F)Lnet/minecraft/core/entity/EntityItem;"))
    public EntityItem setDrops(EntitySheep instance, ItemStack itemStack, float shitass) {
        if (getFleeceColor()>15) itemStack = new ItemStack(ModBlocks.wool.id, 1, getFleeceColor()-16);
        return spawnAtLocation(itemStack, shitass);
    }

    @Redirect(method="setFleeceColor",at=@At(value = "INVOKE", target = "Lnet/minecraft/core/world/data/SynchedEntityData;set(ILjava/lang/Object;)V"))
    public void setFleeceColor(SynchedEntityData instance, int id, Object value, int i) {
        getEntityData().set(16,(byte) (i<<1&0xE0| (Byte) value));
    }

    @Inject(method="getFleeceColor",at=@At("RETURN"),cancellable = true)
    public void getFleeceColor(CallbackInfoReturnable<Integer> cir) {
        int colour = getEntityData().getByte(16);
        cir.setReturnValue((colour&0xE0)>>1|colour&0xF);
    }

    @Shadow
    abstract int getFleeceColor();

    @ModifyVariable(method = "interact", at = @At("STORE"), name = "entityitem")
    private EntityItem injected(EntityItem entityitem) {
        if (getFleeceColor()>15) {
            entityitem.item = new ItemStack(ModBlocks.wool.id, 1, getFleeceColor()-16);
        }
        return entityitem;
    }
}

