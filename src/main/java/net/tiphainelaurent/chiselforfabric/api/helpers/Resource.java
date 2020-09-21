package net.tiphainelaurent.chiselforfabric.api.helpers;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public static void writeBlockStates(final String name)
    {
        write("/assets/chiselforfabric/blockstates", name, String.format("{\"variants\": {\"\": {\"model\": \"chiselforfabric:block/%s\"}}}", name));
    }

    public static void writeModel(final String name, final String directory)
    {
        write("/assets/chiselforfabric/models/block", name, String.format("{\"parent\": \"block/cube_all\",\"textures\": {\"all\": \"chiselforfabric:block/%s/%s\"}}", directory, name.substring(name.indexOf("_", 0) + 1)));
    }

    public static void writeItem(final String name)
    {
        write("/assets/chiselforfabric/models/item", name, String.format("{\"parent\": \"chiselforfabric:block/%s\"}", name));
    }
}
