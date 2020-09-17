package net.tiphainelaurent.chiselforfabric.blocks.andesite;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.tiphainelaurent.chiselforfabric.ChiselForFabric;
import net.tiphainelaurent.chiselforfabric.api.LootTables;
import net.tiphainelaurent.chiselforfabric.api.BasicBlock;

public class AndesiteFamily
{
    static final BasicBlock[] blocks = {
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "braid"), FabricBlockSettings.copy(Blocks.ANDESITE))
    };

    public static void registerAll(final ItemGroup group)
    {
        for (BasicBlock block : blocks)
        {
            block.register(group);
            LootTables.of(block);
        };
    }
}
