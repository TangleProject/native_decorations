package xyz.sqaaakoi.minecraft_mods.native_decorations.loot;

import xyz.sqaaakoi.minecraft_mods.native_decorations.Main;
import xyz.sqaaakoi.minecraft_mods.native_decorations.items.Items;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import java.util.Map.Entry;

public class LootTablePatcher {
  public static void patch() {
    patchLeavesLootTable();
  }

  public static void patchLeavesLootTable() {
    LootTableEvents.MODIFY.register((resourceManager, lootManager, id, table, source) -> {
      for (Entry<RegistryKey<Block>, Block> entry : Registry.BLOCK.getEntrySet()) {
        Block b = entry.getValue();
        if (entry.getKey().getValue().toString().endsWith("leaves") && b.getLootTableId().equals(id)) {
          for (LootPool p : table.pools) {
            for (LootPoolEntry e : p.entries) {
              if (e instanceof ItemEntry) {
                if (((ItemEntry)e).item == net.minecraft.item.Items.STICK) {
                  ((ItemEntry)e).item = Items.twig;
                }
              }
            }
          }
        }
      }
    });
  }
}
