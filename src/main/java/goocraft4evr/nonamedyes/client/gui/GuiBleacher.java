package goocraft4evr.nonamedyes.client.gui;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import goocraft4evr.nonamedyes.player.inventory.ContainerBleacher;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import org.lwjgl.opengl.GL11;

public class GuiBleacher extends GuiContainer {
    private TileEntityBleacher bleacher;

    public GuiBleacher(InventoryPlayer inventoryplayer, TileEntityBleacher tileentitybleacher) {
        super(new ContainerBleacher(inventoryplayer, tileentitybleacher));
        ySize = 148;
        this.bleacher = tileentitybleacher;
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString("Bleacher", 60, 6, 0x404040);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 112 + 18, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {
        int guiTexture = this.mc.renderEngine.getTexture(String.format("/assets/%s/gui/bleaching.png", NoNameDyes.MOD_ID));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(guiTexture);
        int j = (this.width - this.xSize) / 2;
        int k = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);
        if (bleacher.hasWaterSource) {
            this.drawTexturedModalRect(j + 18, k + 16, 176, 0, 3, 16);
            this.drawTexturedModalRect(j + 33, k + 16, 179, 0, 3, 16);
        }
        //TODO: implement progress bar
        if (false) {
            this.drawTexturedModalRect(j + 91, k + 25, 176, 32, 24, 16);
        }
    }
}
