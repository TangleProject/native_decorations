package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.RandomFeatureEntry;

public class CloneFeature implements FeatureConfig {
    public static final Codec<CloneFeature> CODEC = RecordCodecBuilder.create(i -> i.apply2(CloneFeature::new, ((MapCodec)PlacedFeature.REGISTRY_CODEC.fieldOf("feature")).forGetter(a -> a.feature)));
    public final Supplier<PlacedFeature> feature;

    public CloneFeature(PlacedFeature feature) {
        this(() -> feature);
    }

    private CloneFeature(Supplier<PlacedFeature> feature) {
        this.feature = feature;
    }

    @Override
    public Stream<ConfiguredFeature<?, ?>> getDecoratedFeatures() {
        return Stream.concat(this.features.stream().flatMap(a -> a.feature.get().getDecoratedFeatures()), this.feature.get().getDecoratedFeatures());
    }
}
