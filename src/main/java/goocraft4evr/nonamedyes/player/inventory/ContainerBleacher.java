package goocraft4evr.nonamedyes.player.inventory;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import goocraft4evr.nonamedyes.player.inventory.slot.SlotBleaching;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.Container;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.player.inventory.slot.SlotFurnace;

import java.util.List;

public class ContainerBleacher extends Container {
    public TileEntityBleacher tileEntity;

    public ContainerBleacher(InventoryPlayer inventoryplayer, TileEntityBleacher tileentitybleacher) {
        tileEntity = tileentitybleacher;
        //fuel slot
        this.addSlot(new Slot(tileEntity, 0, 20, 35));
        //input slots
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                this.addSlot(new Slot(tileentitybleacher, i*2+j+1, 50+j * 18, 17+i * 18));
            }
        }
        //output slots
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                NoNameDyes.LOGGER.info(String.format("slot is %d.",i*2+j+5));
                this.addSlot(new SlotBleaching(tileentitybleacher, i*2+j+5, 122+j * 18, 17+i * 18));
            }
        }
        //inventory slots
        for (int i = 0; i < 3; ++i) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 66 + i * 18));
            }
        }
        for (int j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventoryplayer, j, 8 + j * 18, 124));
        }
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
