package com.luidenka.bedwars.events;

import com.luidenka.bedwars.scoreboard.InGameScoreboard;
import com.luidenka.bedwars.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import com.luidenka.bedwars.scoreboard.WaitingScoreboard;

import java.util.ArrayList;

import static com.luidenka.bedwars.scoreboard.WaitingScoreboard.status;
import static com.luidenka.bedwars.teams.Teams.*;
import static com.luidenka.bedwars.teams.Teams.grayl;

public class Events implements Listener {
    public static int players = Bukkit.getOnlinePlayers().size();
    public static int countdown = 20;
    public static boolean cantakedamage = false;
    public static ArrayList<Block> playerPlacedBlocks = new ArrayList<>();
    @EventHandler
    public static void onBlockPlace(BlockPlaceEvent e) {
        playerPlacedBlocks.add((Block) e.getBlockPlaced());
    }
    @EventHandler
    public static void onPlayerDisconnect(PlayerQuitEvent e) {
        if (Bukkit.getOnlinePlayers().size() == 1) {
            if (playerPlacedBlocks.size() > 0) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clearblocks");
            }
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload confirm");
        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        Player killer = e.getEntity().getKiller();
        if(e.getDeathMessage().contains("fell out of the world")){
            e.setDeathMessage(player.getName()+ChatColor.WHITE+" fell to the void.");
        }
        else if(e.getDeathMessage().contains(" didn't want to live in the same world as")){
            e.setDeathMessage(player.getName()+ChatColor.WHITE+" was knocked to the void by" + killer +
                    ChatColor.WHITE+'.');
        }
        else if(e.getDeathMessage().contains("was slain by")) {
            e.setDeathMessage(player.getName()+ChatColor.WHITE+" was killed by"+killer+ChatColor.WHITE+'.');
        }
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
    public void playerJoinEvent(PlayerJoinEvent e) {
        players += 1;
        if (players >= 2) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (countdown >= 1) {
                        if (countdown == 20) {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + "The game starts in " + ChatColor.YELLOW + countdown + ChatColor.YELLOW + " seconds!");
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                p.sendTitle(ChatColor.GREEN + "" + countdown, null, 0, 20, 0);
                            }
                        } else if (countdown == 10) {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + "The game starts in " + ChatColor.GOLD + countdown + ChatColor.YELLOW + " seconds!");
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                p.sendTitle(ChatColor.GREEN + "" + countdown, null, 0, 20, 0);
                            }
                        } else if (countdown <= 5 && countdown > 1) {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + "The game starts in " + ChatColor.RED + countdown + ChatColor.YELLOW + " seconds!");
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                p.sendTitle(ChatColor.YELLOW + "" + countdown, null, 0, 20, 0);
                            }
                        } else if (countdown == 1) {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + "The game starts in " + ChatColor.RED + countdown + ChatColor.YELLOW + " second!");
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                p.sendTitle(ChatColor.RED + "" + countdown, null, 0, 20, 0);
                            }
                        }

                        countdown--;
                        status = "Starting in"+ChatColor.GREEN+countdown+"s";
                    } else {
                        cantakedamage = true;
                        InGameScoreboard.Scoreboard();
                        Bukkit.broadcastMessage("§a§l--------------------------------------");
                        Bukkit.broadcastMessage("                            §f§lBed Wars");
                        Bukkit.broadcastMessage(" ");
                        Bukkit.broadcastMessage("    §e§lProtect your bed and destroy the enemy beds.");
                        Bukkit.broadcastMessage("     §e§lUpgrade yourself and your team by collecting");
                        Bukkit.broadcastMessage("   §e§lIron, Gold, Emerald and Diamond from generators");
                        Bukkit.broadcastMessage("            §e§lto access powerful upgrades.");
                        Bukkit.broadcastMessage(" ");
                        Bukkit.broadcastMessage("§a§l--------------------------------------");
                        InGameScoreboard.Scoreboard();
                        for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                            if (Teams.red.getEntries().contains(pl.toString()) ||
                                    Teams.blue.getEntries().contains(pl.toString()) ||
                                    Teams.green.getEntries().contains(pl.toString()) ||
                                    Teams.yellow.getEntries().contains(pl.toString()) ||
                                    Teams.aqua.getEntries().contains(pl.toString()) ||
                                    Teams.white.getEntries().contains(pl.toString()) ||
                                    Teams.pink.getEntries().contains(pl.toString()) ||
                                    Teams.gray.getEntries().contains(pl.toString())) {

                                pl.getInventory().clear();
                                if (Teams.red.getEntries().contains(pl.toString())) {
                                    pl.teleport(redl);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§c" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&c&lR&r&c '");
                                }
                                if (Teams.blue.getEntries().contains(pl.toString())) {
                                    pl.teleport(bluel);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§9" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&9&lB&r&9 '");
                                }
                                if (Teams.green.getEntries().contains(pl.toString())) {
                                    pl.teleport(greenl);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§a" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&a&lG&r&a '");
                                }
                                if (Teams.yellow.getEntries().contains(pl.toString())) {
                                    pl.teleport(yellowl);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§e" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&e&lY&r&e '");
                                }
                                if (Teams.aqua.getEntries().contains(pl.toString())) {
                                    pl.teleport(aqual);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§b" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&b&lA&r&b '");
                                }
                                if (Teams.white.getEntries().contains(pl.toString())) {
                                    pl.teleport(whitel);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§f" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&f&lW&r&f '");
                                }
                                if (Teams.pink.getEntries().contains(pl.toString())) {
                                    pl.teleport(pinkl);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§d" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&d&lP&r&d '");
                                }
                                if (Teams.gray.getEntries().contains(pl.toString())) {
                                    pl.teleport(grayl);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§8" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&8&lS&r&8 '");
                                }
                            }
                        }
                    }
                }
            }.runTaskTimer(JavaPlugin.getProvidingPlugin(Events.class), 0, 20);
        }
    }
    @EventHandler
    public static void onTNTplace(BlockPlaceEvent e) {
        if (e.getBlockPlaced().getType() == Material.TNT) {
            Location TNTloc = e.getBlockPlaced().getLocation();
            e.getBlockPlaced().setType(Material.AIR);
            TNTPrimed tnt = (TNTPrimed) e.getPlayer().getWorld().spawnEntity(TNTloc, EntityType.PRIMED_TNT);
            tnt.setFuseTicks(52);
        }
    }
}
