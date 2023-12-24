package goocraft4evr.nonamedyes.crafting.recipe;

import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.crafting.legacy.recipe.IRecipe;
import net.minecraft.core.crafting.legacy.type.RecipeLabelDye;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.InventoryCrafting;

public class RecipeLabelModDye
        implements IRecipe {
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) {
        ItemStack labelStack = null;
        ItemStack dyeStack = null;
        block0: for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                ItemStack stack = inventorycrafting.getItemStackAt(x, y);
                if (stack == null) continue;
                if (stack.itemID == Item.label.id && labelStack == null) {
                    labelStack = stack;
                } else if (stack.itemID == ModItems.dye.id && dyeStack == null) {
                    dyeStack = stack;
                }
                if (labelStack != null && dyeStack != null) break block0;
            }
        }
        if (labelStack != null && dyeStack != null) {
            ItemStack outStack = labelStack.copy();
            outStack.setCustomColor((byte)(22 + dyeStack.getMetadata()));
            outStack.stackSize = 1;
            return outStack;
        }
        return null;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(Item.label);
    }

    @Override
    public int getRecipeSize() {
        return 2;
    }

    @Override
    public boolean matches(InventoryCrafting crafting) {
        ItemStack labelStack = null;
        ItemStack dyeStack = null;
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                ItemStack stack = crafting.getItemStackAt(x, y);
                if (stack == null) continue;
                if (stack.itemID == Item.label.id) {
                    if (labelStack != null) {
                        return false;
                    }
                    labelStack = stack;
                    continue;
                }
                if (stack.itemID == ModItems.dye.id) {
                    if (dyeStack != null) {
                        return false;
                    }
                    dyeStack = stack;
                    continue;
                }
                return false;
            }
        }
        if (labelStack == null || dyeStack == null) {
            return false;
        }
        return labelStack.hasCustomName() && !labelStack.hasCustomColor();
    }

    @Override
    public ItemStack[] onCraftResult(InventoryCrafting crafting) {
        ItemStack[] returnStack = new ItemStack[9];
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                ItemStack stack = crafting.getItemStackAt(x, y);
                if (stack == null) continue;
                --stack.stackSize;
                if (stack.stackSize > 0) continue;
                crafting.setSlotContentsAt(x, y, null);
            }
        }
        return returnStack;
    }
}