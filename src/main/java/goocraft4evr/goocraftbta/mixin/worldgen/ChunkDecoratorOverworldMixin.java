package goocraft4evr.goocraftbta.mixin.worldgen;

import goocraft4evr.goocraftbta.GoocraftBTA;
import goocraft4evr.goocraftbta.block.ModBlocks;
import goocraft4evr.goocraftbta.worldgen.WorldFeatureOchre;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.block.BlockSand;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.generate.feature.WorldFeatureClay;
import net.minecraft.core.world.generate.feature.WorldFeatureFlowers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;


@Mixin(value= ChunkDecoratorOverworld.class, remap = false)
public class ChunkDecoratorOverworldMixin {
    @Shadow
    private World world;

    @Inject(method="decorate()V",at=@At("HEAD"))
    public void decorate(Chunk chunk, CallbackInfo info) {
        int chunkX = chunk.xPosition;
        int chunkZ = chunk.zPosition;
        int minY = world.getWorldType().getOceanY();
        int maxY = world.getWorldType().getMaxY();
        int rangeY = maxY + 1 - minY;
        BlockSand.fallInstantly = true;
        int x = chunkX << 4;
        int z = chunkZ << 4;
        int y = world.getHeightValue(x + 16, z + 16);
        Biome biome = world.getBlockBiome(x + 16, y, z + 16);
        float oreHeightModifier = (float)rangeY / 128.0f;
        Random rand = new Random(this.world.getRandomSeed());
        long l1 = rand.nextLong() / 2L * 2L + 1L;
        long l2 = rand.nextLong() / 2L * 2L + 1L;
        rand.setSeed((long)chunkX * l1 + (long)chunkZ * l2 ^ this.world.getRandomSeed());

        if ((biome == Biomes.OVERWORLD_GRASSLANDS
            || biome == Biomes.OVERWORLD_MEADOW
            || biome == Biomes.OVERWORLD_PLAINS
            || biome == Biomes.OVERWORLD_SHRUBLAND) &&
                rand.nextInt(3) == 0) {
            int blockX = x + rand.nextInt(16) + 8;
            int blockY =  + rand.nextInt(rangeY);
            int blockZ = z + rand.nextInt(16) + 8;
            new WorldFeatureFlowers(ModBlocks.mushroomInkCap.id).generate(world, rand, blockX, blockY, blockZ);
        }
        if ((biome == Biomes.OVERWORLD_DESERT ||
            biome == Biomes.OVERWORLD_OUTBACK ||
            biome == Biomes.OVERWORLD_OUTBACK_GRASSY)&&
            rand.nextInt(25)==0) {
            int k5 = x + rand.nextInt(16);
            int l8 = minY + rand.nextInt(rangeY);
            int k11 = z + rand.nextInt(16);
            new WorldFeatureOchre(96).generate(this.world, rand, k5, l8, k11);
            world.getWorldType().getMaxY();
        }
    }
}
