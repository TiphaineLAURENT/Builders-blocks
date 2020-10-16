package net.tiphainelaurent.buildersblocks;

import java.util.Arrays;
import java.util.List;

import com.mojang.brigadier.Command;
import com.swordglowsblue.artifice.api.Artifice;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;

import net.tiphainelaurent.buildersblocks.api.familyregistry.GenericFamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.familyregistry.PlanksFamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.familyregistry.SimpleFamilyRegistry;

public class BuildersBlocksClient implements ClientModInitializer
{
	@Override
	public void onInitializeClient()
	{
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			if (!dedicated)
			{
				dispatcher.register(CommandManager.literal("mine").executes(context -> {
					final MinecraftClient client = MinecraftClient.getInstance();
					if (client.crosshairTarget.getType() == HitResult.Type.BLOCK)
					{
						final BlockHitResult target = (BlockHitResult)client.crosshairTarget;
						final ServerWorld world = context.getSource().getWorld();
						final BlockEntity blockEntity = world.getBlockEntity(target.getBlockPos());
						final BlockState blockState = world.getBlockState(target.getBlockPos());
						final List<ItemStack> stacks = Block.getDroppedStacks(blockState, world, target.getBlockPos(),
							blockEntity);

						final ServerPlayerEntity player = context.getSource().getPlayer();
						for (final ItemStack stack : stacks)
							player.giveItemStack(stack);
					}
					return Command.SINGLE_SUCCESS;
				}));
			}
		});

		Artifice.registerAssets(new Identifier(BuildersBlocks.MOD_ID, "resourcepack"), pack -> {
			pack.setDisplayName("Builders' Blocks resources");
			pack.setDescription("Resources for the Builders' Blocks mod");

			// new SimpleFamilyRegistry("ancient_stone",
			// Blocks.STONE).registerAll(ITEM_GROUP);
			if (BuildersBlocks.configuration.andesite)
				new SimpleFamilyRegistry("andesite", Blocks.ANDESITE).registerAll(BuildersBlocks.ITEM_GROUP, pack);

			if (BuildersBlocks.configuration.antiblock)
				new GenericFamilyRegistry("antiblock", Blocks.GLOWSTONE).with(Arrays.asList(
					"black", "blue", "brown", "cyan", "gray", "green", "light_blue", "lime",
					"magenta", "orange", "pink", "purple", "red", "silver", "white", "yellow"))
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);
			// new SimpleFamilyRegistry("arcane_stone",
			// Blocks.STONE).registerAll(ITEM_GROUP);
			if (BuildersBlocks.configuration.basalt)
				new SimpleFamilyRegistry("basalt", Blocks.BASALT).registerAll(BuildersBlocks.ITEM_GROUP, pack);

			// new SimpleFamilyRegistry("blood_magic",).registerAll(ITEM_GROUP);
			// if (configuration.bookshelf)
			// new GenericFamilyRegistry("bookshelf",
			// Blocks.BOOKSHELF).with(Arrays.asList("abandoned", "brim", "cans",
			// "historician", "hoarder", "necromancer-novice", "necromancer",
			// "papers", "rainbow", "redtomes"))
			// .registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.bricks)
				new SimpleFamilyRegistry("bricks", Blocks.BRICKS).registerAll(BuildersBlocks.ITEM_GROUP, pack);

			if (BuildersBlocks.configuration.certus)
				new SimpleFamilyRegistry("certus", Blocks.QUARTZ_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP, pack);
			// new SimpleFamilyRegistry("cloud",).registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.charcoal)
				new SimpleFamilyRegistry("coal/charcoal", Blocks.COAL_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);

			if (BuildersBlocks.configuration.coal)
				new SimpleFamilyRegistry("coal/coal", Blocks.COAL_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP, pack);
			// new SimpleFamilyRegistry("coal/coalcoke",
			// Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.cobblestone)
				new SimpleFamilyRegistry("cobblestone", Blocks.COBBLESTONE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);

			if (BuildersBlocks.configuration.concrete)
			{
				new GenericFamilyRegistry("concrete", Blocks.STONE).with(Arrays.asList(
					"block", "blocks", "default", "doubleslab-side", "weathered-block-half-side",
					"weathered-block", "weathered-blocks", "weathered-doubleslab-side", "weathered-half-side",
					"weathered")).registerAll(BuildersBlocks.ITEM_GROUP, pack);
				new SimpleFamilyRegistry("concrete_black", Blocks.BLACK_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_blue", Blocks.BLUE_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_brown", Blocks.BROWN_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_cyan", Blocks.CYAN_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_gray", Blocks.GRAY_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_green", Blocks.GREEN_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_lightblue", Blocks.LIGHT_BLUE_CONCRETE).registerAll(
					BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_lightgray", Blocks.LIGHT_GRAY_CONCRETE).registerAll(
					BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_lime", Blocks.LIME_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_magenta", Blocks.MAGENTA_CONCRETE)
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);
				new SimpleFamilyRegistry("concrete_orange", Blocks.ORANGE_CONCRETE)
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);
				new SimpleFamilyRegistry("concrete_pink", Blocks.PINK_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				// new SimpleFamilyRegistry("concrete_powder",
				// Blocks.WHITE_CONCRETE_POWDER).registerAll(ITEM_GROUP);
				new SimpleFamilyRegistry("concrete_purple", Blocks.PURPLE_CONCRETE)
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);
				new SimpleFamilyRegistry("concrete_red", Blocks.RED_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_white", Blocks.WHITE_CONCRETE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new SimpleFamilyRegistry("concrete_yellow", Blocks.YELLOW_CONCRETE)
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);
			}

			if (BuildersBlocks.configuration.diamond)
				new GenericFamilyRegistry("diamond", Blocks.DIAMOND_BLOCK)
					.with(Arrays.asList("terrain-diamond-bismuth", "terrain-diamond-cells", "terrain-diamond-crushed",
						"terrain-diamond-embossed-bottom", "terrain-diamond-embossed-side",
						"terrain-diamond-embossed-top", "terrain-diamond-four", "terrain-diamond-fourornate",
						"terrain-diamond-gem-bottom", "terrain-diamond-gem-side", "terrain-diamond-gem-top",
						"terrain-diamond-ornatelayer", "terrain-diamond-simple-bottom", "terrain-diamond-simple-side",
						"terrain-diamond-simple-top", "terrain-diamond-spaceblack", "terrain-diamond-zelda"))
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);

			if (BuildersBlocks.configuration.diorite)
				new SimpleFamilyRegistry("diorite", Blocks.DIORITE).registerAll(BuildersBlocks.ITEM_GROUP, pack);
			// new SimpleFamilyRegistry("dirt",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("emerald",).registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.endstone)
				new SimpleFamilyRegistry("endstone", Blocks.END_STONE).registerAll(BuildersBlocks.ITEM_GROUP, pack);
			// new SimpleFamilyRegistry("factory",).registerAll(ITEM_GROUP);

			// new SimpleFamilyRegistry("fluid",
			// Blocks.STONE).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("futura",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("glass",).registerAll(ITEM_GROUP);
			// new
			// SimpleFamilyRegistry("glass_stained",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("glassdyed",).registerAll(ITEM_GROUP);
			// new
			// SimpleFamilyRegistry("glasspaneddyed",).registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.glowstone)
				new SimpleFamilyRegistry("glowstone", Blocks.GLOWSTONE).without("raw").without("weaver")
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);
			// new SimpleFamilyRegistry("gold",).registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.granite)
				new SimpleFamilyRegistry("granite", Blocks.GRANITE).registerAll(BuildersBlocks.ITEM_GROUP, pack);

			if (BuildersBlocks.configuration.hardenedclay)
				new SimpleFamilyRegistry("hardenedclay", Blocks.TERRACOTTA).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);

			if (BuildersBlocks.configuration.ice)
				new SimpleFamilyRegistry("ice", Blocks.ICE).registerAll(BuildersBlocks.ITEM_GROUP, pack);
			// new SimpleFamilyRegistry("icepillar",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("iron",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("ironpane",).registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.laboratory)
			{
				final String laboratoryFamilyName = "laboratory";
				final String laboratoryBlockName = String.format("%s_checkertile", laboratoryFamilyName);
				final Identifier laboratoryBlockId = new Identifier(BuildersBlocks.MOD_ID, laboratoryBlockName);
				Block laboratoryBlock = net.tiphainelaurent.buildersblocks.api.helpers.Block.builder(Blocks.IRON_BLOCK)
					.asItem(BuildersBlocks.ITEM_GROUP).mineable().build(laboratoryBlockId);

				final Identifier blockModelId = new Identifier(BuildersBlocks.MOD_ID, "block/" + laboratoryBlockName);
				pack.addBlockState(laboratoryBlockId,
					state -> state.variant("", variant -> variant.model(blockModelId)));
				pack.addBlockModel(laboratoryBlockId,
					model -> model.parent(new Identifier("block/cube_all")).texture("all",
						new Identifier(BuildersBlocks.MOD_ID, String.format("block/%s/%s", laboratoryFamilyName,
							laboratoryBlockName.substring(laboratoryBlockName.lastIndexOf("_") + 1)))));
				pack.addItemModel(laboratoryBlockId, model -> model.parent(blockModelId));

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

				net.tiphainelaurent.buildersblocks.api.helpers.Item.RECIPES
					.add(new ShapedRecipe(new Identifier(BuildersBlocks.MOD_ID, "shaped-laboratory"),
						"Builders' Blocks", 3, 3,
						recipe, new ItemStack(laboratoryBlock)));

				new GenericFamilyRegistry(laboratoryFamilyName, laboratoryBlock)
					.with(Arrays.asList("clearscreen", "directionleft-top", "directionright-top", "dottedpanel-top",
						"floortile", "fuzzscreen", "infocon-top", "largewall", "roundel", "smallsteel-side",
						"smallsteel-top", "smalltile", "wallpanel-top", "wallvents-top"))
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);
			}
			// new SimpleFamilyRegistry("lapis",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("limestone",
			// Blocks.STONE).registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.magma)
				new SimpleFamilyRegistry("magma", Blocks.MAGMA_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP, pack);
			// new SimpleFamilyRegistry("marble",
			// Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);
			// new
			// SimpleFamilyRegistry("marblepillar",).registerAll(ITEM_GROUP);
			// new
			// SimpleFamilyRegistry("marblepillarslab",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("marbleslab",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("metals",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("netherbrick",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("netherrack",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("obsidian",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("paper",).registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.planks)
			{
				new PlanksFamilyRegistry("planks-acacia", Blocks.ACACIA_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new PlanksFamilyRegistry("planks-birch", Blocks.BIRCH_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new PlanksFamilyRegistry("planks-dark-oak", Blocks.DARK_OAK_PLANKS)
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);
				new PlanksFamilyRegistry("planks-jungle", Blocks.JUNGLE_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				new PlanksFamilyRegistry("planks-oak", Blocks.OAK_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP, pack);
				new PlanksFamilyRegistry("planks-spruce", Blocks.SPRUCE_PLANKS).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
			}

			// new SimpleFamilyRegistry("primarineanim",
			// Blocks.PRISMARINE).registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.purpur)
				new SimpleFamilyRegistry("purpur", Blocks.PURPUR_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP, pack);

			if (BuildersBlocks.configuration.quartz)
				new SimpleFamilyRegistry("quartz", Blocks.QUARTZ_BLOCK).registerAll(BuildersBlocks.ITEM_GROUP, pack);

			if (BuildersBlocks.configuration.redstone)
				new SimpleFamilyRegistry("redstone", Blocks.REDSTONE_BLOCK).without("raw").without("weaver")
					.registerAll(BuildersBlocks.ITEM_GROUP, pack);

			// if (configuration.redstonelamp)
			// new GenericFamilyRegistry("redstonelamp",
			// Blocks.REDSTONE_LAMP).with("square-off").registerAll(ITEM_GROUP);

			if (BuildersBlocks.configuration.sandstone)
			{
				// new
				// SimpleFamilyRegistry("sandstone-scribbles",).registerAll(ITEM_GROUP);
				new SimpleFamilyRegistry("sandstonered", Blocks.RED_SANDSTONE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
				// new
				// SimpleFamilyRegistry("sandstonered-scribbles",).registerAll(ITEM_GROUP);
				new SimpleFamilyRegistry("sandstoneyellow", Blocks.SANDSTONE).registerAll(BuildersBlocks.ITEM_GROUP,
					pack);
			}

			if (BuildersBlocks.configuration.stone)
				new SimpleFamilyRegistry("stone", Blocks.STONE).registerAll(BuildersBlocks.ITEM_GROUP, pack);
			// new SimpleFamilyRegistry("technical",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("temple",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("templemossy",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("tyrian",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("valentines",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("voidstone",).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("wool",).registerAll(ITEM_GROUP);

		});
	}
}
