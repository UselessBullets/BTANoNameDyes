package goocraft4evr.nonamedyes.mixin.core.world.generate.chunk.perlin.overworld;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.world.biome.ModBiomes;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureOchre;
import net.minecraft.core.block.BlockSand;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.generate.feature.WorldFeatureFlowers;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;


@Mixin(value= ChunkDecoratorOverworld.class, remap = false)
public abstract class ChunkDecoratorOverworldMixin {
    @Final
    private World world;

    @Inject(method="decorate",at=@At("TAIL"))
    public void decorate(Chunk chunk, CallbackInfo info) {
        int chunkX = chunk.xPosition;
        int chunkZ = chunk.zPosition;
        int minY = world.getWorldType().getMinY();
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
        int blockX, blockY, blockZ;

        if (biome == ModBiomes.OVERWORLD_CINNAMON_FOREST) {
            NoNameDyes.LOGGER.info(String.format("FOUND at %d %d %d",x,y,z));
        }

        for (int i=0;(float)i<1.5f*oreHeightModifier;i++) {
            blockX = x + rand.nextInt(16);
            blockY = minY + rand.nextInt(rangeY / 4);
            blockZ = z + rand.nextInt(16);
            new WorldFeatureOre(ModBlocks.oreMalachiteStone.id, 6, true).generate(world, rand, blockX, blockY, blockZ);
        }
        if ((biome == Biomes.OVERWORLD_GRASSLANDS
            || biome == Biomes.OVERWORLD_MEADOW
            || biome == Biomes.OVERWORLD_PLAINS) &&
                rand.nextInt(48) == 0) {
            blockX = x + rand.nextInt(16) + 8;
            blockZ = z + rand.nextInt(16) + 8;
            blockY = world.getHeightValue(blockX, blockZ);
            new WorldFeatureFlowers(ModBlocks.mushroomInkCap.id).generate(world, rand, blockX, blockY, blockZ);
        }
        if ((biome == Biomes.OVERWORLD_DESERT ||
            biome == Biomes.OVERWORLD_OUTBACK ||
            biome == Biomes.OVERWORLD_OUTBACK_GRASSY) &&
            rand.nextInt(6) == 0) {
            blockX = x + rand.nextInt(16);
            blockZ = z + rand.nextInt(16);
            blockY = world.getWorldType().getOceanY() + rand.nextInt(maxY + 1 - world.getWorldType().getOceanY());
            new WorldFeatureOchre(48).generate(world, rand, blockX, blockY, blockZ);
            world.getWorldType().getMaxY();
        }
        if ((biome == Biomes.OVERWORLD_RAINFOREST || biome == Biomes.OVERWORLD_SEASONAL_FOREST)
            && rand.nextInt(2) == 0) {
            blockX = x + rand.nextInt(16) + 8;
            blockY = minY + rand.nextInt(rangeY);
            blockZ = z + rand.nextInt(16) + 8;
            new WorldFeatureFlowers(ModBlocks.flowerIndigo.id).generate(world, rand, blockX, blockY, blockZ);
        }
    }
}
