package goocraft4evr.nonamedyes.player.inventory;

import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.Container;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;

import java.util.List;

public class ContainerBleacher extends Container {
    public TileEntityBleacher tileEntity;

    public ContainerBleacher(InventoryPlayer inventoryplayer, TileEntityBleacher tileentitybleacher) {
        tileEntity = tileentitybleacher;
    }

    @Override
    public List<Integer> getMoveSlots(InventoryAction inventoryAction, Slot slot, int i, EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    public List<Integer> getTargetSlots(InventoryAction inventoryAction, Slot slot, int i, EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }
}
