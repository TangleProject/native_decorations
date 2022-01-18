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
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class Biomes {

  public static Biome biome_oak_forest = null;
  public static final RegistryKey<Biome> key_biome_oak_forest = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "oak_forest"));

  public static Biome biome_big_oak_forest = null;
  public static final RegistryKey<Biome> key_biome_big_oak_forest = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "big_oak_forest"));

  public static Biome create_oak_forest() {
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
    gens.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.placed_trees_oak);
    return OverworldBiomeCreator.createBiome(Biome.Precipitation.RAIN, Biome.Category.FOREST, 0.7f, 0.8f, sps, gens, null);
  }

  public static Biome create_big_oak_forest() {
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
    gens.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.placed_trees_big_oak);
    return new Biome.Builder().precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST).temperature(0.7f).downfall(0.8f).effects(new BiomeEffects.Builder().grassColor(0x3ec836).foliageColor(0x1cbd14).waterColor(0x38a5db).waterFogColor(0x032436).fogColor(0xc0d8ff).skyColor(OverworldBiomeCreator.getSkyColor(0.7f)).moodSound(BiomeMoodSound.CAVE).music(null).build()).spawnSettings(sps.build()).generationSettings(gens.build()).build();
  }

  public static void register() {
    biome_oak_forest = create_oak_forest();
    biome_big_oak_forest = create_big_oak_forest();
    Registry.register(BuiltinRegistries.BIOME, key_biome_oak_forest.getValue(), biome_oak_forest);
    Registry.register(BuiltinRegistries.BIOME, key_biome_big_oak_forest.getValue(), biome_big_oak_forest);
  }

}
