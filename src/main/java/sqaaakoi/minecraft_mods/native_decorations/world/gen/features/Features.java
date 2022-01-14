package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import sqaaakoi.minecraft_mods.native_decorations.Main;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.decorator.HeightmapPlacementModifier;
import net.minecraft.world.gen.decorator.PlacementModifierType;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class Features {

  private static final Feature<RockFeatureConfig> feature_rock = new RockFeature(RockFeatureConfig.CODEC);

  public static final ConfiguredFeature<?, ?> configured_rock = feature_rock.configure(new RockFeatureConfig(ConstantIntProvider.create(40), new SimpleBlockStateProvider(Blocks.STONE.getDefaultState())))
      .decorate(PlacementModifierType.HEIGHTMAP.configure(new HeightmapPlacementModifier(Heightmap.Type.OCEAN_FLOOR_WG)))
      .withPlacement(RarityFilterPlacementModifier.of(6));

  public static void register() {
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.ID, "rock"), rocks);
  }

}
