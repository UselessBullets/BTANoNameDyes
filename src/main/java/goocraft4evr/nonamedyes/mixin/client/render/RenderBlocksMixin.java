package goocraft4evr.nonamedyes.mixin.client.render;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.block.ModBlocks;
import net.minecraft.client.render.RenderBlocks;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockBasket;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value= RenderBlocks.class,remap = false)
public abstract class RenderBlocksMixin  {

    @Inject(method = "renderBlockByRenderType",at=@At(value="INVOKE",target = "Lnet/minecraft/core/block/Block;setBlockBoundsBasedOnState(Lnet/minecraft/core/world/World;III)V"), cancellable = true)
    private void renderMyAss(Block block, int renderType, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {

    }
}
