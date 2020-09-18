package net.tiphainelaurent.chiselforfabric.mixin;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.google.gson.JsonElement;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Blocks;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.Texture;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.tiphainelaurent.chiselforfabric.api.Helpers;

@Mixin(ItemModelGenerator.class)
public class ItemModelsRegistrationMixin
{

    @Shadow
    @Final
    private BiConsumer<Identifier, Supplier<JsonElement>> writer;

    @Inject(
        method = "register()V",
        at = @At(
            value = "TAIL"
        )
    )
    private void injected(final CallbackInfo info)
    {
        Helpers.Item.ITEMS.forEach((model, items) -> {
            items.forEach((item) -> {
                final Identifier itemId = Registry.ITEM.getId(item);
                model.upload(itemId, Texture.all(itemId), writer);
            });
        });
    }
}
