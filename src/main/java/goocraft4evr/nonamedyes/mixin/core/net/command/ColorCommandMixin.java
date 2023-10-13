package goocraft4evr.nonamedyes.mixin.core.net.command;

import goocraft4evr.nonamedyes.item.ItemModDye;
import net.minecraft.core.net.command.CommandHandler;
import net.minecraft.core.net.command.CommandSender;
import net.minecraft.core.net.command.TextFormatting;
import net.minecraft.core.net.command.commands.ColorCommand;
import net.minecraft.server.entity.player.EntityPlayerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = ColorCommand.class, remap = false)
public class ColorCommandMixin {
    @Inject(method = "execute(Lnet/minecraft/core/net/command/CommandHandler;Lnet/minecraft/core/net/command/CommandSender;[Ljava/lang/String;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/core/net/command/CommandSender;sendMessage(Ljava/lang/String;)V", ordinal = 1, shift = At.Shift.BEFORE),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void execute(CommandHandler handler, CommandSender sender, String[] args, CallbackInfoReturnable<Boolean> cir, EntityPlayerMP player, StringBuilder builder){
        int c = 0;
        builder.append(", ");
        for (int i2 = 22; i2 < 22 + ItemModDye.NUM_DYES; ++i2) {
            TextFormatting color2 = TextFormatting.get(i2);
            if (c > 0) {
                builder.append(", ");
            }
            builder.append(color2).append(color2.getNames()[0]);
            ++c;
        }
    }
}
