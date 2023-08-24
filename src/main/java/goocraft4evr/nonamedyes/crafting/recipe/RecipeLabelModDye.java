package goocraft4evr.nonamedyes.crafting.recipe;

import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.crafting.recipe.IRecipe;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.InventoryCrafting;

public class RecipeLabelModDye extends net.minecraft.core.crafting.recipe.RecipeLabelDye implements IRecipe {
    //A mixin might be more appropriate but I can't be bothered

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
            outStack.tag.putBoolean("overrideColor", true);
            outStack.tag.putByte("color", (byte)(22 + dyeStack.getMetadata()));
            return outStack;
        }
        return null;
    }

    @Override
    public boolean matches(InventoryCrafting inventorycrafting) {
        int labelCount = 0;
        int dyeCount = 0;
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                ItemStack stack = inventorycrafting.getItemStackAt(x, y);
                if (stack == null) continue;
                if (stack.itemID == Item.label.id) {
                    ++labelCount;
                }
                if (stack.itemID != ModItems.dye.id) continue;
                ++dyeCount;
            }
        }
        return labelCount == 1 && dyeCount == 1;
    }
}
