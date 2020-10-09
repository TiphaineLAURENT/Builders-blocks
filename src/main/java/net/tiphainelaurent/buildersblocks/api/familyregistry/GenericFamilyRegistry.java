package net.tiphainelaurent.buildersblocks.api.familyregistry;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.recipe.StonecuttingRecipe;

import net.tiphainelaurent.buildersblocks.BuildersBlocks;

public abstract class GenericFamilyRegistry extends FamilyRegistry {
    final Block ancestor;
    final String ancestorName;
    final String familyName;

    public GenericFamilyRegistry(final String familyName, final Block ancestor) {
        this.ancestor = ancestor;
        this.ancestorName = Registry.BLOCK.getId(ancestor).getPath();
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Block getAncestor() {
        return ancestor;
    }

    public Recipe<?> getRecipe(final Block current) {
        return new StonecuttingRecipe(
                new Identifier(BuildersBlocks.MOD_ID,
                        String.format("stonecutting-%s_to_%s", ancestorName, Registry.BLOCK.getId(current).getPath())),
                "BuildersBlocks", Ingredient.ofItems(ancestor), new ItemStack(current));
    }

    public Recipe<?> getReversedRecipe(final Block parent, final Block current) {
        if (parent.equals(current)) {
            return new StonecuttingRecipe(
                    new Identifier(BuildersBlocks.MOD_ID,
                            String.format("stonecutting-%s_to_%s", Registry.BLOCK.getId(current).getPath(),
                                    ancestorName)),
                    "BuildersBlocks", Ingredient.ofItems(current), new ItemStack(ancestor));
        }
        return new StonecuttingRecipe(
                new Identifier(BuildersBlocks.MOD_ID,
                        String.format("stonecutting-%s_to_%s", Registry.BLOCK.getId(current).getPath(),
                                Registry.BLOCK.getId(parent).getPath())),
                "BuildersBlocks", Ingredient.ofItems(current), new ItemStack(parent));
    }
}
