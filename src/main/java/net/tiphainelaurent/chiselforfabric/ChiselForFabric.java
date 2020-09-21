package net.tiphainelaurent.chiselforfabric;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.tiphainelaurent.chiselforfabric.api.helpers.Block;
import net.tiphainelaurent.chiselforfabric.api.helpers.Item;
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

	public static final net.minecraft.block.Block EXAMPLE_BLOCK = Block.builder(Blocks.ANDESITE)
																		.mineable()
																		.namespace(MOD_ID)
																		.name("example")
																		.build();

	@Override
	public void onInitialize()
	{
		Item.builder()
			.block(EXAMPLE_BLOCK)
			.namespace(MOD_ID)
			.name("example")
			.group(ITEM_GROUP)
			.build();

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
