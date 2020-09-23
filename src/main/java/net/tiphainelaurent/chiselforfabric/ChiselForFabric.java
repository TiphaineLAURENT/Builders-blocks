package net.tiphainelaurent.chiselforfabric;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.chiselforfabric.blocks.ancientstone.AncientStoneFamily;
import net.tiphainelaurent.chiselforfabric.blocks.andesite.AndesiteFamily;
import net.tiphainelaurent.chiselforfabric.blocks.antiblock.AntiBlockFamily;

public class ChiselForFabric implements ModInitializer
{
	public static final String MOD_ID = "chiselforfabric";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "general"))
 																	 .icon(() -> new ItemStack(Items.STONE))
																	 .build();

	public static Path MAIN_DIRECTORY;
	public static final Logger LOGGER = LogManager.getLogger();

	public static final Block EXAMPLE_BLOCK = net.tiphainelaurent.chiselforfabric.api.helpers.Block.builder(Blocks.ANDESITE)
																								   .mineable()
																								   .build(MOD_ID, "example");

	@Override
	public void onInitialize()
	{
		net.tiphainelaurent.chiselforfabric.api.helpers.Item.builder()
															.fromBlock(EXAMPLE_BLOCK)
															.group(ITEM_GROUP)
															.build(MOD_ID, "example");

		try {
			MAIN_DIRECTORY = Paths.get(ChiselForFabric.class.getClassLoader().getResource("").toURI());
		} catch (Exception e) {
			LOGGER.error(e);
		}
		new AndesiteFamily().registerAll(ITEM_GROUP);
		new AncientStoneFamily().registerAll(ITEM_GROUP);
		new AntiBlockFamily().registerAll(ITEM_GROUP);
	}
}
