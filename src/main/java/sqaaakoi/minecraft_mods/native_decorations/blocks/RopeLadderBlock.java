package sqaaakoi.minecraft_mods.native_decorations.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import javax.annotation.Nullable;

public class RopeLadderBlock extends LadderBlock implements Waterloggable {
  public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
  public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
  public static final BooleanProperty BOTTOM = BooleanProperty.of("bottom");
  protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
  protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
  protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape EAST_SHAPE_BOTTOM = Block.createCuboidShape(0.0, 5.0, 0.0, 3.0, 16.0, 16.0);
  protected static final VoxelShape WEST_SHAPE_BOTTOM = Block.createCuboidShape(13.0, 5.0, 0.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape SOUTH_SHAPE_BOTTOM = Block.createCuboidShape(0.0, 5.0, 0.0, 16.0, 16.0, 3.0);
  protected static final VoxelShape NORTH_SHAPE_BOTTOM = Block.createCuboidShape(0.0, 5.0, 13.0, 16.0, 16.0, 16.0);

  public RopeLadderBlock(AbstractBlock.Settings arg) {
    super(arg);
    this.setDefaultState(((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH).with(WATERLOGGED, false).with(BOTTOM, false));
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    if (state.get(BOTTOM)) {
      switch (state.get(FACING)) {
        case NORTH: {
          return NORTH_SHAPE_BOTTOM;
        }
        case SOUTH: {
          return SOUTH_SHAPE_BOTTOM;
        }
        case WEST: {
          return WEST_SHAPE_BOTTOM;
        }
      }
      return EAST_SHAPE_BOTTOM;
    }
    switch (state.get(FACING)) {
      case NORTH: {
        return NORTH_SHAPE;
      }
      case SOUTH: {
        return SOUTH_SHAPE;
      }
      case WEST: {
        return WEST_SHAPE;
      }
    }
    return EAST_SHAPE;
  }

  private boolean canPlaceOn(BlockView world, BlockPos pos, Direction side) {
    BlockState b = world.getBlockState(pos);
    BlockState al = world.getBlockState(pos.offset(side).offset(Direction.UP));
    return ((b.isSideSolidFullSquare(world, pos, side) && !((b.getBlock() instanceof RopeLadderBlock) && b.get(FACING).getOpposite().equals(side))) || (al.getBlock() instanceof RopeLadderBlock && al.get(FACING).equals(side)));
  }

  @Override
  public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
    Direction lv = state.get(FACING);
    return this.canPlaceOn(world, pos.offset(lv.getOpposite()), lv);
  }

  @Override
  public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
    if (direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos)) {
      return Blocks.AIR.getDefaultState();
    }
    if (direction == Direction.UP && !state.canPlaceAt(world, pos)) {
      return Blocks.AIR.getDefaultState();
    }
    if (direction == Direction.DOWN && !state.canPlaceAt(world, pos)) {
      return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
    if (state.get(WATERLOGGED).booleanValue()) {
      world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
    }
    BlockState b = world.getBlockState(pos.offset(state.get(FACING).getOpposite()));
    BlockState bl = world.getBlockState(pos.offset(Direction.DOWN));
    return state.with(BOTTOM, (!(bl.getBlock() instanceof RopeLadderBlock)  && !b.isSideSolidFullSquare(world, pos, state.get(FACING))));
  }

  @Override
  @Nullable
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    BlockState lv;
    if (!ctx.canReplaceExisting() && (lv = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(ctx.getSide().getOpposite()))).isOf(this) && lv.get(FACING) == ctx.getSide()) {
      return null;
    }
    lv = this.getDefaultState();
    World lv2 = ctx.getWorld();
    BlockPos lv3 = ctx.getBlockPos();
    FluidState lv4 = ctx.getWorld().getFluidState(ctx.getBlockPos());
    for (Direction lv5 : ctx.getPlacementDirections()) {
      if (!lv5.getAxis().isHorizontal() || !(lv = (BlockState)lv.with(FACING, lv5.getOpposite())).canPlaceAt(lv2, lv3)) continue;
      BlockState b = lv2.getBlockState(lv3.offset(lv.get(FACING).getOpposite()));
      BlockState bl = lv2.getBlockState(lv3.offset(Direction.DOWN));
      lv = lv.with(BOTTOM, (!(bl.getBlock() instanceof RopeLadderBlock) && !b.isSideSolidFullSquare(lv2, lv3, lv.get(FACING))));
      return (BlockState)lv.with(WATERLOGGED, lv4.getFluid() == Fluids.WATER);
    }
    return null;
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING, WATERLOGGED, BOTTOM);
  }

  private boolean isBlockMatchingRopeLadder(BlockState bs, World w, BlockPos p) {
    if (w.getBlockState(p).getBlock() instanceof RopeLadderBlock) {
      if (w.getBlockState(p).get(RopeLadderBlock.FACING).equals(bs.get(RopeLadderBlock.FACING))) {
        return true;
      }
    }
    return false;
  }

  // @Override
  // public ActionResult onUse(BlockState bs, World w, BlockPos p_, PlayerEntity pl, Hand h, BlockHitResult bhr) {
  //   BlockPos p = p_;
  //   if (pl.shouldCancelInteraction() && !isBlockMatchingRopeLadder(bs, w, p.offset(Direction.UP))) {
  //     p = p.offset(Direction.DOWN);
  //     while (w.isInBuildLimit(p)) {
  //       if (w.getBlockState(p).getBlock() instanceof RopeLadderBlock && w.getBlockState(p).get(RopeLadderBlock.FACING).equals(bs.get(RopeLadderBlock.FACING))) {
  //         p = p.offset(Direction.DOWN);
  //       } else {
  //         p = p.offset(Direction.UP);
  //         if (p.equals(p_)) {
  //           return ActionResult.FAIL;
  //         }
  //           // context.getStack().decrement(1);
  //           w.setBlockState(p, w.getFluidState(p).getBlockState(), 3);
  //           w.emitGameEvent(pl, GameEvent.BLOCK_DESTROY, p);
  //           return ActionResult.success(w.isClient);
  //       }
  //     }
  //     return ActionResult.FAIL;
  //   }
  //   return super.onUse(bs, w, p, pl, h, bhr);
  // }

}
