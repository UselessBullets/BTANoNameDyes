package goocraft4evr.goocraftbta.block.wood;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockStairs;

public class BlockModStairsPainted extends BlockStairs {
    public BlockModStairsPainted(Block modelBlock, int id) {
        super(modelBlock, id);
    }

    public static int getMetaForDyeColor(int i) {
        return i << 4;
    }
}
