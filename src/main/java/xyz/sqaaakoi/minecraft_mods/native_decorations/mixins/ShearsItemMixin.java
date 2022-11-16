package xyz.sqaaakoi.minecraft_mods.native_decorations.mixins;

import xyz.sqaaakoi.minecraft_mods.native_decorations.Main;
import xyz.sqaaakoi.minecraft_mods.native_decorations.blocks.Blocks;
import xyz.sqaaakoi.minecraft_mods.native_decorations.blocks.BushyBushBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.objectweb.asm.Opcodes;
import javax.annotation.Nullable;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import java.util.Map;

@Mixin(ShearsItem.class)
public class ShearsItemMixin {

  @Inject(method = "useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;", at = @At("HEAD"), cancellable = true)
  public void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
    World w = context.getWorld();
    BlockPos pos = context.getBlockPos();
    BlockState bs = w.getBlockState(pos);
    if (bs.getBlock() instanceof BushyBushBlock) {
      if (bs.get(BushyBushBlock.BUSHY_BUSH)) {
        PlayerEntity pl = context.getPlayer();
        ItemStack is = context.getStack();
        if (pl instanceof ServerPlayerEntity) {
          Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)pl, pos, is);
        }
        BlockSoundGroup k = bs.getBlock().getSoundGroup(bs);
        w.syncWorldEvent(pl, WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(bs));
        w.setBlockState(pos, bs.with(BushyBushBlock.BUSHY_BUSH, false));
        if (pl != null) {
          is.damage(1, pl, pl_ -> pl_.sendToolBreakStatus(context.getHand()));
        }
        cir.setReturnValue(ActionResult.success(w.isClient));
      } else {
        cir.setReturnValue(ActionResult.PASS);
      }
    }
  }

  @Inject(method = "getMiningSpeedMultiplier(Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/BlockState;)F", at = @At("HEAD"), cancellable = true)
  public void getMiningSpeedMultiplier(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir) {
    if (state.isOf(Blocks.rope_ladder)) {
      cir.setReturnValue(3.0f);
    }
  }

}
