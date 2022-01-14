package sqaaakoi.minecraft_mods.native_decorations.items;

import sqaaakoi.minecraft_mods.native_decorations.blocks.RopeLadderBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import javax.annotation.Nullable;

public class RopeLadderItem extends BlockItem {
  public RopeLadderItem(Block b, Item.Settings s) {
    super(b, s);
  }

  @Override
  @Nullable
  public ItemPlacementContext getPlacementContext(ItemPlacementContext context) {
    BlockPos p = context.getBlockPos();
    World w = context.getWorld();
    BlockState bs = w.getBlockState(p);
    if (bs.getBlock().equals(this.getBlock())) {
      p = p.offset(Direction.DOWN);
      while (w.isInBuildLimit(p)) {
        if (w.getBlockState(p).getBlock().canReplace(w.getBlockState(p), context)) {
          return ItemPlacementContext.offset(context, p, bs.get(RopeLadderBlock.FACING));
        }
        p = p.offset(Direction.DOWN);
      }
      return null;
    }
    return context;
  }

  @Override
  protected boolean checkStatePlacement() {
    return false;
  }
}
