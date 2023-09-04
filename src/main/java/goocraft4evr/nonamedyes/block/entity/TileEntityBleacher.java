package goocraft4evr.nonamedyes.block.entity;

import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;

public class TileEntityBleacher extends TileEntity implements IInventory {
    private ItemStack[] bleacherItemStacks = new ItemStack[9];
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

    @Override
    public ItemStack decrStackSize(int i, int j) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {

    }

    @Override
    public String getInvName() {
        return null;
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
