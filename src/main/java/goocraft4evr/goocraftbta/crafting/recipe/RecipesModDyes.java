package goocraft4evr.goocraftbta.crafting.recipe;

import goocraft4evr.goocraftbta.block.BlockModLamp;
import goocraft4evr.goocraftbta.block.BlockModWool;
import goocraft4evr.goocraftbta.block.ModBlocks;
import goocraft4evr.goocraftbta.block.wood.*;
import goocraft4evr.goocraftbta.item.ModItems;
import goocraft4evr.goocraftbta.misc.ModColors;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.CraftingManager;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import turniplabs.halplibe.helper.RecipeHelper;

public class RecipesModDyes {
    public static void addRecipes(CraftingManager craftingmanager) {
        //delete plank recipes
        RecipeHelper.removeRecipe(Block.fencePlanksOak,0);
        RecipeHelper.removeRecipe(Block.fencegatePlanksOak,0);
        RecipeHelper.removeRecipe(Block.slabPlanksOak,0);
        RecipeHelper.removeRecipe(Block.stairsPlanksOak,0);
        //add recipes for dyed blocks/items
        for (int dye = 0; dye < ModColors.MOD_COLORS; ++dye) {
            //wood
            craftingmanager.addRecipe(new ItemStack(ModBlocks.fencePlanksOakPainted, 6, BlockModFencePainted.getMetadataForColour(dye)), "X#X", "X#X", Character.valueOf('#'), Item.stick, Character.valueOf('X'), new ItemStack(ModBlocks.planksOakPainted, 1, BlockModPlanksPainted.getMetadataForColour(dye)));
            craftingmanager.addRecipe(new ItemStack(ModBlocks.slabPlanksOakPainted, 6, BlockModSlabPainted.getMetadataForColour(dye)), "###", Character.valueOf('#'), new ItemStack(ModBlocks.planksOakPainted, 1, BlockModPlanksPainted.getMetadataForColour(dye)));
            craftingmanager.addRecipe(new ItemStack(ModBlocks.stairsPlanksOakPainted, 6, BlockModSlabPainted.getMetadataForColour(dye)), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(ModBlocks.planksOakPainted, 1, BlockModPlanksPainted.getMetadataForColour(dye)));
            craftingmanager.addRecipe(new ItemStack(ModBlocks.fencegatePlanksOakPainted, 3, BlockModFenceGatePainted.getMetadataForColour(dye)), "X#X", "X#X", Character.valueOf('X'), Item.stick, Character.valueOf('#'), new ItemStack(ModBlocks.planksOakPainted, 1, BlockModPlanksPainted.getMetadataForColour(dye)));
            craftingmanager.addRecipe(new ItemStack(ModBlocks.chestPlanksOakPainted, 1, BlockModChestPainted.getMetaForDyeColor(dye)), "###", "# #", "###", Character.valueOf('#'), new ItemStack(ModBlocks.planksOakPainted, 1, BlockModPlanksPainted.getMetadataForColour(dye)));
            craftingmanager.addShapelessRecipe(new ItemStack(ModBlocks.chestPlanksOakPainted, 1, BlockModChestPainted.getMetaForDyeColor(dye)), Block.chestPlanksOak, new ItemStack(ModItems.dye, 1, dye));
            craftingmanager.addRecipe(new ItemStack(ModBlocks.planksOakPainted, 8, BlockModPlanksPainted.getMetadataForColour(dye)), "###", "#0#", "###", Character.valueOf('#'), Block.planksOak, Character.valueOf('0'), new ItemStack(ModItems.dye, 1, dye));
            //wool
            craftingmanager.addShapelessRecipe(new ItemStack(ModBlocks.wool, 1, BlockModWool.getMetadataForColour(dye)), Block.wool, new ItemStack(ModItems.dye, 1, dye));
            //lamp
            craftingmanager.addShapelessRecipe(new ItemStack(ModBlocks.lampIdle, 1, BlockModLamp.getMetadataForColour(dye)), new ItemStack(ModItems.dye, 1, dye), new ItemStack(Item.itemsList[Block.lampIdle.id], 1, 0));
        }
        //add recipes for dye items
        //TODO: dye ids are hardcoded
        craftingmanager.addShapelessRecipe(new ItemStack(ModItems.dye, 2, 0), ModBlocks.netherRoots);
        craftingmanager.addShapelessRecipe(new ItemStack(ModItems.dye, 2, 1), new ItemStack(Item.dye, 1, DyeColor.DYE_BROWN.dyeMeta), new ItemStack(ModItems.dye, 1, 0));
        craftingmanager.addShapelessRecipe(new ItemStack(ModItems.dye, 2, 2), ModBlocks.mushroomInkCap);
        craftingmanager.addShapelessRecipe(new ItemStack(ModItems.dye, 2, 2), new ItemStack(Item.dye, 1, DyeColor.DYE_GREEN.dyeMeta),new ItemStack(Item.dye, 1, DyeColor.DYE_LIGHT_GRAY.dyeMeta));
        craftingmanager.addShapelessRecipe(new ItemStack(ModItems.dye, 2, 3), new ItemStack(Item.dye, 1, DyeColor.DYE_GREEN.dyeMeta),new ItemStack(Item.dye, 1, DyeColor.DYE_BROWN.dyeMeta));
        craftingmanager.addShapelessRecipe(new ItemStack(ModItems.dye, 2, 5), new ItemStack(Item.dye, 1, DyeColor.DYE_WHITE.dyeMeta),new ItemStack(ModItems.dye, 1, 4));

        //read plank recipes
        craftingmanager.addRecipe(new ItemStack(Block.fencePlanksOak, 6), true, new Object[]{"#X#", "#X#", Character.valueOf('X'), Item.stick, Character.valueOf('#'), Block.planksOak});
        craftingmanager.addRecipe(new ItemStack(Block.fencegatePlanksOak, 3), true, new Object[]{"#X#", "#X#", Character.valueOf('X'), Block.planksOak, Character.valueOf('#'), Item.stick});
        craftingmanager.addRecipe(new ItemStack(Block.slabPlanksOak, 6), true, new Object[]{"###", Character.valueOf('#'), Block.planksOak});
        craftingmanager.addRecipe(new ItemStack(Block.stairsPlanksOak, 6), true, new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.planksOak});
    }
}
