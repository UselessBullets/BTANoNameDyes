package goocraft4evr.nonamedyes.block.blockcolor;

import goocraft4evr.nonamedyes.helper.ModColors;
import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.core.world.World;

public class BlockColorCeramicPainted extends BlockColor {
    @Override
    public int getFallbackColor(int i) {
        try {
            return ModColors.allCeramicColors[i].getARGB();
        } catch (Exception e) {
            return 16711935;
        }
    }

    @Override
    public int getWorldColor(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        return this.getFallbackColor(meta);
    }
}
