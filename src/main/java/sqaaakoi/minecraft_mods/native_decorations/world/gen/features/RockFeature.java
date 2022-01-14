package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import java.util.Random;
import java.util.function.Function;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ChunkSectionCache;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class RockFeature extends Feature<DefaultFeatureConfig> {
  public RockFeature(Codec<DefaultFeatureConfig> configCodec) {
    super(configCodec);
  }

  @Override
  public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
    Random rand = context.getRandom();
    StructureWorldAccess w = context.getWorld();
    BlockPos pos = w.getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
    BlockState bs = context.getConfig().block();
    for (int i = 0; i < context.getConfig().tries(); i++) {
      BlockPos lbp = pos.add(rand.nextInt(10) - rand.nextInt(10), rand.nextInt(3) - rand.nextInt(3), rand.nextInt(10) - rand.nextInt(10));
      if (w.getBlockState(pos).isAir() && w.getBlockState(pos.offset(Direction.DOWN)) == Blocks.GRASS_BLOCK.getDefaultState()) {
        w.setBlockState(lbp, bs, 3);
      }
    }
    return true;
  }
}
