package net.tiphainelaurent.chiselforfabric.api.helpers;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.AbstractBlock.ContextPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootConditionConsumingBuilder;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.tiphainelaurent.chiselforfabric.api.helpers.Resource;

public class Block
{
    public static final Set<Item> EXPLOSION_IMMUNE = Set.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).stream().map(ItemConvertible::asItem).collect(Collectors.toSet());
    public static <T> T addSurvivesExplosionCondition(final ItemConvertible drop, final LootConditionConsumingBuilder<T> builder)
    {
        return !EXPLOSION_IMMUNE.contains(drop.asItem())
                ? builder.conditionally(SurvivesExplosionLootCondition.builder())
                : builder.getThis();
    }

    public static void makeMineable(final net.minecraft.block.Block block)
    {
        LootTable table = new LootTable.Builder().pool(addSurvivesExplosionCondition(block,
                                                LootPool.builder()
                                                        .rolls(ConstantLootTableRange.create(1))
                                                        .with(ItemEntry.builder(block))))
            .build();
        Resource.write(Registry.BLOCK.getId(block).getPath(), table);
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
            final net.minecraft.block.Block block = new net.minecraft.block.Block(settings);
            Registry.register(Registry.BLOCK, new Identifier(namespace, name), block);

            return block;
        }

        public Block.Builder namespace(final String namespace_) {
            namespace = namespace_;
            return this;
        }

        public Block.Builder name(final String name_) {
            name = name_;
            return this;
        }

        @Deprecated
        public Block.Builder mineable()
        {
            mineable = true;
            return this;
        }

        public Block.Builder air() {
            settings.air();
            return this;
        }

        public Block.Builder allowsSpawning(final AbstractBlock.TypedContextPredicate<EntityType<?>> predicate) {
            settings.allowsSpawning(predicate);
            return this;
        }

        public Block.Builder blockVision(final ContextPredicate predicate) {
            settings.blockVision(predicate);
            return this;
        }

        public Block.Builder breakByHand(final boolean breakByHand) {
            settings.breakByHand(breakByHand);
            return this;
        }

        public Block.Builder breakByTool(final Tag<Item> tag, final int miningLevel) {
            settings.breakByTool(tag, miningLevel);
            return this;
        }

        public Block.Builder breakByTool(final Tag<Item> tag) {
            settings.breakByTool(tag);
            return this;
        }

        public Block.Builder breakInstantly() {
            settings.breakInstantly();
            return this;
        }

        public Block.Builder collidable(final boolean collidable) {
            settings.collidable(collidable);
            return this;
        }

        public Block.Builder drops(final Identifier dropTableId) {
            settings.drops(dropTableId);
            return this;
        }

        public Block.Builder dropsLike(final net.minecraft.block.Block block) {
            settings.dropsLike(block);
            return this;
        }

        public Block.Builder dynamicBounds() {
            settings.dynamicBounds();
            return this;
        }

        public Block.Builder emissiveLightning(final ContextPredicate predicate) {
            settings.emissiveLighting(predicate);
            return this;
        }

        public Block.Builder hardness(final float hardness) {
            settings.hardness(hardness);
            return this;
        }

        public Block.Builder jumpVelocityMultiplier(final float jumpVelocityMultiplier) {
            settings.jumpVelocityMultiplier(jumpVelocityMultiplier);
            return this;
        }

        public Block.Builder lightLevel(final int lightLevel) {
            settings.lightLevel(lightLevel);
            return this;
        }

        public Block.Builder lightLevel(final ToIntFunction<BlockState> levelFunction) {
            settings.lightLevel(levelFunction);
            return this;
        }

        public Block.Builder materialColor(final DyeColor color) {
            settings.materialColor(color);
            return this;
        }

        public Block.Builder materialColor(final MaterialColor color) {
            settings.materialColor(color);
            return this;
        }

        public Block.Builder noCollision() {
            settings.noCollision();
            return this;
        }

        public Block.Builder nonOpaque() {
            settings.nonOpaque();
            return this;
        }

        public Block.Builder postProcess(final ContextPredicate predicate) {
            settings.postProcess(predicate);
            return this;
        }

        public Block.Builder requiresTool() {
            settings.requiresTool();
            return this;
        }

        public Block.Builder resistances(final float resistance) {
            settings.resistance(resistance);
            return this;
        }

        public Block.Builder slipperiness(final float value) {
            settings.slipperiness(value);
            return this;
        }

        public Block.Builder solidBlock(final ContextPredicate predicate) {
            settings.solidBlock(predicate);
            return this;
        }

        public Block.Builder sounds(final BlockSoundGroup group) {
            settings.sounds(group);
            return this;
        }

        public Block.Builder strength(final float hardness, final float resistance) {
            settings.strength(hardness, resistance);
            return this;
        }

        public Block.Builder strength(final float strength) {
            settings.strength(strength);
            return this;
        }

        public Block.Builder suffocates(final ContextPredicate predicate) {
            settings.suffocates(predicate);
            return this;
        }

        public Block.Builder tickRandomly() {
            settings.ticksRandomly();
            return this;
        }

        public Block.Builder velocityMultiplier(final float velocityMultiplier)
        {
            settings.velocityMultiplier(velocityMultiplier);
            return this;
        }
    }
}
