package goocraft4evr.goocraftbta.crafting;

import goocraft4evr.goocraftbta.block.ModBlocks;
import goocraft4evr.goocraftbta.crafting.recipe.RecipesModDyes;
import goocraft4evr.goocraftbta.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.CraftingManager;
import net.minecraft.core.crafting.recipe.*;
import net.minecraft.core.item.ItemStack;

public abstract class ModCraftingManager {

    public static void register() {
        //register alternatives
        addAlternatives(2,new Block[]{ModBlocks.planksOakPainted});
        addAlternatives(13,new Block[]{ModBlocks.chestPlanksOakPainted});
        appendAlternatives(new Block[]{Block.wool,ModBlocks.wool});
        //add recipes
        RecipesModDyes.addRecipes(CraftingManager.getInstance());
        CraftingManager.getInstance().addRecipe(
                new ItemStack(ModBlocks.chestPlanksOakPainted, 1),
                "##", "##",
                Character.valueOf('#'),
                new ItemStack(ModItems.dye, 1,4));
        //sort recipes
        CraftingManager.getInstance().getRecipeList().sort(new RecipeSorter(CraftingManager.getInstance()));
    }

    /*
    0 = stone
    1 = cobblestone
    2 = planksOak
    3 = grass
    4 = dirt
    5 = mossStone
    6 = logOak
    7 = leavesOak
    8 = oreCoalStone
    9 = oreIronStone
    10 = oreGoldStone
    11 = oreLapisStone
    12 = oreRedstoneOre
    13 = chestPlanksOak
     */
    private static void addAlternatives(int index, Block[] alternatives) {
        Block[] current = CraftingManager.blockAlternatives[index];
        Block[] newAlts = new Block[current.length+alternatives.length];
        System.arraycopy(current, 0, newAlts, 0, current.length);
        System.arraycopy(alternatives, 0, newAlts, current.length + 0, alternatives.length);
        CraftingManager.blockAlternatives[index] = newAlts;
    }

    private static void appendAlternatives(Block[] alternatives) {
        Block[][] current = CraftingManager.blockAlternatives;
        Block[][] newAlts = new Block[current.length+1][];
        System.arraycopy(current, 0, newAlts, 0, current.length);
        newAlts[newAlts.length-1] = alternatives;
        CraftingManager.blockAlternatives = newAlts;
    }
}
