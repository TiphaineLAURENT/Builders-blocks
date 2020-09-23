package net.tiphainelaurent.chiselforfabric.mixin;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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
    // @Inject(
    // method =
    // "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V",
    // at = @At(
    // value = "INVOKE",
    // target =
    // "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;"),
    // locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    // private void injected(final Map<Identifier, JsonElement> map, final
    // ResourceManager resourceManager,
    // final Profiler profiler, final CallbackInfo ci, final
    // ImmutableMap.Builder<Identifier, LootTable> builder)
    // {
    // Block.LOOT_POOLS.forEach((id, supplier) -> {
    // final LootTable lootTable = supplier.get();
    // builder.put(id, lootTable);
    // });
    // }
    private JsonObject deepMerge(JsonObject source, JsonObject target) throws IllegalStateException
    {

        for (Map.Entry<String, JsonElement> sourceEntry : source.entrySet())
        {
            String key = sourceEntry.getKey();
            JsonElement value = sourceEntry.getValue();

            if (!target.has(key))
            {
                // target does not have the same key, so perhaps it should be
                // added to target
                if (!value.isJsonNull()) // well, only add if the source value
                                         // is not null
                    target.add(key, value);
            }
            else
            {

                if (!value.isJsonNull())
                {

                    if (value.isJsonObject())
                    {
                        // source value is json object, start deep merge
                        deepMerge(value.getAsJsonObject(), target.get(key).getAsJsonObject());
                    }
                    else
                    {
                        target.add(key, value);
                    }
                }
                else
                {
                    if (target.get(key).isJsonNull())
                        target.remove(key);
                }
            }
        }
        return target;
    }


    @Inject(
        method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V",
        at = @At("HEAD"))
    private void injected_head(final Map<Identifier, JsonElement> map, final ResourceManager resourceManager,
        final Profiler profiler, final CallbackInfo callbackInfo)
    {
        Block.LOOT_POOLS.forEach((id, supplier) -> {

            if (map.containsKey(id))
            {

                try
                {
                    map.put(id,
                        deepMerge(map.get(id).getAsJsonObject(), LootManager.toJson(supplier.get()).getAsJsonObject()));
                }
                catch (IllegalStateException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                map.put(id, LootManager.toJson(supplier.get()));
            }
        });
    }
}
