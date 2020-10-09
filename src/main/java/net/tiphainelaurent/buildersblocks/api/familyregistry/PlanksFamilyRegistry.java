package net.tiphainelaurent.buildersblocks.api.familyregistry;

import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.buildersblocks.BuildersBlocks;

public class PlanksFamilyRegistry extends GenericFamilyRegistry {
    public final Set<String> blocksName = Set.of("blinds", "chaotic-hor", "chaotic", "clean", "crate-fancy", "crate",
            "crateex", "double-side", "double-top", "fancy", "large", "panel-nails", "parquet", "short",
            "vertical-uneven", "vertical");

    public PlanksFamilyRegistry(final String familyName, final Block ancestor) {
        super(familyName, ancestor);
    }

    @Override
    public Set<Identifier> getBlocksId() {
        return blocksName.stream()
                .map(name -> new Identifier(BuildersBlocks.MOD_ID, String.format("%s_%s", getFamilyName(), name)))
                .collect(Collectors.toSet());
    }
}
