package net.tiphainelaurent.chiselforfabric.api;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BasicBlock extends Block {
    public BasicBlock(Settings settings) {
        super(settings);
    }

    public Identifier getIdentifier()
    {
        return new Identifier(getTranslationKey());
    }

    public void register(ItemGroup itemGroup)
    {
        Registry.register(Registry.BLOCK, getIdentifier(), this);

        final Item item = new BlockItem(this, new Item.Settings().group(itemGroup));
        Registry.register(Registry.ITEM, getIdentifier(), item);
    }
}
