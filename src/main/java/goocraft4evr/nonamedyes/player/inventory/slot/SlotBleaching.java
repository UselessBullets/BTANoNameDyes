package goocraft4evr.nonamedyes.player.inventory.slot;

import net.minecraft.core.achievement.AchievementList;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import net.minecraft.core.player.inventory.slot.Slot;

public class SlotBleaching extends Slot {
    public SlotBleaching(IInventory inventory, int id, int x, int y) {
        super(inventory, id, x, y);
    }

    @Override
    public boolean canPutStackInSlot(ItemStack itemstack) {
        return false;
    }

    @Override
    public boolean enableDragAndPickup() {
        return false;
    }

    @Override
    public boolean allowItemInteraction() {
        return false;
    }
}
