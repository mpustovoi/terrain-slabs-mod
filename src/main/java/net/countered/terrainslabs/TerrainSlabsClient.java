package net.countered.terrainslabs;

import net.countered.terrainslabs.block.ModBlocksRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;

public class TerrainSlabsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.GRASS_SLAB, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.POPPY_ON_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.DANDELION_ON_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.AZURE_BLUET_ON_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.CORNFLOWER_ON_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.SHORT_GRASS_ON_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.FERN_ON_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.BROWN_MUSHROOM_ON_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.RED_MUSHROOM_ON_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.DEAD_BUSH_ON_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksRegistry.SEAGRASS_ON_TOP, RenderLayer.getCutoutMipped());

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
                return world != null && pos != null
                        ? BiomeColors.getGrassColor(world, pos)
                        : GrassColors.getDefaultColor();
        }, ModBlocksRegistry.GRASS_SLAB);


        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) ->
                        MinecraftClient.getInstance().getBlockColors().getColor(Blocks.GRASS_BLOCK.getDefaultState(), null, null, tintIndex),
                ModBlocksRegistry.GRASS_SLAB
        );

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
                return world != null && pos != null
                        ? BiomeColors.getGrassColor(world, pos)
                        : GrassColors.getDefaultColor();
        }, ModBlocksRegistry.SHORT_GRASS_ON_TOP);


        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) ->
                        MinecraftClient.getInstance().getBlockColors().getColor(Blocks.GRASS.getDefaultState(), null, null, tintIndex),
                ModBlocksRegistry.SHORT_GRASS_ON_TOP
        );

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
                return world != null && pos != null
                        ? BiomeColors.getGrassColor(world, pos)
                        : GrassColors.getDefaultColor();
        }, ModBlocksRegistry.FERN_ON_TOP);

        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) ->
                        MinecraftClient.getInstance().getBlockColors().getColor(Blocks.FERN.getDefaultState(), null, null, tintIndex),
                ModBlocksRegistry.FERN_ON_TOP
        );
    }
}
