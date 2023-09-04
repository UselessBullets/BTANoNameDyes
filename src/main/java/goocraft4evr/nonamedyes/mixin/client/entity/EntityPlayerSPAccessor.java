package goocraft4evr.nonamedyes.mixin.client.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value= EntityPlayerSP.class,remap = false)
public interface EntityPlayerSPAccessor {
    @Accessor()
    Minecraft getMc();
}
