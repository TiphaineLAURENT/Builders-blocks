package net.tiphainelaurent.chiselforfabric.api;

import java.util.Set;

import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;

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
            final Identifier blockId = block.getIdentifier();
            Helpers.Item.builder().block(block)
                                  .namespace(blockId.getNamespace())
                                  .name(blockId.getPath())
                                  .group(group)
                                  .build();
            block.write(block.asLootTable().build())
                 .writeBlockStates()
                 .writeItem()
                 .writeModel()
                 .writeRecipe(getRecipe(block));

            for (BasicBlock reverseBlock : blocks)
            {
                reverseBlock.writeRecipe(getRecipe(reverseBlock));
            }
        }
    }
}
