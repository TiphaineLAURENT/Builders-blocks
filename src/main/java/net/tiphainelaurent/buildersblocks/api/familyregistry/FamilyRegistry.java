package net.tiphainelaurent.buildersblocks.api.familyregistry;

import java.util.Set;

import com.swordglowsblue.artifice.api.ArtificeResourcePack.ClientResourcePackBuilder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.buildersblocks.BuildersBlocks;
import net.tiphainelaurent.buildersblocks.api.helpers.Item;
import net.tiphainelaurent.buildersblocks.api.helpers.Block;

public abstract class FamilyRegistry
{
    abstract public Set<Identifier> getBlocksId();

    abstract public net.minecraft.block.Block getAncestor();

    abstract public Recipe<?> getRecipe(final Identifier current);

    abstract public Recipe<?> getReversedRecipe(final Identifier parent, final Identifier current);

    abstract public String getFamilyName();

    @Environment(EnvType.SERVER)
    public void registerAll(final ItemGroup group)
    {
        final Set<Identifier> blockIds = getBlocksId();
        final net.minecraft.block.Block ancestor = getAncestor();

        blockIds.forEach((blockId) -> {
            Block.builder(ancestor).mineable()
                .asItem((item) -> {
                    final Item.Builder itemBuilder = item.group(group).withRecipe(() -> getRecipe(blockId));
                    blockIds.forEach((otherId) -> {
                        itemBuilder.withRecipe(() -> getReversedRecipe(otherId, blockId));
                    });
                }).build(blockId);
        });
    }

    @Environment(EnvType.CLIENT)
    public void registerAll(final ItemGroup group, final ClientResourcePackBuilder pack)
    {
        final Set<Identifier> blockIds = getBlocksId();
        final String familyName = getFamilyName();
        final net.minecraft.block.Block ancestor = getAncestor();

        blockIds.forEach((blockId) -> {
            final String blockName = blockId.getPath();

            Block.builder(ancestor).mineable()
                .asItem((item) -> {
                    final Item.Builder itemBuilder = item.group(group).withRecipe(() -> getRecipe(blockId));
                    blockIds.forEach((otherId) -> {
                        itemBuilder.withRecipe(() -> getReversedRecipe(otherId, blockId));
                    });
                }).build(blockId);

            final Identifier blockModelId = new Identifier(blockId.getNamespace(), "block/" + blockName);

            pack.addBlockState(blockId, state -> state.variant("", variant -> variant.model(blockModelId)));
            pack.addBlockModel(blockId,
                model -> model.parent(new Identifier("block/cube_all")).texture("all",
                    new Identifier(BuildersBlocks.MOD_ID, String.format("block/%s/%s", familyName,
                        blockName.substring(blockName.lastIndexOf("_") + 1)))));
            pack.addItemModel(blockId, model -> model.parent(blockModelId));
        });
    }
}
