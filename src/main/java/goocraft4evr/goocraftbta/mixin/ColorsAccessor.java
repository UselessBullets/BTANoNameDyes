package goocraft4evr.goocraftbta.mixin;

import net.minecraft.core.util.helper.Color;
import net.minecraft.core.util.helper.Colors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = Colors.class, remap = false)
public interface ColorsAccessor {
    @Accessor("allChatColors")
    static void setAllChatColors(Color[] colors) {
        throw new AssertionError();
    }
}
