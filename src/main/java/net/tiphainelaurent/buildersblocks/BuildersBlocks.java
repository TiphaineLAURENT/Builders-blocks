package net.tiphainelaurent.buildersblocks;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.tiphainelaurent.buildersblocks.api.familyregistry.GenericFamilyRegistry;
import net.tiphainelaurent.buildersblocks.blocks.andesite.AndesiteFamily;
import net.tiphainelaurent.buildersblocks.blocks.antiblock.AntiBlockFamily;
import net.tiphainelaurent.buildersblocks.config.Configuration;

public class BuildersBlocks implements ModInitializer {
	public static final String MOD_ID = "buildersblocks";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "general"))
			.icon(() -> new ItemStack(Items.STONECUTTER)).build();
	public static final Logger LOGGER = LogManager.getLogger();
	public static Configuration configuration;

	// public static final Block EXAMPLE_BLOCK =
	// net.tiphainelaurent.buildersblocks.api.helpers.Block.builder(Blocks.ANDESITE)
	// .mineable()
	// .build(MOD_ID, "example");

	@Override
	public void onInitialize() {
		// net.tiphainelaurent.buildersblocks.api.helpers.Item.builder()
		// .fromBlock(EXAMPLE_BLOCK)
		// .group(ITEM_GROUP)
		// .build(MOD_ID, "example");
		configuration = AutoConfig.register(Configuration.class, Toml4jConfigSerializer::new).getConfig();

		// new GenericFamilyRegistry("ancient_stone",
		// Blocks.STONE).registerAll(ITEM_GROUP);
		if (configuration.andesite)
			new AndesiteFamily().registerAll(ITEM_GROUP);

		if (configuration.antiblock)
			new AntiBlockFamily().registerAll(ITEM_GROUP);
		// new GenericFamilyRegistry("arcane_stone",
		// Blocks.STONE).registerAll(ITEM_GROUP);
		if (configuration.basalt)
			new GenericFamilyRegistry("basalt", Blocks.BASALT).registerAll(ITEM_GROUP);

		if (configuration.bricks)
			new GenericFamilyRegistry("bricks", Blocks.BRICKS).registerAll(ITEM_GROUP);
		// new GenericFamilyRegistry("certus",
		// Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.charcoal)
			new GenericFamilyRegistry("coal/charcoal", Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.coal)
			new GenericFamilyRegistry("coal/coal", Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);
		// new GenericFamilyRegistry("coal/coalcoke",
		// Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.cobblestone)
			new GenericFamilyRegistry("cobblestone", Blocks.COBBLESTONE).registerAll(ITEM_GROUP);

		if (configuration.concrete) {
			new GenericFamilyRegistry("concrete_black", Blocks.BLACK_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_blue", Blocks.BLUE_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_brown", Blocks.BROWN_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_cyan", Blocks.CYAN_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_gray", Blocks.GRAY_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_green", Blocks.GREEN_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_lightblue", Blocks.LIGHT_BLUE_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_lightgray", Blocks.LIGHT_GRAY_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_lime", Blocks.LIME_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_magenta", Blocks.MAGENTA_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_orange", Blocks.ORANGE_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_pink", Blocks.PINK_CONCRETE).registerAll(ITEM_GROUP);
			// new GenericFamilyRegistry("concrete_powder",
			// Blocks.WHITE_CONCRETE_POWDER).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_purple", Blocks.PURPLE_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_red", Blocks.RED_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_white", Blocks.WHITE_CONCRETE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("concrete_yellow", Blocks.YELLOW_CONCRETE).registerAll(ITEM_GROUP);
		}

		if (configuration.diorite)
			new GenericFamilyRegistry("diorite", Blocks.DIORITE).registerAll(ITEM_GROUP);

		if (configuration.endstone)
			new GenericFamilyRegistry("endstone", Blocks.END_STONE).registerAll(ITEM_GROUP);

		// new GenericFamilyRegistry("fluid", Blocks.STONE).registerAll(ITEM_GROUP);

		if (configuration.glowstone)
			new GenericFamilyRegistry("glowstone", Blocks.GLOWSTONE).registerAll(ITEM_GROUP);

		if (configuration.granite)
			new GenericFamilyRegistry("granite", Blocks.GRANITE).registerAll(ITEM_GROUP);

		if (configuration.hardenedclay)
			new GenericFamilyRegistry("hardenedclay", Blocks.TERRACOTTA).registerAll(ITEM_GROUP);

		if (configuration.ice)
			new GenericFamilyRegistry("ice", Blocks.ICE).registerAll(ITEM_GROUP);

		// new GenericFamilyRegistry("limestone", Blocks.STONE).registerAll(ITEM_GROUP);
		// new GenericFamilyRegistry("marble",
		// Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.magma)
			new GenericFamilyRegistry("magma", Blocks.MAGMA_BLOCK).registerAll(ITEM_GROUP);

		// new GenericFamilyRegistry("primarineanim",
		// Blocks.PRISMARINE).registerAll(ITEM_GROUP);

		if (configuration.purpur)
			new GenericFamilyRegistry("purpur", Blocks.PURPUR_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.quartz)
			new GenericFamilyRegistry("quartz", Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.redstone)
			new GenericFamilyRegistry("redstone", Blocks.REDSTONE_BLOCK).registerAll(ITEM_GROUP);

		if (configuration.sandstone) {
			new GenericFamilyRegistry("sandstonered", Blocks.RED_SANDSTONE).registerAll(ITEM_GROUP);
			new GenericFamilyRegistry("sandstoneyellow", Blocks.SANDSTONE).registerAll(ITEM_GROUP);
		}

		if (configuration.stone)
			new GenericFamilyRegistry("stone", Blocks.STONE).registerAll(ITEM_GROUP);

	}
}
