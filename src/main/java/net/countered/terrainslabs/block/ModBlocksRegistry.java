package net.countered.terrainslabs.block;

import net.countered.terrainslabs.TerrainSlabs;
import net.countered.terrainslabs.block.customslabs.soilslabs.GrassSlab;
import net.countered.terrainslabs.block.customslabs.soilslabs.PathSlab;
import net.countered.terrainslabs.block.customslabs.specialslabs.GravityAffectedSlab;
import net.countered.terrainslabs.block.customslabs.soilslabs.MyceliumSlab;
import net.countered.terrainslabs.block.customslabs.soilslabs.PodzolSlab;
import net.countered.terrainslabs.block.customslabs.specialslabs.MudSlab;
import net.countered.terrainslabs.block.customslabs.specialslabs.dimensions.NetherrackSlab;
import net.countered.terrainslabs.block.customslabs.specialslabs.dimensions.NyliumSlab;
import net.countered.terrainslabs.block.customslabs.specialslabs.dimensions.SoulSandSlab;
import net.countered.terrainslabs.block.ontopofslabs.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

public class ModBlocksRegistry {

    public static final Block DIRT_SLAB = registerBlock("dirt_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.DIRT)));
    public static final Block MUD_SLAB = registerBlock("mud_slab",
            new MudSlab(AbstractBlock.Settings.copy(Blocks.MUD).blockVision(Blocks::never)));
    public static final Block COARSE_SLAB = registerBlock("coarse_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.COARSE_DIRT)));
    public static final Block SNOW_SLAB = registerBlock("snow_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK)));
    public static final Block PACKED_ICE_SLAB = registerBlock("packed_ice_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PACKED_ICE)));
    public static final Block DEEPSLATE_SLAB = registerBlock("deepslate_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)));
    public static final Block CLAY_SLAB = registerBlock("clay_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.CLAY)));
    public static final Block MOSS_SLAB = registerBlock("moss_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK)));

    public static final Block GRASS_SLAB = registerBlock("grass_slab",
            new GrassSlab(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)));
    public static final Block MYCELIUM_SLAB = registerBlock("mycelium_slab",
            new MyceliumSlab(AbstractBlock.Settings.copy(Blocks.MYCELIUM)));
    public static final Block PODZOL_SLAB = registerBlock("podzol_slab",
            new PodzolSlab(AbstractBlock.Settings.copy(Blocks.PODZOL)));
    public static final Block PATH_SLAB = registerBlock("path_slab",
            new PathSlab(AbstractBlock.Settings.copy(Blocks.DIRT_PATH).blockVision(Blocks::never)));

    public static final Block GRAVEL_SLAB = registerBlock("gravel_slab",
            new GravityAffectedSlab(AbstractBlock.Settings.copy(Blocks.GRAVEL)));
    public static final Block SAND_SLAB = registerBlock("sand_slab",
            new GravityAffectedSlab(AbstractBlock.Settings.copy(Blocks.SAND)));
    public static final Block RED_SAND_SLAB = registerBlock("red_sand_slab",
            new GravityAffectedSlab(AbstractBlock.Settings.copy(Blocks.RED_SAND)));

    public static final Block TERRACOTTA_SLAB = registerBlock("terracotta_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.TERRACOTTA)));
    public static final Block RED_TERRACOTTA_SLAB = registerBlock("red_terracotta_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.RED_TERRACOTTA)));
    public static final Block ORANGE_TERRACOTTA_SLAB = registerBlock("orange_terracotta_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_TERRACOTTA)));
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = registerBlock("light_gray_terracotta_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final Block WHITE_TERRACOTTA_SLAB = registerBlock("white_terracotta_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.WHITE_TERRACOTTA)));
    public static final Block BROWN_TERRACOTTA_SLAB = registerBlock("brown_terracotta_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BROWN_TERRACOTTA)));
    public static final Block YELLOW_TERRACOTTA_SLAB = registerBlock("yellow_terracotta_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_TERRACOTTA)));

    public static final Block CUSTOM_STONE_SLAB = registerBlock("terrain_stone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_SLAB)));
    public static final Block CUSTOM_TUFF_SLAB = registerBlock("terrain_tuff_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.TUFF_SLAB)));
    public static final Block CUSTOM_SANDSTONE_SLAB = registerBlock("terrain_sandstone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.SANDSTONE_SLAB)));
    public static final Block CUSTOM_RED_SANDSTONE_SLAB = registerBlock("terrain_red_sandstone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.RED_SANDSTONE_SLAB)));
    public static final Block CUSTOM_ANDESITE_SLAB = registerBlock("terrain_andesite_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.ANDESITE_SLAB)));
    public static final Block CUSTOM_DIORITE_SLAB = registerBlock("terrain_diorite_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.DIORITE_SLAB)));
    public static final Block CUSTOM_GRANITE_SLAB = registerBlock("terrain_granite_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.GRANITE_SLAB)));

    public static final Block SOUL_SAND_SLAB = registerBlock("soul_sand_slab",
            new SoulSandSlab(AbstractBlock.Settings.copy(Blocks.SOUL_SAND).blockVision(Blocks::never)));
    public static final Block SOUL_SOIL_SLAB = registerBlock("soul_soil_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.SOUL_SOIL)));
    public static final Block NETHERRACK_SLAB = registerBlock("netherrack_slab",
            new NetherrackSlab(AbstractBlock.Settings.copy(Blocks.NETHERRACK)));
    public static final Block WARPED_NYLIUM_SLAB = registerBlock("warped_nylium_slab",
            new NyliumSlab(AbstractBlock.Settings.copy(Blocks.WARPED_NYLIUM)));
    public static final Block CRIMSON_NYLIUM_SLAB = registerBlock("crimson_nylium_slab",
            new NyliumSlab(AbstractBlock.Settings.copy(Blocks.CRIMSON_NYLIUM)));
    public static final Block BASALT_SLAB = registerBlock("basalt_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BASALT)));
    public static final Block CUSTOM_BLACKSTONE_SLAB = registerBlock("terrain_blackstone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE_SLAB)));
    public static final Block ENDSTONE_SLAB = registerBlock("endstone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.END_STONE)));

    public static final Block SNOW_ON_TOP = registerBlock("snow_on_top",
            new SnowOnTop(AbstractBlock.Settings.copy(Blocks.SNOW)));
    public static final Block SEAGRASS_ON_TOP = registerBlock("seagrass_on_top",
            new SeagrassOnTop(AbstractBlock.Settings.copy(Blocks.SEAGRASS)));
    public static final Block POPPY_ON_TOP = registerBlock("poppy_on_top",
            new FlowerOnTop(StatusEffects.NIGHT_VISION, 5.0F, AbstractBlock.Settings.copy(Blocks.POPPY)));
    public static final Block DANDELION_ON_TOP = registerBlock("dandelion_on_top",
            new FlowerOnTop(StatusEffects.SATURATION, 0.35F, AbstractBlock.Settings.copy(Blocks.DANDELION)));
    public static final Block AZURE_BLUET_ON_TOP = registerBlock("azure_bluet_on_top",
            new FlowerOnTop(StatusEffects.BLINDNESS, 8.0F, AbstractBlock.Settings.copy(Blocks.AZURE_BLUET)));
    public static final Block CORNFLOWER_ON_TOP = registerBlock("cornflower_on_top",
            new FlowerOnTop(StatusEffects.JUMP_BOOST, 6.0F, AbstractBlock.Settings.copy(Blocks.CORNFLOWER)));
    public static final Block DEAD_BUSH_ON_TOP = registerBlock("dead_bush_on_top",
            new DeadBushOnTop(AbstractBlock.Settings.copy(Blocks.DEAD_BUSH)));
    public static final Block BROWN_MUSHROOM_ON_TOP = registerBlock("brown_mushroom_on_top",
            new MushroomOnTop(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM, AbstractBlock.Settings.copy(Blocks.BROWN_MUSHROOM)));
    public static final Block RED_MUSHROOM_ON_TOP = registerBlock("red_mushroom_on_top",
            new MushroomOnTop(TreeConfiguredFeatures.HUGE_RED_MUSHROOM, AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM)));
    public static final Block SHORT_GRASS_ON_TOP = registerBlock("short_grass_on_top",
            new GrassOnTop(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS)));
    public static final Block FERN_ON_TOP = registerBlock("fern_on_top",
            new GrassOnTop(AbstractBlock.Settings.copy(Blocks.FERN)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TerrainSlabs.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TerrainSlabs.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TerrainSlabs.LOGGER.info("Registering Mod Blocks for" + TerrainSlabs.MOD_ID);
    }
}
