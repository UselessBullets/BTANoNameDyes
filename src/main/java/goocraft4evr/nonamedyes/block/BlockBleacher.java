package goocraft4evr.nonamedyes.block;

import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import goocraft4evr.nonamedyes.client.gui.GuiBleacher;
import goocraft4evr.nonamedyes.mixin.client.entity.EntityPlayerSPAccessor;
import goocraft4evr.nonamedyes.mixin.server.entity.player.EntityPlayerMPAccessor;
import goocraft4evr.nonamedyes.player.inventory.ContainerBleacher;
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
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
        if (!world.isClientSide) {
            TileEntityBleacher tileentitybleacher = (TileEntityBleacher)world.getBlockTileEntity(x, y, z);
            displayGUI(player,tileentitybleacher);
        }
        return true;
    }

    private void displayGUI(EntityPlayer player, TileEntityBleacher tileentitybleacher) {
        if (player instanceof EntityPlayerSP) {
            EntityPlayerSP splayer = (EntityPlayerSP)player;
            ((EntityPlayerSPAccessor)splayer).getMc().displayGuiScreen(new GuiBleacher(splayer.inventory, tileentitybleacher));
            return;
        }
        EntityPlayerMP mplayer = (EntityPlayerMP)player;
        ((EntityPlayerMPAccessor)mplayer).invokeGetNextWindowId();
        mplayer.playerNetServerHandler.sendPacket(new Packet100OpenWindow(
                ((EntityPlayerMPAccessor)mplayer).getCurrentWindowId(),
                2,
                tileentitybleacher.getInvName(),
                tileentitybleacher.getSizeInventory()));
        mplayer.craftingInventory = new ContainerBleacher(mplayer.inventory, tileentitybleacher);
        mplayer.craftingInventory.windowId = ((EntityPlayerMPAccessor)mplayer).getCurrentWindowId();
        mplayer.craftingInventory.onContainerInit(mplayer);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityBleacher();
    }
}
