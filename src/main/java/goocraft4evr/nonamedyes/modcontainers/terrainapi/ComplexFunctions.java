package goocraft4evr.nonamedyes.modcontainers.terrainapi;

import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import useless.terrainapi.generation.Parameters;

import java.util.Random;

public class ComplexFunctions {
    public static WorldFeature getVileNetherrack(Object[] parameters){
        Random random = Parameters.getRandom(parameters);
        return new WorldFeatureOre(ModBlocks.netherrackVile.id, 16+random.nextInt(16), false);
    }
    public static int getNetherRootsDensity(Object[] parameters){
        Random random = Parameters.getRandom(parameters);
        return (8+random.nextInt(4))<<2;
    }
}
