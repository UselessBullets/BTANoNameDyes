package goocraft4evr.goocraftbta.block.blockcolor;

import goocraft4evr.goocraftbta.misc.ModColors;
import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.core.world.World;

public class BlockColorModLampsPainted extends BlockColor {
    @Override
    public int getFallbackColor(int meta) {
        try {
            return ModColors.modLampColors[meta].getARGB();
        } catch (Exception var3) {
            return 16711935;
        }
    }

    @Override
    public int getWorldColor(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        return this.getFallbackColor(meta);
    }
}
