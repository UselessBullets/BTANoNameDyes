package goocraft4evr.nonamedyes.crafting.recipe;

import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class RecipesBleacher {
    private static final RecipesBleacher bleachingBase = new RecipesBleacher();
    private Map bleachingList = new HashMap();

    public static final RecipesBleacher bleaching() {
        return bleachingBase;
    }

    private RecipesBleacher() {
        addBleaching(Block.planksOakPainted.id, new ItemStack(Block.planksOak));
        addBleaching(Block.fencePlanksOakPainted.id, new ItemStack(Block.fencePlanksOak));
        addBleaching(Block.fencegatePlanksOakPainted.id, new ItemStack(Block.fencegatePlanksOak));
        addBleaching(Block.slabPlanksOakPainted.id, new ItemStack(Block.slabPlanksOak));
        addBleaching(Block.stairsPlanksOakPainted.id, new ItemStack(Block.stairsPlanksOak));
        addBleaching(Block.chestPlanksOakPainted.id, new ItemStack(Block.chestPlanksOak));
        addBleaching(Block.wool.id, new ItemStack(Block.wool));
        addBleaching(Block.lampIdle.id, new ItemStack(Block.lampIdle));

        addBleaching(ModBlocks.planksOakPainted.id, new ItemStack(Block.planksOak));
        addBleaching(ModBlocks.fencePlanksOakPainted.id, new ItemStack(Block.fencePlanksOak));
        addBleaching(ModBlocks.fencegatePlanksOakPainted.id, new ItemStack(Block.fencegatePlanksOak));
        addBleaching(ModBlocks.slabPlanksOakPainted.id, new ItemStack(Block.slabPlanksOak));
        addBleaching(ModBlocks.stairsPlanksOakPainted.id, new ItemStack(Block.stairsPlanksOak));
        addBleaching(ModBlocks.chestPlanksOakPainted.id, new ItemStack(Block.chestPlanksOak));
        addBleaching(ModBlocks.wool.id, new ItemStack(Block.wool));
        addBleaching(ModBlocks.lampIdle.id, new ItemStack(Block.lampIdle));
    }

    public void addBleaching(int i, ItemStack itemstack) {
        bleachingList.put(i, itemstack);
    }

    public ItemStack getBleachingResult(int i) {
        return (ItemStack)bleachingList.get(i);
    }

    public Map getBleachingList() {
        return bleachingList;
    }
}
