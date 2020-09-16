package net.tiphainelaurent.chiselforfabric.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;
import net.tiphainelaurent.chiselforfabric.ChiselForFabric;

public class LootTables {

    public static void of(final Block block) {
        try {
            final Path main = Paths.get(ChiselForFabric.class.getResource("ChiselForFabric.class").toURI()).getParent()
                    .getParent().getParent().getParent();
            final Path lootables = Paths.get(main.toString() + "/data/chiselforfabric/loot_tables/blocks");
            Files.createDirectories(lootables);
            Files.write(lootables.resolve("braid.json"), getLootTable(block), StandardCharsets.UTF_8);            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Iterable<String> getLootTable(final Block block)
    {
        return Arrays.asList(
            "{",
                "\"type\": \"minecraft:block\",",
                "\"pools\": [{",
                    "\"rolls\": 1,",
                    "\"entries\": [{",
                        "\"type\": \"minecraft:item\",",
                        String.format("\"name\": \"%s\"", Registry.BLOCK.getId(block)),
                    "}],",
                    "\"conditions\": [{",
                        "\"condition\": \"minecraft:survives_explosion\"",
                    "}]",
                "}]",
            "}"
        );
    }
}
