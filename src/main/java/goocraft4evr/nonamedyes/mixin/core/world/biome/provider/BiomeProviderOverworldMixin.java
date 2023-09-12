package goocraft4evr.nonamedyes.mixin.core.world.biome.provider;

import goocraft4evr.nonamedyes.world.biome.ModBiomes;
import net.minecraft.core.world.biome.data.BiomeRange;
import net.minecraft.core.world.biome.data.BiomeRangeMap;
import net.minecraft.core.world.biome.provider.BiomeProviderOverworld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= BiomeProviderOverworld.class,remap=false)
public abstract class BiomeProviderOverworldMixin {
    @Shadow @Final private static BiomeRangeMap brm;
    @Inject(method="init",at=@At("HEAD"))
    private static void init(CallbackInfo ci) {
        brm.addRange(ModBiomes.OVERWORLD_CINNAMON_FOREST, new BiomeRange(
                0.6,
                1.0,
                0.8,
                1.0,
                0.0,
                1.0,
                0.1,
                1.0));
    }
}
