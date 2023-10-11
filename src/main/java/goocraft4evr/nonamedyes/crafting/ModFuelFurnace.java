package goocraft4evr.nonamedyes.crafting;

import goocraft4evr.nonamedyes.block.ModBlocks;

import net.minecraft.core.crafting.LookupFuelFurnace;

public abstract class ModFuelFurnace {
    public static void register() {
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.planksOakPainted.id, 300);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.slabPlanksOakPainted.id, 150);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.fencePlanksOakPainted.id, 300);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.fencegatePlanksOakPainted.id, 300);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.logCocoa.id, 300);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.saplingCocoa.id, 10);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.logCinnamon.id, 300);
        LookupFuelFurnace.instance.addFuelEntry(ModBlocks.saplingCinnamon.id, 10);
    }
}
