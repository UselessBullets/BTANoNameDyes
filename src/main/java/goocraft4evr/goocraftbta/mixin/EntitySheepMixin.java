package goocraft4evr.goocraftbta.mixin;

import goocraft4evr.goocraftbta.block.ModBlocks;
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

    //TODO: overwrites may cause potential issues in the future! (redirectors may be more appropriate)
    //byte 16 = CCCC CCCC (C is a colour bit)
    //byte 17 = 0000 00SE (E is an eating bit, S is a sheared bit)

    @Overwrite
    public boolean getSheared() {
        return (this.getEntityData().getByte(17) & 2) != 0;
    }
    @Overwrite
    public void setSheared(boolean flag) {
        byte byte0 = this.getEntityData().getByte(17);
        if (flag) {
            this.getEntityData().set(17, (byte)(byte0 | 2));
        } else {
            this.getEntityData().set(17, (byte)(byte0 & 1));
        }
    }

    @Overwrite
    public boolean getIsSheepEating() {
        return (this.getEntityData().getByte(17) & 1) != 0;
    }
    @Overwrite
    public void setIsSheepEating(boolean value) {
        byte byte0 = this.getEntityData().getByte(17);
        if (value) {
            this.getEntityData().set(17, (byte)(byte0 | 1));
        } else {
            this.getEntityData().set(17, (byte)(byte0 & 2));
        }
    }

    @Overwrite
    public void setFleeceColor(int i) {
        this.getEntityData().set(16,(byte)i);
    }

    @Overwrite
    public int getFleeceColor() {
        return this.getEntityData().getByte(16);
    }

    @ModifyVariable(method = "interact()Z", at = @At("STORE"), name = "entityitem")
    private EntityItem injected(EntityItem entityitem) {
        if (getFleeceColor()>15) {
            entityitem.item = new ItemStack(ModBlocks.wool.id, 1, getFleeceColor()-16);
        }
        return entityitem;
    }
}

