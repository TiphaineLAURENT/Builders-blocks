package net.tiphainelaurent.chiselforfabric.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.swordglowsblue.artifice.api.Artifice;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;
import net.tiphainelaurent.chiselforfabric.ChiselForFabric;

public abstract class FamilyRegistry
{
    abstract public Set<Identifier> getBlocks();

    abstract public String getTextureDirectory();

    abstract public Block getAncestor();

    abstract public Recipe<?> getRecipe(final Block current);

    abstract public Recipe<?> getReversedRecipe(final Block parent, final Block current);

    // abstract public void getRecipes(final
    // net.tiphainelaurent.chiselforfabric.api.helpers.Item.Builder builder);
    // abstract public void getReversedRecipes(final
    // net.tiphainelaurent.chiselforfabric.api.helpers.Item.Builder builder);

    public void registerAll(final ItemGroup group)
    {
        final Set<Identifier> blockIds = getBlocks();
        final List<Block> blocks = new ArrayList<>(blockIds.size());
        final String textureDirectory = getTextureDirectory();

        ArtificeResourcePack resourcePack = Artifice
            .registerAssets(new Identifier(ChiselForFabric.MOD_ID, textureDirectory), pack -> {
                pack.setDisplayName("Chisel For Fabric resources");
                pack.setDescription("Resources for the Chisel For Fabric mod");

                blockIds.forEach((blockId) -> {
                    final String namespace = blockId.getNamespace();
                    final String blockName = blockId.getPath();
                    Block block = net.tiphainelaurent.chiselforfabric.api.helpers.Block.builder(getAncestor())
                        .mineable()
                        .asItem(group)
                        .build(namespace, blockName);

                    final Identifier blockModelId = new Identifier(ChiselForFabric.MOD_ID, "block/" + blockName);
                    pack.addBlockState(blockId, state -> state
                        .variant("", variant -> variant
                            .model(blockModelId)));
                    pack.addBlockModel(blockId, model -> model
                        .parent(new Identifier("block/cube_all"))
                        .texture("all", new Identifier(ChiselForFabric.MOD_ID, String.format("block/%s/%s",
                            textureDirectory, blockName.substring(blockName.indexOf("_", 0) + 1)))));
                    pack.addItemModel(blockId, model -> model
                        .parent(blockModelId));

                    blocks.add(block);
                });
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
