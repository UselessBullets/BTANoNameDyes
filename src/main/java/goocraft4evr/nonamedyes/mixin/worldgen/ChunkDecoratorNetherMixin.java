package goocraft4evr.nonamedyes.mixin.worldgen;

import goocraft4evr.nonamedyes.worldgen.WorldFeatureNetherRoots;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkDecorator;
import net.minecraft.core.world.generate.chunk.perlin.nether.ChunkDecoratorNether;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = ChunkDecoratorNether.class, remap = false)
public abstract class ChunkDecoratorNetherMixin implements ChunkDecorator {
    @Shadow
    private World world;

    @Inject(method = "decorate()V", at = @At("TAIL"))
    private void injectMethod(Chunk chunk, CallbackInfo info) {
        //define chunk vals
        int chunkX = chunk.xPosition;
        int chunkZ = chunk.zPosition;
        //define absolute vals
        int x = chunkX<<4;
        int z = chunkZ<<4;
        //define random
        Random rand = new Random((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
        //get Y range
        int minY = world.getWorldType().getMinY();
        int maxY = world.getWorldType().getMaxY();
        int rangeY = maxY + 1 - minY;

        int xf;
        int yf;
        int zf;
        int max = 8+rand.nextInt(4);
        for(int i=0;i<max;i++) {
            xf = x + rand.nextInt(16) + 8;
            yf = minY + rand.nextInt(rangeY);
            zf = z + rand.nextInt(16) + 8;
            (new WorldFeatureNetherRoots()).generate(world, rand, xf, yf, zf);
        }
    }
}

