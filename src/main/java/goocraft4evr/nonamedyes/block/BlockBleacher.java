package goocraft4evr.nonamedyes.block;

import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import goocraft4evr.nonamedyes.client.gui.GuiBleacher;
import goocraft4evr.nonamedyes.mixin.server.entity.player.EntityPlayerMPAccessor;
import goocraft4evr.nonamedyes.player.inventory.ContainerBleacher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.EntityPlayerSP;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.entity.TileEntityFurnace;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.packet.Packet100OpenWindow;
import net.minecraft.core.world.World;
import net.minecraft.server.entity.player.EntityPlayerMP;

import java.util.Random;

public class BlockBleacher extends BlockTileEntity {
    protected Random bleacherRand = new Random();
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

    @Override
    public void onBlockRemoval(World world, int x, int y, int z) {
        TileEntityBleacher tileentitybleacher = (TileEntityBleacher)world.getBlockTileEntity(x, y, z);
        for (int l = 0; l < tileentitybleacher.getSizeInventory(); ++l) {
            ItemStack itemstack = tileentitybleacher.getStackInSlot(l);
            if (itemstack == null) continue;
            float f = this.bleacherRand.nextFloat() * 0.8f + 0.1f;
            float f1 = this.bleacherRand.nextFloat() * 0.8f + 0.1f;
            float f2 = this.bleacherRand.nextFloat() * 0.8f + 0.1f;
            while (itemstack.stackSize > 0) {
                int i1 = this.bleacherRand.nextInt(21) + 10;
                if (i1 > itemstack.stackSize) {
                    i1 = itemstack.stackSize;
                }
                itemstack.stackSize -= i1;
                EntityItem entityitem = new EntityItem(world, (float)x + f, (float)y + f1, (float)z + f2, new ItemStack(itemstack.itemID, i1, itemstack.getMetadata()));
                float f3 = 0.05f;
                entityitem.xd = (float)this.bleacherRand.nextGaussian() * f3;
                entityitem.yd = (float)this.bleacherRand.nextGaussian() * f3 + 0.2f;
                entityitem.zd = (float)this.bleacherRand.nextGaussian() * f3;
                world.entityJoinedWorld(entityitem);
            }
        }
        super.onBlockRemoval(world, x, y, z);
    }
}
