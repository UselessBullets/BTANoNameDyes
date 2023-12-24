package goocraft4evr.nonamedyes.crafting.recipe;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.crafting.legacy.recipe.IRecipe;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tool.ItemToolAxe;
import net.minecraft.core.player.inventory.InventoryCrafting;

public class RecipeCinnamon implements IRecipe {
    @Override
    public boolean matches(InventoryCrafting crafting) {
        ItemStack logStack = null;
        ItemStack axeStack = null;
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                ItemStack stack = crafting.getItemStackAt(x, y);
                if (stack == null) continue;
                if (stack.getItem() instanceof ItemToolAxe) {
                    if (axeStack != null) return false;
                    axeStack = stack;
                    continue;
                }
                if (stack.itemID != ModBlocks.logCinnamon.id || logStack != null) return false;
                logStack = stack;
            }
        }
        return logStack != null && axeStack != null;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return new ItemStack(ModItems.dye,4,10);
    }

    @Override
    public int getRecipeSize() {
        return 2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ModItems.dye,4,10);
    }

    @Override
    public ItemStack[] onCraftResult(InventoryCrafting crafting) {
        ItemStack[] returnStack = new ItemStack[9];
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                ItemStack stack = crafting.getItemStackAt(x, y);
                if (stack == null) continue;
                if (stack.getItem() instanceof ItemToolAxe) {
                    stack.damageItem(1, null);
                } else --stack.stackSize;
                if (stack.stackSize > 0) continue;
                crafting.setSlotContentsAt(x, y, null);
            }
        }
        return returnStack;
    }
}
