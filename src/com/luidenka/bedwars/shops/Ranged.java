package com.luidenka.bedwars.shops;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranged implements InventoryHolder {

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

    ItemStack arrow;
    ItemStack bow;
    ItemStack powerbow;
    ItemStack punchbow;

    public Ranged() {
        inv = Bukkit.createInventory(this, 54, "Ranged");
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
            if (p.getInventory().contains(Material.GOLD_INGOT, 2)) {

                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §62 Gold");
                meta.add("");
                meta.add("§eClick to purchase!");
                arrow = CreateItem.createitem("§aArrow", Material.ARROW, meta, 8, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §62 Gold");
                meta.add("");
                meta.add("§cYou don't have enough Gold!");
                arrow = CreateItem.createitem("§cArrow", Material.ARROW, meta, 8, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 12)) {

                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §612 Gold");
                meta.add("");
                meta.add("§eClick to purchase!");
                bow = CreateItem.createitem("§aBow", Material.BOW, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §612 Gold");
                meta.add("");
                meta.add("§cYou don't have enough Gold!");
                bow = CreateItem.createitem("§cBow", Material.BOW, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 24)) {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §624 Gold");
                meta.add("");
                meta.add("§eClick to purchase!");
                powerbow = CreateItem.createItemEnchanted("§aBow (Power I)", Material.BOW, meta, 1, true, false, Collections.singletonList(Enchantment.ARROW_DAMAGE), 1);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §624 Gold");
                meta.add("");
                meta.add("§cYou don't have enough Gold!");
                powerbow = CreateItem.createItemEnchanted("§cBow (Power I)", Material.BOW, meta, 1, true, false, Collections.singletonList(Enchantment.ARROW_DAMAGE), 1);
            }

            if (p.getInventory().contains(Material.EMERALD, 6)) {
                List<String> meta = new ArrayList<>();

                List<Enchantment> enchs = new ArrayList<>();

                enchs.add(Enchantment.ARROW_DAMAGE);
                enchs.add(Enchantment.ARROW_KNOCKBACK);

                meta.add("§7Cost: §26 Emeralds");
                meta.add("");
                meta.add("§eClick to purchase!");
                punchbow = CreateItem.createItemEnchanted("§aBow (Power I, Punch I)", Material.BOW, meta, 1, true, false, enchs, 1);
            }

            else {
                List<String> meta = new ArrayList<>();

                List<Enchantment> enchs = new ArrayList<>();

                enchs.add(Enchantment.ARROW_DAMAGE);
                enchs.add(Enchantment.ARROW_KNOCKBACK);

                meta.add("§7Cost: §26 Emeralds");
                meta.add("");
                meta.add("§cYou don't have enough Emeralds!");
                punchbow = CreateItem.createItemEnchanted("§cBow (Power I, Punch I)", Material.BOW, meta, 1, true, false, enchs, 1);
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

        inv.setItem(19, arrow);
        inv.setItem(20, bow);
        inv.setItem(21, powerbow);
        inv.setItem(22, punchbow);

        inv.setItem(9, graypanes);
        inv.setItem(10, graypanes);
        inv.setItem(11, graypanes);
        inv.setItem(12, graypanes);
        inv.setItem(13, graypanes);
        inv.setItem(14, greenpane);
        for (int i=15; i<18; i++) {
            inv.setItem(i, graypanes);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
