package net.tiphainelaurent.chiselforfabric;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.tiphainelaurent.chiselforfabric.blocks.andesite.AndesiteFamily;

public class ChiselForFabric implements ModInitializer
{
	public static final String MOD_ID = "chiselforfabric";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "general"))
 																	 .icon(() -> new ItemStack(Items.STONE))
																	 .build();

	public static Path MAIN_DIRECTORY;
	public static Map<Identifier, Recipe<?>> RECIPES = new HashMap<>();
	public static final AndesiteFamily andesiteFamily = new AndesiteFamily();

	@Override
	public void onInitialize()
	{
		try {
			MAIN_DIRECTORY = Paths.get(ChiselForFabric.class.getClassLoader().getResource("").toURI());
		} catch (Exception e) {
			System.out.println(e);
		}
		andesiteFamily.registerAll(ITEM_GROUP);
	}
}
