package goocraft4evr.nonamedyes.crafting;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.crafting.recipe.RecipesModDyes;
import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.CraftingManager;
import net.minecraft.core.crafting.recipe.*;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;

public abstract class ModCraftingManager {

    public static void register() {
        //register alternatives
        addAlternatives(2,new Block[]{ModBlocks.planksOakPainted});
        addAlternatives(6,new Block[]{ModBlocks.logCocoa});
        addAlternatives(7,new Block[]{ModBlocks.leavesCocoa});
        addAlternatives(13,new Block[]{ModBlocks.chestPlanksOakPainted});
        appendAlternatives(new Block[]{Block.wool,ModBlocks.wool});
        //add recipes
        CraftingManager craftingManager = CraftingManager.getInstance();
        RecipesModDyes.addRecipes(craftingManager);
        craftingManager.addRecipe(
                new ItemStack(ModBlocks.ochreBlock, 1),
                "##", "##",
                Character.valueOf('#'),
                new ItemStack(ModItems.dye, 1,4));
        craftingManager.addRecipe(
                new ItemStack(ModBlocks.blockMalachite, 1),
                "###", "###","###",
                Character.valueOf('#'),
                new ItemStack(ModItems.dye, 1,6));
        craftingManager.addShapelessRecipe(new ItemStack(ModItems.dye, 9,6), new ItemStack(ModBlocks.blockMalachite, 1));
        craftingManager.addShapelessRecipe(new ItemStack(ModBlocks.saplingCocoa, 1), new ItemStack(Block.saplingOak, 1),new ItemStack(Item.dye, 1, 3));
        craftingManager.addRecipe(
                new ItemStack(ModBlocks.brickMalachite, 4),
                "##", "##",
                Character.valueOf('#'),
                new ItemStack(ModItems.dye, 1,6));

        //TODO: These probably aren't necessary
        craftingManager.addShapelessRecipe(new ItemStack(Block.planksOak, 4), new ItemStack(ModBlocks.logCocoa, 1));
        //sort recipes
        craftingManager.getRecipeList().sort(new RecipeSorter(craftingManager));
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
        System.arraycopy(alternatives, 0, newAlts, current.length, alternatives.length);
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
