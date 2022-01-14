package sqaaakoi.minecraft_mods.native_decorations.items;

import sqaaakoi.minecraft_mods.native_decorations.blocks.RopeLadderBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
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
    if (bs.getBlock().equals(this.getBlock())) {
      p = p.offset(Direction.DOWN);
      while (w.isInBuildLimit(p)) {
        if (w.getBlockState(p).getBlock() instanceof RopeLadderBlock) {
          p = p.offset(Direction.DOWN);
        } else {
          if (w.getBlockState(p).getBlock().canReplace(w.getBlockState(p), new ItemPlacementContext(context))) {
            BlockState b = w.getBlockState(p.offset(bs.get(RopeLadderBlock.FACING).getOpposite()));
            BlockState bl = w.getBlockState(p.offset(Direction.DOWN));
            w.setBlockState(p, bs.with(RopeLadderBlock.BOTTOM,  (!(bl.getBlock() instanceof RopeLadderBlock) && !b.isSideSolidFullSquare(w, p, bs.get(RopeLadderBlock. FACING)))), 2);
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





    // World lv = context.getWorld();
    // BlockPos lv2 = context.getBlockPos();
    // BlockPos lv3 = lv2.offset(context.getSide());
    // if (BoneMealItem.useOnFertilizable(context.getStack(), lv, lv2)) {
    //     if (!lv.isClient) {
    //         lv.syncWorldEvent(WorldEvents.BONE_MEAL_USED, lv2, 0);
    //     }
    //     return ActionResult.success(lv.isClient);
    // }
    // BlockState lv4 = lv.getBlockState(lv2);
    // boolean bl = lv4.isSideSolidFullSquare(lv, lv2, context.getSide());
    // if (bl && BoneMealItem.useOnGround(context.getStack(), lv, lv3, context.getSide())) {
    //     if (!lv.isClient) {
    //         lv.syncWorldEvent(WorldEvents.BONE_MEAL_USED, lv3, 0);
    //     }
    //     return ActionResult.success(lv.isClient);
    // }
    // return ActionResult.PASS;
}

  // @Override
  // @Nullable
  // public ItemPlacementContext getPlacementContext(ItemPlacementContext context) {
  //   BlockPos p = context.getBlockPos();
  //   World w = context.getWorld();
  //   w.setBlockState(p, net.minecraft.block.Blocks.STONE.getDefaultState(), 0);
  //   return context;
    // BlockState bs = w.getBlockState(p);
    // if (bs.getBlock().equals(this.getBlock())) {
    //   p = p.offset(Direction.DOWN);
    //   while (w.isInBuildLimit(p)) {
    //     if (w.getBlockState(p).getBlock().canReplace(w.getBlockState(p), context)) {
    //       return ItemPlacementContext.offset(context, p, bs.get(RopeLadderBlock.FACING));
    //     }
    //     p = p.offset(Direction.DOWN);
    //   }
    //   return null;
    // }
    // return context;
  // }
  //
  // @Override
  // protected boolean checkStatePlacement() {
  //   return false;
  // }
}
