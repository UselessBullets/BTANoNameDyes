package goocraft4evr.nonamedyes.modcontainers.terrainapi;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.world.biome.ModBiomes;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureNetherRoots;
import goocraft4evr.nonamedyes.world.worldgen.WorldFeatureOchre;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.generate.feature.WorldFeatureFlowers;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import useless.terrainapi.api.TerrainAPI;
import useless.terrainapi.config.TerrainAPIConfig;
import useless.terrainapi.generation.VanillaFunctions;
import useless.terrainapi.generation.nether.ChunkDecoratorNetherAPI;
import useless.terrainapi.generation.overworld.ChunkDecoratorOverworldAPI;
import useless.terrainapi.generation.overworld.OverworldBiomeFeatures;

public class TerrainApiPlugin implements TerrainAPI {
    @Override
    public String getModID() {
        return NoNameDyes.MOD_ID;
    }

    @Override
    public void onInitialize() {
		TerrainAPIConfig overworldConfig = ChunkDecoratorOverworldAPI.overworldConfig;
		ChunkDecoratorOverworldAPI.oreFeatures.setOreValues(getModID(), ModBlocks.oreMalachiteStone, 6, 2, 1/4f);
		OverworldBiomeFeatures.treeDensityMap.put(ModBiomes.OVERWORLD_CINNAMON_FOREST, 8);
		OverworldBiomeFeatures.treeDensityMap.put(ModBiomes.OVERWORLD_EBONY_FOREST, 4);
		OverworldBiomeFeatures.grassDensityMap.put(ModBiomes.OVERWORLD_CINNAMON_FOREST, 10);
		OverworldBiomeFeatures.grassDensityMap.put(ModBiomes.OVERWORLD_EBONY_FOREST, 2);
		VanillaFunctions.biomeRandomGrassType.put(ModBiomes.OVERWORLD_CINNAMON_FOREST, Block.tallgrassFern.id);

		ChunkDecoratorOverworldAPI.oreFeatures.addFeature(new WorldFeatureOre(ModBlocks.oreMalachiteStone.id,
			overworldConfig.clusterSize.get(ModBlocks.oreMalachiteStone.getKey()), true),
			overworldConfig.chancesPerChunk.get(ModBlocks.oreMalachiteStone.getKey()),
			overworldConfig.verticalRange.get(ModBlocks.oreMalachiteStone.getKey()));

		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureFlowers(ModBlocks.mushroomInkCap.id), 48, -1, 1,
			new Biome[]{Biomes.OVERWORLD_GRASSLANDS, Biomes.OVERWORLD_MEADOW, Biomes.OVERWORLD_PLAINS});
		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureOchre(48), 6, -1, 1,
			new Biome[]{Biomes.OVERWORLD_DESERT, Biomes.OVERWORLD_OUTBACK, Biomes.OVERWORLD_OUTBACK_GRASSY});
		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureFlowers(ModBlocks.flowerIndigo.id), 2, 1, 1,
			new Biome[]{Biomes.OVERWORLD_RAINFOREST, Biomes.OVERWORLD_SEASONAL_FOREST, ModBiomes.OVERWORLD_CINNAMON_FOREST});

		ChunkDecoratorNetherAPI.randomFeatures.addComplexFeature(ComplexFunctions::getVileNetherrack, null, (Object[] x) -> 1, null, 1, 120/128f);
		ChunkDecoratorNetherAPI.biomeFeatures.addComplexFeature((Object[] x) -> new WorldFeatureNetherRoots(24), null, ComplexFunctions::getNetherRootsDensity, null);
    }
}
