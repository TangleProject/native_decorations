package sqaaakoi.minecraft_mods.native_decorations.mixins;

import sqaaakoi.minecraft_mods.native_decorations.Main;
import sqaaakoi.minecraft_mods.native_decorations.blocks.Blocks;
import sqaaakoi.minecraft_mods.native_decorations.blocks.BushBlock;
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
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import java.util.Map;

@Mixin(RenderLayers.class)
public class RenderLayersMixin {
  @Shadow
  private static boolean fancyGraphicsOrBetter;
  @Shadow
  @Final
  private static Map<Block, RenderLayer> BLOCKS;

  @Inject(method = "getBlockLayer(Lnet/minecraft/block/BlockState;)Lnet/minecraft/client/render/RenderLayer;", at = @At("RETURN"), cancellable = true)
  private static void register(BlockState state, CallbackInfoReturnable<RenderLayer> cir) {
    Block lv = state.getBlock();
    if (lv instanceof BushBlock) {
      cir.setReturnValue(fancyGraphicsOrBetter ? RenderLayer.getCutoutMipped() : RenderLayer.getSolid());
    }
  }

  static {
    RenderLayer m = RenderLayer.getCutoutMipped();
    BLOCKS.put(Blocks.oak_bush, m);
    BLOCKS.put(Blocks.spruce_bush, m);
    BLOCKS.put(Blocks.birch_bush, m);
    BLOCKS.put(Blocks.jungle_bush, m);
    BLOCKS.put(Blocks.acacia_bush, m);
    BLOCKS.put(Blocks.dark_oak_bush, m);
    BLOCKS.put(Blocks.azalea_bush, m);
    BLOCKS.put(Blocks.flowering_azalea_bush, m);
    RenderLayer c = RenderLayer.getCutout();
    BLOCKS.put(Blocks.paeonia, c);
    BLOCKS.put(Blocks.potted_paeonia, c);
  }
}
