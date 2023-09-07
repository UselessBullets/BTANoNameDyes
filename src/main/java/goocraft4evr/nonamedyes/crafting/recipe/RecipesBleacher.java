package goocraft4evr.nonamedyes.crafting.recipe;

import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.recipe.RecipesFurnace;
import net.minecraft.core.item.Item;
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
        this.addBleaching(Block.oreCoalStone.id, new ItemStack(Item.coal));
        //TODO: add more recipes
    }

    public void addBleaching(int i, ItemStack itemstack) {
        this.bleachingList.put(i, itemstack);
    }

    public ItemStack getBleachingResult(int i) {
        return (ItemStack)this.bleachingList.get(i);
    }

    public Map getBleachingList() {
        return this.bleachingList;
    }
}
