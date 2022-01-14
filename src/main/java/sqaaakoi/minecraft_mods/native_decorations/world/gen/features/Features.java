package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import sqaaakoi.minecraft_mods.native_decorations.Main;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;

public class Features {

  private static final Feature<SpiralFeatureConfig> feature_rock = new RockFeature(RockFeatureConfig.CODEC);

  public static final ConfiguredFeature<?, ?> configured_rock = feature_rock.configure(new RockFeatureConfig(ConstantIntProvider.create(40), new SimpleBlockStateProvider(Blocks.STONE.getDefaultState())))
      .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR_WG)))
      .withPlacement(RarityFilterPlacementModifier.of(6));

  public static void register() {
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.ID, "rock"), rocks);
  }

}
