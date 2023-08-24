package goocraft4evr.nonamedyes.mixin.entity;

import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.animal.EntitySheep;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = EntitySheep.class, remap=false)
public abstract class EntitySheepMixin
        extends EntityAnimal {
    public EntitySheepMixin(World world) {
        super(world);
    }

    //byte 16 = CCCS CCCC
    //byte 17 = 0000 000E

    @Overwrite
    public void setFleeceColor(int i) {
        getEntityData().set(16,(byte)
                (getEntityData().getByte(16)&0x10|i&0xF|i<<1&0xE0)
        );
    }

    @Overwrite
    public int getFleeceColor() {
        int colour = getEntityData().getByte(16);
        return (colour&0xE0)>>1|colour&0xF;
    }

    @ModifyVariable(method = "interact()Z", at = @At("STORE"), name = "entityitem")
    private EntityItem injected(EntityItem entityitem) {
        if (getFleeceColor()>15) {
            entityitem.item = new ItemStack(ModBlocks.wool.id, 1, getFleeceColor()-16);
        }
        return entityitem;
    }
}

