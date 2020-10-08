package net.tiphainelaurent.buildersblocks.blocks.ancientstone;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tiphainelaurent.buildersblocks.BuildersBlocks;
import net.tiphainelaurent.buildersblocks.api.FamilyRegistry;

public class AncientStoneFamily extends FamilyRegistry
{
    private final String ancientstone = Registry.ITEM.getId(Items.STONE).getPath();

    private static final Set<Identifier> blocks = Set.of(
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_braid"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_bricks-cracked"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_bricks-encased"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_bricks-small"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_bricks-soft"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_bricks-solid"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_bricks-triple"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_chaotic-medium"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_chaotic-small"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_circular"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_cracked"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_dent"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_french-1"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_french-2"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_layers"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_mosaic"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_ornate"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_panel"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_pillar-side"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_pillar-top"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_raw"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_road"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_tiles-large"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_tiles-medium"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_tiles-small"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_twisted-side"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_twisted-top"),
        new Identifier(BuildersBlocks.MOD_ID, "ancientstone_weaver")
    );

    @Override
    public Set<Identifier> getBlocks()
    {
        return blocks;
    }

    @Override
    public String getTextureDirectory()
    {
        return "ancient_stone";
    }

    @Override
    public Block getAncestor()
    {
        return Blocks.STONE;
    }

    @Override
    public Recipe<?> getRecipe(final Block current)
    {
        return new StonecuttingRecipe(new Identifier(BuildersBlocks.MOD_ID, String.format("stonecutting-%s_ot_%s", ancientstone, Registry.BLOCK.getId(current).getPath())),
                    "Chisel",
                    Ingredient.ofItems(Items.STONE),
                    new ItemStack(current)
                    );
    }

    @Override
    public Recipe<?> getReversedRecipe(final Block parent, final Block current)
    {
        return new StonecuttingRecipe(new Identifier(BuildersBlocks.MOD_ID, String.format("stonecutting-%s_ot_%s", Registry.BLOCK.getId(current).getPath(), Registry.BLOCK.getId(parent).getPath())),
            "Chisel",
            Ingredient.ofItems(current),
            new ItemStack(parent)
            );
    }
}
