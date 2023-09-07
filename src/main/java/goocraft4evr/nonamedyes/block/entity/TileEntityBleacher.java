package goocraft4evr.nonamedyes.block.entity;

import goocraft4evr.nonamedyes.NoNameDyes;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;

public class TileEntityBleacher extends TileEntity implements IInventory {
    private final ItemStack[] bleacherItemStacks = new ItemStack[9];
    public boolean hasWaterSource;
    public int maxFuelTime = 0;
    public int currentFuelTime = 0;
    public int currentBleachTime = 0;
    public int maxBleachTime = 200;
    @Override
    public int getSizeInventory() {
        return bleacherItemStacks.length;
    }

    //slot 0 = fuel input
    //slot 1-4 = block input
    //slot 5-8 = block output
    @Override
    public ItemStack getStackInSlot(int i) {
        return bleacherItemStacks[i];
    }

    public void updateWaterSource() {
        int blockId;
        hasWaterSource =
                (((blockId = worldObj.getBlockId(xCoord,yCoord-1,zCoord)) == Block.fluidWaterStill.id ||
                        blockId == Block.fluidWaterFlowing.id) &&
                        worldObj.getBlockMetadata(xCoord,yCoord-1,zCoord) == 0);
    }

    @Override
    public ItemStack decrStackSize(int slot, int numOfItems) {
        if (this.bleacherItemStacks[slot] != null) {
            if (bleacherItemStacks[slot].stackSize <= numOfItems) {
                ItemStack itemstack = bleacherItemStacks[slot];
                bleacherItemStacks[slot] = null;
                return itemstack;
            }
            ItemStack itemstack1 = bleacherItemStacks[slot].splitStack(numOfItems);
            if (bleacherItemStacks[slot].stackSize <= 0) {
                bleacherItemStacks[slot] = null;
            }
            return itemstack1;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        bleacherItemStacks[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {
        return "Bleacher";
    }

    @Override
    public void updateEntity() {
        boolean isFuelTimeHigherThan0 = currentFuelTime > 0;
        boolean requiresUpdate = false;
        if (currentFuelTime > 0) currentFuelTime--;
        if (!this.worldObj.isClientSide) {
            updateWaterSource();
            if (currentFuelTime == 0 && canBleach()) {
                //NOTE: max fuel time is hardcoded to 8 items
                maxFuelTime = currentFuelTime = 1600;
                requiresUpdate = true;
                if (bleacherItemStacks[0] != null) {
                    bleacherItemStacks[0].stackSize--;
                    if (bleacherItemStacks[0].stackSize <= 0) {
                        bleacherItemStacks[0] = null;
                    }
                }
            }
            if (isFuelled() && canBleach()) {
                currentBleachTime++;
                if (currentBleachTime == maxBleachTime) {
                    //smelt an item and update the furnace
                    currentBleachTime = 0;
                    bleachItem();
                    requiresUpdate = true;
                }
            } currentBleachTime = 0;
            //update the furnace if
            if (isFuelTimeHigherThan0 != currentFuelTime > 0) {
                requiresUpdate = true;
                //TODO: update block
            }
        }
        //change the inventory if the furnace has been updated
        if (requiresUpdate) {
            this.onInventoryChanged();
        }
    }

    //TODO: finish method
    private void bleachItem() {
    }

    //TODO: finish method
    private boolean isFuelled() {
    }

    //TODO: finish method
    private boolean canBleach() {
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
            return false;
        }
        return entityPlayer.distanceToSqr((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) <= 64.0;
    }
}
