package net.tiphainelaurent.chiselforfabric.api;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootConditionConsumingBuilder;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.tiphainelaurent.chiselforfabric.ChiselForFabric;

public class BasicBlock extends Block {
    private static final Set<Item> EXPLOSION_IMMUNE = Set.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).stream().map(ItemConvertible::asItem).collect(Collectors.toSet());

    private final Identifier identifier;

    public BasicBlock(final Settings settings) {
        super(settings);
        identifier = new Identifier(getTranslationKey());
    }

    public BasicBlock(final Identifier identifier_, final Settings settings) {
        super(settings);
        identifier = identifier_;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void register(final ItemGroup itemGroup)
    {
        Registry.register(Registry.BLOCK, getIdentifier(), this);

        final Item item = new BlockItem(this, new Item.Settings().group(itemGroup));
        Registry.register(Registry.ITEM, getIdentifier(), item);
    }


    private <T> T addSurvivesExplosionCondition(final ItemConvertible drop, final LootConditionConsumingBuilder<T> builder)
    {
        return !EXPLOSION_IMMUNE.contains(drop.asItem())
                ? builder.conditionally(SurvivesExplosionLootCondition.builder())
                : builder.getThis();
    }

    public LootTable.Builder asLootTable()
    {
        return LootTable.builder()
                        .pool((LootPool.Builder) addSurvivesExplosionCondition(this, LootPool.builder()
                                                                                             .rolls(ConstantLootTableRange.create(1))
                                                                                             .with(ItemEntry.builder(this))));
    }

    public void write(final String relativePath, final String object)
    {
        try {
            final Path directoryPath = Paths.get(ChiselForFabric.MAIN_DIRECTORY.toString() + relativePath);
            Files.createDirectories(directoryPath);
            Files.writeString(directoryPath.resolve(String.format("%s.json", identifier.getPath())), object, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public BasicBlock write(final LootTable lootTable)
    {
        write("/data/chiselforfabric/loot_tables/blocks", LootManager.toJson(lootTable).toString());
        return this;
    }

    public BasicBlock writeBlockStates()
    {
        write("/assets/chiselforfabric/blockstates", String.format("{\"variants\": {\"\": {\"model\": \"chiselforfabric:block/%s\"}}}", getIdentifier().getPath()));
        return this;
    }

    public BasicBlock writeModel()
    {
        write("/assets/chiselforfabric/models/block", String.format("{\"parent\": \"block/cube_all\",\"textures\": {\"all\": \"chiselforfabric:block/andesite/%s\"}}", getIdentifier().getPath()));
        return this;
    }

    public BasicBlock writeItem()
    {
        write("/assets/chiselforfabric/models/item", String.format("{\"parent\": \"chiselforfabric:block/%s\"}", getIdentifier().getPath()));
        return this;
    }

    public BasicBlock writeRecipe(final Recipe<?> recipe)
    {
        ChiselForFabric.RECIPES.put(recipe.getId(), recipe);
        return this;
    }
}
