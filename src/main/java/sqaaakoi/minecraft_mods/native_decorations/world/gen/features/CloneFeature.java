package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class CloneFeature extends Feature<CloneFeatureConfig> {
  public CloneFeature(Codec<CloneFeatureConfig> codec) {
    super(codec);
  }

  @Override
  public boolean generate(FeatureContext<CloneFeatureConfig> context) {
    CloneFeatureConfig c = context.getConfig();
    Random r = context.getRandom();
    StructureWorldAccess w = context.getWorld();
    ChunkGenerator g = context.getGenerator();
    BlockPos p = context.getOrigin();
    return c.feature.get().generateUnregistered(w, g, r, p);
  }
}
