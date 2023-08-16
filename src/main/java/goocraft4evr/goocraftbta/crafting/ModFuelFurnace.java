package goocraft4evr.goocraftbta.crafting;

import goocraft4evr.goocraftbta.block.ModBlocks;

import net.minecraft.core.crafting.LookupFuelFurnace;

public abstract class ModFuelFurnace {
    public static void register() {
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.planksOakPainted.id, 300);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.slabPlanksOakPainted.id, 150);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.fencePlanksOakPainted.id, 300);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.fencegatePlanksOakPainted.id, 300);
    }
}
