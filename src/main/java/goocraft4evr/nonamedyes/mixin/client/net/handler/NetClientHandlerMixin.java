package goocraft4evr.nonamedyes.mixin.client.net.handler;

import goocraft4evr.nonamedyes.block.BlockBleacher;
import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.net.handler.NetClientHandler;
import net.minecraft.core.net.packet.Packet100OpenWindow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= NetClientHandler.class,remap = false)
public abstract class NetClientHandlerMixin {

    @Shadow
    private Minecraft mc;

    @Inject(method="handleOpenWindow",at=@At("TAIL"))
    public void inject(Packet100OpenWindow packet100openwindow, CallbackInfo ci) {
        if (packet100openwindow.inventoryType == 8) {
            TileEntityBleacher tileentitybleacher = new TileEntityBleacher();
            BlockBleacher.displayGUIBleacherClient(this.mc.thePlayer,tileentitybleacher);
            this.mc.thePlayer.craftingInventory.windowId = packet100openwindow.windowId;
        }
    }
}
