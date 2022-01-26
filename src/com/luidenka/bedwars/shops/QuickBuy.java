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

public class QuickBuy implements InventoryHolder {

    private Inventory inv;

    ItemStack wool;
    ItemStack stonesword;
    ItemStack chainmail;
    ItemStack diaarmor;
    ItemStack bow;
    ItemStack fb;
    ItemStack tnt;
    ItemStack wood;
    ItemStack ironsword;
    ItemStack ironarmor;
    ItemStack shears;
    ItemStack endstone;
    ItemStack clay;
    ItemStack water;
    ItemStack glass;
    ItemStack woodpickaxe;

    ItemStack axe;
    ItemStack invis;
    ItemStack jump;
    ItemStack speed;
    ItemStack gapple;

    public static int pickUpgrades = 0;
    public static int axeUpgrades = 0;
    public static boolean shearsBought = false;

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
    ItemStack delayedKBStick;
    String title = "Quick Buy";

    public QuickBuy() {
        inv = Bukkit.createInventory(this, 54, title);
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
                meta.add("§7color. (future update)");
                meta.add("");
                meta.add("§eClick to purchase!");
                wool = CreateItem.createitem("§aWool", Material.WHITE_WOOL, meta, 16, false, false);
            } else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f4 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Iron!");
                wool = CreateItem.createitem("§cWool", Material.WHITE_WOOL, meta, 16, false, false);
            }

                    if (p.getInventory().contains(Material.IRON_INGOT, 10)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eI");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        woodpickaxe = CreateItem.createitem("§aWooden Pickaxe (Efficiency I)", Material.WOODEN_PICKAXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eI");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        woodpickaxe = CreateItem.createitem("§cWooden Pickaxe (Efficiency I)", Material.WOODEN_PICKAXE, pmeta, 1, true, false);

                    }
                /*} else if (BedwarsEvents.picklevel.get(p) == 1) {
                    if (p.getInventory().contains(Material.IRON_INGOT, 10)) {
                        List<String> pmeta = new ArrayList<>();
                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§eClick to purchase!");
                        woodpickaxe = CreateItem.createitem("§aIron Pickaxe (Efficiency II)", Material.IRON_PICKAXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §f10 Iron");
                        pmeta.add("§7Tier: §eII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        woodpickaxe = CreateItem.createitem("§cIron Pickaxe (Efficiency II)", Material.IRON_PICKAXE, pmeta, 1, true, false);
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
                        woodpickaxe = CreateItem.createitem("§aGold Pickaxe (Efficiency III)", Material.GOLDEN_PICKAXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §63 Gold");
                        pmeta.add("§7Tier: §eIII");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        woodpickaxe = CreateItem.createitem("§cGold Pickaxe (Efficiency III)", Material.GOLDEN_PICKAXE, pmeta, 1, true, false);
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
                        woodpickaxe = CreateItem.createitem("§aDiamond Pickaxe (Efficiency III)", Material.DIAMOND_PICKAXE, pmeta, 1, true, false);
                    } else {
                        List<String> pmeta = new ArrayList<>();

                        pmeta.add("§7Cost: §66 Gold");
                        pmeta.add("§7Tier: §eIV");
                        pmeta.add("");
                        pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                        pmeta.add("§cYou don't have enough Iron!");
                        woodpickaxe = CreateItem.createitem("§cDiamond Pickaxe (Efficiency III)", Material.DIAMOND_PICKAXE, pmeta, 1, true, false);
                    }
                }

                else {
                    List<String> pmeta = new ArrayList<>();
                    pmeta.add("§7Cost: §66 Gold");
                    pmeta.add("§7Tier: §eIV");
                    pmeta.add("");
                    pmeta.add("§bSneak Click to remove from Quick Buy! (not working)");
                    pmeta.add("§aUNLOCKED");
                    woodpickaxe = CreateItem.createitem("§aDiamond Pickaxe (Efficiency III)", Material.DIAMOND_PICKAXE, pmeta, 1, true, false);
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

            if (p.getInventory().contains(Material.IRON_INGOT, 10)) {

                //all that cost 10 iron

                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f10 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                stonesword = CreateItem.createitem("§aStone Sword", Material.STONE_SWORD, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();

                meta.add("§7Cost: §f10 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Iron!");
                stonesword = CreateItem.createitem("§cStone Sword", Material.STONE_SWORD, meta, 1, true, false);

            }

            if (p.getInventory().contains(Material.IRON_INGOT, 40)) {

                //all that cost 40 iron
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();
                meta.add("§7Cost: §f40 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                chainmail = CreateItem.createitem("§aPermanent Chainmail Armor", Material.CHAINMAIL_BOOTS, meta, 1, true, false);

                meta2.add("§7Cost: §f40 Iron");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta2.add("§eClick to purchase!");
                fb = CreateItem.createitem("§aFireball", Material.FIRE_CHARGE, meta2, 1, true, false);

            }

            else {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();
                meta.add("§7Cost: §f40 Iron");
                meta.add("");
                meta.add("§7Chainmail leggings and boots");
                meta.add("§7which you will always spawn");
                meta.add("§7with.");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy (not working)!");
                meta.add("§cYou don't have enough Iron!");

                meta2.add("§7Cost: §f40 Iron");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy (not working)!");
                meta2.add("§cYou don't have enough Iron!");
                chainmail = CreateItem.createitem("§cPermanent Chainmail Armor", Material.CHAINMAIL_BOOTS, meta, 1, true, false);
                fb = CreateItem.createitem("§cFireball", Material.FIRE_CHARGE, meta2, 1, true, false);
            }

            if (p.getInventory().contains(Material.EMERALD, 6)) {

                //all that cost 6 ems
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §26 Emeralds");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                diaarmor = CreateItem.createitem("§aPermanent Diamond Armor", Material.DIAMOND_BOOTS, meta, 1, true, false);

            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §26 Emeralds");
                meta.add("");
                meta.add("§7Diamond leggings and boots which");
                meta.add("§7you will always crush with.");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy (not working)!");
                meta.add("§cYou don't have enough Emeralds!");
                diaarmor = CreateItem.createitem("§cPermanent Diamond Armor", Material.DIAMOND_BOOTS, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 12)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §612 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                bow = CreateItem.createitem("§aBow", Material.BOW, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §612 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Gold!");
                bow = CreateItem.createitem("§cBow", Material.BOW, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 4)) {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §64 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                tnt = CreateItem.createitem("§aTNT", Material.TNT, meta, 1, true, false);

                meta2.add("§7Cost: §64 Gold");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta2.add("§eClick to purchase!");
                wood = CreateItem.createitem("§aOak Wood Planks", Material.OAK_PLANKS, meta, 16, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §64 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Gold!");
                tnt = CreateItem.createitem("§cTNT", Material.TNT, meta, 1, true, false);

                meta2.add("§7Cost: §64 Gold");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta2.add("§cYou don't have enough Gold!");
                wood = CreateItem.createitem("§cOak Wood Planks", Material.OAK_PLANKS, meta, 16, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 7)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §67 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                ironsword = CreateItem.createitem("§aIron Sword", Material.IRON_SWORD, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §67 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Gold!");
                ironsword = CreateItem.createitem("§cIron Sword", Material.IRON_SWORD, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 12)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §612 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                ironarmor = CreateItem.createitem("§aPermanent Iron Armor", Material.IRON_BOOTS, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §612 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Gold!");
                ironarmor = CreateItem.createitem("§cPermanent Iron Armor", Material.IRON_BOOTS, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.IRON_INGOT, 20)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f20 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                shears = CreateItem.createitem("§aPermanent Shears", Material.SHEARS, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f20 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Iron!");
                shears = CreateItem.createitem("§cPermanent Shears", Material.SHEARS, meta, 1, true, false);
            }

            if (p.getInventory().contains(Material.IRON_INGOT, 24)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f24 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                endstone = CreateItem.createitem("§aEnd Stone", Material.END_STONE, meta, 12, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §f24 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Iron!");
                endstone = CreateItem.createitem("§cEnd Stone", Material.END_STONE, meta, 12, true, false);
            }

            if (p.getInventory().contains(Material.IRON_INGOT, 12)) {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §f12 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                clay = CreateItem.createitem("§aHardened Clay", Material.TERRACOTTA, meta, 16, true, false);

                meta2.add("§7Cost: §f12 Iron");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta2.add("§eClick to purchase!");
                glass = CreateItem.createitem("§aBlast-Proof Glass", Material.GLASS, meta2, 4, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §f12 Iron");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Iron!");
                clay = CreateItem.createitem("§cHardened Clay", Material.TERRACOTTA, meta, 16, true, false);

                meta2.add("§7Cost: §f12 Iron");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta2.add("§cYou don't have enough Iron!");
                glass = CreateItem.createitem("§cBlast-Proof Glass", Material.GLASS, meta2, 4, true, false);
            }

            if (p.getInventory().contains(Material.GOLD_INGOT, 3)) {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §63 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                water = CreateItem.createitem("§aWater Bucket", Material.WATER_BUCKET, meta, 1, true, false);

                meta2.add("§7Cost: §63 Gold");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta2.add("§eClick to purchase!");
                gapple = CreateItem.createitem("§aGolden Apple", Material.GOLDEN_APPLE, meta2, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §63 Gold");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Iron!");
                water = CreateItem.createitem("§cWater Bucket", Material.WATER_BUCKET, meta, 1, true, false);

                meta2.add("§7Cost: §63 Gold");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta2.add("§cYou don't have enough Gold!");
                gapple = CreateItem.createitem("§cGolden Apple", Material.GOLDEN_APPLE, meta2, 1, true, false);
            }

            if (p.getInventory().contains(Material.EMERALD, 2)) {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §22 Emeralds");
                meta.add("");
                meta.add("§9Complete Invisibility (0:30)");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                invis = CreateItem.createitem("§aInvisibility Potion (30 seconds)", Material.POTION, meta, 1, true, false);
            }

            else {
                List<String> meta = new ArrayList<>();
                meta.add("§7Cost: §22 Emeralds");
                meta.add("");
                meta.add("§9Complete Invisibility (0:30)");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Emeralds!");
                invis = CreateItem.createitem("§cInvisibility Potion (30 seconds)", Material.POTION, meta, 1, true, false);
            }


            if (p.getInventory().contains(Material.EMERALD, 1)) {
                List<String> meta = new ArrayList<>();
                List<String> meta2 = new ArrayList<>();

                meta.add("§7Cost: §21 Emeralds");
                meta.add("");
                meta.add("§9Jump Boost V (0:45)");
                meta.add("");
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§eClick to purchase!");
                jump = CreateItem.createitem("§aJump V Potion (45 seconds)", Material.POTION, meta, 1, true, false);

                meta2.add("§7Cost: §21 Emeralds");
                meta2.add("");
                meta2.add("§9Speed II (0:45)");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy! (not working)");
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
                meta.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta.add("§cYou don't have enough Emeralds!");
                jump = CreateItem.createitem("§cJump V Potion (45 seconds)", Material.POTION, meta, 1, true, false);

                meta2.add("§7Cost: §21 Emeralds");
                meta2.add("");
                meta2.add("§9Speed II (0:45)");
                meta2.add("");
                meta2.add("§bSneak Click to remove from Quick Buy! (not working)");
                meta2.add("§cYou don't have enough Emeralds!");
                speed = CreateItem.createitem("§cSpeed II Potion (45 seconds)", Material.POTION, meta2, 1, true, false);
            }
        }

        inv.setItem(19, wool);
        inv.setItem(20, stonesword);
        inv.setItem(21, chainmail);
        inv.setItem(22, diaarmor);
        inv.setItem(23, bow);
        inv.setItem(24, fb);
        inv.setItem(25, tnt);
        inv.setItem(28, wood);
        inv.setItem(29, ironsword);
        inv.setItem(30, ironarmor);
        inv.setItem(31, shears);
        inv.setItem(32, endstone);
        inv.setItem(33, clay);
        inv.setItem(34, water);
        inv.setItem(37, glass);
        inv.setItem(38, woodpickaxe);
        inv.setItem(39, axe);
        inv.setItem(40, invis);
        inv.setItem(41, jump);
        inv.setItem(42, speed);
        inv.setItem(43, gapple);

        inv.setItem(0, netherstar);
        inv.setItem(1, blocks);
        inv.setItem(2, weapons);
        inv.setItem(3, armor);
        inv.setItem(4, tools);
        inv.setItem(5, ranged);
        inv.setItem(6, potions);
        inv.setItem(7, utils);
        inv.setItem(9, greenpane);
        for (int i=10; i<18; i++) {
            inv.setItem(i, graypanes);
        }
    }


    @Override
    public Inventory getInventory() {
        return inv;
    }
}
