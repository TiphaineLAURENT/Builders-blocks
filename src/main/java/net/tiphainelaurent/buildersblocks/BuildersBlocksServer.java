package net.tiphainelaurent.buildersblocks;

import net.fabricmc.api.DedicatedServerModInitializer;

public class BuildersBlocksServer implements DedicatedServerModInitializer
{
	@Override
	public void onInitializeServer()
	{
		BuildersBlocks.FAMILIES.forEach((family) -> family.registerAll(BuildersBlocks.ITEM_GROUP));
	}
}
