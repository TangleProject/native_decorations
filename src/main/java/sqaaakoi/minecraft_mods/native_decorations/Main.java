package sqaaakoi.minecraft_mods.native_decorations;

import sqaaakoi.minecraft_mods.native_decorations.blocks.Blocks;
import sqaaakoi.minecraft_mods.native_decorations.items.Items;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
  public static final String ID = "native_decorations";
  public static final Logger LOG = LogManager.getLogger(ID);

  @Override
  public void onInitialize() {
    LOG.debug("Loaded mod {}", ID);
    Blocks.register();
    Items.register();
  }
}
