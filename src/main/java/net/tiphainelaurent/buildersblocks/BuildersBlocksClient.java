package net.tiphainelaurent.buildersblocks;

import java.util.List;

import com.mojang.brigadier.Command;
import com.swordglowsblue.artifice.api.Artifice;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;

import net.tiphainelaurent.buildersblocks.api.helpers.Block;

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

			BuildersBlocks.FAMILIES.forEach((family) -> family.registerAll(BuildersBlocks.ITEM_GROUP, pack));
		});
	}
}
