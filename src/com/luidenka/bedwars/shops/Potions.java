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

public class Potions implements InventoryHolder {

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

    ItemStack invis;
    ItemStack jump;
    ItemStack speed;

    public Potions() {
        inv = Bukkit.createInventory(this, 54, "Potions");
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
            if (p.getInventory().contains(Material.EMERALD, 1)) {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §21 Emeralds");
                meta.add("");
                meta.add("§9Jump Boost V (0:45)");
                meta.add("");
                meta.add("§eClick to purchase!");
                jump = CreateItem.createitem("§aJump V Potion (45 seconds)", Material.POTION, meta, 1, true, false);

                meta2.add("§7Cost: §21 Emeralds");
                meta2.add("");
                meta2.add("§9Speed II (0:45)");
                meta2.add("");
                meta2.add("§eClick to purchase!");
                speed = CreateItem.createitem("§aSpeed II Potion (45 seconds)", Material.POTION, meta2, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §21 Emeralds");
                meta.add("");
                meta.add("§9Jump Boost V (0:45)");
                meta.add("");
                meta.add("§cYou don't have enough Emeralds!");
                jump = CreateItem.createItemEnchanted("§cJump V Potion (45 seconds)", Material.POTION, meta, 1, true, false, Collections.singletonList(Enchantment.DIG_SPEED), 1);

                meta2.add("§7Cost: §21 Emeralds");
                meta2.add("");
                meta2.add("§9Speed II (0:45)");
                meta2.add("");
                meta2.add("§cYou don't have enough Emeralds!");
                speed = CreateItem.createItemEnchanted("§cSpeed II Potion (45 seconds)", Material.POTION, meta2, 1, true, false, Collections.singletonList(Enchantment.DIG_SPEED), 1);
            }

            if (p.getInventory().contains(Material.EMERALD, 2)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §22 Emeralds");
                meta.add("");
                meta.add("§9Complete Invisibility (0:30)");
                meta.add("");
                meta.add("§eClick to purchase!");
                invis = CreateItem.createItemEnchanted("§aInvisibility Potion (30 seconds)", Material.POTION, meta, 1, true, false, Collections.singletonList(Enchantment.DIG_SPEED), 1);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §22 Emeralds");
                meta.add("");
                meta.add("§9Complete Invisibility (0:30)");
                meta.add("");
                meta.add("§cYou don't have enough Emeralds!");
                invis = CreateItem.createItemEnchanted("§cInvisibility Potion (30 seconds)", Material.POTION, meta, 1, true, false, Collections.singletonList(Enchantment.DIG_SPEED), 1);
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

        inv.setItem(19, invis);
        inv.setItem(20, jump);
        inv.setItem(21, speed);

        inv.setItem(15, greenpane);
        inv.setItem(16, graypanes);
        inv.setItem(17, graypanes);

        for (int i=9; i<15; i++) {
            inv.setItem(i, graypanes);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
