package net.tiphainelaurent.buildersblocks;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

public class BuildersBlocks implements ModInitializer
{
	public static final String MOD_ID = "buildersblocks";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "general"))
 																	 .icon(() -> new ItemStack(Items.STONECUTTER))
																	 .build();

	public static Path MAIN_DIRECTORY;
	public static final Logger LOGGER = LogManager.getLogger();
	public static boolean DEBUG = FabricLoader.getInstance().isDevelopmentEnvironment();

	public static final Block EXAMPLE_BLOCK = net.tiphainelaurent.buildersblocks.api.helpers.Block.builder(Blocks.ANDESITE)
																								   .mineable()
																								   .build(MOD_ID, "example");

	@Override
	public void onInitialize()
	{
		net.tiphainelaurent.buildersblocks.api.helpers.Item.builder()
															.fromBlock(EXAMPLE_BLOCK)
															.group(ITEM_GROUP)
															.build(MOD_ID, "example");

		try {
			MAIN_DIRECTORY = Paths.get(BuildersBlocks.class.getClassLoader().getResource("").toURI());
		} catch (Exception e) {
			LOGGER.error(e);
		}
		// new GenericFamilyRegistry("ancient_stone", Blocks.STONE).registerAll(ITEM_GROUP);
		new AndesiteFamily().registerAll(ITEM_GROUP);
		new AntiBlockFamily().registerAll(ITEM_GROUP);
		// new GenericFamilyRegistry("arcane_stone", Blocks.STONE).registerAll(ITEM_GROUP);
		new GenericFamilyRegistry("basalt", Blocks.BASALT).registerAll(ITEM_GROUP);
		new GenericFamilyRegistry("bricks", Blocks.BRICKS).registerAll(ITEM_GROUP);
		// new GenericFamilyRegistry("certus", Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("coal/charcoal", Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);
		new GenericFamilyRegistry("coal/coal", Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);
		// new GenericFamilyRegistry("coal/coalcoke", Blocks.COAL_BLOCK).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("cobblestone", Blocks.COBBLESTONE).registerAll(ITEM_GROUP);

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
		// new GenericFamilyRegistry("concrete_powder", Blocks.WHITE_CONCRETE_POWDER).registerAll(ITEM_GROUP);
		new GenericFamilyRegistry("concrete_purple", Blocks.PURPLE_CONCRETE).registerAll(ITEM_GROUP);
		new GenericFamilyRegistry("concrete_red", Blocks.RED_CONCRETE).registerAll(ITEM_GROUP);
		new GenericFamilyRegistry("concrete_white", Blocks.WHITE_CONCRETE).registerAll(ITEM_GROUP);
		new GenericFamilyRegistry("concrete_yellow", Blocks.YELLOW_CONCRETE).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("diorite", Blocks.DIORITE).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("endstone", Blocks.END_STONE).registerAll(ITEM_GROUP);

		// new GenericFamilyRegistry("fluid", Blocks.STONE).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("glowstone", Blocks.GLOWSTONE).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("granite", Blocks.GRANITE).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("hardenedclay", Blocks.TERRACOTTA).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("ice", Blocks.ICE).registerAll(ITEM_GROUP);

		// new GenericFamilyRegistry("limestone", Blocks.STONE).registerAll(ITEM_GROUP);
		// new GenericFamilyRegistry("marble", Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("magma", Blocks.MAGMA_BLOCK).registerAll(ITEM_GROUP);

		// new GenericFamilyRegistry("primarineanim", Blocks.PRISMARINE).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("purpur", Blocks.STONE).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("quartz", Blocks.QUARTZ_BLOCK).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("redstone", Blocks.REDSTONE_BLOCK).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("sandstonered", Blocks.RED_SANDSTONE).registerAll(ITEM_GROUP);
		new GenericFamilyRegistry("sandstoneyellow", Blocks.SANDSTONE).registerAll(ITEM_GROUP);

		new GenericFamilyRegistry("stone", Blocks.STONE).registerAll(ITEM_GROUP);
		
	}
}
