package net.countered.terrainslabs.block.customslabs.soilslabs;

import com.mojang.serialization.MapCodec;
import net.countered.terrainslabs.block.ModBlocksRegistry;
import net.countered.terrainslabs.block.customslabs.specialslabs.CustomSlab;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.tick.ScheduledTickView;

public class GrassSlab extends CustomSlab {

    public GrassSlab(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(SlabBlock.TYPE, SlabType.BOTTOM)
                .with(SNOWY, false)
                .with(WATERLOGGED, Boolean.FALSE)
                .with(GENERATED, Boolean.FALSE));
    }

    public static final MapCodec<GrassSlab> CODEC = createCodec(GrassSlab::new);
    public static final BooleanProperty SNOWY = Properties.SNOWY;

    @Override
    public MapCodec<GrassSlab> getCodec() {
        return CODEC;
    }

    @Override
    protected void spawnBreakParticles(World world, PlayerEntity player, BlockPos pos, BlockState state) {
        if (state.get(TYPE) == SlabType.DOUBLE) {
            super.spawnBreakParticles(world, player, pos, Blocks.DIRT.getDefaultState());
        }
        else {
            super.spawnBreakParticles(world, player, pos, ModBlocksRegistry.DIRT_SLAB.getDefaultState());
        }
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (direction == Direction.UP) {
            state = state.with(SNOWY, isSnow(neighborState));
        }

        if ((Boolean)state.get(WATERLOGGED)) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return state;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        BlockState currentState = ctx.getWorld().getBlockState(blockPos);

        // Check if the block at the position is already a slab (and it's not a double slab yet)
        if (currentState.isOf(this) && currentState.get(TYPE) != SlabType.DOUBLE) {
            // Convert to a double slab if a slab is placed on an existing slab
            return currentState.with(TYPE, SlabType.DOUBLE).with(WATERLOGGED, false);
        }

        // Determine the snowy state based on the block above
        BlockState blockAbove = ctx.getWorld().getBlockState(blockPos.up());
        BlockState defaultState = this.getDefaultState().with(SNOWY, isSnow(blockAbove));

        // Handle slab type and waterlogging for single slab placement
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        BlockState slabState = defaultState.with(TYPE, SlabType.BOTTOM)
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);

        Direction direction = ctx.getSide();

        // Adjust the slab type based on the placement context (whether it's a top or bottom slab)
        if (direction != Direction.DOWN && (direction == Direction.UP || !(ctx.getHitPos().y - (double) blockPos.getY() > 0.5))) {
            return slabState;
        } else {
            return slabState.with(TYPE, SlabType.TOP);
        }
    }

    private static boolean isSnow(BlockState state) {
        return state.isIn(BlockTags.SNOW);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SNOWY, TYPE, WATERLOGGED, GENERATED);
    }

    private static boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPosUp = pos.up();
        BlockState blockStateUp = world.getBlockState(blockPosUp);
        if (blockStateUp.isOf(Blocks.SNOW) && (Integer)blockStateUp.get(SnowBlock.LAYERS) == 1
        || blockStateUp.isOf(ModBlocksRegistry.SNOW_SLAB)) {
            return true;
        } else if (blockStateUp.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = ChunkLightProvider.getRealisticOpacity(Blocks.GRASS_BLOCK.getDefaultState(), blockStateUp, Direction.UP, blockStateUp.getOpacity());
            return i < 15;
        }
    }
    private static boolean canSpread(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return canSurvive(state, world, pos) && !world.getFluidState(blockPos).isIn(FluidTags.WATER);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) {
            if (state.get(TYPE) == SlabType.TOP) {
                world.setBlockState(pos, ModBlocksRegistry.DIRT_SLAB.getDefaultState().with(TYPE, SlabType.TOP), 3);
            }
            else if (state.get(TYPE) == SlabType.DOUBLE) {
                world.setBlockState(pos, ModBlocksRegistry.DIRT_SLAB.getDefaultState().with(TYPE, SlabType.DOUBLE), 3);
            }
            else if (state.get(TYPE) == SlabType.BOTTOM){
                world.setBlockState(pos, ModBlocksRegistry.DIRT_SLAB.getDefaultState().with(TYPE, SlabType.BOTTOM), 3);
            }
        }
        else {
            if (world.getLightLevel(pos.up()) >= 9) {
                BlockState blockState = this.getDefaultState().with(TYPE,world.getBlockState(pos).get(TYPE) );

                for (int i = 0; i < 4; i++) {
                    BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (world.getBlockState(blockPos).isOf(ModBlocksRegistry.DIRT_SLAB) && canSpread(blockState, world, blockPos)) {
                        world.setBlockState(blockPos, blockState.with(SNOWY, Boolean.valueOf(world.getBlockState(blockPos.up()).isOf(Blocks.SNOW))).with(TYPE, world.getBlockState(blockPos).get(TYPE)));
                    }
                }
            }
        }
    }
}
