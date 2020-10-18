package net.tiphainelaurent.buildersblocks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

@Mixin(CropBlock.class)
public class CanPlantCropMixin
{
    @Overwrite
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos)
    {
        return floor.isOf(Blocks.FARMLAND) || floor.getBlock() instanceof FarmlandBlock;
    }
}
