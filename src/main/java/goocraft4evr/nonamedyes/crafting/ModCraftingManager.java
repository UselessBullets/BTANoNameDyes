package goocraft4evr.nonamedyes.crafting;

import goocraft4evr.nonamedyes.crafting.recipe.RecipeCinnamon;
import goocraft4evr.nonamedyes.crafting.recipe.RecipeLabelModDye;
import net.minecraft.core.crafting.legacy.CraftingManager;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class ModCraftingManager implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {

	}

    public static void register() {
        //add recipes
        CraftingManager craftingManager = CraftingManager.getInstance();

        //add IRecipes here
        craftingManager.getRecipeList().add(new RecipeLabelModDye());
        craftingManager.getRecipeList().add(new RecipeCinnamon());
        //sort recipes
        //craftingManager.getRecipeList().sort(new RecipeSorter(craftingManager));
    }
}
