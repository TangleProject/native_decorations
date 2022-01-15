package sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import com.mojang.serialization.Codec;
import java.util.ArrayList;
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

public class LogPileFeature extends Feature<LogPileFeatureConfig> {
  public LogPileFeature(Codec<LogPileFeatureConfig> configCodec) {
    super(configCodec);
  }

  @Override
  public boolean generate(FeatureContext<LogPileFeatureConfig> context) {
    Random rand = context.getRandom();
    StructureWorldAccess w = context.getWorld();
    BlockPos pos = w.getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
    BlockPos initPos = pos;
    Direction logDir = Direction.fromHorizontal(rand.nextInt(4));
    ArrayList<BlockPos> logsPos = new ArrayList<>();
    int minLen = context.getConfig().min_length().get(rand);
    int maxLen = context.getConfig().max_length().get(rand);
    int len = rand.nextInt(maxLen - minLen) + minLen;
    int curLen = 0;
    while (curLen < len) {
      if (isValid(pos, w) && isValid(pos.offset(logDir.rotateYClockwise()), w) && isValid(pos.offset(logDir.rotateYCounterclockwise()), w) && isValid(pos.offset(logDir), w)) {
        logsPos.add(pos);
        pos = pos.offset(logDir);
        curLen++;
      } else {
        break;
      }
    }
    if (curLen < minLen || !isValid(initPos.offset(logDir.getOpposite()), w)) {
      return false;
    }
    for (BlockPos lp : logsPos) {
      BlockState lbs = (logDir.getAxis() == Direction.Axis.X ? context.getConfig().block_x() : context.getConfig().block_z()).getBlockState(rand, lp);
      w.setBlockState(lp, lbs, 3);
      w.setBlockState(lp.offset(Direction.DOWN), Blocks.DIRT.getDefaultState(), 3);
    }
    return true;
  }

  private boolean isValid(BlockPos p, StructureWorldAccess w) {
    return w.getBlockState(p).isAir() && w.getBlockState(p.offset(Direction.DOWN)) == Blocks.GRASS_BLOCK.getDefaultState();
  }
}
