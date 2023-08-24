package goocraft4evr.nonamedyes.mixin;

import net.minecraft.client.gui.GuiHeldItemTooltip;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Color;
import net.minecraft.core.util.helper.Colors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= GuiHeldItemTooltip.class, remap = false)
public abstract class GuiHeldItemTooltipMixin {
    @Shadow
    private Color color;

    @Inject(method = "updateString", at = @At("TAIL"))
    private void injected(ItemStack item, CallbackInfo ci) {
        if (item.tag.getBoolean("overrideColor")&&item.getNameColor()>21) {
            this.color = Colors.allChatColors[item.getNameColor()-6];
        }
    }
}
