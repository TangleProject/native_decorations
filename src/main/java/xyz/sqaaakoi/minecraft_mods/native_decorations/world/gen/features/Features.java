package xyz.sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import xyz.sqaaakoi.minecraft_mods.native_decorations.Main;
import xyz.sqaaakoi.minecraft_mods.native_decorations.blocks.Blocks;
import xyz.sqaaakoi.minecraft_mods.native_decorations.blocks.BushyBushBlock;
import xyz.sqaaakoi.minecraft_mods.native_decorations.blocks.LogPileBlock;
import java.util.List;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.feature.TreePlacedFeatures;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class Features {

  public static TagKey<Biome> OAK_BIOMES = TagKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "has_oak_wood")); // Arrays.asList(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.SWAMP, Biomes.key_biome_oak_forest, Biomes.key_biome_big_oak_forest);
  public static TagKey<Biome> BIRCH_BIOMES = TagKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "has_birch_wood")); // Arrays.asList(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);
  public static TagKey<Biome> SPRUCE_BIOMES = TagKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "has_spruce_wood")); // Arrays.asList(BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA);
  public static TagKey<Biome> JUNGLE_BIOMES = TagKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "has_jungle_wood")); // Arrays.asList(BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE);
  public static TagKey<Biome> ACACIA_BIOMES = TagKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "has_acacia_wood")); // Arrays.asList(BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.WINDSWEPT_SAVANNA);
  public static TagKey<Biome> DARK_OAK_BIOMES = TagKey.of(Registry.BIOME_KEY, new Identifier(Main.ID, "has_dark_oak_wood")); // Arrays.asList(BiomeKeys.DARK_FOREST);

  private static final Feature<RockFeatureConfig> feature_rock = new RockFeature(RockFeatureConfig.CODEC);
  private static final Feature<BushFeatureConfig> feature_bush = new BushFeature(BushFeatureConfig.CODEC);
  private static final Feature<DefaultFeatureConfig> feature_big_oak_tree = new BigOakTreeFeature(DefaultFeatureConfig.CODEC);
  private static final Feature<LogPileFeatureConfig> feature_log_pile = new LogPileFeature(LogPileFeatureConfig.CODEC);

  public static final ConfiguredFeature<?, ?> configured_trees_oak = new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(TreePlacedFeatures.FANCY_OAK_BEES_0002, 0.1f)), TreePlacedFeatures.OAK_BEES_0002));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_trees_oak = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "trees_oak"));
  public static final PlacedFeature placed_trees_oak = new PlacedFeature(RegistryEntry.of(configured_trees_oak), VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(10, 0.1f, 1)));
  public static final RegistryKey<PlacedFeature> key_placed_trees_oak = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "trees_oak"));

  public static final ConfiguredFeature<?, ?> configured_trees_big_oak = new ConfiguredFeature<>(feature_big_oak_tree, DefaultFeatureConfig.INSTANCE);
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_trees_big_oak = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "trees_big_oak"));
  public static final PlacedFeature placed_trees_big_oak = new PlacedFeature(RegistryEntry.of(configured_trees_big_oak), VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(6, 0.1f, 1)));
  public static final RegistryKey<PlacedFeature> key_placed_trees_big_oak = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "trees_big_oak"));

  public static final ConfiguredFeature<?, ?> configured_cobblestone_rock = new ConfiguredFeature<>(feature_rock, new RockFeatureConfig(ConstantIntProvider.create(40), new SimpleBlockStateProvider(Blocks.cobblestone_rock.getDefaultState())));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_cobblestone_rock = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "cobblestone_rock"));
  public static final PlacedFeature placed_cobblestone_rock = new PlacedFeature(RegistryEntry.of(configured_cobblestone_rock), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(5)));
  public static final RegistryKey<PlacedFeature> key_placed_cobblestone_rock = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "cobblestone_rock"));

  public static final ConfiguredFeature<?, ?> configured_oak_log_pile = new ConfiguredFeature<>(feature_log_pile, new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_oak_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "oak_log_pile"));
  public static final PlacedFeature placed_oak_log_pile = new PlacedFeature(RegistryEntry.of(configured_oak_log_pile), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(5)));
  public static final RegistryKey<PlacedFeature> key_placed_oak_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "oak_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_birch_log_pile = new ConfiguredFeature<>(feature_log_pile, new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.birch_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.birch_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_birch_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "birch_log_pile"));
  public static final PlacedFeature placed_birch_log_pile = new PlacedFeature(RegistryEntry.of(configured_birch_log_pile), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(5)));
  public static final RegistryKey<PlacedFeature> key_placed_birch_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "birch_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_spruce_log_pile = new ConfiguredFeature<>(feature_log_pile, new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.spruce_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.spruce_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_spruce_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "spruce_log_pile"));
  public static final PlacedFeature placed_spruce_log_pile = new PlacedFeature(RegistryEntry.of(configured_spruce_log_pile), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(5)));
  public static final RegistryKey<PlacedFeature> key_placed_spruce_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "spruce_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_jungle_log_pile = new ConfiguredFeature<>(feature_log_pile, new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.jungle_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.jungle_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_jungle_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "jungle_log_pile"));
  public static final PlacedFeature placed_jungle_log_pile = new PlacedFeature(RegistryEntry.of(configured_jungle_log_pile), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(5)));
  public static final RegistryKey<PlacedFeature> key_placed_jungle_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "jungle_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_acacia_log_pile = new ConfiguredFeature<>(feature_log_pile, new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.acacia_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.acacia_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_acacia_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "acacia_log_pile"));
  public static final PlacedFeature placed_acacia_log_pile = new PlacedFeature(RegistryEntry.of(configured_acacia_log_pile), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(5)));
  public static final RegistryKey<PlacedFeature> key_placed_acacia_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "acacia_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_dark_oak_log_pile = new ConfiguredFeature<>(feature_log_pile, new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.dark_oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.dark_oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_dark_oak_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "dark_oak_log_pile"));
  public static final PlacedFeature placed_dark_oak_log_pile = new PlacedFeature(RegistryEntry.of(configured_dark_oak_log_pile), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(5)));
  public static final RegistryKey<PlacedFeature> key_placed_dark_oak_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "dark_oak_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_oak_bush = new ConfiguredFeature<>(feature_bush, new BushFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.oak_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.oak_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_oak_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "oak_bush"));
  public static final PlacedFeature placed_oak_bush = new PlacedFeature(RegistryEntry.of(configured_oak_bush), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3)));
  public static final RegistryKey<PlacedFeature> key_placed_oak_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "oak_bush"));

  public static final ConfiguredFeature<?, ?> configured_birch_bush = new ConfiguredFeature<>(feature_bush, new BushFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.birch_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.birch_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_birch_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "birch_bush"));
  public static final PlacedFeature placed_birch_bush = new PlacedFeature(RegistryEntry.of(configured_birch_bush), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3)));
  public static final RegistryKey<PlacedFeature> key_placed_birch_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "birch_bush"));

  public static final ConfiguredFeature<?, ?> configured_spruce_bush = new ConfiguredFeature<>(feature_bush, new BushFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.spruce_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.spruce_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_spruce_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "spruce_bush"));
  public static final PlacedFeature placed_spruce_bush = new PlacedFeature(RegistryEntry.of(configured_spruce_bush), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3)));
  public static final RegistryKey<PlacedFeature> key_placed_spruce_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "spruce_bush"));

  public static final ConfiguredFeature<?, ?> configured_jungle_bush = new ConfiguredFeature<>(feature_bush, new BushFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.jungle_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.jungle_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_jungle_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "jungle_bush"));
  public static final PlacedFeature placed_jungle_bush = new PlacedFeature(RegistryEntry.of(configured_jungle_bush), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3)));
  public static final RegistryKey<PlacedFeature> key_placed_jungle_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "jungle_bush"));

  public static final ConfiguredFeature<?, ?> configured_acacia_bush = new ConfiguredFeature<>(feature_bush, new BushFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.acacia_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.acacia_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_acacia_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "acacia_bush"));
  public static final PlacedFeature placed_acacia_bush = new PlacedFeature(RegistryEntry.of(configured_acacia_bush), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3)));
  public static final RegistryKey<PlacedFeature> key_placed_acacia_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "acacia_bush"));

  public static final ConfiguredFeature<?, ?> configured_dark_oak_bush = new ConfiguredFeature<>(feature_bush, new BushFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.dark_oak_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.dark_oak_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_dark_oak_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "dark_oak_bush"));
  public static final PlacedFeature placed_dark_oak_bush = new PlacedFeature(RegistryEntry.of(configured_dark_oak_bush), List.of(SquarePlacementModifier.of(), BiomePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3)));
  public static final RegistryKey<PlacedFeature> key_placed_dark_oak_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "dark_oak_bush"));

  public static void register() {
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "rock"), feature_rock);
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "bush"), feature_bush);
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "big_oak_tree"), feature_big_oak_tree);
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "log_pile"), feature_log_pile);

    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_trees_oak.getValue(), configured_trees_oak);
    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_trees_oak.getValue(), placed_trees_oak);

    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_trees_big_oak.getValue(), configured_trees_big_oak);
    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_trees_big_oak.getValue(), placed_trees_big_oak);

    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_cobblestone_rock.getValue(), configured_cobblestone_rock);
    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_cobblestone_rock.getValue(), placed_cobblestone_rock);
    BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_cobblestone_rock);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_oak_log_pile.getValue(), placed_oak_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_oak_log_pile.getValue(), configured_oak_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.tag(OAK_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_oak_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_birch_log_pile.getValue(), placed_birch_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_birch_log_pile.getValue(), configured_birch_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.tag(BIRCH_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_birch_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_spruce_log_pile.getValue(), placed_spruce_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_spruce_log_pile.getValue(), configured_spruce_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.tag(SPRUCE_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_spruce_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_jungle_log_pile.getValue(), placed_jungle_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_jungle_log_pile.getValue(), configured_jungle_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.tag(JUNGLE_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_jungle_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_acacia_log_pile.getValue(), placed_acacia_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_acacia_log_pile.getValue(), configured_acacia_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.tag(ACACIA_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_acacia_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_dark_oak_log_pile.getValue(), placed_dark_oak_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_dark_oak_log_pile.getValue(), configured_dark_oak_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.tag(DARK_OAK_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_dark_oak_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_oak_bush.getValue(), placed_oak_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_oak_bush.getValue(), configured_oak_bush);
    BiomeModifications.addFeature(BiomeSelectors.tag(OAK_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_oak_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_birch_bush.getValue(), placed_birch_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_birch_bush.getValue(), configured_birch_bush);
    BiomeModifications.addFeature(BiomeSelectors.tag(BIRCH_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_birch_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_spruce_bush.getValue(), placed_spruce_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_spruce_bush.getValue(), configured_spruce_bush);
    BiomeModifications.addFeature(BiomeSelectors.tag(SPRUCE_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_spruce_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_jungle_bush.getValue(), placed_jungle_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_jungle_bush.getValue(), configured_jungle_bush);
    BiomeModifications.addFeature(BiomeSelectors.tag(JUNGLE_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_jungle_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_acacia_bush.getValue(), placed_acacia_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_acacia_bush.getValue(), configured_acacia_bush);
    BiomeModifications.addFeature(BiomeSelectors.tag(ACACIA_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_acacia_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_dark_oak_bush.getValue(), placed_dark_oak_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_dark_oak_bush.getValue(), configured_dark_oak_bush);
    BiomeModifications.addFeature(BiomeSelectors.tag(DARK_OAK_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_dark_oak_bush);

  }

}
