package net.tiphainelaurent.chiselforfabric.blocks.ancientstone;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.CraftingRecipe;
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
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_braid"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_bricks-cracked"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_bricks-encased"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_bricks-small"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_bricks-soft"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_bricks-solid"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_bricks-triple"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_chaotic-medium"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_chaotic-small"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_circular"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_cracked"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_dent"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_french-1"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_french-2"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_layers"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_mosaic"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_ornate"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_panel"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_pillar-side"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_pillar-top"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_raw"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_road"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_tiles-large"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_tiles-medium"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_tiles-small"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_twisted-side"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_twisted-top"),
        new Identifier(ChiselForFabric.MOD_ID, "ancient_stone_weaver")
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
