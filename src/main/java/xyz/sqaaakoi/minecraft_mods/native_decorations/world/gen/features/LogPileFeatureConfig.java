package xyz.sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record LogPileFeatureConfig(IntProvider min_length, IntProvider max_length, BlockStateProvider block_x, BlockStateProvider block_z) implements FeatureConfig {
  public static final Codec<LogPileFeatureConfig> CODEC = RecordCodecBuilder.create(i -> i.group(
    IntProvider.VALUE_CODEC.fieldOf("min_length").forGetter(LogPileFeatureConfig::min_length),
    IntProvider.VALUE_CODEC.fieldOf("max_length").forGetter(LogPileFeatureConfig::max_length),
    BlockStateProvider.TYPE_CODEC.fieldOf("block_x").forGetter(LogPileFeatureConfig::block_x),
    BlockStateProvider.TYPE_CODEC.fieldOf("block_z").forGetter(LogPileFeatureConfig::block_z)
  ).apply(i, i.stable(LogPileFeatureConfig::new)));
}
