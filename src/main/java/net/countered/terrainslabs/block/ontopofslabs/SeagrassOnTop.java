package net.countered.terrainslabs.block.ontopofslabs;


import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;


public class SeagrassOnTop extends SeagrassBlock implements Fertilizable, FluidFillable{
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, -8.0, 2.0, 14.0, 4.0, 14.0);

    public SeagrassOnTop(Settings settings) {
        super(settings);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.getBlock() instanceof SlabBlock;
    }
}
