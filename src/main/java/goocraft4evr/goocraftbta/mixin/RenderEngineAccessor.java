package goocraft4evr.goocraftbta.mixin;

import net.minecraft.client.render.RenderEngine;
import net.minecraft.client.render.texturepack.TexturePackList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = RenderEngine.class, remap = false)
interface RenderEngineAccessor {
    @Accessor
    TexturePackList getTexturePacks();
}
