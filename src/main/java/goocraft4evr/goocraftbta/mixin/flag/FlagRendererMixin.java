package goocraft4evr.goocraftbta.mixin.flag;

import goocraft4evr.goocraftbta.item.ModItems;
import net.minecraft.client.render.FlagRenderer;
import net.minecraft.core.block.entity.TileEntityFlag;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Colors;
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
            cir.setReturnValue(Colors.allFlagColors[16+stack.getMetadata()].getARGB());
        }
    }
}
