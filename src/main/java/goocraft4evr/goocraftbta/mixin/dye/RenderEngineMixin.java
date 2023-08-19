package goocraft4evr.goocraftbta.mixin.dye;


import goocraft4evr.goocraftbta.misc.ModColors;
import net.minecraft.client.render.RenderEngine;
import net.minecraft.client.render.texturepack.TexturePackList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderEngine.class, remap = false)
public abstract class RenderEngineMixin {
    @Shadow
    public TexturePackList texturePacks;
    @Inject(method = "refreshTextures()V", at = @At("TAIL"))
    private void injectMethod(CallbackInfo info) {
        //ModColors.loadColors(texturePacks.selectedTexturePack);
    }
}

