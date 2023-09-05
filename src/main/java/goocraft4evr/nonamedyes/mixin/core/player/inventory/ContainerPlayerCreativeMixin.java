package goocraft4evr.nonamedyes.mixin.core.player.inventory;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.item.ItemModDye;
import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.ContainerPlayerCreative;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= ContainerPlayerCreative.class, remap=false)
public abstract class ContainerPlayerCreativeMixin {
    @Inject(method="<clinit>",at=@At("TAIL"))
    private static void inject(CallbackInfo ci) {
        for (int i = 1; i< ItemModDye.dyeColors.length; i++) {
            ContainerPlayerCreative.creativeItems.add(new ItemStack(ModBlocks.planksOakPainted, 1, i));
            ContainerPlayerCreative.creativeItems.add(new ItemStack(ModBlocks.fencePlanksOakPainted, 1, i));
            ContainerPlayerCreative.creativeItems.add(new ItemStack(ModBlocks.fencegatePlanksOakPainted, 1, i<<4));
            ContainerPlayerCreative.creativeItems.add(new ItemStack(ModBlocks.slabPlanksOakPainted, 1, i<<4));
            ContainerPlayerCreative.creativeItems.add(new ItemStack(ModBlocks.stairsPlanksOakPainted, 1, i<<4));
            ContainerPlayerCreative.creativeItems.add(new ItemStack(ModBlocks.chestPlanksOakPainted, 1, i<<4));
            ContainerPlayerCreative.creativeItems.add(new ItemStack(ModBlocks.lampIdle, 1, i));
            ContainerPlayerCreative.creativeItems.add(new ItemStack(ModBlocks.wool, 1, i));
            ContainerPlayerCreative.creativeItems.add(new ItemStack(ModItems.dye, 1, i));
        }
        ContainerPlayerCreative.creativeItemsCount += (ItemModDye.dyeColors.length-1)*9;
    }
}