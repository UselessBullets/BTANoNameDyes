package goocraft4evr.goocraftbta.block;

import goocraft4evr.goocraftbta.GoocraftBTA;
import goocraft4evr.goocraftbta.UtilIdRegistrar;
import goocraft4evr.goocraftbta.block.blockcolor.BlockColorModLampsPainted;
import goocraft4evr.goocraftbta.block.blockcolor.BlockColorModPlanksPainted;
import goocraft4evr.goocraftbta.block.wood.*;
import goocraft4evr.goocraftbta.item.block.ItemModBlockPainted;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockMushroom;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import turniplabs.halplibe.helper.BlockBuilder;

public abstract class ModBlocks {
    private static final BlockBuilder woodBlockBuilder = new BlockBuilder(GoocraftBTA.MOD_ID)
            .setHardness(2.0f)
            .setResistance(5.0f)
            .setDisabledNeighborNotifyOnMetadataChange()
            .setFlammability(5,20)
            .setBlockSound(BlockSounds.WOOD);


    public static final Block planksOakPainted = woodBlockBuilder
            .setItemBlock(block -> new ItemModBlockPainted(block,false))
            .setBlockColor(new BlockColorModPlanksPainted(false))
            .build(new BlockModPlanksPainted("planks.oak.painted",UtilIdRegistrar.nextId()))
            .withTexCoords(2, 3)
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);

    public static final Block fencePlanksOakPainted = woodBlockBuilder
            .setItemBlock(block -> new ItemModBlockPainted(block,false))
            .setBlockColor(new BlockColorModPlanksPainted(false))
            .setBlockModel(new BlockModelRenderBlocks(11))
            .build(new BlockModFencePainted("fence.planks.oak.painted",UtilIdRegistrar.nextId()))
            .withTexCoords(2, 3)
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF);

    public static final Block fencegatePlanksOakPainted = woodBlockBuilder
            .setItemBlock(block -> new ItemModBlockPainted(block,false))
            .setBlockColor(new BlockColorModPlanksPainted(true))
            .setBlockModel(new BlockModelRenderBlocks(18))
            .build(new BlockModFenceGatePainted("fencegate.planks.oak.painted",UtilIdRegistrar.nextId()))
            .withTexCoords(2, 3)
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);

    public static final Block slabPlanksOakPainted = woodBlockBuilder
            .setItemBlock(block -> new ItemModBlockPainted(block,true))
            .setUseInternalLight()
            .setBlockColor(new BlockColorModPlanksPainted(true))
            .build(new BlockModSlabPainted(planksOakPainted,UtilIdRegistrar.nextId()))
            .withTexCoords(2, 3)
            .withTags(BlockTags.MINEABLE_BY_AXE);

    public static final Block stairsPlanksOakPainted = woodBlockBuilder
            .setItemBlock(block -> new ItemModBlockPainted(block,false))
            .setUseInternalLight()
            .setBlockColor(new BlockColorModPlanksPainted(true))
            .setBlockModel(new BlockModelRenderBlocks(10))
            .build(new BlockModStairsPainted(planksOakPainted,UtilIdRegistrar.nextId()))
            .withTexCoords(2, 3)
            .withTags(BlockTags.MINEABLE_BY_AXE);

    public static final Block chestPlanksOakPainted = new BlockBuilder(GoocraftBTA.MOD_ID)
            .setHardness(2.5f)
            .setResistance(5.0f)
            .setDisabledNeighborNotifyOnMetadataChange()
            .setBlockSound(BlockSounds.WOOD)
            .setImmovable()
            .setLightOpacity(3)
            .setBlockColor(new BlockColorModPlanksPainted(true))
            .setBlockModel(new BlockModelRenderBlocks(22))
            .build(new BlockModChestPainted("chest.planks.oak.painted",UtilIdRegistrar.nextId(), Material.wood))
            .withTexCoords(9, 1, 9, 1, 11, 1, 10, 1, 10, 1, 10, 1)
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);

    //TODO: This used .setDisabledStats()
    public static final Block lampIdle = new BlockBuilder(GoocraftBTA.MOD_ID)
            .setHardness(0.5f)
            .setDisabledNeighborNotifyOnMetadataChange()
            .setBlockColor(new BlockColorModLampsPainted())
            .setBlockSound(BlockSounds.GLASS)
            .setItemBlock(block -> new ItemModBlockPainted(block))
            .build(new BlockModLamp("lamp.idle",UtilIdRegistrar.nextId(),false)
            .withTags(BlockTags.MINEABLE_BY_PICKAXE))
            .withTexCoords(4, 12);


    //TODO: luminance was initially 0.9375f, this block used setDisabledStats()
    public static final Block lampActive = new BlockBuilder(GoocraftBTA.MOD_ID)
            .setLuminance(14)
            .setHardness(0.5f)
            .setDisabledNeighborNotifyOnMetadataChange()
            .setBlockColor(new BlockColorModLampsPainted())
            .setBlockSound(BlockSounds.GLASS)
            .build(new BlockModLamp("lamp.active",UtilIdRegistrar.nextId(),true)
            .withTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE))
            .withTexCoords(5, 12);
    public static final Block wool = new BlockBuilder(GoocraftBTA.MOD_ID)
            .setHardness(0.8f)
            .setDisabledNeighborNotifyOnMetadataChange()
            .setBlockSound(BlockSounds.CLOTH)
            .setFlammability(30,60)
            .setItemBlock(block -> new ItemModBlockPainted(block))
            .build(BlockModWool.createWool("wool",UtilIdRegistrar.nextId())
            .withTags(BlockTags.MINEABLE_BY_SHEARS));

    public static final Block netherRoots = new BlockBuilder(GoocraftBTA.MOD_ID)
            .setTextures("nether_roots.png")
            .setBlockSound(BlockSounds.GRASS)
            .setHardness(0.1f)
            .setResistance(0.1f)
            .setBlockModel(new BlockModelRenderBlocks(24))
            .build(new BlockNetherRoots("nether.roots", UtilIdRegistrar.nextId(), Material.plant)
            .withTags(BlockTags.MINEABLE_BY_SHEARS,BlockTags.SHEARS_DO_SILK_TOUCH));

    //NOTE: luminance was originally 0.125f
    public static final Block mushroomInkCap = new BlockBuilder(GoocraftBTA.MOD_ID)
            .setTextures("ink_cap.png")
            .setBlockSound(BlockSounds.GRASS)
            .setHardness(0.0f)
            .setLuminance(1)
            .setBlockModel(new BlockModelRenderBlocks(1))
            .build(new BlockMushroom("mushroom.ink.cap", UtilIdRegistrar.nextId())
            .withTags(BlockTags.BROKEN_BY_FLUIDS));


    //TODO: add RGB chest

    public static void register() {

    }
}
