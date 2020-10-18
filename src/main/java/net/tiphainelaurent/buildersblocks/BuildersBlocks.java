package net.tiphainelaurent.buildersblocks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import net.tiphainelaurent.buildersblocks.api.familyregistry.FamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.familyregistry.GenericFamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.familyregistry.PlanksFamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.familyregistry.SimpleFamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.helpers.Block;
import net.tiphainelaurent.buildersblocks.api.helpers.Item;
import net.tiphainelaurent.buildersblocks.blocks.FertilizedDirt;
import net.tiphainelaurent.buildersblocks.config.Configuration;

public class BuildersBlocks implements ModInitializer
{
    public static final String MOD_ID = "buildersblocks";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "general"))
        .icon(() -> new ItemStack(Items.STONECUTTER)).build();
    public static final Logger LOGGER = LogManager.getLogger();
    public static Configuration configuration;
    public static List<String> simpleBlocksName = Arrays.asList("braid", "bricks-cracked", "bricks-encased",
        "bricks-small", "bricks-soft", "bricks-solid", "bricks-triple", "chaotic-medium", "chaotic-small", "circular",
        "cracked", "dent", "french-1", "french-2", "layers", "mosaic", "ornate", "panel", "pillar-side", "pillar-top",
        "raw", "road", "tiles-large", "tiles-medium", "tiles-small", "twisted-side", "twisted-top", "weaver");
    public static List<FamilyRegistry> FAMILIES = new LinkedList<>();

    // "block.buildersblocks.braid": "",
    // "block.buildersblocks.bricks-cracked": "",
    // "block.buildersblocks.bricks-encased": "",
    // "block.buildersblocks.bricks-small": "",
    // "block.buildersblocks.bricks-soft": "",
    // "block.buildersblocks.bricks-solid": "",
    // "block.buildersblocks.bricks-triple": "",
    // "block.buildersblocks.chaotic-medium": "",
    // "block.buildersblocks.chaotic-small": "",
    // "block.buildersblocks.circular": "",
    // "block.buildersblocks.cracked": "",
    // "block.buildersblocks.dent": "",
    // "block.buildersblocks.french-1": "",
    // "block.buildersblocks.french-2": "",
    // "block.buildersblocks.layers": "",
    // "block.buildersblocks.mosaic": "",
    // "block.buildersblocks.ornate": "",
    // "block.buildersblocks.panel": "",
    // "block.buildersblocks.pillar-side": "",
    // "block.buildersblocks.pillar-top": "",
    // "block.buildersblocks.raw": "",
    // "block.buildersblocks.road": "",
    // "block.buildersblocks.tiles-large": "",
    // "block.buildersblocks.tiles-medium": "",
    // "block.buildersblocks.tiles-small": "",
    // "block.buildersblocks.twisted-side": "",
    // "block.buildersblocks.twisted-top": "",
    // "block.buildersblocks.weaver": "",

    @Override
    public void onInitialize()
    {
        configuration = AutoConfig.register(Configuration.class, Toml4jConfigSerializer::new).getConfig();

        final Block.Builder builder = Block.builder(Blocks.REDSTONE_LAMP).asItem((item) -> item.group(ITEM_GROUP));
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
        {
            builder.lightLevel((blockState) -> (Boolean)blockState.get(Properties.LIT) ? 15 : 0);
        }
        else
        {
            builder.lightLevel((blockState) -> 0);
        }
        builder.build(new Identifier(MOD_ID, "schrodinger_lamp"), RedstoneLampBlock::new);

        Block.builder(Blocks.FARMLAND).asItem((item) -> item.group(ITEM_GROUP))
            .build(new Identifier(MOD_ID, "fertilized_dirt"), FertilizedDirt::new);

        if (configuration.ancient_stone && !FabricLoader.getInstance().isModLoaded("thaumcraft"))
        {
            FAMILIES.add(new SimpleFamilyRegistry("ancient_stone", Blocks.STONE));
        }

        if (configuration.andesite)
            FAMILIES.add(new SimpleFamilyRegistry("andesite", Blocks.ANDESITE));

        if (configuration.antiblock)
            FAMILIES.add(new GenericFamilyRegistry("antiblock", Blocks.GLOWSTONE).with(Arrays.asList(
                "black", "blue", "brown", "cyan", "gray", "green", "light_blue", "lime",
                "magenta", "orange", "pink", "purple", "red", "silver", "white", "yellow")));

        if (configuration.arcane_stone && !FabricLoader.getInstance().isModLoaded("thaumcraft"))
            FAMILIES.add(new SimpleFamilyRegistry("arcane_stone", Blocks.STONE));

        if (configuration.basalt)
            FAMILIES.add(new SimpleFamilyRegistry("basalt", Blocks.BASALT));

        // new
        // SimpleFamilyRegistry("blood_magic",);
        // if (configuration.bookshelf)
        // families.add(new GenericFamilyRegistry("bookshelf",
        // Blocks.BOOKSHELF).with(Arrays.asList("abandoned", "brim", "cans",
        // "historician", "hoarder", "necromancer-novice", "necromancer",
        // "papers", "rainbow", "redtomes"))
        // ;

        if (configuration.bricks)
            FAMILIES.add(new SimpleFamilyRegistry("bricks", Blocks.BRICKS));

        if (configuration.certus)
            FAMILIES.add(new SimpleFamilyRegistry("certus", Blocks.QUARTZ_BLOCK));
        // new
        // SimpleFamilyRegistry("cloud",);

        if (configuration.charcoal)
            FAMILIES.add(new SimpleFamilyRegistry("coal/charcoal", Blocks.COAL_BLOCK));

        if (configuration.coal)
            FAMILIES.add(new SimpleFamilyRegistry("coal/coal", Blocks.COAL_BLOCK));
        // families.add(new SimpleFamilyRegistry("coal/coalcoke",
        // Blocks.COAL_BLOCK);

        if (configuration.cobblestone)
            FAMILIES.add(new SimpleFamilyRegistry("cobblestone", Blocks.COBBLESTONE));

        if (configuration.concrete)
        {
            FAMILIES.add(new GenericFamilyRegistry("concrete", Blocks.STONE).with(Arrays.asList(
                "block", "blocks", "default", "doubleslab-side", "weathered-block-half-side",
                "weathered-block", "weathered-blocks", "weathered-doubleslab-side", "weathered-half-side",
                "weathered")));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_black", Blocks.BLACK_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_blue", Blocks.BLUE_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_brown", Blocks.BROWN_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_cyan", Blocks.CYAN_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_gray", Blocks.GRAY_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_green", Blocks.GREEN_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_lightblue", Blocks.LIGHT_BLUE_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_lightgray", Blocks.LIGHT_GRAY_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_lime", Blocks.LIME_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_magenta", Blocks.MAGENTA_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_orange", Blocks.ORANGE_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_pink", Blocks.PINK_CONCRETE));
            // families.add(new SimpleFamilyRegistry("concrete_powder",
            // Blocks.WHITE_CONCRETE_POWDER);
            FAMILIES.add(new SimpleFamilyRegistry("concrete_purple", Blocks.PURPLE_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_red", Blocks.RED_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_white", Blocks.WHITE_CONCRETE));
            FAMILIES.add(new SimpleFamilyRegistry("concrete_yellow", Blocks.YELLOW_CONCRETE));
        }

        if (configuration.diamond)
            FAMILIES.add(new GenericFamilyRegistry("diamond", Blocks.DIAMOND_BLOCK)
                .with(Arrays.asList("terrain-diamond-bismuth", "terrain-diamond-cells", "terrain-diamond-crushed",
                    "terrain-diamond-embossed-bottom", "terrain-diamond-embossed-side",
                    "terrain-diamond-embossed-top", "terrain-diamond-four", "terrain-diamond-fourornate",
                    "terrain-diamond-gem-bottom", "terrain-diamond-gem-side", "terrain-diamond-gem-top",
                    "terrain-diamond-ornatelayer", "terrain-diamond-simple-bottom", "terrain-diamond-simple-side",
                    "terrain-diamond-simple-top", "terrain-diamond-spaceblack", "terrain-diamond-zelda")));

        if (configuration.diorite)
            FAMILIES.add(new SimpleFamilyRegistry("diorite", Blocks.DIORITE));
        // new
        // SimpleFamilyRegistry("dirt",);
        // new
        // SimpleFamilyRegistry("emerald",);

        if (configuration.endstone)
            FAMILIES.add(new SimpleFamilyRegistry("endstone", Blocks.END_STONE));
        // new
        // SimpleFamilyRegistry("factory",);

        // families.add(new SimpleFamilyRegistry("fluid",
        // Blocks.STONE);
        // new
        // SimpleFamilyRegistry("futura",);
        // new
        // SimpleFamilyRegistry("glass",);
        // new
        // SimpleFamilyRegistry("glass_stained",);
        // new
        // SimpleFamilyRegistry("glassdyed",);
        // new
        // SimpleFamilyRegistry("glasspaneddyed",);

        if (configuration.glowstone)
            FAMILIES.add(new SimpleFamilyRegistry("glowstone", Blocks.GLOWSTONE).without("raw").without("weaver"));
        // new
        // SimpleFamilyRegistry("gold",);

        if (configuration.granite)
            FAMILIES.add(new SimpleFamilyRegistry("granite", Blocks.GRANITE));

        if (configuration.hardenedclay)
            FAMILIES.add(new SimpleFamilyRegistry("hardenedclay", Blocks.TERRACOTTA));

        if (configuration.ice)
            FAMILIES.add(new SimpleFamilyRegistry("ice", Blocks.ICE));
        // new
        // SimpleFamilyRegistry("icepillar",);
        // new
        // SimpleFamilyRegistry("iron",);
        // new
        // SimpleFamilyRegistry("ironpane",);

        if (configuration.laboratory)
        {
            final String laboratoryFamilyName = "laboratory";
            final String laboratoryBlockName = String.format("%s_checkertile", laboratoryFamilyName);
            final Identifier laboratoryBlockId = new Identifier(MOD_ID, laboratoryBlockName);
            Block laboratoryBlock = Block.builder(Blocks.IRON_BLOCK).asItem(ITEM_GROUP).mineable()
                .build(laboratoryBlockId);

            DefaultedList<Ingredient> recipe = DefaultedList.of();
            recipe.add(Ingredient.ofItems(Items.STONE));
            recipe.add(Ingredient.ofItems(Items.STONE));
            recipe.add(Ingredient.ofItems(Items.STONE));
            recipe.add(Ingredient.ofItems(Items.STONE));
            recipe.add(Ingredient.ofItems(Items.QUARTZ));
            recipe.add(Ingredient.ofItems(Items.STONE));
            recipe.add(Ingredient.ofItems(Items.STONE));
            recipe.add(Ingredient.ofItems(Items.STONE));
            recipe.add(Ingredient.ofItems(Items.STONE));

            Item.RECIPES.add(() -> new ShapedRecipe(new Identifier(MOD_ID, "shaped-laboratory"),
                "Builders' Blocks", 3,
                3, recipe, new ItemStack(laboratoryBlock)));

            FAMILIES.add(new GenericFamilyRegistry(laboratoryFamilyName, laboratoryBlock)
                .with(Arrays.asList("clearscreen", "directionleft-top", "directionright-top", "dottedpanel-top",
                    "floortile", "fuzzscreen", "infocon-top", "largewall", "roundel", "smallsteel-side",
                    "smallsteel-top", "smalltile", "wallpanel-top", "wallvents-top")));
        }
        // new
        // SimpleFamilyRegistry("lapis",);
        // families.add(new SimpleFamilyRegistry("limestone",
        // Blocks.STONE);

        if (configuration.magma)
            FAMILIES.add(new SimpleFamilyRegistry("magma", Blocks.MAGMA_BLOCK));
        // families.add(new SimpleFamilyRegistry("marble",
        // Blocks.QUARTZ_BLOCK);
        // new
        // SimpleFamilyRegistry("marblepillar",);
        // new
        // SimpleFamilyRegistry("marblepillarslab",);
        // new
        // SimpleFamilyRegistry("marbleslab",);
        // new
        // SimpleFamilyRegistry("metals",);
        // new
        // SimpleFamilyRegistry("netherbrick",);
        // new
        // SimpleFamilyRegistry("netherrack",);
        // new
        // SimpleFamilyRegistry("obsidian",);
        // new
        // SimpleFamilyRegistry("paper",);

        if (configuration.planks)
        {
            FAMILIES.add(new PlanksFamilyRegistry("planks-acacia", Blocks.ACACIA_PLANKS));
            FAMILIES.add(new PlanksFamilyRegistry("planks-birch", Blocks.BIRCH_PLANKS));
            FAMILIES.add(new PlanksFamilyRegistry("planks-dark-oak", Blocks.DARK_OAK_PLANKS));
            FAMILIES.add(new PlanksFamilyRegistry("planks-jungle", Blocks.JUNGLE_PLANKS));
            FAMILIES.add(new PlanksFamilyRegistry("planks-oak", Blocks.OAK_PLANKS));
            FAMILIES.add(new PlanksFamilyRegistry("planks-spruce", Blocks.SPRUCE_PLANKS));
        }

        // families.add(new SimpleFamilyRegistry("primarineanim",
        // Blocks.PRISMARINE);

        if (configuration.purpur)
            FAMILIES.add(new SimpleFamilyRegistry("purpur", Blocks.PURPUR_BLOCK));

        if (configuration.quartz)
            FAMILIES.add(new SimpleFamilyRegistry("quartz", Blocks.QUARTZ_BLOCK));

        if (configuration.redstone)
            FAMILIES.add(new SimpleFamilyRegistry("redstone", Blocks.REDSTONE_BLOCK).without("raw").without("weaver"));

        // if (configuration.redstonelamp)
        // families.add(new GenericFamilyRegistry("redstonelamp",
        // Blocks.REDSTONE_LAMP).with("square-off");

        if (configuration.sandstone)
        {
            // new
            // SimpleFamilyRegistry("sandstone-scribbles",);
            FAMILIES.add(new SimpleFamilyRegistry("sandstonered", Blocks.RED_SANDSTONE));
            // new
            // SimpleFamilyRegistry("sandstonered-scribbles",);
            FAMILIES.add(new SimpleFamilyRegistry("sandstoneyellow", Blocks.SANDSTONE));
        }

        if (configuration.stone)
            FAMILIES.add(new SimpleFamilyRegistry("stone", Blocks.STONE));
        // new
        // SimpleFamilyRegistry("technical",);
        // new
        // SimpleFamilyRegistry("temple",);
        // new
        // SimpleFamilyRegistry("templemossy",);
        // new
        // SimpleFamilyRegistry("tyrian",);
        // new
        // SimpleFamilyRegistry("valentines",);
        // new
        // SimpleFamilyRegistry("voidstone",);
        // new
        // SimpleFamilyRegistry("wool",);
    }
}
