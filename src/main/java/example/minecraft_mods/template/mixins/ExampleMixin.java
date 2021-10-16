package example.minecraft_mods.template.mixins;

import example.minecraft_mods.template.Main;
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
import net.minecraft.client.gui.screen.TitleScreen;

@Mixin(TitleScreen.class)
public class ExampleMixin {
  @Inject(at = @At("HEAD"), method = "init()V")
  private void init(CallbackInfo info) {
    // System.out.println("This line is printed by an example mod mixin!");
  }
}
