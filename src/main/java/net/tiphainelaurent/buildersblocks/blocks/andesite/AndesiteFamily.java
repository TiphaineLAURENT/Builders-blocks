package net.tiphainelaurent.buildersblocks.blocks.andesite;

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

public class AndesiteFamily extends GenericFamilyRegistry
{
    private final String andesite = Registry.ITEM.getId(Items.ANDESITE).getPath();
    
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
    public String getFamilyName() {
        return "andesite";
    }
}
