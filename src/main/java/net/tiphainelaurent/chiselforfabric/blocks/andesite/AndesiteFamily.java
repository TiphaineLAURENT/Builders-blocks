package net.tiphainelaurent.chiselforfabric.blocks.andesite;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.tiphainelaurent.chiselforfabric.ChiselForFabric;
import net.tiphainelaurent.chiselforfabric.api.LootTables;

public class AndesiteFamily
{
    static final Map<Identifier, Block> blocks = Map.of(
        new Identifier(ChiselForFabric.MOD_ID, "braid"), new Block(FabricBlockSettings.copy(Blocks.ANDESITE))
    );

    public static void registerAll(final ItemGroup group)
    {
        blocks.entrySet().stream().forEach(entry -> {
            final Identifier identifier = entry.getKey();
            final Block block = entry.getValue();
            Registry.register(Registry.BLOCK, identifier, block);

            final Item item = new BlockItem(block, new Item.Settings().group(group));
            Registry.register(Registry.ITEM, identifier, item);

            LootTables.of(block);
        });
    }
}
