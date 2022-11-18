package xyz.sqaaakoi.minecraft_mods.native_decorations.blocks;

import xyz.sqaaakoi.minecraft_mods.native_decorations.Main;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
  public static RockBlock stone_rock = new RockBlock();
  public static RockBlock granite_rock = new RockBlock();
  public static RockBlock diorite_rock = new RockBlock();
  public static RockBlock andesite_rock = new RockBlock();
  public static RockBlock cobblestone_rock = new RockBlock();
  public static BushyBushBlock oak_bush = new BushyBushBlock();
  public static BushyBushBlock spruce_bush = new BushyBushBlock();
  public static BushyBushBlock birch_bush = new BushyBushBlock();
  public static BushyBushBlock jungle_bush = new BushyBushBlock();
  public static BushyBushBlock acacia_bush = new BushyBushBlock();
  public static BushyBushBlock dark_oak_bush = new BushyBushBlock();
  public static BushyBushBlock azalea_bush = new BushyBushBlock(BushBlock.DEFAULT_SETTINGS.sounds(BlockSoundGroup.AZALEA_LEAVES));
  public static BushyBushBlock flowering_azalea_bush = new BushyBushBlock(BushBlock.DEFAULT_SETTINGS.sounds(BlockSoundGroup.AZALEA_LEAVES));
  public static LogPileBlock oak_log_pile = new LogPileBlock();
  public static LogPileBlock spruce_log_pile = new LogPileBlock();
  public static LogPileBlock birch_log_pile = new LogPileBlock();
  public static LogPileBlock jungle_log_pile = new LogPileBlock();
  public static LogPileBlock acacia_log_pile = new LogPileBlock();
  public static LogPileBlock dark_oak_log_pile = new LogPileBlock();
  public static LogPileBlock crimson_stem_pile = new LogPileBlock(LogPileBlock.NETHER_SETTINGS);
  public static LogPileBlock warped_stem_pile = new LogPileBlock(LogPileBlock.NETHER_SETTINGS);
  public static FlowerBlock paeonia = new FlowerBlock(StatusEffects.REGENERATION, 8, Block.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ));
  public static FlowerPotBlock potted_paeonia = new FlowerPotBlock(paeonia, Block.Settings.of(Material.DECORATION).breakInstantly().nonOpaque());

  public static void register() {
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "stone_rock"), stone_rock);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "granite_rock"), granite_rock);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "andesite_rock"), andesite_rock);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "diorite_rock"), diorite_rock);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "cobblestone_rock"), cobblestone_rock);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "oak_bush"), oak_bush);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "spruce_bush"), spruce_bush);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "birch_bush"), birch_bush);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "jungle_bush"), jungle_bush);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "acacia_bush"), acacia_bush);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "dark_oak_bush"), dark_oak_bush);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "azalea_bush"), azalea_bush);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "flowering_azalea_bush"), flowering_azalea_bush);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "oak_log_pile"), oak_log_pile);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "spruce_log_pile"), spruce_log_pile);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "birch_log_pile"), birch_log_pile);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "jungle_log_pile"), jungle_log_pile);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "acacia_log_pile"), acacia_log_pile);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "dark_oak_log_pile"), dark_oak_log_pile);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "crimson_stem_pile"), crimson_stem_pile);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "warped_stem_pile"), warped_stem_pile);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "paeonia"), paeonia);
    Registry.register(Registry.BLOCK, new Identifier(Main.ID, "potted_paeonia"), potted_paeonia);
  }
}
