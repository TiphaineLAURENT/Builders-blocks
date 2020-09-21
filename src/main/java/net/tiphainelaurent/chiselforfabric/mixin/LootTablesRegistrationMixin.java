package net.tiphainelaurent.chiselforfabric.mixin;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootTable;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import net.tiphainelaurent.chiselforfabric.api.helpers.Block;

@Mixin(LootManager.class)
public class LootTablesRegistrationMixin
{
    @Inject(
        method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V",
        at = @At(
            value = "INVOKE",
            target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;"
        ),
        locals = LocalCapture.CAPTURE_FAILEXCEPTION
    )
    private void injected(final Map<Identifier, JsonElement> map, final ResourceManager resourceManager,
            final Profiler profiler, final CallbackInfo ci, final ImmutableMap.Builder<Identifier, LootTable> builder)
    {
        builder.putAll(Block.LOOT_POOLS);
    }
}
