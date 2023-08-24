package goocraft4evr.nonamedyes;

import net.minecraft.core.block.Block;
import turniplabs.halplibe.helper.TextureHelper;

public class TextureMap {
    private int[] textures;
    private int curr;
    private String modid;

    public TextureMap(String modid, int length) {
        this.modid = modid;
        textures = new int[length];
        curr = 0;
    }

    public int getTexture(int index) {
        return textures[index];
    }

    public int length() {
        return textures.length;
    }

    public void addBlockTexture(String texture) {
        int[] mainCoords = TextureHelper.getOrCreateBlockTexture(modid, texture);
        textures[curr++] = Block.texCoordToIndex(mainCoords[0],mainCoords[1]);
    }

    public void addItemTexture(String texture) {
        int[] mainCoords = TextureHelper.getOrCreateItemTexture(modid, texture);
        textures[curr++] = Block.texCoordToIndex(mainCoords[0],mainCoords[1]);
    }
}
