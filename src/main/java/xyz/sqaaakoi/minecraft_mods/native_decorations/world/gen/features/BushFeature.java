package xyz.sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ChunkSectionCache;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BushFeature extends Feature<BushFeatureConfig> {
  public BushFeature(Codec<BushFeatureConfig> configCodec) {
    super(configCodec);
  }

  @Override
  public boolean generate(FeatureContext<BushFeatureConfig> context) {
    Random rand = context.getRandom();
    StructureWorldAccess w = context.getWorld();
    BlockPos pos = w.getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
    for (int i = 0; i < context.getConfig().tries().get(rand); i++) {
      BlockPos lbp = pos.add(rand.nextInt(4) - rand.nextInt(4), rand.nextInt(2) - rand.nextInt(2), rand.nextInt(4) - rand.nextInt(4));
      if (w.getBlockState(lbp).isAir() && w.getBlockState(lbp.offset(Direction.DOWN)) == Blocks.GRASS_BLOCK.getDefaultState()) {
        BlockState bs = (rand.nextBoolean() ? context.getConfig().block() : context.getConfig().block_bushy()).getBlockState(rand, lbp);
        w.setBlockState(lbp, bs, 3);
      }
    }
    return true;
  }
}
