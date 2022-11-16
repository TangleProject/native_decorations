package xyz.sqaaakoi.minecraft_mods.native_decorations.mixins;

import xyz.sqaaakoi.minecraft_mods.native_decorations.Main;
import xyz.sqaaakoi.minecraft_mods.native_decorations.blocks.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.objectweb.asm.Opcodes;
import javax.annotation.Nullable;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;

@Mixin(BlockColors.class)
public class BlockColorsMixin {
  @Inject(method = "create()Lnet/minecraft/client/color/block/BlockColors;", at = @At("RETURN"), cancellable = true)
  private static void register(CallbackInfoReturnable<BlockColors> cir) {
    BlockColors bc = cir.getReturnValue();
    bc.registerColorProvider((state, world, pos, tintIndex) -> FoliageColors.getSpruceColor(), Blocks.spruce_bush);
    bc.registerColorProvider((state, world, pos, tintIndex) -> FoliageColors.getBirchColor(), Blocks.birch_bush);
    bc.registerColorProvider((state, world, pos, tintIndex) -> {
      if (world == null || pos == null) {
        return FoliageColors.getDefaultColor();
      }
      return BiomeColors.getFoliageColor(world, pos);
    }, Blocks.oak_bush, Blocks.jungle_bush, Blocks.acacia_bush, Blocks.dark_oak_bush);
  }
}
