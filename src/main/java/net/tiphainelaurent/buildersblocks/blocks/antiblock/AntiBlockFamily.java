package net.tiphainelaurent.buildersblocks.blocks.antiblock;

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

public class AntiBlockFamily extends FamilyRegistry
{
    private static final Set<Item> ancestors = Set.of(
        Items.GLOWSTONE
    );
    private final String glowstone = Registry.ITEM.getId(Items.GLOWSTONE).getPath();

    private static final Set<Identifier> blocks = Set.of(
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_black"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_blue"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_brown"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_cyan"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_gray"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_green"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_light_blue"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_lime"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_magenta"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_orange"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_pink"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_purple"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_red"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_silver"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_white"),
        new Identifier(BuildersBlocks.MOD_ID, "antiblock_yellow")
    );

    @Override
    public Set<Identifier> getBlocks()
    {
        return blocks;
    }

    @Override
    public Block getAncestor()
    {
        return Blocks.GLOWSTONE;
    }

    @Override
    public Recipe<?> getRecipe(final Block current)
    {
        return new StonecuttingRecipe(new Identifier(BuildersBlocks.MOD_ID, String.format("stonecutting-%s_ot_%s", glowstone, Registry.BLOCK.getId(current).getPath())),
                    "Chisel",
                    Ingredient.ofItems(Items.GLOWSTONE),
                    new ItemStack(current)
                    );
    }

    @Override
    public Recipe<?> getReversedRecipe(final Block parent, final Block current)
    {
        if (parent.is(current))
        {
            return new StonecuttingRecipe(new Identifier(BuildersBlocks.MOD_ID, String.format("stonecutting-%s_ot_%s", Registry.BLOCK.getId(current).getPath(), glowstone)),
                "Chisel",
                Ingredient.ofItems(current),
                new ItemStack(Items.GLOWSTONE)
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
        return "antiblock";
    }
}
