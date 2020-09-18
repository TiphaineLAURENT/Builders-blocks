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
