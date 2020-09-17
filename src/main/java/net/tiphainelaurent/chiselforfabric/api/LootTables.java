package net.tiphainelaurent.chiselforfabric.api;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootConditionConsumingBuilder;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tiphainelaurent.chiselforfabric.ChiselForFabric;

public class LootTables {
    private static final Set<Item> EXPLOSION_IMMUNE = (Set)Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemConvertible::asItem).collect(ImmutableSet.toImmutableSet());

    private static <T> T addSurvivesExplosionCondition(final ItemConvertible drop,
            final LootConditionConsumingBuilder<T> builder) {
        return !EXPLOSION_IMMUNE.contains(drop.asItem())
                ? builder.conditionally(SurvivesExplosionLootCondition.builder())
                : builder.getThis();
    }

    private static LootTable.Builder drops(final ItemConvertible drop) {
        return LootTable.builder().pool((LootPool.Builder) addSurvivesExplosionCondition(drop,
                LootPool.builder().rolls(ConstantLootTableRange.create(1)).with(ItemEntry.builder(drop))));
    }

    public static void of(final Block block) {
        try {
            final Path main = Paths.get(ChiselForFabric.class.getResource("ChiselForFabric.class").toURI()).getParent()
                    .getParent().getParent().getParent();
            final Path lootables = Paths.get(main.toString() + "/data/chiselforfabric/loot_tables/blocks");
            Files.createDirectories(lootables);
            final Identifier identifier = Registry.BLOCK.getId(block);
            Files.write(lootables.resolve(String.format("%s.json", identifier.getPath())), getLootTable(identifier),
                    StandardCharsets.UTF_8);
            final Gson gson = new Gson();
            final LootTable lootTable = drops(block).build();
            System.out.println(gson.toJson(lootTable));
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    public static Iterable<String> getLootTable(final Identifier identifier)
    {
        return Arrays.asList(
            "{",
                "\"type\": \"minecraft:block\",",
                "\"pools\": [{",
                    "\"rolls\": 1,",
                    "\"entries\": [{",
                        "\"type\": \"minecraft:item\",",
                        String.format("\"name\": \"%s\"", identifier),
                    "}],",
                    "\"conditions\": [{",
                        "\"condition\": \"minecraft:survives_explosion\"",
                    "}]",
                "}]",
            "}"
        );
    }
}
