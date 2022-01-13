package sqaaakoi.minecraft_mods.native_decorations.blocks;

import java.util.Random;
import java.lang.SuppressWarnings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldEvents;
import net.minecraft.server.world.ServerWorld;

public class BushyBushBlock extends BushBlock {

  private static VoxelShape BUSH_SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 10.0, 13.0);
  private static VoxelShape BUSHY_BUSH_SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
  public static BooleanProperty BUSHY_BUSH = BooleanProperty.of("bushy");

  public BushyBushBlock() {
    this(DEFAULT_SETTINGS);
  }
  public BushyBushBlock(Block.Settings settings) {
    super(settings);
    this.setDefaultState(this.stateManager.getDefaultState().with(BUSHY_BUSH, false));
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(BUSHY_BUSH);
  }

  public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
    return !state.get(BUSHY_BUSH);
  }

  public boolean canGrow(World world, Random rand, BlockPos pos, BlockState state) {
    return !state.get(BUSHY_BUSH);
  }

  public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
    if (!state.get(BUSHY_BUSH)) {
      world.setBlockState(pos, state.with(BUSHY_BUSH, true), 3);
    }
  }

  @Override
  @SuppressWarnings("deprecation")
  public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
    entity.slowMovement(state, state.get(BUSHY_BUSH) ? (new Vec3d(0.45D, 0.15D, 0.45D)) : (new Vec3d(0.85D, 0.65D, 0.85D)));
  }

  @Override
  @SuppressWarnings("deprecation")
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return state.get(BUSHY_BUSH) ? BUSHY_BUSH_SHAPE : BUSH_SHAPE;
  }
}
