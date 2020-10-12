package net.tiphainelaurent.buildersblocks.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Category;

import net.tiphainelaurent.buildersblocks.BuildersBlocks;

@Config(
    name = BuildersBlocks.MOD_ID)
public class Configuration implements ConfigData
{
    @Category(
        value = "Families")
    public boolean andesite = true;
    public boolean antiblock = true;
    public boolean basalt = true;
    public boolean bookshelf = true;
    public boolean bricks = true;
    public boolean certus = false;
    public boolean charcoal = true;
    public boolean coal = true;
    public boolean cobblestone = true;
    public boolean concrete = true;
    public boolean diorite = true;
    public boolean endstone = true;
    public boolean glowstone = true;
    public boolean granite = true;
    public boolean hardenedclay = true;
    public boolean ice = true;
    public boolean laboratory = true;
    public boolean magma = true;
    public boolean planks = true;
    public boolean purpur = true;
    public boolean quartz = true;
    public boolean redstone = true;
    public boolean sandstone = true;
    public boolean stone = true;
}
