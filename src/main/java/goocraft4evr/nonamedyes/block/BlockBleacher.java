package goocraft4evr.nonamedyes.block;

import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import goocraft4evr.nonamedyes.client.gui.GuiBleacher;
import goocraft4evr.nonamedyes.mixin.server.entity.player.EntityPlayerMPAccessor;
import goocraft4evr.nonamedyes.player.inventory.ContainerBleacher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.EntityPlayerSP;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.net.packet.Packet100OpenWindow;
import net.minecraft.core.world.World;
import net.minecraft.server.entity.player.EntityPlayerMP;

public class BlockBleacher extends BlockTileEntity {
    public BlockBleacher(String key, int id) {
        super(key, id, Material.stone);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
        ((TileEntityBleacher)world.getBlockTileEntity(x,y,z)).updateWaterSource();
    }

    @Override
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
        if (!world.isClientSide) {
            TileEntityBleacher tileEntityBleacher = (TileEntityBleacher) world.getBlockTileEntity(x,y,z);
            tileEntityBleacher.updateWaterSource();
            if ((player instanceof EntityPlayerSP)) displayGUIBleacherClient((EntityPlayerSP) player, tileEntityBleacher);
            else displayGUIBleacherServer((EntityPlayerMP) player, tileEntityBleacher);
        }
        return true;
    }

    public static void displayGUIBleacherClient(EntityPlayerSP player, TileEntityBleacher tileentitybleacher) {
        Minecraft.getMinecraft(Minecraft.class).displayGuiScreen(new GuiBleacher(player.inventory, tileentitybleacher));
    }

    public static void displayGUIBleacherServer(EntityPlayerMP player, TileEntityBleacher tileentitybleacher) {
        ((EntityPlayerMPAccessor)player).invokeGetNextWindowId();
        player.playerNetServerHandler.sendPacket(new Packet100OpenWindow(
                ((EntityPlayerMPAccessor)player).getCurrentWindowId(),
                8,
                tileentitybleacher.getInvName(),
                tileentitybleacher.getSizeInventory()));
        player.craftingInventory = new ContainerBleacher(player.inventory, tileentitybleacher);
        player.craftingInventory.windowId = ((EntityPlayerMPAccessor)player).getCurrentWindowId();
        player.craftingInventory.onContainerInit(player);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityBleacher();
    }
}
