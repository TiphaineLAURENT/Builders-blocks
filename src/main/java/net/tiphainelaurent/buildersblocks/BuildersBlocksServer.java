package net.tiphainelaurent.buildersblocks;

import java.util.Arrays;

import net.fabricmc.api.DedicatedServerModInitializer;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import net.tiphainelaurent.buildersblocks.api.familyregistry.GenericFamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.familyregistry.PlanksFamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.familyregistry.SimpleFamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.helpers.Item;

public class BuildersBlocksServer implements DedicatedServerModInitializer
{
	@Override
	public void onInitializeServer()
	{
		// new SimpleFamilyRegistry("ancient_stone",
		// Blocks.STONE).registerAll(BuildersBlocks.ITEM_GROUP);
		if (BuildersBlocks.configuration.andesite)
			new SimpleFamilyRegistry("andesite", Blocks.ANDESITE).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.antiblock)
			new GenericFamilyRegistry("antiblock", Blocks.GLOWSTONE).with(Arrays.asList(
				"black", "blue", "brown", "cyan", "gray", "green", "light_blue", "lime",
				"magenta", "orange", "pink", "purple", "red", "silver", "white", "yellow"))
				.registerAll(BuildersBlocks.ITEM_GROUP);
		// new SimpleFamilyRegistry("arcane_stone",
		// Blocks.STONE).registerAll(BuildersBlocks.ITEM_GROUP);
		if (BuildersBlocks.configuration.basalt)
			new SimpleFamilyRegistry("basalt", Blocks.BASALT).registerAll(BuildersBlocks.ITEM_GROUP);

		// new
		// SimpleFamilyRegistry("blood_magic",).registerAll(BuildersBlocks.ITEM_GROUP);
		// if (BuildersBlocks.configuration.bookshelf)
		// new GenericFamilyRegistry("bookshelf",
		// Blocks.BOOKSHELF).with(Arrays.asList("abandoned", "brim", "cans",
		// "historician", "hoarder", "necromancer-novice", "necromancer",
		// "papers", "rainbow", "redtomes"))
		// .registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.bricks)
			new SimpleFamilyRegistry("bricks", Blocks.BRICKS).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.certus)
			new SimpleFamilyRegistry("certus", Blocks.QUARTZ_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("cloud",).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.charcoal)
			new SimpleFamilyRegistry("coal/charcoal", Blocks.COAL_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.coal)
			new SimpleFamilyRegistry("coal/coal", Blocks.COAL_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP);
		// new SimpleFamilyRegistry("coal/coalcoke",
		// Blocks.COAL_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.cobblestone)
			new SimpleFamilyRegistry("cobblestone", Blocks.COBBLESTONE).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.concrete)
		{
			new GenericFamilyRegistry("concrete", Blocks.STONE).with(Arrays.asList(
				"block", "blocks", "default", "doubleslab-side", "weathered-block-half-side",
				"weathered-block", "weathered-blocks", "weathered-doubleslab-side", "weathered-half-side",
				"weathered")).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_black", Blocks.BLACK_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_blue", Blocks.BLUE_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_brown", Blocks.BROWN_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_cyan", Blocks.CYAN_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_gray", Blocks.GRAY_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_green", Blocks.GREEN_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_lightblue", Blocks.LIGHT_BLUE_CONCRETE)
				.registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_lightgray", Blocks.LIGHT_GRAY_CONCRETE)
				.registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_lime", Blocks.LIME_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_magenta", Blocks.MAGENTA_CONCRETE)
				.registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_orange", Blocks.ORANGE_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_pink", Blocks.PINK_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			// new SimpleFamilyRegistry("concrete_powder",
			// Blocks.WHITE_CONCRETE_POWDER).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_purple", Blocks.PURPLE_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_red", Blocks.RED_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_white", Blocks.WHITE_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_yellow", Blocks.YELLOW_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP);
		}

		if (BuildersBlocks.configuration.diamond)
			new GenericFamilyRegistry("diamond", Blocks.DIAMOND_BLOCK)
				.with(Arrays.asList("terrain-diamond-bismuth", "terrain-diamond-cells", "terrain-diamond-crushed",
					"terrain-diamond-embossed-bottom", "terrain-diamond-embossed-side",
					"terrain-diamond-embossed-top", "terrain-diamond-four", "terrain-diamond-fourornate",
					"terrain-diamond-gem-bottom", "terrain-diamond-gem-side", "terrain-diamond-gem-top",
					"terrain-diamond-ornatelayer", "terrain-diamond-simple-bottom", "terrain-diamond-simple-side",
					"terrain-diamond-simple-top", "terrain-diamond-spaceblack", "terrain-diamond-zelda"))
				.registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.diorite)
			new SimpleFamilyRegistry("diorite", Blocks.DIORITE).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("dirt",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("emerald",).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.endstone)
			new SimpleFamilyRegistry("endstone", Blocks.END_STONE).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("factory",).registerAll(BuildersBlocks.ITEM_GROUP);

		// new SimpleFamilyRegistry("fluid",
		// Blocks.STONE).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("futura",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("glass",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("glass_stained",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("glassdyed",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("glasspaneddyed",).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.glowstone)
			new SimpleFamilyRegistry("glowstone", Blocks.GLOWSTONE).without("raw").without("weaver")
				.registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("gold",).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.granite)
			new SimpleFamilyRegistry("granite", Blocks.GRANITE).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.hardenedclay)
			new SimpleFamilyRegistry("hardenedclay", Blocks.TERRACOTTA).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.ice)
			new SimpleFamilyRegistry("ice", Blocks.ICE).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("icepillar",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("iron",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("ironpane",).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.laboratory)
		{
			final String laboratoryFamilyName = "laboratory";
			final String laboratoryBlockName = String.format("%s_checkertile", laboratoryFamilyName);
			final Identifier laboratoryBlockId = new Identifier(BuildersBlocks.MOD_ID, laboratoryBlockName);
			Block laboratoryBlock = net.tiphainelaurent.buildersblocks.api.helpers.Block.builder(Blocks.IRON_BLOCK)
				.asItem(BuildersBlocks.ITEM_GROUP).mineable().build(laboratoryBlockId);

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

			Item.RECIPES.add(() -> new ShapedRecipe(new Identifier(BuildersBlocks.MOD_ID, "shaped-laboratory"), "Builders' Blocks", 3,
					3, recipe, new ItemStack(laboratoryBlock)));

			new GenericFamilyRegistry(laboratoryFamilyName, laboratoryBlock)
				.with(Arrays.asList("clearscreen", "directionleft-top", "directionright-top", "dottedpanel-top",
					"floortile", "fuzzscreen", "infocon-top", "largewall", "roundel", "smallsteel-side",
					"smallsteel-top", "smalltile", "wallpanel-top", "wallvents-top"))
				.registerAll(BuildersBlocks.ITEM_GROUP);
		}
		// new
		// SimpleFamilyRegistry("lapis",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new SimpleFamilyRegistry("limestone",
		// Blocks.STONE).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.magma)
			new SimpleFamilyRegistry("magma", Blocks.MAGMA_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP);
		// new SimpleFamilyRegistry("marble",
		// Blocks.QUARTZ_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("marblepillar",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("marblepillarslab",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("marbleslab",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("metals",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("netherbrick",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("netherrack",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("obsidian",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("paper",).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.planks)
		{
			new PlanksFamilyRegistry("planks-acacia", Blocks.ACACIA_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP);
			new PlanksFamilyRegistry("planks-birch", Blocks.BIRCH_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP);
			new PlanksFamilyRegistry("planks-dark-oak", Blocks.DARK_OAK_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP);
			new PlanksFamilyRegistry("planks-jungle", Blocks.JUNGLE_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP);
			new PlanksFamilyRegistry("planks-oak", Blocks.OAK_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP);
			new PlanksFamilyRegistry("planks-spruce", Blocks.SPRUCE_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP);
		}

		// new SimpleFamilyRegistry("primarineanim",
		// Blocks.PRISMARINE).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.purpur)
			new SimpleFamilyRegistry("purpur", Blocks.PURPUR_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.quartz)
			new SimpleFamilyRegistry("quartz", Blocks.QUARTZ_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.redstone)
			new SimpleFamilyRegistry("redstone", Blocks.REDSTONE_BLOCK).without("raw").without("weaver")
				.registerAll(BuildersBlocks.ITEM_GROUP);

		// if (BuildersBlocks.configuration.redstonelamp)
		// new GenericFamilyRegistry("redstonelamp",
		// Blocks.REDSTONE_LAMP).with("square-off").registerAll(BuildersBlocks.ITEM_GROUP);

		if (BuildersBlocks.configuration.sandstone)
		{
			// new
			// SimpleFamilyRegistry("sandstone-scribbles",).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("sandstonered", Blocks.RED_SANDSTONE).registerAll(BuildersBlocks.ITEM_GROUP);
			// new
			// SimpleFamilyRegistry("sandstonered-scribbles",).registerAll(BuildersBlocks.ITEM_GROUP);
			new SimpleFamilyRegistry("sandstoneyellow", Blocks.SANDSTONE).registerAll(BuildersBlocks.ITEM_GROUP);
		}

		if (BuildersBlocks.configuration.stone)
			new SimpleFamilyRegistry("stone", Blocks.STONE).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("technical",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("temple",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("templemossy",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("tyrian",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("valentines",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("voidstone",).registerAll(BuildersBlocks.ITEM_GROUP);
		// new
		// SimpleFamilyRegistry("wool",).registerAll(BuildersBlocks.ITEM_GROUP);
	}
}
