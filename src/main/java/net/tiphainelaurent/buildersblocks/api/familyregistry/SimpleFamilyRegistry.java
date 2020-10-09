package net.tiphainelaurent.buildersblocks.api.familyregistry;

import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.buildersblocks.BuildersBlocks;

public class SimpleFamilyRegistry extends GenericFamilyRegistry
{
    public final Set<String> blocksName = Set.of("braid", "bricks-cracked", "bricks-encased", "bricks-small",
        "bricks-soft", "bricks-solid", "bricks-triple", "chaotic-medium", "chaotic-small", "circular", "cracked",
        "dent", "french-1", "french-2", "layers", "mosaic", "ornate", "panel", "pillar-side", "pillar-top", "raw",
        "road", "tiles-large", "tiles-medium", "tiles-small", "twisted-side", "twisted-top", "weaver");

    public SimpleFamilyRegistry(final String familyName, final Block ancestor)
    {
        super(familyName, ancestor);
    }

    @Override
    public Set<Identifier> getBlocksId()
    {
        return blocksName.stream()
            .map(name -> new Identifier(BuildersBlocks.MOD_ID, String.format("%s_%s", getFamilyName(), name)))
            .collect(Collectors.toSet());
    }
}
