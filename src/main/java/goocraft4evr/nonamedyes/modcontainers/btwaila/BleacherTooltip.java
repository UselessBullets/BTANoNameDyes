package goocraft4evr.nonamedyes.modcontainers.btwaila;

import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import toufoumaster.btwaila.gui.components.AdvancedInfoComponent;
import toufoumaster.btwaila.tooltips.TileTooltip;
import toufoumaster.btwaila.util.ProgressBarOptions;

public class BleacherTooltip extends TileTooltip<TileEntityBleacher> {
    @Override
    public void initTooltip() {
        addClass(TileEntityBleacher.class);
    }
    @Override
    public void drawAdvancedTooltip(TileEntityBleacher tileEntityBleacher, AdvancedInfoComponent advancedInfoComponent) {
        ProgressBarOptions options = (new ProgressBarOptions()).setText("Progress: ");
        advancedInfoComponent.drawProgressBarWithText(tileEntityBleacher.getBleachProgressScaled(100), 100, options, 0);
        advancedInfoComponent.drawStringWithShadow("Bleach time: " + tileEntityBleacher.currentFuelTime + "t", 0);
        advancedInfoComponent.drawItemList(tileEntityBleacher.bleacherItemStacks, 0);
    }
}
