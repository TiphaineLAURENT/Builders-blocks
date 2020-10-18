package net.tiphainelaurent.buildersblocks.blocks;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class FertilizedDirt extends FarmlandBlock
{
    public FertilizedDirt(AbstractBlock.Settings settings)
    {
        super(settings);
    }

    private static boolean hasCrop(BlockView world, BlockPos pos)
    {
        Block block = world.getBlockState(pos).getBlock();
        return block instanceof CropBlock || block instanceof StemBlock || block instanceof AttachedStemBlock;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        super.randomTick(state, world, pos, random);
        final int i = (Integer)state.get(MOISTURE);
        if (i >= 7 && hasCrop(world, pos.up()))
        {
            world.getBlockState(pos.up()).randomTick(world, pos, random);
        }
    }
}
