package goocraft4evr.nonamedyes.mixin.core.crafting.recipe;

import net.minecraft.core.crafting.legacy.recipe.RecipesBlastFurnace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(value = RecipesBlastFurnace.class,remap = false)
public interface RecipesBlastFurnaceAccessor {
    /*
    @Accessor
    Map getSmeltingList();
     */
}
