package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import sqaaakoi.minecraft_mods.native_decorations.Main;
import sqaaakoi.minecraft_mods.native_decorations.blocks.Blocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.Identifier;
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

  public static final ConfiguredFeature<?, ?> configured_cobblestone_rock = feature_rock.configure(new RockFeatureConfig(ConstantIntProvider.create(40), new SimpleBlockStateProvider(Blocks.cobblestone_rock.getDefaultState())));
  public static final RegistryKey<ConfiguredFeature<?, ?>> key_configured_cobblestone_rock = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Main.ID, "cobblestone_rock"));

  public static final PlacedFeature placed_cobblestone_rock = configured_cobblestone_rock.withPlacement(HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG), RarityFilterPlacementModifier.of(6));
  public static final RegistryKey<PlacedFeature> key_placed_cobblestone_rock = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Main.ID, "cobblestone_rock"));

  public static void register() {
    Registry.register(Registry.FEATURE, new Identifier(Main.ID, "rock"), feature_rock);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key_configured_cobblestone_rock.getValue(), configured_cobblestone_rock);
    Registry.register(BuiltinRegistries.PLACED_FEATURE, key_placed_cobblestone_rock.getValue(), placed_cobblestone_rock);
    BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.VEGETAL_DECORATION, key_placed_cobblestone_rock);
  }

}
