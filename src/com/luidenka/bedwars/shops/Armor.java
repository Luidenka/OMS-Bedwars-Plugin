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

public class Armor implements InventoryHolder {

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

    ItemStack chainmail;
    ItemStack iron;
    ItemStack diamond;

    public Armor() {
        inv = Bukkit.createInventory(this, 54, "Armor");
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
            if (p.getInventory().contains(Material.IRON_INGOT, 40)) {

                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f40 Iron");
                meta.add("");
                meta.add("§eClick to purchase!");
                chainmail = CreateItem.createitem("§aPermanent Chainmail Armor", Material.CHAINMAIL_BOOTS, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f40 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                chainmail = CreateItem.createitem("§cPermanent Chainmail Armor", Material.CHAINMAIL_BOOTS, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 12)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §612 Gold");
                meta.add("");
                meta.add("§eClick to purchase!");
                iron = CreateItem.createitem("§aPermanent Iron Armor", Material.IRON_BOOTS, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §612 Gold");
                meta.add("");
                meta.add("§cYou don't have enough Gold!");
                iron = CreateItem.createitem("§cPermanent Iron Armor", Material.IRON_BOOTS, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.EMERALD, 6)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §26 Emeralds");
                meta.add("");
                meta.add("§eClick to purchase!");
                diamond = CreateItem.createitem("§aPermanent Diamond Armor", Material.DIAMOND_BOOTS, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §26 Emeralds");
                meta.add("");
                meta.add("§cYou don't have enough Emeralds!");
                diamond = CreateItem.createitem("§cPermanent Diamond Armor", Material.DIAMOND_BOOTS, meta, 1, true, false);
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

        inv.setItem(19, chainmail);
        inv.setItem(20, iron);
        inv.setItem(21, diamond);

        inv.setItem(9, graypanes);
        inv.setItem(10, graypanes);
        inv.setItem(11, graypanes);
        inv.setItem(12, greenpane);
        for (int i=13; i<18; i++) {
            inv.setItem(i, graypanes);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}