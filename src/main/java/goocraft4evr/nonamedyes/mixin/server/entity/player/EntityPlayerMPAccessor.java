package goocraft4evr.nonamedyes.mixin.server.entity.player;

import net.minecraft.server.entity.player.EntityPlayerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value=EntityPlayerMP.class,remap=false)
public interface EntityPlayerMPAccessor {
    @Invoker("getNextWindowId")
    void invokeGetNextWindowId();

    @Accessor()
    int getCurrentWindowId();
}
