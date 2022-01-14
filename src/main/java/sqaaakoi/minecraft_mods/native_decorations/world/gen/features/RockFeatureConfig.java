package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import sqaaakoi.minecraft_mods.native_decorations.tags.BlockTags;
import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record RockFeatureConfig(IntProvider tries, BlockStateProvider block) implements FeatureConfig {
  public static final Codec<RockFeatureConfig> CODEC = RecordCodecBuilder.create(i -> i.group(
    IntProvider.VALUE_CODEC.fieldOf("tries").forGetter(RockFeatureConfig::tries),
    BlockStateProvider.TYPE_CODEC.fieldOf("block").forGetter(RockFeatureConfig::block)
  ).apply(i, instance.stable(RockFeatureConfig::new)));
}
