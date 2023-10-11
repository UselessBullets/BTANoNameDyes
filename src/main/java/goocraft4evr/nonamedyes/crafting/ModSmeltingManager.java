package goocraft4evr.nonamedyes.crafting;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.item.ModItems;
import goocraft4evr.nonamedyes.mixin.core.crafting.recipe.RecipesBlastFurnaceAccessor;
import net.minecraft.core.crafting.recipe.RecipesBlastFurnace;
import net.minecraft.core.crafting.recipe.RecipesFurnace;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;

public abstract class ModSmeltingManager {
    public static void register() {
        RecipesFurnace smeltingBase = RecipesFurnace.smelting();
        smeltingBase.addSmelting(ModBlocks.oreMalachiteStone.id, new ItemStack(ModItems.dye, 1, 6));
        smeltingBase.addSmelting(ModBlocks.oreMalachiteBasalt.id, new ItemStack(ModItems.dye, 1, 6));
        smeltingBase.addSmelting(ModBlocks.oreMalachiteLimestone.id, new ItemStack(ModItems.dye, 1, 6));
        smeltingBase.addSmelting(ModBlocks.oreMalachiteGranite.id, new ItemStack(ModItems.dye, 1, 6));
        smeltingBase.addSmelting(ModBlocks.logCocoa.id, new ItemStack(Item.coal, 1, 1));
        smeltingBase.addSmelting(ModBlocks.logCinnamon.id, new ItemStack(Item.coal, 1, 1));
        smeltingBase.addSmelting(ModBlocks.netherrackVile.id, new ItemStack(ModItems.vileShard));
        smeltingBase.addSmelting(ModItems.vileShard.id, new ItemStack(ModItems.dye,1,9));
        RecipesBlastFurnace blastSmeltingBase = RecipesBlastFurnace.smelting();
        ((RecipesBlastFurnaceAccessor)blastSmeltingBase).getSmeltingList().remove(Item.clay.id);
        blastSmeltingBase.addSmelting(Item.clay.id, new ItemStack(ModItems.ceramic));
    }
}
