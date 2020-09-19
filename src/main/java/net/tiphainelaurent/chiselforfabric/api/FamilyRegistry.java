package net.tiphainelaurent.chiselforfabric.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.chiselforfabric.api.helpers.Item;
import net.tiphainelaurent.chiselforfabric.api.helpers.Block;

public abstract class FamilyRegistry {
    private static final String namespace = "minecraft";

    abstract public Set<Identifier> getBlocks();
    abstract public net.minecraft.block.Block getAncestor();
    abstract public Recipe<?> getRecipe(final net.minecraft.block.Block current);
    abstract public Recipe<?> getReversedRecipe(final net.minecraft.block.Block parent, final net.minecraft.block.Block current);

    public String getNamespace()
    {
        return namespace;
    }

    public void registerAll(final ItemGroup group)
    {        
        final Set<Identifier> blockIds = getBlocks();
        final List<net.minecraft.block.Block> blocks = new ArrayList<>(blockIds.size());

        blockIds.forEach((blockId) -> {
            final String namespace = blockId.getNamespace();
            final String blockName = blockId.getPath();
            net.minecraft.block.Block block = Block.builder(getAncestor())
                 .mineable()
                 .namespace(namespace)
                 .name(blockName)
                 .build();
            net.minecraft.item.Item item = Item.builder()
                .block(block)
                .namespace(namespace)
                .name(blockName)
                .group(group)
                .build();
            BasicBlock.writeBlockStates(blockName);
            BasicBlock.writeModel(blockName);
            BasicBlock.writeItem(blockName);
            BasicBlock.writeRecipe(getRecipe(block));
            blocks.add(block);
        });

        blocks.forEach((parent) -> {
            blocks.forEach((block) -> {
                BasicBlock.writeRecipe(getReversedRecipe(parent, block));
            });
        });
    }
}
