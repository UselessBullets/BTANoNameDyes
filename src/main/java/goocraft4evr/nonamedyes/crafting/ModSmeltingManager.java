package goocraft4evr.nonamedyes.crafting;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.crafting.legacy.recipe.RecipesBlastFurnace;
import net.minecraft.core.crafting.legacy.recipe.RecipesFurnace;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.util.RecipeEntrypoint;

public abstract class ModSmeltingManager implements RecipeEntrypoint {

    public void onRecipesReady() {

    }

    /*
    public static void register() {
        RecipesFurnace smeltingBase = RecipesFurnace.getInstance();
        smeltingBase.addSmelting(ModBlocks.oreMalachiteStone.id, new ItemStack(ModItems.dye, 1, 6));
        smeltingBase.addSmelting(ModBlocks.oreMalachiteBasalt.id, new ItemStack(ModItems.dye, 1, 6));
        smeltingBase.addSmelting(ModBlocks.oreMalachiteLimestone.id, new ItemStack(ModItems.dye, 1, 6));
        smeltingBase.addSmelting(ModBlocks.oreMalachiteGranite.id, new ItemStack(ModItems.dye, 1, 6));
        smeltingBase.addSmelting(ModBlocks.logCocoa.id, new ItemStack(Item.coal, 1, 1));
        smeltingBase.addSmelting(ModBlocks.logCinnamon.id, new ItemStack(Item.coal, 1, 1));
        smeltingBase.addSmelting(ModBlocks.netherrackVile.id, new ItemStack(ModItems.vileShard));
        smeltingBase.addSmelting(ModItems.vileShard.id, new ItemStack(ModItems.dye,1,9));
        RecipesBlastFurnace blastSmeltingBase = RecipesBlastFurnace.getInstance();
        //((RecipesBlastFurnaceAccessor)blastSmeltingBase).getSmeltingList().remove(Item.clay.id);
        blastSmeltingBase.addSmelting(Item.clay.id, new ItemStack(ModItems.ceramic));
        //((RecipesBlastFurnaceAccessor)blastSmeltingBase).getSmeltingList().remove(ModBlocks.netherrackVile.id);
        blastSmeltingBase.addSmelting(ModBlocks.netherrackVile.id, new ItemStack(new ItemStack(ModItems.dye,1,9)));
    }
     */
}
