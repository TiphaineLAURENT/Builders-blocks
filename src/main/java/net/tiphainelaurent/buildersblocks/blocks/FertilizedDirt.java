package net.tiphainelaurent.buildersblocks.blocks;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class FertilizedDirt extends FarmlandBlock
{
    public FertilizedDirt(AbstractBlock.Settings settings)
    {
        super(settings);
    }

    public void onLandedUpon(World world, BlockPos pos, Entity entity, float distance)
    {
        entity.handleFallDamage(distance, 1.0F);
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
        final BlockPos up = pos.up();
        if (i >= 7 && hasCrop(world, up))
        {
            final BlockState cropState = world.getBlockState(up);
            final CropBlock crop = (CropBlock)cropState.getBlock();
            crop.randomTick(cropState, world, up, random);
            crop.randomTick(cropState, world, up, random);
            crop.randomTick(cropState, world, up, random);
            crop.randomTick(cropState, world, up, random);
            // crop.grow(world, random, up, cropState);
        }
    }
}
