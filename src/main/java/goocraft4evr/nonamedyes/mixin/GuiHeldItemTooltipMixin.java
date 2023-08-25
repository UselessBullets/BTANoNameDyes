package goocraft4evr.nonamedyes.mixin;

import goocraft4evr.nonamedyes.NoNameDyes;
import net.minecraft.client.gui.GuiHeldItemTooltip;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Color;
import net.minecraft.core.util.helper.Colors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= GuiHeldItemTooltip.class, remap = false)
public abstract class GuiHeldItemTooltipMixin {
    @Shadow
    private Color color;

    @Redirect(method = "updateString", at = @At(value="INVOKE",target = "Lnet/minecraft/core/item/ItemStack;getNameColor()B"))
    private byte injected(ItemStack item) {
        return (byte)(item.getNameColor()-((item.tag.getBoolean("overrideColor")&&item.getNameColor()>21)?6:0));
    }
}
