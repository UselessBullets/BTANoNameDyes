package goocraft4evr.goocraftbta.mixin;

import net.minecraft.client.render.RenderEngine;
import net.minecraft.client.render.colorizer.ColorProperties;
import net.minecraft.client.render.texturepack.TexturePackBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.io.IOException;
import java.util.Properties;

@Mixin(value= RenderEngine.class, remap = false)
public class RenderEngineMixin {
    @Inject(method="refreshTextures",at=@At("TAIL"),locals = LocalCapture.CAPTURE_FAILHARD)
    private void injected(CallbackInfo ci, TexturePackBase texturePack) {
        Properties colors = new Properties();
        try {
            colors.load(texturePack.getResourceAsStream("assets/goocraft/misc/colors.properties"));
        } catch (IOException iOException) {
            // empty catch block
        }
        //color loading code
        ColorPropertiesAccessor.invokeRegisterLeavesColor("cocoa",colors);
    }
}

@Mixin(value=ColorProperties.class, remap = false)
interface ColorPropertiesAccessor {
    @Invoker("registerLeavesColor")
    static void invokeRegisterLeavesColor(String name, Properties prop) {
        throw new AssertionError();
    }
}