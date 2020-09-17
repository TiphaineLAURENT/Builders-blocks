package net.tiphainelaurent.chiselforfabric.api;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BasicBlock extends Block {
    private final Identifier identifier;

    public BasicBlock(final Settings settings) {
        super(settings);
        identifier = new Identifier(getTranslationKey());
    }

    public BasicBlock(final Identifier identifier_, final Settings settings) {
        super(settings);
        identifier = identifier_;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void register(final ItemGroup itemGroup)
    {
        Registry.register(Registry.BLOCK, getIdentifier(), this);

        final Item item = new BlockItem(this, new Item.Settings().group(itemGroup));
        Registry.register(Registry.ITEM, getIdentifier(), item);
    }
}
