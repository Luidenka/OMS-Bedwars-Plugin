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

public class Tools implements InventoryHolder {

    private Inventory inv;

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

    ItemStack shears;
    ItemStack pick;
    ItemStack axe;

    public Tools() {
        inv = Bukkit.createInventory(this, 54, "Tools");
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

            /*if (BedwarsEvents.picklevel.containsKey(p)) {
                if (BedwarsEvents.picklevel.get(p) == 0) {*/
                    if (p.getInventory().contains(Material.IRON_INGOT, 10)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eI");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        pick = CreateItem.createitem("§aWooden Pickaxe (Efficiency I)", Material.WOODEN_PICKAXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eI");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        pick = CreateItem.createitem("§cWooden Pickaxe (Efficiency I)", Material.WOODEN_PICKAXE, pmeta, 1, true, false);

                    }
                /*} else if (BedwarsEvents.picklevel.get(p) == 1) {
                    if (p.getInventory().contains(Material.IRON_INGOT, 10)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        pick = CreateItem.createitem("§aIron Pickaxe (Efficiency II)", Material.IRON_PICKAXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        pick = CreateItem.createitem("§cIron Pickaxe (Efficiency II)", Material.IRON_PICKAXE, pmeta, 1, true, false);
                    }
                }

                else if (BedwarsEvents.picklevel.get(p) == 2) {
                    if (p.getInventory().contains(Material.GOLD_INGOT, 3)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §63 Gold");
                        pmeta.add("§7Tier: §eIII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        pick = CreateItem.createitem("§aGold Pickaxe (Efficiency III)", Material.GOLDEN_PICKAXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §63 Gold");
                        pmeta.add("§7Tier: §eIII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        pick = CreateItem.createitem("§cGold Pickaxe (Efficiency III)", Material.GOLDEN_PICKAXE, pmeta, 1, true, false);
                    }
                }

                else if (BedwarsEvents.picklevel.get(p) == 3) {
                    if (p.getInventory().contains(Material.GOLD_INGOT, 3)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §66 Gold");
                        pmeta.add("§7Tier: §eIV");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        pick = CreateItem.createitem("§aDiamond Pickaxe (Efficiency III)", Material.DIAMOND_PICKAXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §66 Gold");
                        pmeta.add("§7Tier: §eIV");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        pick = CreateItem.createitem("§cDiamond Pickaxe (Efficiency III)", Material.DIAMOND_PICKAXE, pmeta, 1, true, false);
                    }
                }

                else {
                    List<String> pmeta = new ArrayList<>();
                    pmeta.add("§7Cost: §66 Gold");
                    pmeta.add("§7Tier: §eIV");
                    pmeta.add("");
                    pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                    pmeta.add("§aUNLOCKED");
                    pick = CreateItem.createitem("§aDiamond Pickaxe (Efficiency III)", Material.DIAMOND_PICKAXE, pmeta, 1, true, false);
                }

            }*/

            /*if (BedwarsEvents.axelevel.containsKey(p)) {
                if (BedwarsEvents.axelevel.get(p) == 0) {*/
                    if (p.getInventory().contains(Material.IRON_INGOT, 10)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eI");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        axe = CreateItem.createitem("§aWooden Axe (Efficiency I)", Material.WOODEN_AXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eI");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        axe = CreateItem.createitem("§cWooden Axe (Efficiency I)", Material.WOODEN_AXE, pmeta, 1, true, false);

                    }
                /*} else if (BedwarsEvents.axelevel.get(p) == 1) {
                    if (p.getInventory().contains(Material.IRON_INGOT, 10)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        axe = CreateItem.createitem("§aStone Axe (Efficiency I)", Material.STONE_AXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        axe = CreateItem.createitem("§cStone Axe (Efficiency I)", Material.STONE_AXE, pmeta, 1, true, false);
                    }
                }

                else if (BedwarsEvents.axelevel.get(p) == 2) {
                    if (p.getInventory().contains(Material.GOLD_INGOT, 3)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §63 Gold");
                        pmeta.add("§7Tier: §eIII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        axe = CreateItem.createitem("§aIron Axe (Efficiency II)", Material.IRON_AXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §63 Gold");
                        pmeta.add("§7Tier: §eIII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        axe = CreateItem.createitem("§cIron Axe (Efficiency II)", Material.IRON_AXE, pmeta, 1, true, false);
                    }
                }

                else if (BedwarsEvents.axelevel.get(p) == 3) {
                    if (p.getInventory().contains(Material.GOLD_INGOT, 3)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §66 Gold");
                        pmeta.add("§7Tier: §eIV");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        axe = CreateItem.createitem("§aDiamond Axe (Efficiency III)", Material.DIAMOND_AXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §66 Gold");
                        pmeta.add("§7Tier: §eIV");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        axe = CreateItem.createitem("§cDiamond Axe (Efficiency III)", Material.DIAMOND_AXE, pmeta, 1, true, false);
                    }
                }

                else {
                    List<String> pmeta = new ArrayList<>();
                    pmeta.add("§7Cost: §66 Gold");
                    pmeta.add("§7Tier: §eIV");
                    pmeta.add("");
                    pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                    pmeta.add("§aUNLOCKED");
                    axe = CreateItem.createitem("§aDiamond Axe (Efficiency III)", Material.DIAMOND_AXE, pmeta, 1, true, false);
                }
            }*/

            if (p.getInventory().contains(Material.IRON_INGOT, 20)) {

                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f20 Iron");
                meta.add("");
                meta.add("§eClick to purchase!");
                shears = CreateItem.createitem("§aPermanent Shears", Material.SHEARS, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f20 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                shears = CreateItem.createitem("§cPermanent Shears", Material.SHEARS, meta, 1, true, false);
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

        inv.setItem(19, shears);
        inv.setItem(20, pick);
        inv.setItem(21, axe);

        inv.setItem(9, graypanes);
        inv.setItem(10, graypanes);
        inv.setItem(11, graypanes);
        inv.setItem(12, graypanes);
        inv.setItem(13, greenpane);
        for (int i=14; i<18; i++) {
            inv.setItem(i, graypanes);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}