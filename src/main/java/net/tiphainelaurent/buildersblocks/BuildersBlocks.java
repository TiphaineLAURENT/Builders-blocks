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

import net.tiphainelaurent.buildersblocks.blocks.ancientstone.AncientStoneFamily;
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
		new AndesiteFamily().registerAll(ITEM_GROUP);
		new AncientStoneFamily().registerAll(ITEM_GROUP);
		new AntiBlockFamily().registerAll(ITEM_GROUP);
	}
}
