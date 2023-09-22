package goocraft4evr.nonamedyes.mixin.core.block.entity;

import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.WeightedRandomBag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.entity.TileEntityTrommel;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= TileEntityTrommel.class,remap = false)
public abstract class TileEntityTrommelMixin {
    @Final
    private static WeightedRandomBag<WeightedRandomLootObject> trommelDropsGravel;
    @Final
    private static WeightedRandomBag<WeightedRandomLootObject> trommelDropsSand;
    @Final
    private static WeightedRandomBag<WeightedRandomLootObject> trommelDropsRichDirt;

    @Inject(method="<clinit>",at=@At("TAIL"))
    private static void injected(CallbackInfo ci) {
        //ochre
        trommelDropsRichDirt.addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 4), 4,8), 12.0);
        trommelDropsSand.addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 4), 4,8), 10.0);
        //malachite
        trommelDropsRichDirt.addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 6), 2,4), 18.0);
        trommelDropsGravel.addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 6), 2,4), 2.0);

    }
}
