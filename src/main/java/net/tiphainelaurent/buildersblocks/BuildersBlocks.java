package net.tiphainelaurent.buildersblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;

import net.tiphainelaurent.buildersblocks.api.helpers.Block;
import net.tiphainelaurent.buildersblocks.blocks.SchrodingerLamp;
import net.tiphainelaurent.buildersblocks.config.Configuration;

public class BuildersBlocks implements ModInitializer
{
    public static final String MOD_ID = "buildersblocks";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "general"))
        .icon(() -> new ItemStack(Items.STONECUTTER)).build();
    public static final Logger LOGGER = LogManager.getLogger();
    public static Configuration configuration;

    @Override
    public void onInitialize()
    {
        configuration = AutoConfig.register(Configuration.class, Toml4jConfigSerializer::new).getConfig();

        final Block.Builder builder = Block.builder(Blocks.REDSTONE_LAMP).asItem((item) -> item.group(ITEM_GROUP));
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
        {
            builder.lightLevel((blockState) -> (Boolean)blockState.get(Properties.LIT) ? 15 : 0);
        }
        else
        {
            builder.lightLevel((blockState) -> 0);
        }
        builder.build(new Identifier(MOD_ID, "schrodinger_lamp"), SchrodingerLamp::new);
    }
}
