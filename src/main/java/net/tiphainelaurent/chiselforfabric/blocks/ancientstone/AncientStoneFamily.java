package net.tiphainelaurent.chiselforfabric.blocks.ancientstone;

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

import net.tiphainelaurent.chiselforfabric.ChiselForFabric;
import net.tiphainelaurent.chiselforfabric.api.FamilyRegistry;

public class AncientStoneFamily extends FamilyRegistry
{
    private final String ancientstone = Registry.ITEM.getId(Items.STONE).getPath();

    private static final Set<Identifier> blocks = Set.of(
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_braid"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_bricks-cracked"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_bricks-encased"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_bricks-small"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_bricks-soft"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_bricks-solid"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_bricks-triple"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_chaotic-medium"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_chaotic-small"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_circular"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_cracked"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_dent"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_french-1"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_french-2"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_layers"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_mosaic"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_ornate"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_panel"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_pillar-side"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_pillar-top"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_raw"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_road"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_tiles-large"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_tiles-medium"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_tiles-small"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_twisted-side"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_twisted-top"),
        new Identifier(ChiselForFabric.MOD_ID, "ancientstone_weaver")
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
        return new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("stonecutting-%s_ot_%s", ancientstone, Registry.BLOCK.getId(current).getPath())),
                    "Chisel",
                    Ingredient.ofItems(Items.STONE),
                    new ItemStack(current)
                    );
    }

    @Override
    public Recipe<?> getReversedRecipe(final Block parent, final Block current)
    {
        return new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("stonecutting-%s_ot_%s", Registry.BLOCK.getId(current).getPath(), Registry.BLOCK.getId(parent).getPath())),
            "Chisel",
            Ingredient.ofItems(current),
            new ItemStack(parent)
            );
    }
}
