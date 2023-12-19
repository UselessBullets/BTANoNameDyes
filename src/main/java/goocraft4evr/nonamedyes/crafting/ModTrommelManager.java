package goocraft4evr.nonamedyes.crafting;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryTrommel;


public class ModTrommelManager {

    public static void register() {
        RecipeGroup<RecipeEntryTrommel> recipes = Registries.RECIPES.TROMMEL;
        /*
        //ochre
        trommelDropsRichDirt.addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 4), 4,8), 12.0);
        trommelDropsSand.addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 4), 4,8), 10.0);
        //malachite
        trommelDropsRichDirt.addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 6), 2,4), 18.0);
        trommelDropsGravel.addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 6), 2,4), 2.0);
         */
    }
}
