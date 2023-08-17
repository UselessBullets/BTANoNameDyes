package goocraft4evr.goocraftbta.block.wood;

import goocraft4evr.goocraftbta.GoocraftBTA;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockSlab;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class BlockModSlabPainted extends BlockSlab {
    public BlockModSlabPainted(Block modelBlock, int id) {
        super(modelBlock, id);
        key = "funnyslab" + modelBlock.getKey().substring(5+GoocraftBTA.MOD_ID.length());
    }

    public static int getMetadataForColour(int i) {
        return i << 4;
    }

    @Override
    public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
        int meta = entity.getVerticalPlacementDirection(side, sideHeight) == Direction.UP ? 2 : 0;
        world.setBlockMetadataWithNotify(x, y, z, meta | world.getBlockMetadata(x, y, z));
    }

}
