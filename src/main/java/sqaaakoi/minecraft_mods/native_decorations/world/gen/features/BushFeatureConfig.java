package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Random;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record BushFeatureConfig(IntProvider tries, BlockStateProvider block, BlockStateProvider block_bushy) implements FeatureConfig {
  public static final Codec<BushFeatureConfig> CODEC = RecordCodecBuilder.create(i -> i.group(
    IntProvider.VALUE_CODEC.fieldOf("tries").forGetter(BushFeatureConfig::tries),
    BlockStateProvider.TYPE_CODEC.fieldOf("block").forGetter(BushFeatureConfig::block),
    BlockStateProvider.TYPE_CODEC.fieldOf("block_bushy").forGetter(BushFeatureConfig::block_bushy)
  ).apply(i, i.stable(BushFeatureConfig::new)));
}
