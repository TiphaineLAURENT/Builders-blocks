package net.tiphainelaurent.buildersblocks.blocks.andesite;

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
import net.tiphainelaurent.buildersblocks.BuildersBlocks;
import net.tiphainelaurent.buildersblocks.api.FamilyRegistry;

public class AndesiteFamily extends FamilyRegistry
{
    private static final Set<Item> ancestors = Set.of(
        Items.ANDESITE,
        Items.POLISHED_ANDESITE
    );
    private final String andesite = Registry.ITEM.getId(Items.ANDESITE).getPath();

    private static final Set<Identifier> blocks = Set.of(
        new Identifier(BuildersBlocks.MOD_ID, "andesite_braid"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_bricks-cracked"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_bricks-encased"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_bricks-small"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_bricks-soft"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_bricks-solid"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_bricks-triple"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_chaotic-medium"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_chaotic-small"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_circular"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_cracked"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_dent"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_french-1"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_french-2"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_layers"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_mosaic"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_ornate"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_panel"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_pillar-side"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_pillar-top"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_raw"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_road"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_tiles-large"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_tiles-medium"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_tiles-small"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_twisted-side"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_twisted-top"),
        new Identifier(BuildersBlocks.MOD_ID, "andesite_weaver")
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
        return new StonecuttingRecipe(new Identifier(BuildersBlocks.MOD_ID, String.format("stonecutting-%s_ot_%s", andesite, Registry.BLOCK.getId(current).getPath())),
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
            return new StonecuttingRecipe(new Identifier(BuildersBlocks.MOD_ID, String.format("stonecutting-%s_ot_%s", Registry.BLOCK.getId(current).getPath(), andesite)),
                "Chisel",
                Ingredient.ofItems(current),
                new ItemStack(Items.ANDESITE)
                );
        }
        else
        {
            return new StonecuttingRecipe(new Identifier(BuildersBlocks.MOD_ID, String.format("stonecutting-%s_ot_%s", Registry.BLOCK.getId(current).getPath(), Registry.BLOCK.getId(parent).getPath())),
                "Chisel",
                Ingredient.ofItems(current),
                new ItemStack(parent)
                );
        }
    }

    @Override
    public String getTextureDirectory() {
        return "andesite";
    }
}
