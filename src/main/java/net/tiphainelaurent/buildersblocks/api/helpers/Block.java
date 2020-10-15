package net.tiphainelaurent.buildersblocks.api.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Block extends net.minecraft.block.Block
{
    public static final Map<Identifier, Supplier<LootTable>> LOOT_POOLS = new HashMap<>();

    public Block(AbstractBlock.Settings settings)
    {
        super(settings);
    }

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
        private boolean mineable = false;
        private Item.Builder itemBuilder;

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

        public Block build()
        {
            return build(new Identifier(namespace, name));
        }

        public Block build(final String namespace_, final String name_)
        {
            return build(new Identifier(namespace_, name_));
        }

        public Block build(final Identifier blockId)
        {
            final Block block = new Block(settings);
            Registry.register(Registry.BLOCK, blockId, block);

            if (itemBuilder != null)
            {
                itemBuilder.fromBlock(block).build(blockId);
            }

            if (mineable)
            {
                LOOT_POOLS.put(block.getLootTableId(), () -> {
                    final LootPool.Builder pool = FabricLootPoolBuilder.builder()
                        .withEntry(ItemEntry.builder(block).build())
                        .rolls(ConstantLootTableRange.create(1))
                        .withCondition(SurvivesExplosionLootCondition.builder().build());
                    return LootTable.builder().pool(pool).build();
                });
            }

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

        public Block.Builder mineable()
        {
            mineable = true;
            return this;
        }

        public Block.Builder air()
        {
            settings.air();
            return this;
        }

        public Block.Builder allowsSpawning(final AbstractBlock.TypedContextPredicate<EntityType<?>> predicate)
        {
            settings.allowsSpawning(predicate);
            return this;
        }

        public Block.Builder blockVision(final ContextPredicate predicate)
        {
            settings.blockVision(predicate);
            return this;
        }

        public Block.Builder breakByHand(final boolean breakByHand)
        {
            settings.breakByHand(breakByHand);
            return this;
        }

        public Block.Builder breakByTool(final Tag<net.minecraft.item.Item> tag, final int miningLevel)
        {
            settings.breakByTool(tag, miningLevel);
            return this;
        }

        public Block.Builder breakByTool(final Tag<net.minecraft.item.Item> tag)
        {
            settings.breakByTool(tag);
            return this;
        }

        public Block.Builder breakInstantly()
        {
            settings.breakInstantly();
            return this;
        }

        public Block.Builder collidable(final boolean collidable)
        {
            settings.collidable(collidable);
            return this;
        }

        public Block.Builder drops(final Identifier dropTableId)
        {
            settings.drops(dropTableId);
            return this;
        }

        public Block.Builder dropsLike(final net.minecraft.block.Block block)
        {
            settings.dropsLike(block);
            return this;
        }

        public Block.Builder dynamicBounds()
        {
            settings.dynamicBounds();
            return this;
        }

        public Block.Builder emissiveLightning(final ContextPredicate predicate)
        {
            settings.emissiveLighting(predicate);
            return this;
        }

        public Block.Builder hardness(final float hardness)
        {
            settings.hardness(hardness);
            return this;
        }

        public Block.Builder jumpVelocityMultiplier(final float jumpVelocityMultiplier)
        {
            settings.jumpVelocityMultiplier(jumpVelocityMultiplier);
            return this;
        }

        public Block.Builder lightLevel(final int lightLevel)
        {
            settings.lightLevel(lightLevel);
            return this;
        }

        public Block.Builder lightLevel(final ToIntFunction<BlockState> levelFunction)
        {
            settings.lightLevel(levelFunction);
            return this;
        }

        public Block.Builder materialColor(final DyeColor color)
        {
            settings.materialColor(color);
            return this;
        }

        public Block.Builder materialColor(final MaterialColor color)
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

        public Block.Builder postProcess(final ContextPredicate predicate)
        {
            settings.postProcess(predicate);
            return this;
        }

        public Block.Builder requiresTool()
        {
            settings.requiresTool();
            return this;
        }

        public Block.Builder resistances(final float resistance)
        {
            settings.resistance(resistance);
            return this;
        }

        public Block.Builder slipperiness(final float value)
        {
            settings.slipperiness(value);
            return this;
        }

        public Block.Builder solidBlock(final ContextPredicate predicate)
        {
            settings.solidBlock(predicate);
            return this;
        }

        public Block.Builder sounds(final BlockSoundGroup group)
        {
            settings.sounds(group);
            return this;
        }

        public Block.Builder strength(final float hardness, final float resistance)
        {
            settings.strength(hardness, resistance);
            return this;
        }

        public Block.Builder strength(final float strength)
        {
            settings.strength(strength);
            return this;
        }

        public Block.Builder suffocates(final ContextPredicate predicate)
        {
            settings.suffocates(predicate);
            return this;
        }

        public Block.Builder tickRandomly()
        {
            settings.ticksRandomly();
            return this;
        }

        public Block.Builder velocityMultiplier(final float velocityMultiplier)
        {
            settings.velocityMultiplier(velocityMultiplier);
            return this;
        }

        public Block.Builder asItem(final ItemGroup itemGroup)
        {
            itemBuilder = net.tiphainelaurent.buildersblocks.api.helpers.Item.builder()
                .group(itemGroup);

            return this;
        }
    }
}
