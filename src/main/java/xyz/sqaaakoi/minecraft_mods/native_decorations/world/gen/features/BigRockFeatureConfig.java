package xyz.sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.util.math.floatprovider.FloatProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record BigRockFeatureConfig(BlockStateProvider block, BlockStateProvider alt_block, FloatProvider chance) implements FeatureConfig {
  public static final Codec<BigRockFeatureConfig> CODEC = RecordCodecBuilder.create(i -> i.group(
    BlockStateProvider.TYPE_CODEC.fieldOf("block").forGetter(BigRockFeatureConfig::block),
    BlockStateProvider.TYPE_CODEC.fieldOf("alt_block").forGetter(BigRockFeatureConfig::alt_block),
    FloatProvider.VALUE_CODEC.fieldOf("chance").forGetter(BigRockFeatureConfig::chance)
  ).apply(i, i.stable(BigRockFeatureConfig::new)));
}
