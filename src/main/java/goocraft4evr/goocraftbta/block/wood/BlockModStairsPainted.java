package goocraft4evr.goocraftbta.block.wood;

import goocraft4evr.goocraftbta.GoocraftBTA;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockStairs;

public class BlockModStairsPainted extends BlockStairs {
    public BlockModStairsPainted(Block modelBlock, int id) {
        super(modelBlock, id);
        key = "funnystairs" + modelBlock.getKey().substring(5+GoocraftBTA.MOD_ID.length());
    }

    public static int getMetaForDyeColor(int i) {
        return i << 4;
    }
}
