package goocraft4evr.nonamedyes.crafting;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.item.ItemModDye;
import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryFurnace;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryTrommel;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class ModRecipes implements RecipeEntrypoint {
	public static final RecipeNamespace RN = new RecipeNamespace();
	public static final RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.workbench)));
	public static final RecipeGroup<RecipeEntryFurnace> FURNACE = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.furnaceStoneIdle)));
	@Override
	public void onRecipesReady() {
		RN.register("furnace", FURNACE);
		RN.register("workbench", WORKBENCH);
		Registries.RECIPES.register(NoNameDyes.MOD_ID, RN);

		Registries.ITEM_GROUPS.register("nonamedyes:plasters", Registries.stackListOf(ModBlocks.plaster));
		for (int i = 0; i < ItemDye.dyeColors.length; i++) {
			Registries.ITEM_GROUPS.getItem("nonamedyes:plasters").add(new ItemStack(ModBlocks.plasterPainted, 1, i^15));
		}
		for (int i = 0; i < ItemModDye.NUM_DYES; i++) {
			Registries.ITEM_GROUPS.getItem("nonamedyes:plasters").add(new ItemStack(ModBlocks.plasterPainted, 1, 16 + i));
			Registries.ITEM_GROUPS.getItem("minecraft:planks").add(new ItemStack(ModBlocks.planksOakPainted.id, 1, i));
			Registries.ITEM_GROUPS.getItem("minecraft:wools").add(new ItemStack(ModBlocks.wool.id, 1, i));
			Registries.ITEM_GROUPS.getItem("minecraft:lamps").add(new ItemStack(ModBlocks.lampIdle.id, 1, i));
		}
		Registries.ITEM_GROUPS.getItem("minecraft:logs").add(ModBlocks.logCinnamon.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("minecraft:leaves").add(ModBlocks.leavesCinnamon.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("minecraft:chests").add(ModBlocks.chestPlanksOakPainted.getDefaultStack());

		new ModCraftingManager().onRecipesReady();
		new ModSmeltingManager().onRecipesReady();

		RecipeGroup<RecipeEntryTrommel> trommel = Registries.RECIPES.TROMMEL;
		trommel.getItem("rich_dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 4), 4,8), 12.0);
		trommel.getItem("sand").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 4), 4,8), 10.0);
		trommel.getItem("rich_dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 6), 2,4), 18.0);
		trommel.getItem("gravel").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(ModItems.dye, 1, 6), 2,4), 2.0);
	}
}
