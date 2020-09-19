package net.tiphainelaurent.chiselforfabric.blocks.andesite;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.tiphainelaurent.chiselforfabric.ChiselForFabric;
import net.tiphainelaurent.chiselforfabric.api.FamilyRegistry;

public class AndesiteFamily extends FamilyRegistry
{
    private static final Set<Item> ancestors = Set.of(
        Items.ANDESITE,
        Items.POLISHED_ANDESITE
    );
    private final String andesite = Registry.ITEM.getId(Items.ANDESITE).getPath();

    private static final Set<Identifier> blocks = Set.of(
        new Identifier(ChiselForFabric.MOD_ID, "braid"),
        new Identifier(ChiselForFabric.MOD_ID, "bricks-cracked"),
        new Identifier(ChiselForFabric.MOD_ID, "bricks-encased"),
        new Identifier(ChiselForFabric.MOD_ID, "bricks-small"),
        new Identifier(ChiselForFabric.MOD_ID, "bricks-soft"),
        new Identifier(ChiselForFabric.MOD_ID, "bricks-solid"),
        new Identifier(ChiselForFabric.MOD_ID, "bricks-triple"),
        new Identifier(ChiselForFabric.MOD_ID, "chaotic-medium"),
        new Identifier(ChiselForFabric.MOD_ID, "chaotic-small"),
        new Identifier(ChiselForFabric.MOD_ID, "circular"),
        new Identifier(ChiselForFabric.MOD_ID, "cracked"),
        new Identifier(ChiselForFabric.MOD_ID, "dent"),
        new Identifier(ChiselForFabric.MOD_ID, "french-1"),
        new Identifier(ChiselForFabric.MOD_ID, "french-2"),
        new Identifier(ChiselForFabric.MOD_ID, "layers"),
        new Identifier(ChiselForFabric.MOD_ID, "mosaic"),
        new Identifier(ChiselForFabric.MOD_ID, "ornate"),
        new Identifier(ChiselForFabric.MOD_ID, "panel"),
        new Identifier(ChiselForFabric.MOD_ID, "pillar-side"),
        new Identifier(ChiselForFabric.MOD_ID, "pillar-top"),
        new Identifier(ChiselForFabric.MOD_ID, "raw"),
        new Identifier(ChiselForFabric.MOD_ID, "road"),
        new Identifier(ChiselForFabric.MOD_ID, "tiles-large"),
        new Identifier(ChiselForFabric.MOD_ID, "tiles-medium"),
        new Identifier(ChiselForFabric.MOD_ID, "tiles-small"),
        new Identifier(ChiselForFabric.MOD_ID, "twisted-side"),
        new Identifier(ChiselForFabric.MOD_ID, "twisted-top"),
        new Identifier(ChiselForFabric.MOD_ID, "weaver")
    );

    @Override
    public Set<Identifier> getBlocks()
    {
        return blocks;
    }

    @Override
    public Block getAncestor()
    {
        return Blocks.ANDESITE;
    }

    @Override
    public Recipe<?> getRecipe(final Block current)
    {
        return new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("stonecutting-%s_ot_%s", andesite, Registry.BLOCK.getId(current).getPath())),
                    "Chisel",
                    Ingredient.ofItems(Items.ANDESITE),
                    new ItemStack(current)
                    );
    }

    @Override
    public Recipe<?> getReversedRecipe(final Block parent, final Block current)
    {
        if (parent.is(current))
        {
            return new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("stonecutting-%s_ot_%s", Registry.BLOCK.getId(current).getPath(), andesite)),
                "Chisel",
                Ingredient.ofItems(current),
                new ItemStack(Items.ANDESITE)
                );
        }
        else
        {
            return new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("stonecutting-%s_ot_%s", Registry.BLOCK.getId(current).getPath(), Registry.BLOCK.getId(parent).getPath())),
                "Chisel",
                Ingredient.ofItems(current),
                new ItemStack(parent)
                );
        }
    }
}
