package net.tiphainelaurent.buildersblocks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tiphainelaurent.buildersblocks.api.helpers.Item;

@Mixin(BlockStateModelGenerator.class)
public class BlockModelsRegistrationMixin
{

    @Shadow
    private void registerSimpleCubeAll(Block block){};

    @Shadow
    private void registerParentedItemModel(Block block, Identifier parentModelId){};

    @Inject(
        method = "register()V",
        at = @At(
            value = "TAIL"
        )
    )
    private void injected(final CallbackInfo info)
    {
        Item.ITEMS.forEach((itemId, model) -> {
            Block block = Registry.BLOCK.get(itemId);
            registerSimpleCubeAll(block);
            registerParentedItemModel(block, itemId);
        });
    }
}
