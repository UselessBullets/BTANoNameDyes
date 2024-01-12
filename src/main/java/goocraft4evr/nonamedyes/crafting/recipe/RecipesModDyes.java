package goocraft4evr.nonamedyes.crafting.recipe;

import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.legacy.CraftingManager;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeHelper;

public class RecipesModDyes {
    public static void addRecipes(CraftingManager craftingmanager) {
        //delete plank recipes
        RecipeHelper.removeRecipe(Item.itemsList[Block.fencePlanksOak.id],0);
        RecipeHelper.removeRecipe(Item.itemsList[Block.fencegatePlanksOak.id],0);
        RecipeHelper.removeRecipe(Item.itemsList[Block.slabPlanksOak.id],0);
        RecipeHelper.removeRecipe(Item.itemsList[Block.stairsPlanksOak.id],0);
        //read plank recipes
        craftingmanager.addRecipe(new ItemStack(Block.fencePlanksOak, 6), true, new Object[]{"#X#", "#X#", Character.valueOf('X'), Item.stick, Character.valueOf('#'), Block.planksOak});
        craftingmanager.addRecipe(new ItemStack(Block.fencegatePlanksOak, 3), true, new Object[]{"#X#", "#X#", Character.valueOf('X'), Block.planksOak, Character.valueOf('#'), Item.stick});
        craftingmanager.addRecipe(new ItemStack(Block.slabPlanksOak, 6), true, new Object[]{"###", Character.valueOf('#'), Block.planksOak});
        craftingmanager.addRecipe(new ItemStack(Block.stairsPlanksOak, 6), true, new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.planksOak});
    }
}
