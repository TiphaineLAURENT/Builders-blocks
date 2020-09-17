package net.tiphainelaurent.chiselforfabric.blocks.andesite;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.tiphainelaurent.chiselforfabric.ChiselForFabric;
import net.tiphainelaurent.chiselforfabric.api.BasicBlock;

import java.util.HashMap;
import java.util.Map;

import me.orangemonkey68.injectablerecipes.InjectableRecipes;
import me.orangemonkey68.injectablerecipes.RecipeHolder;

public class AndesiteFamily implements RecipeHolder
{
    static final BasicBlock[] blocks = {
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "braid"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-cracked"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-encased"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-small"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-soft"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-solid"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "bricks-triple"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "chaotic-medium"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "chaotic-small"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "circular"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "cracked"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "dent"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "french-1"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "french-2"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "layers"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "mosaic"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "ornate"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "panel"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "pillar-side"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "pillar-top"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "raw"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "road"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "tiles-large"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "tiles-medium"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "tiles-small"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "twisted-side"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "twisted-top"), FabricBlockSettings.copy(Blocks.ANDESITE)),
        new BasicBlock(new Identifier(ChiselForFabric.MOD_ID, "weaver"), FabricBlockSettings.copy(Blocks.ANDESITE))
    };

    private static final Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipes = new HashMap<>();

    @Override
    public Map<RecipeType<?>, Map<Identifier, Recipe<?>>> getRecipes()
    {
        return recipes;
    }

    public void registerAll(final ItemGroup group)
    {
        recipes.put(RecipeType.STONECUTTING, new HashMap<>());
        Map<Identifier, Recipe<?>> stonecuttingRecipes = recipes.get(RecipeType.STONECUTTING);

        for (BasicBlock block : blocks)
        {
            block.register(group);
            block.write(block.asLootTable().build())
                 .writeBlockStates()
                 .writeModel()
                 .writeItem();

            stonecuttingRecipes.put(new Identifier(ChiselForFabric.MOD_ID, String.format("andesite-stonecutting-%s", block.getIdentifier().getPath())),
                                    new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("andesite-stonecutting-%s-id", block.getIdentifier().getPath())),
                                                           "Chisel",
                                                           Ingredient.ofItems(Items.ANDESITE),
                                                           new ItemStack(block)));
        }
        InjectableRecipes.register(this);
    }
}
