package sqaaakoi.minecraft_mods.native_decorations.items;

import sqaaakoi.minecraft_mods.native_decorations.blocks.RopeLadderBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import javax.annotation.Nullable;

public class RopeLadderItem extends BlockItem {
  public RopeLadderItem(Block b, Item.Settings s) {
    super(b, s);
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    BlockPos p = context.getBlockPos();
    PlayerEntity pl = context.getPlayer();
    World w = context.getWorld();
    BlockState bs = w.getBlockState(p);
    if (bs.getBlock().equals(this.getBlock()) && !pl.shouldCancelInteraction()) {
      p = p.offset(Direction.DOWN);
      while (w.isInBuildLimit(p)) {
        if (w.getBlockState(p).getBlock() instanceof RopeLadderBlock) {
          if (w.getBlockState(p).get(RopeLadderBlock.FACING).equals(bs.get(RopeLadderBlock.FACING))) {
            p = p.offset(Direction.DOWN);
          } else {
            break;
          }
        } else {
          if (w.getBlockState(p).getBlock().canReplace(w.getBlockState(p), new ItemPlacementContext(context))) {
            BlockState b = w.getBlockState(p.offset(bs.get(RopeLadderBlock.FACING).getOpposite()));
            BlockState bl = w.getBlockState(p.offset(Direction.DOWN));
            FluidState fs = w.getFluidState(p);
            context.getStack().decrement(1);
            w.setBlockState(p, bs.with(RopeLadderBlock.WATERLOGGED, fs.getFluid() == Fluids.WATER).with(RopeLadderBlock.BOTTOM,  (!(bl.getBlock() instanceof RopeLadderBlock) && !b.isSideSolidFullSquare(w, p, bs.get(RopeLadderBlock. FACING)))), 3);
            w.playSound(pl, p, this.getPlaceSound(bs), SoundCategory.BLOCKS, (bs.getSoundGroup().getVolume() + 1.0f) / 2.0f, bs.getSoundGroup().getPitch() * 0.8f);
            w.emitGameEvent(pl, GameEvent.BLOCK_PLACE, p);
            pl.swingHand(context.getHand(), true);
            return ActionResult.success(w.isClient);
          } else {
            break;
          }
        }
      }
      return ActionResult.FAIL;
    }
    return super.useOnBlock(context);
  }

}
