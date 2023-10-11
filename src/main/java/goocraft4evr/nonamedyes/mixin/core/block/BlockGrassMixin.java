package goocraft4evr.nonamedyes.mixin.core.block;

import goocraft4evr.nonamedyes.block.ModBlocks;
import goocraft4evr.nonamedyes.world.biome.ModBiomes;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockGrass;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Random;

@Mixin(value= BlockGrass.class,remap=false)
public abstract class BlockGrassMixin {
    @ModifyVariable(method="updateTick",at=@At(value="LOAD"),name="idToSpawn")
    private int updateId(int id, World world, int x, int y, int z, Random rand) {
        if (!(id == Block.flowerRed.id && rand.nextInt(2) == 0)) return id;
        Biome biome = world.getBlockBiome(x,y,z);
        if (biome == Biomes.OVERWORLD_SEASONAL_FOREST ||
            biome == Biomes.OVERWORLD_RAINFOREST ||
            biome == ModBiomes.OVERWORLD_CINNAMON_FOREST) {
            return ModBlocks.flowerIndigo.id;
        }
        return id;
    }
}
