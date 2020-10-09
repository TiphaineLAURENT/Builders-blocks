package net.tiphainelaurent.buildersblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.tiphainelaurent.buildersblocks.api.familyregistry.PlanksFamilyRegistry;
import net.tiphainelaurent.buildersblocks.api.familyregistry.SimpleFamilyRegistry;
import net.tiphainelaurent.buildersblocks.blocks.antiblock.AntiBlockFamily;
import net.tiphainelaurent.buildersblocks.config.Configuration;

public class BuildersBlocks implements ModInitializer {
	public static final String MOD_ID = "buildersblocks";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "general"))
			.icon(() -> new ItemStack(Items.STONECUTTER)).build();
	public static final Logger LOGGER = LogManager.getLogger();
	public static Configuration configuration;

	public static final Block EXAMPLE_BLOCK = net.tiphainelaurent.buildersblocks.api.helpers.Block
			.builder(Blocks.ANDESITE).mineable().build(MOD_ID, "example");
	public static final Item EXAMPLE_ITEM = net.tiphainelaurent.buildersblocks.api.helpers.Item.builder()
			.fromBlock(EXAMPLE_BLOCK).group(ITEM_GROUP).build(MOD_ID, "example");

	@Override
	public void onInitialize() {
		configuration = AutoConfig.register(Configuration.class, Toml4jConfigSerializer::new).getConfig();

		// new SimpleFamilyRegistry("ancient_stone",
		// Blocks.STONE).registerAll(ITEM_GROUP);
		if (configuration.andesite)
			new SimpleFamilyRegistry("andesite", Blocks.ANDESITE).registerAll(ITEM_GROUP);

		if (configuration.antiblock)
			new AntiBlockFamily().registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("arcane_stone",
		// Blocks.STONE).registerAll(ITEM_GROUP);
		if (configuration.basalt)
			new SimpleFamilyRegistry("basalt", Blocks.BASALT).registerAll(ITEM_GROUP);

		// new SimpleFamilyRegistry("blood_magic",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("bookshelf",).registerAll(ITEM_GROUP);

		if (configuration.bricks)
			new SimpleFamilyRegistry("bricks", Blocks.BRICKS).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("certus",
		// Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("cloud",).registerAll(ITEM_GROUP);

		if (configuration.charcoal)
			new SimpleFamilyRegistry("coal/charcoal", Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.coal)
			new SimpleFamilyRegistry("coal/coal", Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("coal/coalcoke",
		// Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.cobblestone)
			new SimpleFamilyRegistry("cobblestone", Blocks.COBBLESTONE).registerAll(ITEM_GROUP);

		if (configuration.concrete) {
			// new SimpleFamilyRegistry("concrete",).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_black", Blocks.BLACK_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_blue", Blocks.BLUE_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_brown", Blocks.BROWN_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_cyan", Blocks.CYAN_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_gray", Blocks.GRAY_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_green", Blocks.GREEN_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_lightblue", Blocks.LIGHT_BLUE_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_lightgray", Blocks.LIGHT_GRAY_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_lime", Blocks.LIME_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_magenta", Blocks.MAGENTA_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_orange", Blocks.ORANGE_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_pink", Blocks.PINK_CONCRETE).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("concrete_powder",
			// Blocks.WHITE_CONCRETE_POWDER).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_purple", Blocks.PURPLE_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_red", Blocks.RED_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_white", Blocks.WHITE_CONCRETE).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("concrete_yellow", Blocks.YELLOW_CONCRETE).registerAll(ITEM_GROUP);
		}
		// new SimpleFamilyRegistry("diamond",).registerAll(ITEM_GROUP);

		if (configuration.diorite)
			new SimpleFamilyRegistry("diorite", Blocks.DIORITE).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("dirt",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("emerald",).registerAll(ITEM_GROUP);

		if (configuration.endstone)
			new SimpleFamilyRegistry("endstone", Blocks.END_STONE).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("factory",).registerAll(ITEM_GROUP);

		// new SimpleFamilyRegistry("fluid", Blocks.STONE).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("futura",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("glass",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("glass_stained",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("glassdyed",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("glasspaneddyed",).registerAll(ITEM_GROUP);

		if (configuration.glowstone)
			new SimpleFamilyRegistry("glowstone", Blocks.GLOWSTONE).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("gold",).registerAll(ITEM_GROUP);

		if (configuration.granite)
			new SimpleFamilyRegistry("granite", Blocks.GRANITE).registerAll(ITEM_GROUP);

		if (configuration.hardenedclay)
			new SimpleFamilyRegistry("hardenedclay", Blocks.TERRACOTTA).registerAll(ITEM_GROUP);

		if (configuration.ice)
			new SimpleFamilyRegistry("ice", Blocks.ICE).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("icepillar",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("iron",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("ironpane",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("laboratory",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("lapis",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("limestone", Blocks.STONE).registerAll(ITEM_GROUP);

		if (configuration.magma)
			new SimpleFamilyRegistry("magma", Blocks.MAGMA_BLOCK).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("marble",
		// Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("marblepillar",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("parblepillarslab",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("marbleslab",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("metals",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("netherbrick",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("netherrack",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("obsidian",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("paper",).registerAll(ITEM_GROUP);

		if (configuration.planks) {
			new PlanksFamilyRegistry("planks-acacia", Blocks.ACACIA_PLANKS).registerAll(ITEM_GROUP);
			new PlanksFamilyRegistry("planks-birch", Blocks.BIRCH_PLANKS).registerAll(ITEM_GROUP);
			new PlanksFamilyRegistry("planks-dark-oak", Blocks.DARK_OAK_PLANKS).registerAll(ITEM_GROUP);
			new PlanksFamilyRegistry("planks-jungle", Blocks.JUNGLE_PLANKS).registerAll(ITEM_GROUP);
			new PlanksFamilyRegistry("planks-oak", Blocks.OAK_PLANKS).registerAll(ITEM_GROUP);
			new PlanksFamilyRegistry("planks-spruce", Blocks.SPRUCE_PLANKS).registerAll(ITEM_GROUP);
		}

		// new SimpleFamilyRegistry("primarineanim",
		// Blocks.PRISMARINE).registerAll(ITEM_GROUP);

		if (configuration.purpur)
			new SimpleFamilyRegistry("purpur", Blocks.PURPUR_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.quartz)
			new SimpleFamilyRegistry("quartz", Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.redstone)
			new SimpleFamilyRegistry("redstone", Blocks.REDSTONE_BLOCK).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("redstonelamp",).registerAll(ITEM_GROUP);

		if (configuration.sandstone) {
			// new SimpleFamilyRegistry("sandstone-scribbles",).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("sandstonered", Blocks.RED_SANDSTONE).registerAll(ITEM_GROUP);
			// new SimpleFamilyRegistry("sandstonered-scribbles",).registerAll(ITEM_GROUP);
			new SimpleFamilyRegistry("sandstoneyellow", Blocks.SANDSTONE).registerAll(ITEM_GROUP);
		}

		if (configuration.stone)
			new SimpleFamilyRegistry("stone", Blocks.STONE).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("technical",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("temple",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("templemossy",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("tyrian",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("valentines",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("voidstone",).registerAll(ITEM_GROUP);
		// new SimpleFamilyRegistry("wool",).registerAll(ITEM_GROUP);
	}
}
