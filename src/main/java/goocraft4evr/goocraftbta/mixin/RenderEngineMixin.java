package goocraft4evr.goocraftbta.mixin;


import goocraft4evr.goocraftbta.misc.ModColors;
import net.minecraft.client.render.RenderEngine;
import net.minecraft.client.render.texturepack.TexturePackList;
import net.minecraft.core.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = RenderEngine.class, remap = false)
public abstract class RenderEngineMixin {
    @Inject(method = "refreshTextures()V", at = @At("TAIL"))
    private void injectMethod(CallbackInfo info) {
        ModColors.loadColors(((RenderEngineAccessor)this).getTexturePacks().selectedTexturePack);
    }
}

