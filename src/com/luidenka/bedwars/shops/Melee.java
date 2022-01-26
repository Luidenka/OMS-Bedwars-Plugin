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

public class Melee implements InventoryHolder {

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

    ItemStack stonesword;
    ItemStack ironsword;
    ItemStack diamondsword;
    ItemStack kbstick;
    ItemStack delayedKBStick;

    public Melee() {
        inv = Bukkit.createInventory(this, 54, "Melee");
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
            if (p.getInventory().contains(Material.IRON_INGOT, 10)) {

                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f10 Iron");
                meta.add("");
                meta.add("§eClick to purchase!");
                stonesword = CreateItem.createitem("§aStone Sword", Material.STONE_SWORD, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f10 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                stonesword = CreateItem.createitem("§cStone Sword", Material.STONE_SWORD, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 7)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §67 Gold");
                meta.add("");
                meta.add("§eClick to purchase!");
                ironsword = CreateItem.createitem("§aIron Sword", Material.IRON_SWORD, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §67 Gold");
                meta.add("");
                meta.add("§cYou don't have enough Gold!");
                ironsword = CreateItem.createitem("§cIron Sword", Material.IRON_SWORD, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.EMERALD, 4)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §24 Emeralds");
                meta.add("");
                meta.add("§eClick to purchase!");
                diamondsword = CreateItem.createitem("§aDiamond Sword", Material.DIAMOND_SWORD, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §24 Emeralds");
                meta.add("");
                meta.add("§cYou don't have enough Emeralds!");
                diamondsword = CreateItem.createitem("§cDiamond Sword", Material.DIAMOND_SWORD, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 5)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §65 Gold");
                meta.add("");
                meta.add("§eClick to purchase!");
                kbstick = CreateItem.createItemEnchanted("§aStick (Knockback I)", Material.STICK, meta, 1, true, false, Collections.singletonList(Enchantment.KNOCKBACK), 1);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §65 Gold");
                meta.add("");
                meta.add("§cYou don't have enough Gold!");
                kbstick = CreateItem.createItemEnchanted("§cStick (Knockback I)", Material.STICK, meta, 1, true, false, Collections.singletonList(Enchantment.KNOCKBACK), 1);
            }

            // prototype
            List<String> delayedKBStickMeta = new ArrayList<>();
            delayedKBStickMeta.add("§7Cost: §aFREE");
            delayedKBStickMeta.add("");
            delayedKBStickMeta.add("§7A Knockback Stick that makes the player take");
            delayedKBStickMeta.add("§7knockback after a certain amount of time");
            delayedKBStickMeta.add("");
            delayedKBStickMeta.add("§9Right-click to configure!");
            delayedKBStickMeta.add("§ePROTOTYPE ITEM");

            delayedKBStick = CreateItem.createItemEnchanted("§e[PT] Delayed Knockback Stick", Material.BLAZE_ROD, delayedKBStickMeta, 1, true, true, Collections.singletonList(Enchantment.ARROW_DAMAGE), 1);
        }

        inv.setItem(0, netherstar);
        inv.setItem(1, blocks);
        inv.setItem(2, weapons);
        inv.setItem(3, armor);
        inv.setItem(4, tools);
        inv.setItem(5, ranged);
        inv.setItem(6, potions);
        inv.setItem(7, utils);

        inv.setItem(19, stonesword);
        inv.setItem(20, ironsword);
        inv.setItem(21, diamondsword);
        inv.setItem(22, kbstick);
        //inv.setItem(23, delayedKBStick); SETS DELAYED KNOCKBACK STICK

        inv.setItem(9, graypanes);
        inv.setItem(10, graypanes);
        inv.setItem(11, greenpane);
        for (int i=12; i<18; i++) {
            inv.setItem(i, graypanes);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
