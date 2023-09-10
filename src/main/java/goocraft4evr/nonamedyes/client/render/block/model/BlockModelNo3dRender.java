package goocraft4evr.nonamedyes.client.render.block.model;

import net.minecraft.client.render.block.model.BlockModelRenderBlocks;

public class BlockModelNo3dRender extends BlockModelRenderBlocks {
    public BlockModelNo3dRender() {
        super(0);
    }

    @Override
    public boolean shouldItemRender3d() {
        return false;
    }
}
