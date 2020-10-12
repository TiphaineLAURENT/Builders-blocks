package net.tiphainelaurent.buildersblocks.api.familyregistry;

import java.util.Arrays;

import net.minecraft.block.Block;

public class SimpleFamilyRegistry extends GenericFamilyRegistry
{
    public SimpleFamilyRegistry(final String familyName, final Block ancestor)
    {
        super(familyName, ancestor);
        with(Arrays.asList("braid", "bricks-cracked", "bricks-encased", "bricks-small",
        "bricks-soft", "bricks-solid", "bricks-triple", "chaotic-medium", "chaotic-small", "circular", "cracked",
        "dent", "french-1", "french-2", "layers", "mosaic", "ornate", "panel", "pillar-side", "pillar-top", "raw",
        "road", "tiles-large", "tiles-medium", "tiles-small", "twisted-side", "twisted-top", "weaver"));
    }
}
