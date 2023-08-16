package goocraft4evr.goocraftbta.mixin;

import net.minecraft.core.block.BlockFire;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = BlockFire.class, remap = false)
public interface BlockFireAccessor {
    @Invoker("setBurnRate")
    void invokeSetBurnRate(int id, int chanceToEncourageFire, int abilityToCatchFire);
}
