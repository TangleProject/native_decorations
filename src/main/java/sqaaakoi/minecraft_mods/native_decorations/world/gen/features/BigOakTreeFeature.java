package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.feature.TreePlacedFeatures;

public class BigOakTreeFeature extends Feature<DefaultFeatureConfig> {
  public BigOakTreeFeature(Codec<DefaultFeatureConfig> codec) {
    super(codec);
  }

  @Override
  public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
    Random r = context.getRandom();
    StructureWorldAccess w = context.getWorld();
    ChunkGenerator g = context.getGenerator();
    BlockPos p = context.getOrigin();
    return TreePlacedFeatures.FANCY_OAK_BEES_0002.generateUnregistered(w, g, r, p);
  }
}
