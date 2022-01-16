package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import sqaaakoi.minecraft_mods.native_decorations.Main;
import sqaaakoi.minecraft_mods.native_decorations.blocks.Blocks;
import sqaaakoi.minecraft_mods.native_decorations.blocks.LogPileBlock;
import java.util.Arrays;
import java.util.Collection;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.decorator.HeightmapPlacementModifier;
import net.minecraft.world.gen.decorator.PlacementModifierType;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class Features {

  private static final Feature<RockFeatureConfig> feature_rock = new RockFeature(RockFeatureConfig.CODEC);
  private static final Feature<BushFeatureConfig> feature_bush = new BushFeature(BushFeatureConfig.CODEC);
  private static final Feature<LogPileFeatureConfig> feature_log_pile = new LogPileFeature(LogPileFeatureConfig.CODEC);

  public static final ConfiguredFeature<?, ?> configured_cobblestone_rock = feature_rock.configure(new RockFeatureConfig(ConstantIntProvider.create(40), new SimpleBlockStateProvider(Blocks.cobblestone_rock.getDefaultState())));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_cobblestone_rock = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "cobblestone_rock"));
  public static final PlacedFeature placed_cobblestone_rock = configured_cobblestone_rock.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(6));
  public static final RegistryKey<PlacedFeature> key_placed_cobblestone_rock = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "cobblestone_rock"));

  public static final ConfiguredFeature<?, ?> configured_oak_log_pile = feature_log_pile.configure(new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_oak_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "oak_log_pile"));
  public static final PlacedFeature placed_oak_log_pile = configured_oak_log_pile.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_oak_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "oak_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_birch_log_pile = feature_log_pile.configure(new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.birch_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.birch_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_birch_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "birch_log_pile"));
  public static final PlacedFeature placed_birch_log_pile = configured_birch_log_pile.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_birch_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "birch_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_spruce_log_pile = feature_log_pile.configure(new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.spruce_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.spruce_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_spruce_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "spruce_log_pile"));
  public static final PlacedFeature placed_spruce_log_pile = configured_spruce_log_pile.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_spruce_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "spruce_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_jungle_log_pile = feature_log_pile.configure(new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.jungle_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.jungle_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_jungle_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "jungle_log_pile"));
  public static final PlacedFeature placed_jungle_log_pile = configured_jungle_log_pile.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_jungle_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "jungle_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_acacia_log_pile = feature_log_pile.configure(new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.acacia_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.acacia_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_acacia_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "acacia_log_pile"));
  public static final PlacedFeature placed_acacia_log_pile = configured_acacia_log_pile.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_acacia_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "acacia_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_dark_oak_log_pile = feature_log_pile.configure(new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.dark_oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.dark_oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_dark_oak_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "dark_oak_log_pile"));
  public static final PlacedFeature placed_dark_oak_log_pile = configured_dark_oak_log_pile.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_dark_oak_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "dark_oak_log_pile"));

  public static final ConfiguredFeature<?, ?> configured_oak_bush = feature_bush.configure(new LogPileFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.oak_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.oak_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_oak_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "oak_bush"));
  public static final PlacedFeature placed_oak_bush = configured_oak_bush.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_oak_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "oak_bush"));

  public static final ConfiguredFeature<?, ?> configured_birch_bush = feature_bush.configure(new LogPileFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.birch_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.birch_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_birch_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "birch_bush"));
  public static final PlacedFeature placed_birch_bush = configured_birch_bush.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_birch_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "birch_bush"));

  public static final ConfiguredFeature<?, ?> configured_spruce_bush = feature_bush.configure(new LogPileFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.spruce_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.spruce_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_spruce_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "spruce_bush"));
  public static final PlacedFeature placed_spruce_bush = configured_spruce_bush.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_spruce_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "spruce_bush"));

  public static final ConfiguredFeature<?, ?> configured_jungle_bush = feature_bush.configure(new LogPileFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.jungle_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.jungle_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_jungle_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "jungle_bush"));
  public static final PlacedFeature placed_jungle_bush = configured_jungle_bush.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_jungle_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "jungle_bush"));

  public static final ConfiguredFeature<?, ?> configured_acacia_bush = feature_bush.configure(new LogPileFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.acacia_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.acacia_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_acacia_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "acacia_bush"));
  public static final PlacedFeature placed_acacia_bush = configured_acacia_bush.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_acacia_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "acacia_bush"));

  public static final ConfiguredFeature<?, ?> configured_dark_oak_bush = feature_bush.configure(new LogPileFeatureConfig(ConstantIntProvider.create(24), new SimpleBlockStateProvider(Blocks.dark_oak_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, false)), new SimpleBlockStateProvider(Blocks.dark_oak_bush.getDefaultState().with(BushyBushBlock.BUSHY_BUSH, true))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_dark_oak_bush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "dark_oak_bush"));
  public static final PlacedFeature placed_dark_oak_bush = configured_dark_oak_bush.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(3));
  public static final RegistryKey<PlacedFeature> key_placed_dark_oak_bush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "dark_oak_bush"));

  public static Collection<RegistryKey<Biome>> OAK_BIOMES = Arrays.asList(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.SWAMP);
  public static Collection<RegistryKey<Biome>> BIRCH_BIOMES = Arrays.asList(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);
  public static Collection<RegistryKey<Biome>> SPRUCE_BIOMES = Arrays.asList(BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA);
  public static Collection<RegistryKey<Biome>> JUNGLE_BIOMES = Arrays.asList(BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE);
  public static Collection<RegistryKey<Biome>> ACACIA_BIOMES = Arrays.asList(BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.WINDSWEPT_SAVANNA);
  public static Collection<RegistryKey<Biome>> DARK_OAK_BIOMES = Arrays.asList(BiomeKeys.DARK_FOREST);

  public static void register() {
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "rock"), feature_rock);
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "bush"), feature_bush);
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "log_pile"), feature_log_pile);

    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_cobblestone_rock.getValue(), configured_cobblestone_rock);
    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_cobblestone_rock.getValue(), placed_cobblestone_rock);
    BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_cobblestone_rock);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_oak_log_pile.getValue(), placed_oak_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_oak_log_pile.getValue(), configured_oak_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(OAK_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_oak_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_birch_log_pile.getValue(), placed_birch_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_birch_log_pile.getValue(), configured_birch_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(BIRCH_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_birch_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_spruce_log_pile.getValue(), placed_spruce_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_spruce_log_pile.getValue(), configured_spruce_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(SPRUCE_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_spruce_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_jungle_log_pile.getValue(), placed_jungle_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_jungle_log_pile.getValue(), configured_jungle_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(JUNGLE_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_jungle_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_acacia_log_pile.getValue(), placed_acacia_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_acacia_log_pile.getValue(), configured_acacia_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(ACACIA_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_acacia_log_pile);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_dark_oak_log_pile.getValue(), placed_dark_oak_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_dark_oak_log_pile.getValue(), configured_dark_oak_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(DARK_OAK_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_dark_oak_log_pile);

    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_cobblestone_rock.getValue(), configured_cobblestone_rock);
    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_cobblestone_rock.getValue(), placed_cobblestone_rock);
    BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_cobblestone_rock);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_oak_bush.getValue(), placed_oak_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_oak_bush.getValue(), configured_oak_bush);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(OAK_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_oak_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_birch_bush.getValue(), placed_birch_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_birch_bush.getValue(), configured_birch_bush);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(BIRCH_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_birch_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_spruce_bush.getValue(), placed_spruce_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_spruce_bush.getValue(), configured_spruce_bush);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(SPRUCE_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_spruce_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_jungle_bush.getValue(), placed_jungle_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_jungle_bush.getValue(), configured_jungle_bush);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(JUNGLE_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_jungle_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_acacia_bush.getValue(), placed_acacia_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_acacia_bush.getValue(), configured_acacia_bush);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(ACACIA_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_acacia_bush);

    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_dark_oak_bush.getValue(), placed_dark_oak_bush);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_dark_oak_bush.getValue(), configured_dark_oak_bush);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(DARK_OAK_BIOMES), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_dark_oak_bush);

  }

}
