package goocraft4evr.nonamedyes.modcontainers.btwaila;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import net.minecraft.core.block.entity.TileEntity;
import toufoumaster.btwaila.BTWaila;
import toufoumaster.btwaila.IBTWailaCustomBlockTooltip;
import toufoumaster.btwaila.TooltipGroup;
import toufoumaster.btwaila.TooltipRegistry;
import toufoumaster.btwaila.gui.GuiBlockOverlay;
import toufoumaster.btwaila.util.ProgressBarOptions;

public class BleacherTooltip implements IBTWailaCustomBlockTooltip {
    public void addTooltip() {
        BTWaila.LOGGER.info("Adding tooltips for: " + this.getClass().getSimpleName());
        TooltipGroup tooltipGroup = new TooltipGroup(NoNameDyes.MOD_ID, TileEntityBleacher.class, this);
        tooltipGroup.addTooltip(TileEntityBleacher.class);
        TooltipRegistry.tooltipMap.add(tooltipGroup);
    }

    public void drawAdvancedTooltip(TileEntity tileEntity, GuiBlockOverlay guiBlockOverlay) {
        TileEntityBleacher bleacher = (TileEntityBleacher)tileEntity;
        ProgressBarOptions options = (new ProgressBarOptions()).setText("Progress: ");
        guiBlockOverlay.drawProgressBarWithText(bleacher.getBleachProgressScaled(100), 100, options, 32);
        guiBlockOverlay.drawStringWithShadow("Bleach time: " + bleacher.currentFuelTime + "t", 0);
        guiBlockOverlay.drawItemList(bleacher.bleacherItemStacks, 0);
    }
}
