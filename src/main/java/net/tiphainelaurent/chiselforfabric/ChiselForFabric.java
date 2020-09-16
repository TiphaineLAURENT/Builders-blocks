package net.tiphainelaurent.chiselforfabric;

import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

import me.orangemonkey68.injectablerecipes.RecipeHolder;

public class ChiselForFabric implements ModInitializer, RecipeHolder
{
	public static final String MOD_ID = "chiselforfabric";

	private static final Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipes = new HashMap<>();

	@Override
	public void onInitialize()
	{
	}

    @Override
	public Map<RecipeType<?>, Map<Identifier, Recipe<?>>> getRecipes()
	{
        return recipes;
    }
}
