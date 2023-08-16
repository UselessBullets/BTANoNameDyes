package goocraft4evr.goocraftbta.mixin;

import net.minecraft.core.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;


@Mixin(value = Block.class, remap = false)
public interface BlockAccessor {
    @Invoker("withDisabledNeighborNotifyOnMetadataChange")
    Block invokeWithDisabledNeighborNotifyOnMetadataChange();

    @Invoker("withHardness")
    Block invokeWithHardness(float var1);

    @Invoker("withBlastResistance")
    Block invokeWithBlastResistance(float var1);

    @Invoker("withLightOpacity")
    Block invokeWithLightOpacity(int var1);

    @Invoker("withLightValue")
    Block invokeWithLightValue(float var1);

    @Invoker("withLightValue")
    Block invokeWithLightValue(int var1);

    @Invoker("withImmovableFlagSet")
    Block invokeWithImmovableFlagSet();

    @Invoker("withLitInteriorSurface")
    Block invokeWithLitInteriorSurface(boolean var1);

    @Invoker("withSetUnbreakable")
    Block invokeWithSetUnbreakable();

    @Invoker("withDisabledStats")
    Block invokeWithDisabledStats();
}
