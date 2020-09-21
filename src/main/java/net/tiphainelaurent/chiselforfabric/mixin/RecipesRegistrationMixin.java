package net.tiphainelaurent.chiselforfabric.mixin;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.profiler.Profiler;

import net.tiphainelaurent.chiselforfabric.api.helpers.Item;

@Mixin(RecipeManager.class)
public class RecipesRegistrationMixin
{
	@Shadow
	private boolean errored;

	@Shadow
	private Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipes;

	@Overwrite
	public void apply(final Map<Identifier, JsonElement> map, final ResourceManager resourceManager, final Profiler profiler)
	{
		errored = false;
		final Map<RecipeType<?>, Builder<Identifier, Recipe<?>>> tempRecipes = Maps.newHashMap();

		map.forEach((identifier, json) -> {
			try {
				final Recipe<?> recipe = RecipeManager.deserialize(identifier, JsonHelper.asObject(json, "top element"));
				tempRecipes.computeIfAbsent(recipe.getType(), (recipeType) -> {
					return ImmutableMap.builder();
				}).put(identifier, recipe);
			} catch (IllegalArgumentException | JsonParseException e) {
				System.out.println(e);
			}
		});
		Item.RECIPES.forEach((recipe) -> {
			try {
				tempRecipes.computeIfAbsent(recipe.getType(), (recipeType) -> {
					return ImmutableMap.builder();
				}).put(recipe.getId(), recipe);
			} catch (IllegalArgumentException | JsonParseException e) {
				System.out.println(e);
			}
		});
  
		recipes = tempRecipes.entrySet().stream().collect(ImmutableMap.toImmutableMap(Entry::getKey, (entryx) -> {
		   return entryx.getValue().build();
		}));
	}
}
