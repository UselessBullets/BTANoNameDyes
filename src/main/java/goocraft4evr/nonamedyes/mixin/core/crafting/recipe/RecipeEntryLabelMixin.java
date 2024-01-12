package goocraft4evr.nonamedyes.mixin.core.crafting.recipe;

import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryLabel;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.InventoryCrafting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = RecipeEntryLabel.class, remap = false)
public class RecipeEntryLabelMixin {
	@Inject(method="matches",at=@At(value="RETURN"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
	private void inject(InventoryCrafting crafting, CallbackInfoReturnable<Boolean> cir, ItemStack labelStack, ItemStack otherStack) {
		if (!cir.getReturnValueZ() || otherStack == null || labelStack == null) return;
		cir.setReturnValue(!(otherStack.itemID == ModItems.dye.id && !labelStack.hasCustomColor()));
	}
}
