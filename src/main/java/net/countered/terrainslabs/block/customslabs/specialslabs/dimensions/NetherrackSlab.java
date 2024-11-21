package net.countered.terrainslabs.block.customslabs.specialslabs.dimensions;

import net.countered.terrainslabs.block.ModBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class NetherrackSlab extends SlabBlock implements Fertilizable{

    public NetherrackSlab(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        if (!world.getBlockState(pos.up()).isTransparent(world, pos)) {
            return false;
        } else {
            for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
                if (world.getBlockState(blockPos).isIn(BlockTags.NYLIUM)) {
                    return true;
                }
            }

            return false;
        }
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        boolean hasWarped = false;
        boolean hasCrimson = false;

        // Check neighboring blocks for nylium
        for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(Blocks.WARPED_NYLIUM) || blockState.isOf(ModBlocksRegistry.WARPED_NYLIUM_SLAB)) {
                hasWarped = true;
            }

            if (blockState.isOf(Blocks.CRIMSON_NYLIUM) || blockState.isOf(ModBlocksRegistry.CRIMSON_NYLIUM_SLAB)) {
                hasCrimson = true;
            }

            if (hasWarped && hasCrimson) {
                break; // No need to check further
            }
        }

        // Determine the new state based on neighboring nylium
        BlockState newState = null;
        if (hasWarped && hasCrimson) {
            newState = random.nextBoolean() ? ModBlocksRegistry.WARPED_NYLIUM_SLAB.getDefaultState() : ModBlocksRegistry.CRIMSON_NYLIUM_SLAB.getDefaultState();
        } else if (hasWarped) {
            newState = ModBlocksRegistry.WARPED_NYLIUM_SLAB.getDefaultState();
        } else if (hasCrimson) {
            newState = ModBlocksRegistry.CRIMSON_NYLIUM_SLAB.getDefaultState();
        }

        // If a new state was determined, copy the slab type and update the block
        if (newState != null) {
            SlabType slabType = state.get(SlabBlock.TYPE); // Get current slab type
            newState = newState.with(SlabBlock.TYPE, slabType); // Apply it to the new state
            world.setBlockState(pos, newState, Block.NOTIFY_ALL);
        }
    }
}
