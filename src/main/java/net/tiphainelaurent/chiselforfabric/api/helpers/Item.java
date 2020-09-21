package net.tiphainelaurent.chiselforfabric.api.helpers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.data.client.model.Model;
import net.minecraft.data.client.model.Models;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Recipe;

import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class Item
{
    public static enum ITEM_TYPE
    {
        BLOCK;
    }

    public static final Map<Model, List<net.minecraft.item.Item>> ITEMS = new HashMap<>();
	public static List<Supplier<Recipe<?>>> RECIPES = new LinkedList<>();

    public static Builder builder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private final FabricItemSettings settings = new FabricItemSettings();
        private ITEM_TYPE type;
        private Block block;
        private String namespace = "minecraft";
        private String name;

        private net.minecraft.item.Item createItem()
        {
            switch (type)
            {
                case BLOCK:
                    net.minecraft.item.Item item = new BlockItem(block, settings);
                    ITEMS.computeIfAbsent(Models.CUBE_ALL, (itemModel) -> {
                        return new LinkedList<net.minecraft.item.Item>();
                    }).add(item);
                    return item;
                default:
                    item =  new net.minecraft.item.Item(settings);
                    ITEMS.computeIfAbsent(Models.GENERATED, (itemModel) -> {
                        return new LinkedList<net.minecraft.item.Item>();
                    }).add(item);
                    return item;
            }
        }

        public net.minecraft.item.Item build()
        {
            net.minecraft.item.Item item = createItem();
            Registry.register(Registry.ITEM, new Identifier(namespace, name), item);

            return item;
        }

        public Item.Builder namespace(final String namespace_)
        {
            namespace = namespace_;
            return this;
        }

        public Item.Builder name(final String name_)
        {
            name = name_;
            return this;
        }

        public Item.Builder block(final Block block_)
        {
            type = ITEM_TYPE.BLOCK;
            block = block_;
            return this;
        }

        public Item.Builder equipmentSlot(EquipmentSlotProvider equipmentSlotProvider)
        {
            settings.equipmentSlot(equipmentSlotProvider);
            return this;
        }

        public Item.Builder fireproof()
        {
            settings.fireproof();
            return this;
        }

        public Item.Builder food(final FoodComponent foodComponent)
        {
            settings.food(foodComponent);
            return this;
        }

        public Item.Builder group(final ItemGroup group)
        {
            settings.group(group);
            return this;
        }

        public Item.Builder maxCount(final int maxCount)
        {
            settings.maxCount(maxCount);
            return this;
        }

        public Item.Builder maxDamage(final int maxDamage)
        {
            settings.maxDamage(maxDamage);
            return this;
        }

        public Item.Builder maxDamageIfAbsent(final int maxDamage)
        {
            settings.maxDamageIfAbsent(maxDamage);
            return this;
        }

        public Item.Builder rarity(final Rarity rarity)
        {
            settings.rarity(rarity);
            return this;
        }

        public Item.Builder recipeRemainder(final net.minecraft.item.Item recipeRemainder)
        {
            settings.recipeRemainder(recipeRemainder);
            return this;
        }

        public Item.Builder withRecipe(final Supplier<Recipe<?>> recipe)
        {
            RECIPES.add(recipe);
            return this;
        }
    }
}
