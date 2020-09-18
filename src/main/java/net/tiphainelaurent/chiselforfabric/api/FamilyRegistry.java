package net.tiphainelaurent.chiselforfabric.api;

import java.util.Set;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class FamilyRegistry {
    private static final String namespace = "minecraft";

    abstract public Set<BasicBlock> getBlocks();
    abstract public Recipe<?> getRecipe(final BasicBlock current);
    abstract public Recipe<?> getReversedRecipe(final BasicBlock parent, final BasicBlock current);

    public String getNamespace()
    {
        return namespace;
    }

    public void registerAll(final ItemGroup group)
    {
        final Set<BasicBlock> blocks = getBlocks();
        for (BasicBlock block : blocks)
        {
            block.register(group);
            block.write(block.asLootTable().build())
                 .writeBlockStates()
                 .writeModel()
                 .writeItem()
                 .writeRecipe(getRecipe(block));

            for (BasicBlock reverseBlock : blocks)
            {
                reverseBlock.writeRecipe(getRecipe(reverseBlock));
            }
        }
    }
}
