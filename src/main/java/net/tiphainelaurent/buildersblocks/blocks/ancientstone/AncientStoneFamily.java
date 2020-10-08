package net.tiphainelaurent.buildersblocks.blocks.ancientstone;

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
import net.tiphainelaurent.buildersblocks.api.familyregistry.GenericFamilyRegistry;

public class AncientStoneFamily extends GenericFamilyRegistry
{
    private final String ancientstone = Registry.ITEM.getId(Items.STONE).getPath();

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

    @Override
    public String getFamilyName() {
        return "ancient_stone";
    }
}
