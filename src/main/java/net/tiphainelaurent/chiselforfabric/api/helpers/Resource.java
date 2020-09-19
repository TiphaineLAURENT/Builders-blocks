package net.tiphainelaurent.chiselforfabric.api.helpers;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootTable;
import net.minecraft.recipe.Recipe;
import net.tiphainelaurent.chiselforfabric.ChiselForFabric;

public class Resource {
    public static void write(final String relativePath, final String name, final String object)
    {
        try {
            final Path directoryPath = Paths.get(ChiselForFabric.MAIN_DIRECTORY.toString() + relativePath);
            Files.createDirectories(directoryPath);
            Files.writeString(directoryPath.resolve(String.format("%s.json", name)), object, StandardCharsets.UTF_8);
        } catch (Exception e) {
            ChiselForFabric.LOGGER.error(e);
        }
    }

    public static void write(final String name, final LootTable lootTable)
    {
        write("/data/chiselforfabric/loot_tables/blocks", name, LootManager.toJson(lootTable).toString());
    }

    public static void writeBlockStates(final String name)
    {
        write("/assets/chiselforfabric/blockstates", name, String.format("{\"variants\": {\"\": {\"model\": \"chiselforfabric:block/%s\"}}}", name));
    }

    public static void writeModel(final String name)
    {
        write("/assets/chiselforfabric/models/block", name, String.format("{\"parent\": \"block/cube_all\",\"textures\": {\"all\": \"chiselforfabric:block/andesite/%s\"}}", name));
    }

    public static void writeItem(final String name)
    {
        write("/assets/chiselforfabric/models/item", name, String.format("{\"parent\": \"chiselforfabric:block/%s\"}", name));
    }

    public static void writeRecipe(final Recipe<?> recipe)
    {
        ChiselForFabric.RECIPES.put(recipe.getId(), recipe);
    }
}
