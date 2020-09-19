package net.tiphainelaurent.chiselforfabric.api;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.AbstractBlock.ContextPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.ToIntFunction;

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
        private String namespace = "minecraft";
        private String name;

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
            net.minecraft.block.Block block = new net.minecraft.block.Block(settings);
            Registry.register(Registry.BLOCK, new Identifier(namespace, name), block);
            return block;
        }

        public Block.Builder namespace(final String namespace_)
        {
            namespace = namespace_;
            return this;
        }

        public Block.Builder name(final String name_)
        {
            name = name_;
            return this;
        }

        public Block.Builder air()
        {
            settings.air();
            return this;
        }

        public Block.Builder allowsSpawning(AbstractBlock.TypedContextPredicate<EntityType<?>> predicate)
        {
            settings.allowsSpawning(predicate);
            return this;
        }

        public Block.Builder blockVision(ContextPredicate predicate)
        {
            settings.blockVision(predicate);
            return this;
        }

        public Block.Builder breakByHand(boolean breakByHand)
        {
            settings.breakByHand(breakByHand);
            return this;
        }

        public Block.Builder breakByTool(Tag<Item> tag, int miningLevel)
        {
            settings.breakByTool(tag, miningLevel);
            return this;
        }

        public Block.Builder breakByTool(Tag<Item> tag)
        {
            settings.breakByTool(tag);
            return this;
        }

        public Block.Builder breakInstantly()
        {
            settings.breakInstantly();
            return this;
        }

        public Block.Builder collidable(boolean collidable)
        {
            settings.collidable(collidable);
            return this;
        }

        public Block.Builder drops(Identifier dropTableId)
        {
            settings.drops(dropTableId);
            return this;
        }

        public Block.Builder dropsLike(net.minecraft.block.Block block)
        {
            settings.dropsLike(block);
            return this;
        }

        public Block.Builder dynamicBounds()
        {
            settings.dynamicBounds();
            return this;
        }

        public Block.Builder emissiveLightning(ContextPredicate predicate)
        {
            settings.emissiveLighting(predicate);
            return this;
        }

        public Block.Builder hardness(float hardness)
        {
            settings.hardness(hardness);
            return this;
        }

        public Block.Builder jumpVelocityMultiplier(float jumpVelocityMultiplier)
        {
            settings.jumpVelocityMultiplier(jumpVelocityMultiplier);
            return this;
        }

        public Block.Builder lightLevel(int lightLevel)
        {
            settings.lightLevel(lightLevel);
            return this;
        }

        public Block.Builder lightLevel(ToIntFunction<BlockState> levelFunction)
        {
            settings.lightLevel(levelFunction);
            return this;
        }

        public Block.Builder materialColor(DyeColor color)
        {
            settings.materialColor(color);
            return this;
        }

        public Block.Builder materialColor(MaterialColor color)
        {
            settings.materialColor(color);
            return this;
        }

        public Block.Builder noCollision()
        {
            settings.noCollision();
            return this;
        }

        public Block.Builder nonOpaque()
        {
            settings.nonOpaque();
            return this;
        }

        public Block.Builder postProcess(ContextPredicate predicate)
        {
            settings.postProcess(predicate);
            return this;
        }

        public Block.Builder requiresTool()
        {
            settings.requiresTool();
            return this;
        }

        public Block.Builder resistances(float resistance)
        {
            settings.resistance(resistance);
            return this;
        }

        public Block.Builder slipperiness(float value)
        {
            settings.slipperiness(value);
            return this;
        }

        public Block.Builder solidBlock(ContextPredicate predicate)
        {
            settings.solidBlock(predicate);
            return this;
        }

        public Block.Builder sounds(BlockSoundGroup group)
        {
            settings.sounds(group);
            return this;
        }

        public Block.Builder strength(float hardness, float resistance)
        {
            settings.strength(hardness, resistance);
            return this;
        }

        public Block.Builder strength(float strength)
        {
            settings.strength(strength);
            return this;
        }

        public Block.Builder suffocates(ContextPredicate predicate)
        {
            settings.suffocates(predicate);
            return this;
        }

        public Block.Builder tickRandomly()
        {
            settings.ticksRandomly();
            return this;
        }

        public Block.Builder velocityMultiplier(float velocityMultiplier)
        {
            settings.velocityMultiplier(velocityMultiplier);
            return this;
        }
    }
}
