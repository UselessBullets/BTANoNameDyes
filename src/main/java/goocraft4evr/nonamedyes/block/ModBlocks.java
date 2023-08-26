package goocraft4evr.nonamedyes.block;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.UtilIdRegistrar;
import goocraft4evr.nonamedyes.block.blockcolor.BlockColorModLampsPainted;
import goocraft4evr.nonamedyes.block.blockcolor.BlockColorModPlanksPainted;
import goocraft4evr.nonamedyes.block.cocoa.BlockLeavesCocoa;
import goocraft4evr.nonamedyes.block.cocoa.BlockLogCocoaRipe;
import goocraft4evr.nonamedyes.block.cocoa.BlockSaplingCocoa;
import goocraft4evr.nonamedyes.block.wood.*;
import goocraft4evr.nonamedyes.item.block.ItemModBlockPainted;
import goocraft4evr.nonamedyes.item.block.ItemModBlockSlabPainted;
import net.minecraft.client.render.block.color.BlockColorLeaves;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.block.BlockLog;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import turniplabs.halplibe.helper.BlockBuilder;

public abstract class ModBlocks {
    private static final BlockBuilder woodBlockBuilder = new BlockBuilder(NoNameDyes.MOD_ID)
            .setHardness(2.0f)
            .setResistance(5.0f)
            .setVisualUpdateOnMetadata()
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
            .setItemBlock(block -> new ItemModBlockPainted(block,true))
            .setBlockColor(new BlockColorModPlanksPainted(true))
            .setBlockModel(new BlockModelRenderBlocks(18))
            .build(new BlockModFenceGatePainted("fencegate.planks.oak.painted",UtilIdRegistrar.nextId()))
            .withTexCoords(2, 3)
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);

    public static final Block slabPlanksOakPainted = woodBlockBuilder
            .setItemBlock(ItemModBlockSlabPainted::new)
            .setUseInternalLight()
            .setBlockColor(new BlockColorModPlanksPainted(true))
            .build(new BlockModSlabPainted(planksOakPainted,UtilIdRegistrar.nextId()))
            .withTexCoords(2, 3)
            .withTags(BlockTags.MINEABLE_BY_AXE);

    public static final Block stairsPlanksOakPainted = woodBlockBuilder
            .setItemBlock(block -> new ItemModBlockPainted(block,true))
            .setUseInternalLight()
            .setBlockColor(new BlockColorModPlanksPainted(true))
            .setBlockModel(new BlockModelRenderBlocks(10))
            .build(new BlockModStairsPainted(planksOakPainted,UtilIdRegistrar.nextId()))
            .withTexCoords(2, 3)
            .withTags(BlockTags.MINEABLE_BY_AXE);

    public static final Block chestPlanksOakPainted = new BlockBuilder(NoNameDyes.MOD_ID)
            .setHardness(2.5f)
            .setResistance(5.0f)
            .setVisualUpdateOnMetadata()
            .setBlockSound(BlockSounds.WOOD)
            .setImmovable()
            .setLightOpacity(3)
            .setBlockColor(new BlockColorModPlanksPainted(true))
            .setBlockModel(new BlockModelRenderBlocks(22))
            .setItemBlock(block -> new ItemModBlockPainted(block,true))
            .build(new BlockModChestPainted("chest.planks.oak.painted",UtilIdRegistrar.nextId(), Material.wood))
            .withTexCoords(9, 1, 9, 1, 11, 1, 10, 1, 10, 1, 10, 1)
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);

    //TODO: This used .setDisabledStats()
    public static final Block lampIdle = new BlockBuilder(NoNameDyes.MOD_ID)
            .setHardness(0.5f)
            .setVisualUpdateOnMetadata()
            .setBlockColor(new BlockColorModLampsPainted())
            .setBlockSound(BlockSounds.GLASS)
            .setItemBlock(ItemModBlockPainted::new)
            .build(new BlockModLamp("lamp.idle",UtilIdRegistrar.nextId(),false)
            .withTags(BlockTags.MINEABLE_BY_PICKAXE))
            .withTexCoords(4, 12);


    //TODO: luminance was initially 0.9375f, this block used setDisabledStats()
    public static final Block lampActive = new BlockBuilder(NoNameDyes.MOD_ID)
            .setLuminance(14)
            .setHardness(0.5f)
            .setVisualUpdateOnMetadata()
            .setBlockColor(new BlockColorModLampsPainted())
            .setBlockSound(BlockSounds.GLASS)
            .build(new BlockModLamp("lamp.active",UtilIdRegistrar.nextId(),true)
            .withTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE))
            .withTexCoords(5, 12);
    public static final Block wool = new BlockBuilder(NoNameDyes.MOD_ID)
            .setHardness(0.8f)
            .setVisualUpdateOnMetadata()
            .setBlockSound(BlockSounds.CLOTH)
            .setFlammability(30,60)
            .setItemBlock(ItemModBlockPainted::new)
            .build(BlockModWool.createWool("wool",UtilIdRegistrar.nextId())
            .withTags(BlockTags.MINEABLE_BY_SHEARS));

    public static final Block netherRoots = new BlockBuilder(NoNameDyes.MOD_ID)
            .setTextures("nether_roots.png")
            .setBlockSound(BlockSounds.GRASS)
            .setHardness(0.1f)
            .setResistance(0.1f)
            .setBlockModel(new BlockModelRenderBlocks(29))
            .build(new BlockNetherRoots("nether.roots", UtilIdRegistrar.nextId(), Material.plant)
            .withTags(BlockTags.MINEABLE_BY_SHEARS,BlockTags.SHEARS_DO_SILK_TOUCH));

    //NOTE: luminance was originally 0.125f
    public static final Block mushroomInkCap = new BlockBuilder(NoNameDyes.MOD_ID)
            .setTextures("ink_cap.png")
            .setBlockSound(BlockSounds.GRASS)
            .setHardness(0.0f)
            .setLuminance(1)
            .setBlockModel(new BlockModelRenderBlocks(1))
            .build(new BlockMushroomInkCap("mushroom.ink.cap", UtilIdRegistrar.nextId())
            .withTags(BlockTags.BROKEN_BY_FLUIDS));

    public static final Block ochreBlock = new BlockBuilder(NoNameDyes.MOD_ID)
            .setTextures("ochre_block.png")
            .setBlockSound(BlockSounds.GRAVEL)
            .setHardness(0.6f)
            .build(new BlockOchre("block.ochre",UtilIdRegistrar.nextId()))
            .withTags(BlockTags.MINEABLE_BY_SHOVEL);

    private static final BlockBuilder malachiteBuilder = new BlockBuilder(NoNameDyes.MOD_ID)
            .setBlockSound(BlockSounds.STONE)
            .setHardness(3.0f)
            .setResistance(5.0f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE);

    public static final Block oreMalachiteStone = malachiteBuilder
            .setTextures("ore_malachite_stone.png")
            .build(new BlockOreMalachite("ore.malachite.stone",UtilIdRegistrar.nextId()));

    public static final Block oreMalachiteBasalt = malachiteBuilder
            .setTextures("ore_malachite_basalt.png")
            .build(new BlockOreMalachite("ore.malachite.basalt",UtilIdRegistrar.nextId()));

    public static final Block oreMalachiteLimestone = malachiteBuilder
            .setTextures("ore_malachite_limestone.png")
            .build(new BlockOreMalachite("ore.malachite.limestone",UtilIdRegistrar.nextId()));

    public static final Block oreMalachiteGranite = malachiteBuilder
            .setTextures("ore_malachite_granite.png")
            .build(new BlockOreMalachite("ore.malachite.granite",UtilIdRegistrar.nextId()));

    public static final Block blockMalachite = malachiteBuilder
            .setTextures("malachite_block.png")
            .build(new Block("block.malachite",UtilIdRegistrar.nextId(),Material.stone));

    public static final Block flowerIndigo = ((BlockFlower)new BlockBuilder(NoNameDyes.MOD_ID)
            .setTextures("indigo_flower.png")
            .setBlockSound(BlockSounds.GRASS)
            .setHardness(0.0f)
            .setBlockModel(new BlockModelRenderBlocks(1))
            .build(new BlockFlower("flower.indigo", UtilIdRegistrar.nextId())))
            .setKilledByWeather()
            .withTags(BlockTags.BROKEN_BY_FLUIDS);

    public static final Block logCocoa = new BlockBuilder(NoNameDyes.MOD_ID)
            .setTopBottomTexture("log_cocoa_top.png")
            .setSideTextures("log_cocoa_sides.png")
            .setBlockSound(BlockSounds.WOOD)
            .setHardness(2.0f)
            .setVisualUpdateOnMetadata()
            .setFlammability(5,5)
            .setBlockModel(new BlockModelRenderBlocks(27))
            .build(new BlockLog("log.cocoa", UtilIdRegistrar.nextId()))
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);
    public static final Block logCocoaRipe = new BlockBuilder(NoNameDyes.MOD_ID)
            .setTopBottomTexture("log_cocoa_top.png")
            .setSideTextures("log_cocoa_ripe_sides.png")
            .setBlockSound(BlockSounds.WOOD)
            .setHardness(2.0f)
            .setVisualUpdateOnMetadata()
            .setFlammability(5,3)
            .build(new BlockLogCocoaRipe("log.cocoa.ripe", UtilIdRegistrar.nextId()))
            .withTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE);

    //HAS DISABLED STATS
    public static final Block leavesCocoa = new BlockBuilder(NoNameDyes.MOD_ID)
            .setBlockSound(BlockSounds.GRASS)
            .setHardness(0.2f)
            .setLightOpacity(1)
            .setVisualUpdateOnMetadata()
            .setBlockColor(new BlockColorLeaves("cocoa"))
            .setFlammability(30,60)
            .build(BlockLeavesCocoa.createBlock("leaves.cocoa", UtilIdRegistrar.nextId()))
            .withTags(BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS);

    public static final Block saplingCocoa = new BlockBuilder(NoNameDyes.MOD_ID)
            .setTextures("sapling_cocoa.png")
            .setBlockSound(BlockSounds.GRASS)
            .setBlockModel(new BlockModelRenderBlocks(1))
            .setHardness(0.0f)
            .setVisualUpdateOnMetadata()
            .build(new BlockSaplingCocoa("sapling.cocoa", UtilIdRegistrar.nextId()))
            .withTags(BlockTags.BROKEN_BY_FLUIDS);

    public static final Block brickMalachite = malachiteBuilder
            .setResistance(10.0f)
            .setTextures("brick_malachite.png")
            .build(new Block("brick.malachite", UtilIdRegistrar.nextId(), Material.stone))
            .withTags(BlockTags.MINEABLE_BY_PICKAXE);

    public static void register() {

    }
}
