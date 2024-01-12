package goocraft4evr.nonamedyes.crafting;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.crafting.recipe.RecipeCinnamon;
import goocraft4evr.nonamedyes.crafting.recipe.RecipeLabelModDye;
import net.minecraft.core.crafting.legacy.CraftingManager;
import net.minecraft.core.data.DataLoader;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class ModCraftingManager implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/workbench.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/stairs.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/slabs.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/fences.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/fencegates.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/chests.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/planks.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/wools.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/lamps.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/plasters.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/ceramics.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/ceramic_tiles.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/ceramic_tiles2.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/dyes.json", NoNameDyes.MOD_ID));
		DataLoader.loadRecipes(String.format("/assets/%s/recipes/workbench/vanilla_overrides.json", NoNameDyes.MOD_ID));
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
