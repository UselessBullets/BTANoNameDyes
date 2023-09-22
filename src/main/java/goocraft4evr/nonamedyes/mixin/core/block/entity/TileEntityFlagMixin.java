package goocraft4evr.nonamedyes.mixin.core.block.entity;

import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.block.entity.TileEntityFlag;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = TileEntityFlag.class, remap = false)
public abstract class TileEntityFlagMixin {
    @Shadow
    public ItemStack[] items;

    @Inject(method="getColor",at=@At("RETURN"),cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private void injected(int x, int y, CallbackInfoReturnable<Byte> cir, int xSample, int ySample, int colorIndex) {
        if (colorIndex < 0) return;
        if (items[colorIndex] != null&&items[colorIndex].itemID == ModItems.dye.id
        ) {
            //I have to return a negative index to ensure waypoints display properly.
            cir.setReturnValue((byte)(-1-items[colorIndex].getMetadata()));
        }
    }
}
