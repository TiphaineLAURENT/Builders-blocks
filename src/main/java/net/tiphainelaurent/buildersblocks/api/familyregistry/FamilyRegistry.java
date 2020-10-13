package net.tiphainelaurent.buildersblocks.api.familyregistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.swordglowsblue.artifice.api.ArtificeResourcePack.ClientResourcePackBuilder;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;
import net.tiphainelaurent.buildersblocks.BuildersBlocks;

public abstract class FamilyRegistry
{
    abstract public Set<Identifier> getBlocksId();

    abstract public Block getAncestor();

    abstract public Recipe<?> getRecipe(final Block current);

    abstract public Recipe<?> getReversedRecipe(final Block parent, final Block current);

    abstract public String getFamilyName();

    public void registerAll(final ItemGroup group, final ClientResourcePackBuilder pack)
    {
        final Set<Identifier> blockIds = getBlocksId();
        final List<Block> blocks = new ArrayList<>(blockIds.size());
        final String namespace = BuildersBlocks.MOD_ID;
        final String familyName = getFamilyName();
        final Block ancestor = getAncestor();

        blockIds.forEach((blockId) -> {
            final String blockName = blockId.getPath();
            Block block = net.tiphainelaurent.buildersblocks.api.helpers.Block.builder(ancestor).mineable()
                .asItem(group).build(namespace, blockName);

            final Identifier blockModelId = new Identifier(namespace, "block/" + blockName);
            pack.addBlockState(blockId, state -> state.variant("", variant -> variant.model(blockModelId)));
            pack.addBlockModel(blockId,
                model -> model.parent(new Identifier("block/cube_all")).texture("all",
                    new Identifier(BuildersBlocks.MOD_ID, String.format("block/%s/%s", familyName,
                        blockName.substring(blockName.lastIndexOf("_") + 1)))));
            pack.addItemModel(blockId, model -> model.parent(blockModelId));

            blocks.add(block);
        });

        blocks.forEach((parent) -> {
            net.tiphainelaurent.buildersblocks.api.helpers.Item.builder().withRecipe(getRecipe(parent));

            blocks.forEach((block) -> {
                net.tiphainelaurent.buildersblocks.api.helpers.Item.builder()
                    .withRecipe(getReversedRecipe(parent, block));
            });
        });
    }
}
