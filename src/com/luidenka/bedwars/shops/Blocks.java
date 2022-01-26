package com.luidenka.bedwars.shops;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blocks implements InventoryHolder {

    private Inventory inv;

    ItemStack wool;
    ItemStack clay;
    ItemStack glass;
    ItemStack endstone;
    ItemStack ladder;
    ItemStack planks;
    ItemStack obsidian;

    ItemStack netherstar;
    ItemStack blocks;
    ItemStack weapons;
    ItemStack armor;
    ItemStack tools;
    ItemStack ranged;
    ItemStack potions;
    ItemStack utils;
    ItemStack graypanes;
    ItemStack greenpane;

    public Blocks() {
        inv = Bukkit.createInventory(this, 54, "Blocks");
        init();
    }

    private void init() {
        netherstar = CreateItem.createitem("§bQuick Buy", Material.NETHER_STAR, null, 1, false, false);
        blocks = CreateItem.createitem("§aBlocks", Material.TERRACOTTA, Collections.singletonList("§eClick to view!"), 1, false, false);
        graypanes = CreateItem.createitem("§8⬆ §7Categories", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList("§8⬇ §7Items"), 1, false, false);
        greenpane = CreateItem.createitem("§8⬆ §7Categories", Material.GREEN_STAINED_GLASS_PANE, Collections.singletonList("§8⬇ §7Items"), 1, false, false);
        weapons = CreateItem.createitem("§aMelee", Material.GOLDEN_SWORD, Collections.singletonList("§eClick to view!"), 1, true, false);
        armor = CreateItem.createitem("§aArmor", Material.CHAINMAIL_BOOTS, Collections.singletonList("§eClick to view!"), 1, true, false);
        tools = CreateItem.createitem("§aTools", Material.WOODEN_PICKAXE, Collections.singletonList("§eClick to view!"), 1, true, false);
        ranged = CreateItem.createitem("§aRanged", Material.BOW, Collections.singletonList("§eClick to view!"), 1, false, false);
        potions = CreateItem.createitem("§aPotions", Material.BREWING_STAND, Collections.singletonList("§eClick to view!"), 1, false, false);
        utils = CreateItem.createitem("§aUtility", Material.TNT, Collections.singletonList("§eClick to view!"), 1, false, false);

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getInventory().contains(Material.IRON_INGOT, 4)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f4 Iron");
                meta.add("");
                meta.add("§7Great for bridging across");
                meta.add("§7islands. Turns into your team's");
                meta.add("§7color.");
                meta.add("");
                meta.add("§eClick to purchase!");
                wool = CreateItem.createitem("§aWool", Material.WHITE_WOOL, meta, 16, false, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f4 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                wool = CreateItem.createitem("§cWool", Material.WHITE_WOOL, meta, 16, false, false);
            }

            if (p.getInventory().contains(Material.IRON_INGOT, 12)) {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §f12 Iron");
                meta.add("");
                meta.add("§eClick to purchase!");
                clay = CreateItem.createitem("§aHardened Clay", Material.TERRACOTTA, meta, 16, true, false);

                meta2.add("§7Cost: §f12 Iron");
                meta2.add("");
                meta2.add("§eClick to purchase!");
                glass = CreateItem.createitem("§aBlast-Proof Glass", Material.GLASS, meta2, 4, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §f12 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                clay = CreateItem.createitem("§cHardened Clay", Material.TERRACOTTA, meta, 16, true, false);

                meta2.add("§7Cost: §f12 Iron");
                meta2.add("");
                meta2.add("§cYou don't have enough Iron!");
                glass = CreateItem.createitem("§cBlast-Proof Glass", Material.GLASS, meta2, 4, true, false);
            }

            if (p.getInventory().contains(Material.IRON_INGOT, 24)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f24 Iron");
                meta.add("");
                meta.add("§eClick to purchase!");
                endstone = CreateItem.createitem("§aEnd Stone", Material.END_STONE, meta, 12, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f24 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                endstone = CreateItem.createitem("§cEnd Stone", Material.END_STONE, meta, 12, true, false);
            }

            if (p.getInventory().contains(Material.IRON_INGOT, 4)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f4 Iron");
                meta.add("");
                meta.add("Useful to save cats stuck in");
                meta.add("trees.");
                meta.add("");
                meta.add("§eClick to purchase!");
                ladder = CreateItem.createitem("§aLadder", Material.LADDER, meta, 16, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f4 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                ladder = CreateItem.createitem("§cLadder", Material.LADDER, meta, 16, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 4)) {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §64 Gold");
                meta.add("");
                meta.add("§eClick to purchase!");
                planks = CreateItem.createitem("§aOak Wood Planks", Material.OAK_PLANKS, meta, 16, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §64 Gold");
                meta.add("");
                meta.add("§cYou don't have enough Gold!");
                planks = CreateItem.createitem("§cOak Wood Planks", Material.OAK_PLANKS, meta, 16, true, false);
            }

            if (p.getInventory().contains(Material.EMERALD, 4)) {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §24 Emeralds");
                meta.add("");
                meta.add("§eClick to purchase!");
                obsidian = CreateItem.createitem("§aObsidian", Material.OBSIDIAN, meta, 4, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §24 Emeralds");
                meta.add("");
                meta.add("§cYou don't have enough Emeralds!");
                obsidian = CreateItem.createitem("§cObsidian", Material.OBSIDIAN, meta, 4, true, false);
            }
        }

        inv.setItem(0, netherstar);
        inv.setItem(1, blocks);
        inv.setItem(2, weapons);
        inv.setItem(3, armor);
        inv.setItem(4, tools);
        inv.setItem(5, ranged);
        inv.setItem(6, potions);
        inv.setItem(7, utils);

        inv.setItem(19, wool);
        inv.setItem(20, clay);
        inv.setItem(21, glass);
        inv.setItem(22, endstone);
        inv.setItem(23, ladder);
        inv.setItem(24, planks);
        inv.setItem(25, obsidian);

        inv.setItem(9, graypanes);
        inv.setItem(10, greenpane);
        for (int i=11; i<18; i++) {
            inv.setItem(i, graypanes);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
