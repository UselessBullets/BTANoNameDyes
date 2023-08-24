package goocraft4evr.nonamedyes.mixin;

import net.minecraft.client.render.colorizer.ColorProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Properties;

@Mixin(value = ColorProperties.class, remap = false)
interface ColorPropertiesAccessor {
    @Invoker("registerLeavesColor")
    static void invokeRegisterLeavesColor(String name, Properties prop) {
        throw new AssertionError();
    }
}
