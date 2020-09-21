package net.tiphainelaurent.chiselforfabric.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.chiselforfabric.api.helpers.Item;
import net.tiphainelaurent.chiselforfabric.api.helpers.Resource;
import net.tiphainelaurent.chiselforfabric.api.helpers.Block;

public abstract class FamilyRegistry {
    abstract public Set<Identifier> getBlocks();
    abstract public String getTextureDirectory();
    abstract public net.minecraft.block.Block getAncestor();
    abstract public Recipe<?> getRecipe(final net.minecraft.block.Block current);
    abstract public Recipe<?> getReversedRecipe(final net.minecraft.block.Block parent, final net.minecraft.block.Block current);

    public void registerAll(final ItemGroup group)
    {
        final Set<Identifier> blockIds = getBlocks();
        final List<net.minecraft.block.Block> blocks = new ArrayList<>(blockIds.size());

        blockIds.forEach((blockId) -> {
            final String namespace = blockId.getNamespace();
            final String blockName = blockId.getPath();
            net.minecraft.block.Block block = Block.builder(getAncestor())
                 .namespace(namespace)
                 .name(blockName)
                 .build();
            Item.builder()
                .block(block)
                .namespace(namespace)
                .name(blockName)
                .group(group)
                .build();
            Block.makeMineable(block);
            Resource.writeBlockStates(blockName);
            Resource.writeModel(blockName, getTextureDirectory());
            Resource.writeItem(blockName);
            Resource.writeRecipe(getRecipe(block));
            blocks.add(block);
        });

        blocks.forEach((parent) -> {
            blocks.forEach((block) -> {
                Resource.writeRecipe(getReversedRecipe(parent, block));
            });
        });
    }
}
