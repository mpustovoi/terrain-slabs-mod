package net.countered.terrainslabs.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;

import java.util.HashMap;
import java.util.Map;

public class ModSlabsMap {
    private static final Map<Block, Block> SLAB_MAP = new HashMap<>();

    static {
        // Register your block-to-slab mappings here
        SLAB_MAP.put(Blocks.STONE, Blocks.STONE_SLAB);
        SLAB_MAP.put(Blocks.SANDSTONE, Blocks.SANDSTONE_SLAB);

        SLAB_MAP.put(Blocks.GRASS_BLOCK, ModBlocksRegistry.GRASS_SLAB);

        SLAB_MAP.put(Blocks.GRAVEL, ModBlocksRegistry.GRAVEL_SLAB);
        SLAB_MAP.put(Blocks.SAND, ModBlocksRegistry.SAND_SLAB);
        SLAB_MAP.put(Blocks.RED_SAND, ModBlocksRegistry.RED_SAND_SLAB);

        SLAB_MAP.put(Blocks.DIRT, ModBlocksRegistry.DIRT_SLAB);
        SLAB_MAP.put(Blocks.MUD, ModBlocksRegistry.MUD_SLAB);

        SLAB_MAP.put(Blocks.TERRACOTTA, ModBlocksRegistry.TERRACOTTA_SLAB);
        SLAB_MAP.put(Blocks.RED_TERRACOTTA, ModBlocksRegistry.RED_TERRACOTTA_SLAB);
        SLAB_MAP.put(Blocks.ORANGE_TERRACOTTA, ModBlocksRegistry.ORANGE_TERRACOTTA_SLAB);
        SLAB_MAP.put(Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocksRegistry.LIGHT_GRAY_TERRACOTTA_SLAB);
        SLAB_MAP.put(Blocks.WHITE_TERRACOTTA, ModBlocksRegistry.WHITE_TERRACOTTA_SLAB);
        SLAB_MAP.put(Blocks.BROWN_TERRACOTTA, ModBlocksRegistry.BROWN_TERRACOTTA_SLAB);
        SLAB_MAP.put(Blocks.YELLOW_TERRACOTTA, ModBlocksRegistry.YELLOW_TERRACOTTA_SLAB);
    }

    public static Block getSlabForBlock(Block blockBelow) {
        return SLAB_MAP.getOrDefault(blockBelow, Blocks.STONE_SLAB); // Default slab if no match
    }
}
