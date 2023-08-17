package goocraft4evr.goocraftbta.container;

import goocraft4evr.goocraftbta.block.ModBlocks;
import goocraft4evr.goocraftbta.item.ItemModDye;
import goocraft4evr.goocraftbta.item.ModItems;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.ContainerPlayerCreative;

import static net.minecraft.core.player.inventory.ContainerPlayerCreative.creativeItems;

public abstract class ContainerPlayerCreativeAppender {
    private static void updateItemCount(int count) {
        ContainerPlayerCreative.creativeItemsCount += count;
    }

    public static void appendItems() {
        for (int i=1;i< ItemModDye.dyeColors.length;i++) {
            creativeItems.add(new ItemStack(ModBlocks.planksOakPainted, 1, i));
            creativeItems.add(new ItemStack(ModBlocks.fencePlanksOakPainted, 1, i));
            creativeItems.add(new ItemStack(ModBlocks.fencegatePlanksOakPainted, 1, i<<4));
            creativeItems.add(new ItemStack(ModBlocks.slabPlanksOakPainted, 1, i<<4));
            creativeItems.add(new ItemStack(ModBlocks.stairsPlanksOakPainted, 1, i<<4));
            creativeItems.add(new ItemStack(ModBlocks.chestPlanksOakPainted, 1, i<<4));
            creativeItems.add(new ItemStack(ModBlocks.lampIdle, 1, i));
            creativeItems.add(new ItemStack(ModBlocks.wool, 1, i));
            creativeItems.add(new ItemStack(ModItems.dye, 1, i));
        }
        updateItemCount((ItemModDye.dyeColors.length-1)*9);
    }
}
