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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.minecraft.world.BlockView;

public class RockBlock extends FallingBlock {

  private static final Material MATERIAL = new Material.Builder(MapColor.STONE_GRAY).lightPassesThrough().destroyedByPiston().build();

  private static final VoxelShape ROCK_X = Block.createCuboidShape(2.0, 0.0, 4.0, 14.0, 6.0, 12.0);
  private static final VoxelShape ROCK_Z = Block.createCuboidShape(4.0, 0.0, 2.0, 12.0, 6.0, 14.0);
  private static final VoxelShape ROCK_Y = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);

  private static VoxelShape ROCK_SHAPE = VoxelShapes.combineAndSimplify(ROCK_Y, VoxelShapes.combineAndSimplify(ROCK_X, ROCK_Z, BooleanBiFunction.OR), BooleanBiFunction.OR);

  public RockBlock() {
    super(Block.Settings.of(MATERIAL).strength(0.35f).sounds(BlockSoundGroup.STONE));
  }

  @Override
  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
  }

  @Override
  @SuppressWarnings("deprecation")
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return ROCK_SHAPE;
  }
}
