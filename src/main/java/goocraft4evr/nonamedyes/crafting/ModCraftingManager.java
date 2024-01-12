package goocraft4evr.nonamedyes.crafting;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.crafting.recipe.RecipeCinnamon;
import goocraft4evr.nonamedyes.crafting.recipe.RecipeLabelModDye;
import goocraft4evr.nonamedyes.crafting.recipe.RecipesModDyes;
import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.legacy.CraftingManager;
import net.minecraft.core.crafting.recipe.*;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
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
	}

    public static void register() {
        //add recipes
        CraftingManager craftingManager = CraftingManager.getInstance();
        RecipesModDyes.addRecipes(craftingManager);

        //add IRecipes here
        craftingManager.getRecipeList().add(new RecipeLabelModDye());
        craftingManager.getRecipeList().add(new RecipeCinnamon());
        //sort recipes
        //craftingManager.getRecipeList().sort(new RecipeSorter(craftingManager));
    }
}
