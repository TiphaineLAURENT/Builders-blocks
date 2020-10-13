package net.tiphainelaurent.buildersblocks.api.familyregistry;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.recipe.StonecuttingRecipe;

import net.tiphainelaurent.buildersblocks.BuildersBlocks;

public class GenericFamilyRegistry extends FamilyRegistry
{
    final Block ancestor;
    String ancestorName;
    String familyName;
    final Set<String> blocksName = new HashSet<>();

    public GenericFamilyRegistry(final Block ancestor)
    {
        this.ancestor = ancestor;
        ancestorName = Registry.BLOCK.getId(ancestor).getPath();
    }

    public GenericFamilyRegistry(final String familyName, final Block ancestor)
    {
        this(ancestor);
        this.familyName = familyName;
    }

    public GenericFamilyRegistry with(final String name)
    {
        blocksName.add(name);
        return this;
    }

    public GenericFamilyRegistry with(final Collection<String> names)
    {
        blocksName.addAll(names);
        return this;
    }

    public GenericFamilyRegistry without(final String name)
    {
        blocksName.remove(name);
        return this;
    }

    public GenericFamilyRegistry named(final String name)
    {
        familyName = name;
        return this;
    }

    @Override
    public Set<Identifier> getBlocksId()
    {
        return blocksName.stream()
            .map(name -> new Identifier(BuildersBlocks.MOD_ID, String.format("%s_%s", getFamilyName(), name)))
            .collect(Collectors.toSet());
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public Block getAncestor()
    {
        return ancestor;
    }

    public Recipe<?> getRecipe(final Block current)
    {
        return new StonecuttingRecipe(
            new Identifier(BuildersBlocks.MOD_ID,
                String.format("stonecutting-%s_to_%s", ancestorName, Registry.BLOCK.getId(current).getPath())),
            "BuildersBlocks", Ingredient.ofItems(ancestor), new ItemStack(current));
    }

    public Recipe<?> getReversedRecipe(final Block parent, final Block current)
    {
        if (parent.equals(current))
        {
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
