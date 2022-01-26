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

public class Utilities implements InventoryHolder {

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

    ItemStack gapple;
    ItemStack bedbug;
    ItemStack golem;
    ItemStack fb;
    ItemStack tnt;
    ItemStack pearl;
    ItemStack waterbucket;
    ItemStack bridgeegg;
    ItemStack magicmilk;
    ItemStack sponge;
    ItemStack popuptower;

    public Utilities() {
        inv = Bukkit.createInventory(this, 54, "Utilities");
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
            if (p.getInventory().contains(Material.GOLD_INGOT, 3)) {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();
                List<String> meta3 = new ArrayList<>();

                meta.add("§7Cost: §63 Gold");
                meta.add("");
                meta.add("§eClick to purchase!");
                waterbucket = CreateItem.createitem("§aWater Bucket", Material.WATER_BUCKET, meta, 1, true, false);

                meta2.add("§7Cost: §63 Gold");
                meta2.add("");
                meta2.add("§eClick to purchase!");
                gapple = CreateItem.createitem("§aGolden Apple", Material.GOLDEN_APPLE, meta2, 1, true, false);

                meta3.add("§7Cost: §63 Gold");
                meta3.add("");
                meta3.add("§eClick to purchase!");
                sponge = CreateItem.createitem("§aSponge", Material.SPONGE, meta3, 4, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();
                List<String> meta3 = new ArrayList<>();

                meta.add("§7Cost: §63 Gold");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                waterbucket = CreateItem.createitem("§cWater Bucket", Material.WATER_BUCKET, meta, 1, true, false);

                meta2.add("§7Cost: §63 Gold");
                meta2.add("");
                meta2.add("§cYou don't have enough Gold!");
                gapple = CreateItem.createitem("§cGolden Apple", Material.GOLDEN_APPLE, meta2, 1, true, false);

                meta3.add("§7Cost: §63 Gold");
                meta3.add("");
                meta3.add("§cYou don't have enough Gold!");
                sponge = CreateItem.createitem("§cSponge", Material.SPONGE, meta3, 4, true, false);
            }

            if (p.getInventory().contains(Material.IRON_INGOT, 40)) {

                //all that cost 40 iron
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();
                meta.add("§7Cost: §f40 Iron");
                meta.add("");
                meta.add("§eClick to purchase!");
                bedbug = CreateItem.createitem("§aBedbug", Material.SNOWBALL, meta, 1, true, false);

                meta2.add("§7Cost: §f40 Iron");
                meta2.add("");
                meta2.add("§eClick to purchase!");
                fb = CreateItem.createitem("§aFireball", Material.FIRE_CHARGE, meta2, 1, true, false);

            }

            else {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();
                meta.add("§7Cost: §f40 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");

                meta2.add("§7Cost: §f40 Iron");
                meta2.add("");
                meta2.add("§cYou don't have enough Iron!");
                bedbug = CreateItem.createitem("§cBedbug", Material.SNOWBALL, meta, 1, true, false);
                fb = CreateItem.createitem("§cFireball", Material.FIRE_CHARGE, meta2, 1, true, false);
            }

            if (p.getInventory().contains(Material.IRON_INGOT, 120)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f120 Iron");
                meta.add("");
                meta.add("§eClick to purchase!");
                golem = CreateItem.createitem("§aDream Defender", Material.POLAR_BEAR_SPAWN_EGG, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f120 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                golem = CreateItem.createitem("§cDream Defender", Material.POLAR_BEAR_SPAWN_EGG, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 4)) {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §64 Gold");
                meta.add("");
                meta.add("§eClick to purchase!");

                meta2.add("§7Cost: §64 Gold");
                meta2.add("");
                meta2.add("§eClick to purchase!");

                tnt = CreateItem.createitem("§aTNT", Material.TNT, meta, 1, true, false);
                magicmilk = CreateItem.createitem("§aMagic Milk", Material.MILK_BUCKET, meta2, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §64 Gold");
                meta.add("");
                meta.add("§cYou don't have enough Gold!");

                meta2.add("§7Cost: §64 Gold");
                meta2.add("");
                meta2.add("§cYou don't have enough Gold!");

                tnt = CreateItem.createitem("§cTNT", Material.TNT, meta, 1, true, false);
                magicmilk = CreateItem.createitem("§cMagic Milk", Material.MILK_BUCKET, meta2, 1, true, false);
            }

            if (p.getInventory().contains(Material.EMERALD, 4)) {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §24 Emeralds");
                meta.add("");
                meta.add("§eClick to purchase!");
                pearl = CreateItem.createitem("§aEnder Pearl", Material.ENDER_PEARL, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §24 Emeralds");
                meta.add("");
                meta.add("§cYou don't have enough Emeralds!");
                pearl = CreateItem.createitem("§cEnder Pearl", Material.ENDER_PEARL, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.EMERALD, 2)) {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §22 Emeralds");
                meta.add("");
                meta.add("§eClick to purchase!");
                bridgeegg = CreateItem.createitem("§aBridge Egg", Material.EGG, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §22 Emeralds");
                meta.add("");
                meta.add("§cYou don't have enough Emeralds!");
                bridgeegg = CreateItem.createitem("§cBridge Egg", Material.EGG, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.IRON_INGOT, 24)) {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f24 Iron");
                meta.add("");
                meta.add("§eClick to purchase!");
                popuptower = CreateItem.createitem("§aCompact Pop-up Tower", Material.CHEST, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f24 Iron");
                meta.add("");
                meta.add("§cYou don't have enough Iron!");
                popuptower = CreateItem.createitem("§cCompact Pop-up Tower", Material.CHEST, meta, 1, true, false);
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

        inv.setItem(19, gapple);
        inv.setItem(20, bedbug);
        inv.setItem(21, golem);
        inv.setItem(22, fb);
        inv.setItem(23, tnt);
        inv.setItem(24, pearl);
        inv.setItem(25, waterbucket);
        inv.setItem(28, bridgeegg);
        inv.setItem(29, magicmilk);
        inv.setItem(30, sponge);
        inv.setItem(31, popuptower);


        inv.setItem(17, graypanes);
        inv.setItem(16, greenpane);
        for (int i=9; i<16; i++) {
            inv.setItem(i, graypanes);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}