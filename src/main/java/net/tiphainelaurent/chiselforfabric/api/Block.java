package net.tiphainelaurent.chiselforfabric.api;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

public class Block
{
    public static Builder builder(final Material material)
    {
        return new Builder(material);
    }

    public static Builder builder(final Material material, final MaterialColor color)
    {
        return new Builder(material, color);
    }

    public static Builder builder(final AbstractBlock block)
    {
        return new Builder(block);
    }

    public static Builder builder(final AbstractBlock.Settings block)
    {
        return new Builder(block);
    }

    public static class Builder
    {
        private final FabricBlockSettings settings;

        public Builder(final Material material)
        {
            settings = FabricBlockSettings.of(material);
        }

        public Builder(final Material material, final MaterialColor color)
        {
            settings = FabricBlockSettings.of(material, color);
        }

        public Builder(final AbstractBlock block)
        {
            settings = FabricBlockSettings.copyOf(block);
        }

        public Builder(final AbstractBlock.Settings block)
        {
            settings = FabricBlockSettings.copyOf(block);
        }

        public net.minecraft.block.Block build()
        {
            return new net.minecraft.block.Block(settings);
        }
    }
}
