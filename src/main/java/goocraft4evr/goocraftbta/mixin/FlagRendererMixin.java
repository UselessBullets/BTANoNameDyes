package goocraft4evr.goocraftbta.mixin;

import goocraft4evr.goocraftbta.item.ModItems;
import goocraft4evr.goocraftbta.misc.ModColors;
import net.minecraft.client.render.FlagRenderer;
import net.minecraft.core.block.entity.TileEntityFlag;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value= FlagRenderer.class,remap = false)
public abstract class FlagRendererMixin {
    @Inject(method="getColorMap()I",at=@At("RETURN"), cancellable = true)
    private void inject(TileEntityFlag tileEntity, int index, CallbackInfoReturnable<Integer> cir) {
        ItemStack stack;
        if (index > 0 && index <= 3 && (stack = tileEntity.getStackInSlot(35 + index)) != null && stack.getItem() == ModItems.dye) {
            cir.setReturnValue(ModColors.modFlagColors[stack.getMetadata()].getARGB());
        }
    }
}
