package goocraft4evr.nonamedyes.player.inventory;

import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import goocraft4evr.nonamedyes.player.inventory.slot.SlotBleaching;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.crafting.ICrafting;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.Container;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;

import java.util.List;

public class ContainerBleacher extends Container {
    public TileEntityBleacher tileEntity;
    private boolean hasWaterSource = false;
    private int currentBleachTime = 0;
    private int currentFuelTime = 0;
    private int itemFuelTime = 0;
    private int itemBleachTime = 0;

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
    public void updateInventory() {
        super.updateInventory();
        for (Object crafter : crafters) {
            ICrafting icrafting = (ICrafting)crafter;
            if (hasWaterSource != tileEntity.hasWaterSource) {
                icrafting.updateCraftingInventoryInfo(this, 0, tileEntity.hasWaterSource?1:0);
            }
            if (currentBleachTime != tileEntity.currentBleachTime) {
                icrafting.updateCraftingInventoryInfo(this, 1, tileEntity.currentBleachTime);
            }
            if (currentBleachTime != tileEntity.currentBleachTime) {
                icrafting.updateCraftingInventoryInfo(this, 2, tileEntity.currentBleachTime);
            }
            if (currentFuelTime != tileEntity.currentFuelTime) {
                icrafting.updateCraftingInventoryInfo(this, 3, tileEntity.currentFuelTime);
            }
            if (itemBleachTime != tileEntity.maxBleachTime) {
                icrafting.updateCraftingInventoryInfo(this, 4, tileEntity.maxBleachTime);
            }
            if (itemFuelTime == tileEntity.maxFuelTime) continue;
            icrafting.updateCraftingInventoryInfo(this, 5, tileEntity.maxFuelTime);
        }
        hasWaterSource = tileEntity.hasWaterSource;
        currentBleachTime = tileEntity.currentBleachTime;
        currentFuelTime = tileEntity.currentFuelTime;
        itemBleachTime = tileEntity.maxBleachTime;
        itemFuelTime = tileEntity.maxFuelTime;
    }

    @Override
    public void updateClientProgressBar(int id, int value) {
        if (id == 0) {
            this.tileEntity.hasWaterSource = value==1;
        }
        if (id == 1) {
            this.tileEntity.currentBleachTime = value;
        }
        if (id == 2) {
            this.tileEntity.currentFuelTime = value;
        }
        if (id == 3) {
            this.tileEntity.maxBleachTime = value;
        }
        if (id == 4) {
            this.tileEntity.maxFuelTime = value;
        }
    }

    @Override
    public List<Integer> getMoveSlots(InventoryAction action, Slot slot, int target, EntityPlayer player) {
        if (slot.id >= 0 && slot.id <= 10) {
            return this.getSlots(slot.id, 1, false);
        }
        if (action == InventoryAction.MOVE_ALL) {
            if (slot.id >= 10 && slot.id <= 30) {
                return this.getSlots(10, 27, false);
            }
            if (slot.id >= 30 && slot.id <= 38) {
                return this.getSlots(30, 9, false);
            }
        }
        if (slot.id >= 10 && slot.id <= 38) {
            return this.getSlots(10, 36, false);
        }
        return null;
    }

    @Override
    public List<Integer> getTargetSlots(InventoryAction action, Slot slot, int target, EntityPlayer player) {
        if (slot.id >= 10 && slot.id <= 39) {
            if (action != InventoryAction.MOVE_ALL) {
                if (target == 1) {
                    return this.getSlots(0, 1, false);
                }
                if (target == 9) {
                    return this.getSlots(1, 1, false);
                }
            }
            if (slot.id <= 29) {
                return this.getSlots(30, 9, false);
            }
            if (slot.id >= 31 && slot.id <= 38) {
                return this.getSlots(10, 27, false);
            }
        }
        if (slot.id >= 0 && slot.id <= 9) {
            if (slot.id == 9) {
                return this.getSlots(10, 36, true);
            }
            return this.getSlots(10, 36, false);
        }
        return null;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityplayer) {
        return this.tileEntity.canInteractWith(entityplayer);
    }
}
