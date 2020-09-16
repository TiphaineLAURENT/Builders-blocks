package net.tiphainelaurent.chiselforfabric;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.tiphainelaurent.chiselforfabric.blocks.andesite.AndesiteFamily;

public class ChiselForFabric implements ModInitializer
{
	public static final String MOD_ID = "chiselforfabric";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "general"))
 																	 .icon(() -> new ItemStack(Items.STONE))
																	 .build();

	@Override
	public void onInitialize()
	{
		AndesiteFamily.registerAll(ITEM_GROUP);
	}
}
