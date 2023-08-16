package goocraft4evr.goocraftbta.mixin;

import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.chunk.perlin.nether.ChunkDecoratorNether;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = ChunkDecoratorNether.class, remap = false)
interface ChunkDecoratorNetherAccessor {
    @Accessor
    World getWorld();
}
