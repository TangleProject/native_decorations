package xyz.sqaaakoi.minecraft_mods.native_decorations.items;

import xyz.sqaaakoi.minecraft_mods.native_decorations.Main;
import xyz.sqaaakoi.minecraft_mods.native_decorations.blocks.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.FoodComponent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class Items {

  public static Item stone_rock = new BlockItem(Blocks.stone_rock, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item granite_rock = new BlockItem(Blocks.granite_rock, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item diorite_rock = new BlockItem(Blocks.diorite_rock, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item andesite_rock = new BlockItem(Blocks.andesite_rock, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item cobblestone_rock = new BlockItem(Blocks.cobblestone_rock, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item oak_bush = new BlockItem(Blocks.oak_bush, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item spruce_bush = new BlockItem(Blocks.spruce_bush, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item birch_bush = new BlockItem(Blocks.birch_bush, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item jungle_bush = new BlockItem(Blocks.jungle_bush, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item acacia_bush = new BlockItem(Blocks.acacia_bush, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item dark_oak_bush = new BlockItem(Blocks.dark_oak_bush, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item azalea_bush = new BlockItem(Blocks.azalea_bush, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item flowering_azalea_bush = new BlockItem(Blocks.flowering_azalea_bush, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item oak_log_pile = new BlockItem(Blocks.oak_log_pile, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item spruce_log_pile = new BlockItem(Blocks.spruce_log_pile, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item birch_log_pile = new BlockItem(Blocks.birch_log_pile, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item jungle_log_pile = new BlockItem(Blocks.jungle_log_pile, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item dark_oak_log_pile = new BlockItem(Blocks.dark_oak_log_pile, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item acacia_log_pile = new BlockItem(Blocks.acacia_log_pile, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item crimson_stem_pile = new BlockItem(Blocks.crimson_stem_pile, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item warped_stem_pile = new BlockItem(Blocks.warped_stem_pile, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item paeonia = new BlockItem(Blocks.paeonia, new Item.Settings().group(ItemGroup.DECORATIONS));
  public static Item twig = new Item(new Item.Settings().group(ItemGroup.MISC));

  public static void register() {
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "stone_rock"), stone_rock);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "granite_rock"), granite_rock);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "diorite_rock"), diorite_rock);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "andesite_rock"), andesite_rock);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "cobblestone_rock"), cobblestone_rock);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "oak_bush"), oak_bush);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "spruce_bush"), spruce_bush);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "birch_bush"), birch_bush);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "jungle_bush"), jungle_bush);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "acacia_bush"), acacia_bush);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "dark_oak_bush"), dark_oak_bush);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "azalea_bush"), azalea_bush);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "flowering_azalea_bush"), flowering_azalea_bush);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "oak_log_pile"), oak_log_pile);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "spruce_log_pile"), spruce_log_pile);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "birch_log_pile"), birch_log_pile);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "jungle_log_pile"), jungle_log_pile);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "acacia_log_pile"), acacia_log_pile);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "dark_oak_log_pile"), dark_oak_log_pile);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "crimson_stem_pile"), crimson_stem_pile);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "warped_stem_pile"), warped_stem_pile);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "paeonia"), paeonia);
    Registry.register(Registry.ITEM, new Identifier(Main.ID, "twig"), twig);
  }

}
