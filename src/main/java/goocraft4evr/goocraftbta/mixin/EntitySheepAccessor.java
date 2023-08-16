package goocraft4evr.goocraftbta.mixin;

import net.minecraft.core.entity.animal.EntitySheep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = EntitySheep.class, remap=false)
public interface EntitySheepAccessor {
    @Accessor("fleeceColorTable")
    public static void setFleeceColorTable(float[][] table) {
        throw new AssertionError();
    }
}
