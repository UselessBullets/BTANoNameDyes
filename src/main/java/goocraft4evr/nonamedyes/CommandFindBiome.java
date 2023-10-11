package goocraft4evr.nonamedyes;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.net.command.Command;
import net.minecraft.core.net.command.CommandHandler;
import net.minecraft.core.net.command.CommandSender;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;

import static net.minecraft.core.data.registry.Registries.BIOMES;

public class CommandFindBiome extends Command {
    public CommandFindBiome() {
        super("findbiome");
    }

    @Override
    public boolean execute(CommandHandler commandHandler, CommandSender commandSender, String[] strings) {
        if (!commandSender.isPlayer()) return false;
        EntityPlayer player = commandSender.getPlayer();
        World world = player.world;
        int radius = Integer.parseInt(strings[0]);
        Biome biome = BIOMES.getItem(strings[1]);
        if (biome == null) return false;
        int cx=0,cz=0;
        int cy = (int)player.y;
        boolean found = false;
        L0: for (int i=0;i<radius;i++) {
            cz = (int)player.z+(i<<4);
            for (int j = -i;j<=i;j++) {
                cx = (int)player.x+(j<<4);
                if (world.getBlockBiome(cx,cy,cz)==biome) {
                    found = true;
                    break L0;
                }
            }
            cz = (int)player.z-(i<<4);
            for (int j = -i;j<=i;j++) {
                cx = (int)player.x+(j<<4);
                if (world.getBlockBiome(cx,cy,cz)==biome) {
                    found = true;
                    break L0;
                }
            }
            cx = (int)player.x+(i<<4);
            for (int j=-i+1;j<i;j++) {
                cz = (int)player.z+(j<<4);
                if (world.getBlockBiome(cx,cy,cz)==biome) {
                    found = true;
                    break L0;
                }
            }
            cx = (int)player.x-(i<<4);
            for (int j=-i+1;j<i;j++) {
                cz = (int)player.z+(j<<4);
                if (world.getBlockBiome(cx,cy,cz)==biome) {
                    found = true;
                    break L0;
                }
            }
        }
        if (found) {
            commandSender.sendMessage(String.format("found at %d %d %d",cx,cy,cz));
        } else commandSender.sendMessage(String.format("no find in radius %d",radius));
        return true;
    }

    @Override
    public boolean opRequired(String[] strings) {
        return false;
    }

    @Override
    public void sendCommandSyntax(CommandHandler commandHandler, CommandSender commandSender) {
        commandSender.sendMessage("/findbiome");
    }
}
