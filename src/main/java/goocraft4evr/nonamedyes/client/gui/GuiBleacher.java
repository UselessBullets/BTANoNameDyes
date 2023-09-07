package goocraft4evr.nonamedyes.client.gui;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import goocraft4evr.nonamedyes.player.inventory.ContainerBleacher;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import org.lwjgl.opengl.GL11;

public class GuiBleacher extends GuiContainer {
    private final TileEntityBleacher bleacher;

    public GuiBleacher(InventoryPlayer inventoryplayer, TileEntityBleacher tileentitybleacher) {
        super(new ContainerBleacher(inventoryplayer, tileentitybleacher));
        ySize = 148;
        bleacher = tileentitybleacher;
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        fontRenderer.drawString("Bleacher", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, ySize - 112 + 18, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {
        int guiTexture = mc.renderEngine.getTexture(String.format("/assets/%s/gui/bleaching.png", NoNameDyes.MOD_ID));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mc.renderEngine.bindTexture(guiTexture);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
        if (bleacher.hasWaterSource) {
            drawTexturedModalRect(j + 18, k + 16, 176, 0, 3, 16);
            drawTexturedModalRect(j + 33, k + 16, 179, 0, 3, 16);
        }
        if (bleacher.currentFuelTime > 0) {
            int len = bleacher.getFuelRemainingScaled(16);
            drawTexturedModalRect(j + 21, k + 16 + 16 - len, 176, 32 - len, 12, len + 2);
        }
        if (bleacher.isFuelled()) {
            int len = bleacher.getBleachProgressScaled(24);
            drawTexturedModalRect(j + 91, k + 25, 176, 32, len + 1, 16);
        }
    }
}
