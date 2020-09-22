package net.tiphainelaurent.chiselforfabric.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.chiselforfabric.api.helpers.Resource;

public abstract class FamilyRegistry
{
    abstract public Set<Identifier> getBlocks();
    abstract public String getTextureDirectory();
    abstract public Block getAncestor();
    abstract public Recipe<?> getRecipe(final Block current);
    abstract public Recipe<?> getReversedRecipe(final Block parent, final Block current);

    // abstract public void getRecipes(final net.tiphainelaurent.chiselforfabric.api.helpers.Item.Builder builder);
    // abstract public void getReversedRecipes(final net.tiphainelaurent.chiselforfabric.api.helpers.Item.Builder builder);

    public void registerAll(final ItemGroup group)
    {
        final Set<Identifier> blockIds = getBlocks();
        final List<Block> blocks = new ArrayList<>(blockIds.size());

        blockIds.forEach((blockId) -> {
            final String namespace = blockId.getNamespace();
            final String blockName = blockId.getPath();
            Block block = net.tiphainelaurent.chiselforfabric.api.helpers.Block.builder(getAncestor())
                .mineable()
                .asItem(group)
                .build(namespace, blockName);
            Resource.writeBlockStates(blockName);
            Resource.writeBlockModel(blockName, getTextureDirectory());
            Resource.writeItemModel(blockName);
            blocks.add(block);
        });

        blocks.forEach((parent) -> {
            net.tiphainelaurent.chiselforfabric.api.helpers.Item.builder().withRecipe(getRecipe(parent));

            blocks.forEach((block) -> {
                net.tiphainelaurent.chiselforfabric.api.helpers.Item.builder()
                    .withRecipe(getReversedRecipe(parent, block));
            });
        });
    }
}
