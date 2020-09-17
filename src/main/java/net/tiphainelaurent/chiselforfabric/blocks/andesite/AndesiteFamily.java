package net.tiphainelaurent.chiselforfabric.blocks.andesite;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.tiphainelaurent.chiselforfabric.ChiselForFabric;
import net.tiphainelaurent.chiselforfabric.api.BasicBlock;

public class AndesiteFamily implements
{
    static final BasicBlock[] blocks = {
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "braid"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-cracked"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-encased"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-small"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-soft"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-solid"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-triple"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "chaotic-medium"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "chaotic-small"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "circular"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "cracked"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "dent"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "french-1"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "french-2"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "layers"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "mosaic"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "ornate"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "panel"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "pillar-side"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "pillar-top"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "raw"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "road"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "tiles-large"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "tiles-medium"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "tiles-small"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "twisted-side"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "twisted-top"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "weaver"), FabricBlockSettings.copy(Blocks.ANDESITE))
    };

    public static void registerAll(final ItemGroup group)
    {
        for (BasicBlock block : blocks)
        {
            block.register(group);
            block.write(block.asLootTable().build())
                 .writeBlockStates()
                 .writeModel()
                 .writeItem();
            
        };
    }
}
