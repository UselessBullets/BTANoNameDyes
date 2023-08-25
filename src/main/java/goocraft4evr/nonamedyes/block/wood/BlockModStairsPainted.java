package goocraft4evr.nonamedyes.block.wood;

import goocraft4evr.nonamedyes.NoNameDyes;
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
