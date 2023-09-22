package goocraft4evr.nonamedyes.mixin.core.block.entity;

import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import net.minecraft.core.block.entity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= TileEntity.class,remap=false)
public abstract class TileEntityMixin {

    @Shadow
    private static void addMapping(Class class1, String s) {
    }
    @Inject(method="<clinit>",at=@At("TAIL"))
    private static void inject(CallbackInfo ci) {
        addMapping(TileEntityBleacher.class, "Bleacher");
    }
}
