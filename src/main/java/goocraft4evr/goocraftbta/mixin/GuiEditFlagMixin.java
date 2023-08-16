package goocraft4evr.goocraftbta.mixin;

import goocraft4evr.goocraftbta.block.ModBlocks;
import goocraft4evr.goocraftbta.item.ModItems;
import goocraft4evr.goocraftbta.misc.ModColors;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.client.gui.GuiEditFlag;
import net.minecraft.client.gui.drawing.IDrawableSurface;
import net.minecraft.core.block.entity.TileEntityFlag;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.command.TextFormatting;
import net.minecraft.core.player.inventory.Container;
import net.minecraft.core.util.helper.Colors;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value= GuiEditFlag.class, remap = false)
public abstract class GuiEditFlagMixin extends GuiContainer implements IDrawableSurface<Byte> {
    public GuiEditFlagMixin(Container container) {
        super(container);
    }

    @Shadow
    private TileEntityFlag tileEntity;

    @ModifyVariable(method = "renderCanvas()V", at = @At("STORE"), ordinal = 0)
    private int[] injected(int[] colors) {
        for (int i = 1; i < 4; ++i) {
            ItemStack stack = tileEntity.getStackInSlot(35 + i);
            if (stack == null || stack.getItem() != ModItems.dye) continue;
            colors[i] = ModColors.modFlagColors[stack.getMetadata()].getARGB();
        }
        return colors;
    }
}
