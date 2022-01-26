package com.luidenka.bedwars.events;

import com.luidenka.bedwars.shops.QuickBuy;
import com.luidenka.bedwars.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

import static com.luidenka.bedwars.events.StartGame.cantakedamage;

public class Misc implements Listener {
    public static ArrayList<Block> playerPlacedBlocks = new ArrayList<>();
    @EventHandler
    public void onInvisDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                Player player = (Player) e.getEntity();
                if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    player.sendMessage(ChatColor.RED+"Your invisibility effect has been removed as someone attack you!");
                    player.removePotionEffect(PotionEffectType.INVISIBILITY);
                }
            }
        }
    }
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        for (Block block : e.blockList().toArray(new Block[e.blockList().size()])) {
            if (block.getType() == Material.GLASS) {
                e.blockList().remove(block);
            }

            if (block.getType() == Material.RED_BED ||
                    block.getType() == Material.BLUE_BED ||
                    block.getType() == Material.LIME_BED ||
                    block.getType() == Material.YELLOW_BED ||
                    block.getType() == Material.CYAN_BED ||
                    block.getType() == Material.WHITE_BED ||
                    block.getType() == Material.PINK_BED ||
                    block.getType() == Material.GRAY_BED) {
                e.blockList().remove(block);
            }

            if (block.getType() == Material.DIAMOND_BLOCK || block.getType() == Material.EMERALD_BLOCK || block.getType() == Material.SMOOTH_STONE_SLAB || block.getType() == Material.STONE_BRICKS || block.getType() == Material.STONE_BRICK_STAIRS) {
                e.blockList().remove(block);
            }

            if (block.getType() == Material.OBSIDIAN) {
                e.blockList().remove(block);
            }
        }
    }
    @EventHandler
    public void onProjectileLand(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Snowball) {
            Location loc = e.getEntity().getLocation();
            e.getEntity().getWorld().spawnEntity(loc, EntityType.SILVERFISH);
        }
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.EGG) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public static void onBlockPlace(BlockPlaceEvent e) {
        playerPlacedBlocks.add(e.getBlockPlaced());
    }
    @EventHandler
    public static void onPlayerDisconnect(PlayerQuitEvent e) {
        Bukkit.broadcastMessage(e.getPlayer().toString()+ChatColor.GRAY+" disconnected.");
    }
    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if (Teams.red.getEntries().contains(player.toString())) {
            e.setFormat("§c" + player.getPlayerListName() + "§f: " + e.getMessage());
        }

        if (Teams.blue.getEntries().contains(player.toString())) {
            e.setFormat("§9" + player.getPlayerListName() + "§f: " + e.getMessage());
        }

        if (Teams.green.getEntries().contains(player.toString())) {
            e.setFormat("§a" + player.getPlayerListName() + "§f: " + e.getMessage());
        }

        if (Teams.yellow.getEntries().contains(player.toString())) {
            e.setFormat("§e" + player.getPlayerListName() + "§f: " + e.getMessage());
        }

        if (Teams.aqua.getEntries().contains(player.toString())) {
            e.setFormat("§b" + player.getPlayerListName() + "§f: " + e.getMessage());
        }

        if (Teams.white.getEntries().contains(player.toString())) {
            e.setFormat("§f" + player.getPlayerListName() + "§f: " + e.getMessage());
        }

        if (Teams.pink.getEntries().contains(player.toString())) {
            e.setFormat("§d" + player.getPlayerListName() + "§f: " + e.getMessage());
        }

        if (Teams.gray.getEntries().contains(player.toString())) {
            e.setFormat("§8" + player.getPlayerListName() + "§f: " + e.getMessage());
        }
    }
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (!cantakedamage) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public static void onSoloShop(InventoryOpenEvent e) {
        HumanEntity pl = e.getPlayer();
        if(e.getInventory().getType() == InventoryType.MERCHANT && e.getInventory().getHolder() instanceof Villager) {
            e.setCancelled(true);
            QuickBuy itemshop = new QuickBuy();
            pl.openInventory(itemshop.getInventory());
        }
    }

}
