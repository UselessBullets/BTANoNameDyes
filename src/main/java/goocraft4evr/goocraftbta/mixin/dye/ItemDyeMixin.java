package goocraft4evr.goocraftbta.mixin.dye;

import goocraft4evr.goocraftbta.GoocraftBTA;
import goocraft4evr.goocraftbta.block.ModBlocks;
import goocraft4evr.goocraftbta.worldgen.WorldFeatureNetherRoots;
import net.minecraft.core.block.*;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.type.WorldTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value= ItemDye.class, remap=false)
public class ItemDyeMixin {
    @Inject(method="onItemUse()Z",at=@At("TAIL"),cancellable = true)
    private void injected(ItemStack itemstack,
                          EntityPlayer entityplayer,
                          World world,
                          int blockX, int blockY, int blockZ,
                          Side side,
                          double xPlaced, double yPlaced,
                          CallbackInfoReturnable<Boolean> cir) {
        if (itemstack.getMetadata() == 15) {
            //bonemeal items in here
            int blockId = world.getBlockId(blockX, blockY, blockZ);
            if (blockId == ModBlocks.netherRoots.id) {
                if (!world.isClientSide) {
                    (new WorldFeatureNetherRoots()).generate(world, new Random(world.getRandomSeed()), blockX, blockY, blockZ,6);
                    if (entityplayer.getGamemode().consumeBlocks) {
                        --itemstack.stackSize;
                    }
                    cir.setReturnValue(true);
                }
            }
        }
    }
}
