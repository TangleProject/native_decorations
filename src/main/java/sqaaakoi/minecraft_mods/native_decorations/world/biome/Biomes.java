package sqaaakoi.minecraft_mods.native_decorations.world.biome;

import sqaaakoi.minecraft_mods.native_decorations.Main;
import sqaaakoi.minecraft_mods.native_decorations.world.gen.features.Features;
import java.util.Arrays;
import java.util.Collection;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.math.Direction;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class Biomes {

  public static final Biome biome_oak_forest = create_oak_forest(false);
  public static final RegistryKey<Biome> key_biome_oak_forest = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "oak_forest"));

  public static final Biome biome_big_oak_forest = create_oak_forest(true);
  public static final RegistryKey<Biome> key_biome_big_oak_forest = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "big_oak_forest"));

  public static Biome create_oak_forest(boolean big) {
    SpawnSettings.Builder sps = new SpawnSettings.Builder();
    DefaultBiomeFeatures.addFarmAnimals(sps);
    DefaultBiomeFeatures.addBatsAndMonsters(sps);

    GenerationSettings.Builder gens = new GenerationSettings.Builder();
    // Defaults
    OverworldBiomeCreator.addBasicFeatures(gens);

    //  Forest defaults
    DefaultBiomeFeatures.addDefaultOres(gens);
    DefaultBiomeFeatures.addDefaultDisks(gens);
    DefaultBiomeFeatures.addDefaultFlowers(gens);
    DefaultBiomeFeatures.addForestGrass(gens);

    //  Custom trees (oak only)
    gens.feature(GenerationStep.Feature.VEGETAL_DECORATION, big ? Features.placed_trees_big_oak : Features.placed_trees_oak);
    return OverworldBiomeCreator.createBiome(Biome.Precipitation.RAIN, Biome.Category.FOREST, 0.7f, 0.8f, sps, gens, null);
  }

  public static void register() {
    Registry.register(BuiltinRegistries.BIOME, key_biome_oak_forest.getValue(), biome_oak_forest);
    Registry.register(BuiltinRegistries.BIOME, key_biome_big_oak_forest.getValue(), biome_big_oak_forest);
  }

}
