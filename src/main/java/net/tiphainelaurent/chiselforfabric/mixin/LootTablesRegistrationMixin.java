package net.tiphainelaurent.chiselforfabric.mixin;

import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.loot.LootManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import net.tiphainelaurent.chiselforfabric.api.helpers.Block;

@Mixin(LootManager.class)
public class LootTablesRegistrationMixin
{
    private JsonObject deepMerge(final JsonObject left, final JsonObject right) throws IllegalStateException
    {
        final JsonObject merged = new JsonObject();
        left.entrySet().forEach((leftEntry) -> {
            final String key = leftEntry.getKey();
            final JsonElement value = leftEntry.getValue();

            if (!right.has(key))
            {
                if (!value.isJsonNull())
                    merged.add(key, value);
            }
            else
            {

                if (!value.isJsonNull())
                {

                    if (value.isJsonObject())
                    {
                        merged.add(key, deepMerge(value.getAsJsonObject(), right.get(key).getAsJsonObject()));
                    }
                    else
                    {
                        merged.add(key, value);
                    }
                }
                else
                {
                    if (!right.get(key).isJsonNull())
                        merged.add(key, right.get(key));
                }
            }
        });
        return merged;
    }

    @Inject(
        method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V",
        at = @At("HEAD"))
    private void injected(final Map<Identifier, JsonElement> map, final ResourceManager resourceManager,
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
                catch (final IllegalStateException e)
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
