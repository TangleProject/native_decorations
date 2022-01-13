package sqaaakoi.minecraft_mods.native_decorations.blocks;

import java.util.Random;
import java.lang.SuppressWarnings;
import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MapColor;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.minecraft.world.BlockView;

public class LogPileBlock extends FallingBlock {

  public static final EnumProperty<Direction.Axis> AXIS = Properties.HORIZONTAL_AXIS;

  public static final Material MATERIAL = new Material.Builder(MapColor.OAK_TAN).lightPassesThrough().burnable().build();
  public static Block.Settings DEFAULT_SETTINGS = Block.Settings.of(MATERIAL).strength(2.0f).sounds(BlockSoundGroup.WOOD);

  public static final Material NETHER_MATERIAL = new Material.Builder(MapColor.OAK_TAN).lightPassesThrough().build();
  public static Block.Settings NETHER_SETTINGS = Block.Settings.of(NETHER_MATERIAL).strength(2.0f).sounds(BlockSoundGroup.NETHER_STEM);

  private static final VoxelShape MODEL_X_LOG0 = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 8.0);
  private static final VoxelShape MODEL_X_LOG1 = Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 8.0, 16.0);
  private static final VoxelShape MODEL_X_LOG2 = Block.createCuboidShape(0.0, 8.0, 4.0, 16.0, 16.0, 12.0);

  private static VoxelShape X_SHAPE = VoxelShapes.combineAndSimplify(MODEL_X_LOG0, VoxelShapes.combineAndSimplify(MODEL_X_LOG1, MODEL_X_LOG2, BooleanBiFunction.OR), BooleanBiFunction.OR);

  private static final VoxelShape MODEL_Z_LOG0 = Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 8.0, 16.0);
  private static final VoxelShape MODEL_Z_LOG1 = Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 8.0, 16.0);
  private static final VoxelShape MODEL_Z_LOG2 = Block.createCuboidShape(4.0, 8.0, 0.0, 12.0, 16.0, 16.0);

  private static VoxelShape Z_SHAPE = VoxelShapes.combineAndSimplify(MODEL_Z_LOG0, VoxelShapes.combineAndSimplify(MODEL_Z_LOG1, MODEL_Z_LOG2, BooleanBiFunction.OR), BooleanBiFunction.OR);

  public LogPileBlock() {
    this(DEFAULT_SETTINGS);
  }

  public LogPileBlock(Block.Settings settings) {
    super(settings);
    this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.X));
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(AXIS);
  }

  @Override
  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
  }

  @Override
  @SuppressWarnings("deprecation")
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    switch (state.get(AXIS)) {
      case Z: {
        return Z_SHAPE;
      }
    }
    return X_SHAPE;
  }

  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return this.getDefaultState().with(AXIS, ctx.getPlayerFacing().getAxis());
  }
}
