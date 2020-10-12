package net.tiphainelaurent.buildersblocks.api.familyregistry;

import java.util.Arrays;

import net.minecraft.block.Block;

public class PlanksFamilyRegistry extends GenericFamilyRegistry
{
    public PlanksFamilyRegistry(final String familyName, final Block ancestor)
    {
        super(familyName, ancestor);
        with(Arrays.asList("blinds", "chaotic-hor", "chaotic", "clean", "crate-fancy", "crate",
            "crateex", "double-side", "double-top", "fancy", "large", "panel-nails", "parquet", "short",
            "vertical-uneven", "vertical"));
    }
}
