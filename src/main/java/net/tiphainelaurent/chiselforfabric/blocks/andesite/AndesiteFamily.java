package net.tiphainelaurent.chiselforfabric.blocks.andesite;

import java.util.Set;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.tiphainelaurent.chiselforfabric.ChiselForFabric;
import net.tiphainelaurent.chiselforfabric.api.BasicBlock;
import net.tiphainelaurent.chiselforfabric.api.FamilyRegistry;

public class AndesiteFamily extends FamilyRegistry
{
    private static final Set<Item> ancestors = Set.of(
        Items.ANDESITE,
        Items.POLISHED_ANDESITE
    );
    private final String andesite = Registry.ITEM.getId(Items.ANDESITE).getPath();

    private static final Set<BasicBlock> blocks = Set.of(
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/braid"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/bricks-cracked"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/bricks-encased"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/bricks-small"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/bricks-soft"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/bricks-solid"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/bricks-triple"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/chaotic-medium"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/chaotic-small"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/circular"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/cracked"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/dent"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/french-1"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/french-2"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/layers"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/mosaic"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/ornate"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/panel"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/pillar-side"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/pillar-top"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/raw"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/road"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/tiles-large"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/tiles-medium"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/tiles-small"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/twisted-side"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/twisted-top"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "block/andesite/weaver"), FabricBlockSettings.copy(Blocks.ANDESITE))
    );

    public Set<BasicBlock> getBlocks()
    {
        return blocks;
    }

    @Override
    public String getNamespace()
    {
        return ChiselForFabric.MOD_ID;
    }

    public Recipe<?> getRecipe(final BasicBlock current)
    {
        return new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("stonecutting-%s_ot_%s", andesite, current.getIdentifier().getPath())),
                    "Chisel",
                    Ingredient.ofItems(Items.ANDESITE),
                    new ItemStack(current)
                    );
    }

    public Recipe<?> getReversedRecipe(final BasicBlock parent, final BasicBlock current)
    {
        if (parent.is(current))
        {
            return new StonecuttingRecipe(new Identifier(getNamespace(), String.format("stonecutting-%s_ot_%s", andesite, parent.getIdentifier().getPath())),
                "Chisel",
                Ingredient.ofItems(parent),
                new ItemStack(Items.ANDESITE)
                );
        }
        else
        {
            return new StonecuttingRecipe(new Identifier(getNamespace(), String.format("stonecutting-%s_ot_%s", andesite, parent.getIdentifier().getPath())),
                "Chisel",
                Ingredient.ofItems(current),
                new ItemStack(parent)
                );
        }
    }
}
