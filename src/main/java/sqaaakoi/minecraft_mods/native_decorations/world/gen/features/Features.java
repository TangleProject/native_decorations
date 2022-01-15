package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import sqaaakoi.minecraft_mods.native_decorations.Main;
import sqaaakoi.minecraft_mods.native_decorations.blocks.Blocks;
import sqaaakoi.minecraft_mods.native_decorations.blocks.LogPileBlock;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.Heightmap;
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
  private static final Feature<LogPileFeatureConfig> feature_log_pile = new LogPileFeature(LogPileFeatureConfig.CODEC);

  public static final ConfiguredFeature<?, ?> configured_cobblestone_rock = feature_rock.configure(new RockFeatureConfig(ConstantIntProvider.create(40), new SimpleBlockStateProvider(Blocks.cobblestone_rock.getDefaultState())));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_cobblestone_rock = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "cobblestone_rock"));
  public static final ConfiguredFeature<?, ?> configured_oak_log_pile = feature_log_pile.configure(new LogPileFeatureConfig(ConstantIntProvider.create(3), ConstantIntProvider.create(5), new SimpleBlockStateProvider(Blocks.oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.X)), new SimpleBlockStateProvider(Blocks.oak_log_pile.getDefaultState().with(LogPileBlock.AXIS, Direction.Axis.Z))));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_oak_log_pile = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "oak_log_pile"));

  public static final PlacedFeature placed_cobblestone_rock = configured_cobblestone_rock.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(6));
  public static final RegistryKey<PlacedFeature> key_placed_cobblestone_rock = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "cobblestone_rock"));
  public static final PlacedFeature placed_oak_log_pile = configured_oak_log_pile.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(6));
  public static final RegistryKey<PlacedFeature> key_placed_oak_log_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "oak_log_pile"));

  public static void register() {
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "rock"), feature_rock);
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "log_pile"), feature_log_pile);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_cobblestone_rock.getValue(), configured_cobblestone_rock);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_oak_log_pile.getValue(), configured_oak_log_pile);
    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_cobblestone_rock.getValue(), placed_cobblestone_rock);
    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_oak_log_pile.getValue(), placed_oak_log_pile);
    BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_cobblestone_rock);
    BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_oak_log_pile);
  }

}
