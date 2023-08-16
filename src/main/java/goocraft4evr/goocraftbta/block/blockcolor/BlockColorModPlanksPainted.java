package goocraft4evr.goocraftbta.block.blockcolor;

import goocraft4evr.goocraftbta.misc.ModColors;
import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.core.world.World;

public class BlockColorModPlanksPainted extends BlockColor {
    private final boolean useUpperMeta;

    public BlockColorModPlanksPainted(boolean useUpperMeta) {
        this.useUpperMeta = useUpperMeta;
    }
    @Override
    public int getFallbackColor(int meta) {
        if (this.useUpperMeta) {
            meta >>= 4;
        }
        try {
            return ModColors.modPlankColors[meta].getARGB();
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
