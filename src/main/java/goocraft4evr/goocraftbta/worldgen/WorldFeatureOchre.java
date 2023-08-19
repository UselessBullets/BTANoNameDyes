package goocraft4evr.goocraftbta.worldgen;

import goocraft4evr.goocraftbta.GoocraftBTA;
import goocraft4evr.goocraftbta.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureOchre extends WorldFeature {
    private int numberOfBlocks;

    public WorldFeatureOchre(int numberOfBlocks) {
        this.numberOfBlocks = numberOfBlocks;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        float f = random.nextFloat() * 3.141593f;
        double d = (float)(x + 8) + MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0f;
        double d1 = (float)(x + 8) - MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0f;
        double d2 = (float)(z + 8) + MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0f;
        double d3 = (float)(z + 8) - MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0f;
        double d4 = y + random.nextInt(3) + 2;
        double d5 = y + random.nextInt(3) + 2;
        for (int l = 0; l <= this.numberOfBlocks; ++l) {
            double d6 = d + (d1 - d) * (double)l / (double)this.numberOfBlocks;
            double d7 = d4 + (d5 - d4) * (double)l / (double)this.numberOfBlocks;
            double d8 = d2 + (d3 - d2) * (double)l / (double)this.numberOfBlocks;
            double d9 = random.nextDouble() * (double)this.numberOfBlocks / 16.0;
            double d10 = (double)(MathHelper.sin((float)l * 3.141593f / (float)this.numberOfBlocks) + 1.0f) * d9 + 1.0;
            double d11 = (double)(MathHelper.sin((float)l * 3.141593f / (float)this.numberOfBlocks) + 1.0f) * d9 + 1.0;
            int i1 = MathHelper.floor_double(d6 - d10 / 2.0);
            int j1 = MathHelper.floor_double(d7 - d11 / 2.0);
            int k1 = MathHelper.floor_double(d8 - d10 / 2.0);
            int l1 = MathHelper.floor_double(d6 + d10 / 2.0);
            int i2 = MathHelper.floor_double(d7 + d11 / 2.0);
            int j2 = MathHelper.floor_double(d8 + d10 / 2.0);
            for (int k2 = i1; k2 <= l1; ++k2) {
                double d12 = ((double)k2 + 0.5 - d6) / (d10 / 2.0);
                if (d12 * d12 >= 1.0) continue;
                for (int l2 = j1; l2 <= i2; ++l2) {
                    double d13 = ((double)l2 + 0.5 - d7) / (d11 / 2.0);
                    if (d12 * d12 + d13 * d13 >= 1.0) continue;
                    for (int i3 = k1; i3 <= j2; ++i3) {
                        double d14 = ((double)i3 + 0.5 - d8) / (d10 / 2.0);
                        int blockId = world.getBlockId(k2, l2, i3);
                        if (!(d12 * d12 + d13 * d13 + d14 * d14 < 1.0) || (blockId != Block.sand.id && blockId != Block.dirtScorched.id)) continue;
                        world.setBlock(k2, l2, i3, ModBlocks.ochreBlock.id);
                    }
                }
            }
        }
        return true;
    }
}
