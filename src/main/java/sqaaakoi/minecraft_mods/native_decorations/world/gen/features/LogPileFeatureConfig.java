package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Random;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record RockFeatureConfig(IntProvider min_length, IntProvider max_length, BlockStateProvider block) implements FeatureConfig {
  public static final Codec<RockFeatureConfig> CODEC = RecordCodecBuilder.create(i -> i.group(
    IntProvider.VALUE_CODEC.fieldOf("min_length").forGetter(RockFeatureConfig::min_length),
    IntProvider.VALUE_CODEC.fieldOf("max_length").forGetter(RockFeatureConfig::max_length),
    BlockStateProvider.TYPE_CODEC.fieldOf("block_x").forGetter(RockFeatureConfig::block_x),
    BlockStateProvider.TYPE_CODEC.fieldOf("block_z").forGetter(RockFeatureConfig::block_z)
  ).apply(i, i.stable(RockFeatureConfig::new)));
}
