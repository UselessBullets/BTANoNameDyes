package goocraft4evr.nonamedyes.mixin.dye;

import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.SlotDye;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value= SlotDye.class, remap = false)
public abstract class SlotDyeMixin {
    @Inject(method="canPutStackInSlot()Z", at = @At("RETURN"), cancellable = true)
    private void injectedReturn(ItemStack itemstack, CallbackInfoReturnable<Boolean> cir) {
        if (itemstack != null && !cir.getReturnValue()) {
            cir.setReturnValue(itemstack.itemID == ModItems.dye.id);
        }
    }
}
