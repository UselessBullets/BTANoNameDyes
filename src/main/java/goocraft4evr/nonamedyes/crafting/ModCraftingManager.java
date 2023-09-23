package goocraft4evr.nonamedyes.crafting;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.crafting.recipe.RecipeCinnamon;
import goocraft4evr.nonamedyes.crafting.recipe.RecipeLabelModDye;
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
        addAlternatives(6,new Block[]{ModBlocks.logCocoa,ModBlocks.logCinnamon});
        addAlternatives(7,new Block[]{ModBlocks.leavesCocoa,ModBlocks.leavesCinnamon});
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
        craftingManager.addShapelessRecipe(new ItemStack(ModItems.bleachingPowder, 4), new ItemStack(Item.dye, 1,15),new ItemStack(Item.sulphur, 1),new ItemStack(Block.cobbleLimestone, 1));
        craftingManager.addRecipe(
                new ItemStack(ModBlocks.bleacher, 1),
                "C C", "S S", "SSS",
                Character.valueOf('C'),
                new ItemStack(Block.cobbleStone, 1),
                Character.valueOf('S'),
                new ItemStack(Block.stonePolished, 1));
        craftingManager.addShapelessRecipe(new ItemStack(Block.planksOak, 4), new ItemStack(ModBlocks.logCocoa, 1));
        craftingManager.addRecipe(
                new ItemStack(ModItems.foodSnickerdoodle, 8),
                " S ", "WCW",
                Character.valueOf('C'),
                new ItemStack(ModItems.dye, 1,10),
                Character.valueOf('S'),
                new ItemStack(Item.dustSugar),
                Character.valueOf('W'),
                new ItemStack(Item.wheat));
        craftingManager.addRecipe(new ItemStack(ModBlocks.planksOakPainted, 4, 10), false, new Object[]{"#", Character.valueOf('#'), ModBlocks.logCinnamon});
        craftingManager.addRecipe(new ItemStack(Block.planksOakPainted, 4, 15), false, new Object[]{"#", Character.valueOf('#'), ModBlocks.logEbony});
        //add IRecipes here
        craftingManager.getRecipeList().add(new RecipeLabelModDye());
        craftingManager.getRecipeList().add(new RecipeCinnamon());
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
