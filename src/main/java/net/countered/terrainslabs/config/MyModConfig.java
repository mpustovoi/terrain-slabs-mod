package net.countered.terrainslabs.config;

import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.util.Identifier;

public class MyModConfig extends MidnightConfig {
    // Define categories and entries
    public static final String GENERATION = "generation";  // category for world generation

    @Entry(category = GENERATION)
    public static boolean enableSlabGeneration = true;
}