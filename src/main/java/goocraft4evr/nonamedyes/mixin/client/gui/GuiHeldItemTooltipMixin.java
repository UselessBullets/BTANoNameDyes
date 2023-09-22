package goocraft4evr.nonamedyes.mixin.client.gui;

import net.minecraft.client.gui.GuiHeldItemTooltip;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Color;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value= GuiHeldItemTooltip.class, remap = false)
public abstract class GuiHeldItemTooltipMixin {
    @Shadow
    private int color;

    @Redirect(method="updateString",at=@At(value="INVOKE",target="Lnet/minecraft/core/item/ItemStack;getDisplayColor()B"))
    private byte redirect(ItemStack item) {
        int index = item.getDisplayColor();
        return (byte)(index>15?index-6:index);
    }
}
