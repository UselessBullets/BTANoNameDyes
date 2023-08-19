package goocraft4evr.goocraftbta.mixin.misc;

import net.minecraft.core.util.helper.Color;
import net.minecraft.core.util.helper.Colors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value= Colors.class,remap = false)
public interface ColorsAccessor {
    @Accessor("allChatColors")
    public static void setAllChatColors(Color[] colors) {
        throw new AssertionError();
    }
    @Accessor("allPlankColors")
    public static void setAllPlankColors(Color[] colors) {
        throw new AssertionError();
    }
    @Accessor("allLampColors")
    public static void setAllLampColors(Color[] colors) {
        throw new AssertionError();
    }
    @Accessor("allFlagColors")
    public static void setAllFlagColors(Color[] colors) {
        throw new AssertionError();
    }
    @Accessor("allSignColors")
    public static void setAllSignColors(Color[] colors) {
        throw new AssertionError();
    }
}
