package com.luidenka.bedwars.events;

import com.luidenka.bedwars.scoreboard.InGameScoreboard;
import com.luidenka.bedwars.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import static com.luidenka.bedwars.scoreboard.WaitingScoreboard.status;
import static com.luidenka.bedwars.teams.Teams.*;
import static com.luidenka.bedwars.teams.Teams.grayl;

public class StartGame implements Listener {
    public static int players = Bukkit.getOnlinePlayers().size();
    public static int countdown = 20;
    public static boolean cantakedamage = false;
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
                        red.setPrefix("§c§lR ");
                        blue.setPrefix("§9§lB ");
                        green.setPrefix("§a§lG ");
                        yellow.setPrefix("§e§lY ");
                        aqua.setPrefix("§b§lA ");
                        white.setPrefix("§lW ");
                        pink.setPrefix("§d§lP ");
                        gray.setPrefix("§7§lS ");
                        red.setColor(ChatColor.RED);
                        blue.setColor(ChatColor.BLUE);
                        green.setColor(ChatColor.GREEN);
                        yellow.setColor(ChatColor.YELLOW);
                        aqua.setColor(ChatColor.AQUA);
                        white.setColor(ChatColor.WHITE);
                        pink.setColor(ChatColor.LIGHT_PURPLE);
                        gray.setColor(ChatColor.GRAY);
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
                            if (red.getEntries().contains(pl.toString()) ||
                                    blue.getEntries().contains(pl.toString()) ||
                                    green.getEntries().contains(pl.toString()) ||
                                    yellow.getEntries().contains(pl.toString()) ||
                                    aqua.getEntries().contains(pl.toString()) ||
                                    white.getEntries().contains(pl.toString()) ||
                                    pink.getEntries().contains(pl.toString()) ||
                                    gray.getEntries().contains(pl.toString())) {

                                pl.getInventory().clear();
                                if (red.getEntries().contains(pl.toString())) {
                                    pl.teleport(redl);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§c" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&c&lR&r&c '");
                                }
                                if (blue.getEntries().contains(pl.toString())) {
                                    pl.teleport(bluel);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§9" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&9&lB&r&9 '");
                                }
                                if (green.getEntries().contains(pl.toString())) {
                                    pl.teleport(greenl);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§a" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&a&lG&r&a '");
                                }
                                if (yellow.getEntries().contains(pl.toString())) {
                                    pl.teleport(yellowl);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§e" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&e&lY&r&e '");
                                }
                                if (aqua.getEntries().contains(pl.toString())) {
                                    pl.teleport(aqual);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§b" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&b&lA&r&b '");
                                }
                                if (white.getEntries().contains(pl.toString())) {
                                    pl.teleport(whitel);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§f" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&f&lW&r&f '");
                                }
                                if (pink.getEntries().contains(pl.toString())) {
                                    pl.teleport(pinkl);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " clear");
                                    pl.setDisplayName("§d" + pl.getDisplayName() + "§f");
                                    pl.setPlayerListName(pl.getDisplayName());
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte player " + pl.getName() + " prefix '&d&lP&r&d '");
                                }
                                if (gray.getEntries().contains(pl.toString())) {
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
}
