package goocraft4evr.goocraftbta.block;

import goocraft4evr.goocraftbta.GoocraftBTA;
import goocraft4evr.goocraftbta.UtilIdRegistrar;
import goocraft4evr.goocraftbta.block.blockcolor.BlockColorModLampsPainted;
import goocraft4evr.goocraftbta.block.blockcolor.BlockColorModPlanksPainted;
import goocraft4evr.goocraftbta.block.wood.*;
import goocraft4evr.goocraftbta.item.block.ItemModBlockPainted;
import goocraft4evr.goocraftbta.item.block.ItemModBlockSlabPainted;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockMushroom;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;

public abstract class ModBlocks {

    public static final Block planksOakPainted = new BlockBuilder(
            new BlockModPlanksPainted("planks.oak.painted",UtilIdRegistrar.nextId()))
            .withHardness(2.0f)
            .withBlastResistance(5.0f)
            .withDisabledNeighborNotifyOnMetadataChange()
            .withBurnRate(5,20)
            .withBlockColor(new BlockColorModPlanksPainted(false))
            .withBlockSound(BlockSounds.WOOD)
            .toBlock()
            .withTexCoords(2, 3)
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);

    public static final Block fencePlanksOakPainted = new BlockBuilder(
            new BlockModFencePainted("fence.planks.oak.painted",UtilIdRegistrar.nextId()))
            .withHardness(2.0f)
            .withBlastResistance(5.0f)
            .withDisabledNeighborNotifyOnMetadataChange()
            .withBurnRate(5,20)
            .withBlockColor(new BlockColorModPlanksPainted(false))
            .withBlockModel(new BlockModelRenderBlocks(11))
            .withBlockSound(BlockSounds.WOOD)
            .toBlock()
            .withTexCoords(2, 3)
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF);

    public static final Block fencegatePlanksOakPainted = new BlockBuilder(
            new BlockModFenceGatePainted("fencegate.planks.oak.painted",UtilIdRegistrar.nextId()))
            .withHardness(2.0f)
            .withBlastResistance(5.0f)
            .withDisabledNeighborNotifyOnMetadataChange()
            .withBurnRate(5,20)
            .withBlockColor(new BlockColorModPlanksPainted(true))
            .withBlockModel(new BlockModelRenderBlocks(18))
            .withBlockSound(BlockSounds.WOOD)
            .toBlock()
            .withTexCoords(2, 3)
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);

    public static final Block slabPlanksOakPainted = new BlockBuilder(
            new BlockModSlabPainted(planksOakPainted,UtilIdRegistrar.nextId()))
            .withDisabledNeighborNotifyOnMetadataChange()
            .withLitInteriorSurface(true)
            .withBurnRate(5,20)
            .withBlockColor(new BlockColorModPlanksPainted(true))
            .withBlockSound(BlockSounds.WOOD)
            .toBlock()
            .withTags(BlockTags.MINEABLE_BY_AXE);

    public static final Block stairsPlanksOakPainted = new BlockBuilder(
            new BlockModStairsPainted(planksOakPainted,UtilIdRegistrar.nextId()))
            .withDisabledNeighborNotifyOnMetadataChange()
            .withLitInteriorSurface(true)
            .withBurnRate(5,20)
            .withBlockColor(new BlockColorModPlanksPainted(true))
            .withBlockModel(new BlockModelRenderBlocks(10))
            .withBlockSound(BlockSounds.WOOD)
            .toBlock()
            .withTags(BlockTags.MINEABLE_BY_AXE);

    public static final Block chestPlanksOakPainted = new BlockBuilder(
            new BlockModChestPainted("chest.planks.oak.painted",UtilIdRegistrar.nextId(), Material.wood))
            .withHardness(2.5f)
            .withBlastResistance(5.0f)
            .withDisabledNeighborNotifyOnMetadataChange()
            .withImmovableFlagSet()
            .withLightOpacity(3)
            .withBlockColor(new BlockColorModPlanksPainted(true))
            .withBlockModel(new BlockModelRenderBlocks(22))
            .withBlockSound(BlockSounds.WOOD)
            .toBlock()
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);

    public static final Block lampIdle = new BlockBuilder(
            new BlockModLamp("lamp.idle",UtilIdRegistrar.nextId(),false))
            .withHardness(0.5f)
            .withDisabledStats()
            .withDisabledNeighborNotifyOnMetadataChange()
            .withBlockColor(new BlockColorModLampsPainted())
            .withBlockSound(BlockSounds.GLASS)
            .toBlock()
            .withTexCoords(4, 12)
            .withTags(BlockTags.MINEABLE_BY_PICKAXE);


    public static final Block lampActive = new BlockBuilder(
            new BlockModLamp("lamp.active",UtilIdRegistrar.nextId(),true))
            .withLightValue(0.9375f)
            .withHardness(0.5f)
            .withDisabledStats()
            .withDisabledNeighborNotifyOnMetadataChange()
            .withBlockColor(new BlockColorModLampsPainted())
            .withBlockSound(BlockSounds.GLASS)
            .toBlock()
            .withTexCoords(5, 12)
            .withTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE);
    public static final Block wool = new BlockBuilder(
            BlockModWool.createWool("wool",UtilIdRegistrar.nextId()))
            .withHardness(0.8f)
            .withDisabledNeighborNotifyOnMetadataChange()
            .withBlockSound(BlockSounds.CLOTH)
            .withBurnRate(30,60)
            .toBlock()
            .withTags(BlockTags.MINEABLE_BY_SHEARS);

    public static final Block netherRoots = new BlockBuilder(
            new BlockNetherRoots("nether.roots", UtilIdRegistrar.nextId(), Material.plant))
            .withCustomTextures(GoocraftBTA.MOD_ID,"nether_roots.png")
            .withBlockSound(BlockSounds.GRASS)
            .withHardness(0.1f)
            .withBlastResistance(0.1f)
            .withBlockModel(new BlockModelRenderBlocks(16))
            .toBlock()
            .withTags(BlockTags.MINEABLE_BY_SHEARS,BlockTags.SHEARS_DO_SILK_TOUCH);

    public static final Block mushroomInkCap = new BlockBuilder(
            new BlockMushroom("mushroom.ink.cap", UtilIdRegistrar.nextId()))
            .withCustomTextures(GoocraftBTA.MOD_ID,"ink_cap.png")
            .withBlockSound(BlockSounds.GRASS)
            .withHardness(0.0f)
            .withLightValue(0.125f)
            .withBlockModel(new BlockModelRenderBlocks(1))
            .toBlock()
            .withTags(BlockTags.BROKEN_BY_FLUIDS);


    //TODO: add RGB chest

    public static void register() {
        Item.itemsList[planksOakPainted.id] = new ItemModBlockPainted(planksOakPainted,false);
        Item.itemsList[fencePlanksOakPainted.id] = new ItemModBlockPainted(fencePlanksOakPainted,false);
        Item.itemsList[fencegatePlanksOakPainted.id] = new ItemModBlockPainted(fencegatePlanksOakPainted,true);
        Item.itemsList[slabPlanksOakPainted.id] = new ItemModBlockSlabPainted(slabPlanksOakPainted);
        Item.itemsList[stairsPlanksOakPainted.id] = new ItemModBlockPainted(stairsPlanksOakPainted,true);
        Item.itemsList[chestPlanksOakPainted.id] = new ItemModBlockPainted(chestPlanksOakPainted,true);
        Item.itemsList[lampIdle.id] = new ItemModBlockPainted(lampIdle);
        Item.itemsList[wool.id] = new ItemModBlockPainted(wool);
    }
}
