package goocraft4evr.nonamedyes.mixin.core.block.entity;

import net.minecraft.core.block.entity.TileEntitySign;
import net.minecraft.core.net.command.TextFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value= TileEntitySign.class, remap = false)
public abstract class TileEntitySignMixin {
    @Shadow
    private int selectedColor;
    @Inject(method="getColor",at=@At("RETURN"),cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    public void injected(CallbackInfoReturnable<TextFormatting> cir) {
        if (selectedColor > 15) {
            cir.setReturnValue(TextFormatting.FORMATTINGS[selectedColor]);
        }
    }
}
