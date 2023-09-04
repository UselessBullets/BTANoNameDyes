package goocraft4evr.nonamedyes.client.gui;

import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import goocraft4evr.nonamedyes.player.inventory.ContainerBleacher;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.core.player.inventory.InventoryPlayer;

public class GuiBleacher extends GuiContainer {
    private TileEntityBleacher bleacherInventory;

    public GuiBleacher(InventoryPlayer inventoryplayer, TileEntityBleacher tileentitybleacher) {
        super(new ContainerBleacher(inventoryplayer, tileentitybleacher));
        this.bleacherInventory = tileentitybleacher;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {

    }
}
