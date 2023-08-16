package goocraft4evr.goocraftbta.block;

import goocraft4evr.goocraftbta.mixin.BlockAccessor;
import goocraft4evr.goocraftbta.mixin.BlockFireAccessor;
import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.client.sound.block.BlockSoundDispatcher;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.block.ItemBlock;
import turniplabs.halplibe.helper.TextureHelper;

public class BlockBuilder {
    private Block block;

    public BlockBuilder(Block block) {
        Item.itemsList[block.id] = new ItemBlock(block);
        this.block = block;
    }

    public BlockBuilder withDisabledNeighborNotifyOnMetadataChange() {
        ((BlockAccessor)block).invokeWithDisabledNeighborNotifyOnMetadataChange();
        return this;
    }

    public BlockBuilder withLightOpacity(int opacity) {
        ((BlockAccessor)block).invokeWithLightOpacity(opacity);
        return this;
    }

    public BlockBuilder withLightValue(float lightValue) {
        ((BlockAccessor)block).invokeWithLightValue(lightValue);
        return this;
    }

    public BlockBuilder withLightValue(int lightValue) {
        ((BlockAccessor)block).invokeWithLightValue(lightValue);
        return this;
    }

    public BlockBuilder withImmovableFlagSet() {
        ((BlockAccessor)block).invokeWithImmovableFlagSet();
        return this;
    }

    public BlockBuilder withBlastResistance(float blastResistance) {
        ((BlockAccessor)block).invokeWithBlastResistance(blastResistance);
        return this;
    }

    public BlockBuilder withHardness(float blockHardness) {
        ((BlockAccessor)block).invokeWithHardness(blockHardness);
        return this;
    }

    public BlockBuilder withLitInteriorSurface(boolean isLit) {
        ((BlockAccessor)block).invokeWithLitInteriorSurface(isLit);
        return this;
    }

    public BlockBuilder withSetUnbreakable() {
        ((BlockAccessor)block).invokeWithSetUnbreakable();
        return this;
    }

    public BlockBuilder withCustomTextures(String modId,
                                           String texture) {
        int[] tex = TextureHelper.registerBlockTexture(modId, texture);
        block.withTexCoords(tex[0], tex[1]);
        return this;
    }

    public BlockBuilder withCustomTextures(String modId,
                                           String topBottomTexture,
                                           String sidesTexture) {
        int[] topBottom = TextureHelper.registerBlockTexture(modId, topBottomTexture);
        int[] sides = TextureHelper.registerBlockTexture(modId, sidesTexture);
        block.withTexCoords(topBottom[0], topBottom[1], sides[0], sides[1]);
        return this;
    }

    public BlockBuilder withCustomTextures(String modId,
                                           String topTexture,
                                           String bottomTexture,
                                           String sidesTexture) {
        int[] top = TextureHelper.registerBlockTexture(modId, topTexture);
        int[] bottom = TextureHelper.registerBlockTexture(modId, bottomTexture);
        int[] sides = TextureHelper.registerBlockTexture(modId, sidesTexture);
        block.withTexCoords(top[0], top[1], bottom[0], bottom[1], sides[0], sides[1]);
        return this;
    }

    public BlockBuilder withCustomTextures(String modId,
                                           String topTexture,
                                           String bottomTexture,
                                           String northTexture,
                                           String eastTexture,
                                           String southTexture,
                                           String westTexture) {
        int[] top = TextureHelper.registerBlockTexture(modId, topTexture);
        int[] bottom = TextureHelper.registerBlockTexture(modId, bottomTexture);
        int[] north = TextureHelper.registerBlockTexture(modId, northTexture);
        int[] south = TextureHelper.registerBlockTexture(modId, southTexture);
        int[] east = TextureHelper.registerBlockTexture(modId, eastTexture);
        int[] west = TextureHelper.registerBlockTexture(modId, westTexture);
        block.withTexCoords(top[0],top[1],bottom[0],bottom[1],north[0],north[1],south[0],south[1],east[0],east[1],west[0],west[1]);
        return this;
    }

    public BlockBuilder withDisabledStats() {
        ((BlockAccessor)block).invokeWithDisabledStats();
        return this;
    }

    public BlockBuilder withBlockSound(BlockSound sound) {
        BlockSoundDispatcher.getInstance().addDispatch(block,sound);
        return this;
    }
    public BlockBuilder withBurnRate(int chanceToEncourageFire, int abilityToCatchFire) {
        ((BlockFireAccessor)Block.fire).invokeSetBurnRate(block.id, chanceToEncourageFire, abilityToCatchFire);
        return this;
    }
    public BlockBuilder withBlockColor(BlockColor color) {
        BlockColorDispatcher.getInstance().addDispatch(block, color);
        return this;
    }
    public BlockBuilder withBlockModel(BlockModel model) {
        BlockModelDispatcher.getInstance().addDispatch(block, model);
        return this;
    }

    public Block toBlock() {
        return block;
    }
}
