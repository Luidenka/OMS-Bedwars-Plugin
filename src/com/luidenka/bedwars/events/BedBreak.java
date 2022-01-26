package com.luidenka.bedwars.events;

import com.luidenka.bedwars.scoreboard.InGameScoreboard;
import com.luidenka.bedwars.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import com.luidenka.bedwars.scoreboard.InGameScoreboard.*;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scoreboard.Score;

import static com.luidenka.bedwars.Bedwars.*;
import static com.luidenka.bedwars.teams.Teams.*;

public class BedBreak implements Listener {
    @EventHandler
    public static void onBedBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.RED_BED) {
            e.setDropItems(false);
            Player player = e.getPlayer();
            if (Teams.red.getEntries().contains(player.toString())) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't break your own bed!");
            } else {
                if (Teams.red.getEntries().size() > 0) {
                    redPlayer.sendTitle("§cBED DESTROYED!", "§fYou will no longer respawn!", 5, 50, 5);
                }
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    for (Player play : Bukkit.getOnlinePlayers()) {
                            play.sendMessage("\n§f§lBED DESTRUCTION > " + "§cRed Bed" + "§7 was destroyed by " + player.getPlayerListName() + "§7!\n");
                            world.playSound(play.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 1);
                    }
                }
            }
            RedCanDie = false;
            if (Teams.red.getEntries().size() == 0) {
                InGameScoreboard.scoreboard.resetScores(ChatColor.RED+"R"+ChatColor.WHITE+" Red: "+InGameScoreboard.redb);
                InGameScoreboard.redb = "§c✗";
                InGameScoreboard.obj.getScore(ChatColor.RED+"R"+ChatColor.WHITE+" Red: "+InGameScoreboard.redb).setScore(9);
            }

            else {
                InGameScoreboard.scoreboard.resetScores(ChatColor.RED+"R"+ChatColor.WHITE+" Red: "+InGameScoreboard.redb);
                InGameScoreboard.redb = "§a" + red.getEntries().size();
                InGameScoreboard.obj.getScore(ChatColor.RED+"R"+ChatColor.WHITE+" Red: "+InGameScoreboard.redb).setScore(9);
            }
        }
        else if (e.getBlock().getType() == Material.BLUE_BED) {
            e.setDropItems(false);
            Player player = e.getPlayer();

            if (Teams.blue.getEntries().contains(player.toString())) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't break your own bed!");
            } else {
                if (Teams.blue.getEntries().size() > 0) {
                    bluePlayer.sendTitle("§cBED DESTROYED!", "§fYou will no longer respawn!", 5, 50, 5);
                }
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    for (Player play : Bukkit.getOnlinePlayers()) {
                        play.sendMessage("\n§f§lBED DESTRUCTION > " + "§9Blue Bed" + "§7 was destroyed by " + player.getPlayerListName() + "§7!\n");
                        world.playSound(play.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 1);
                    }
                }
            }
            BlueCanDie = false;
            if (Teams.blue.getEntries().size() == 0) {
                InGameScoreboard.scoreboard.resetScores(ChatColor.BLUE + "B" + ChatColor.WHITE + " Blue: " + InGameScoreboard.blueb);
                InGameScoreboard.redb = "§c✗";
                InGameScoreboard.obj.getScore(ChatColor.BLUE + "B" + ChatColor.WHITE + " Blue: " + InGameScoreboard.blueb).setScore(8);
            } else {
                InGameScoreboard.scoreboard.resetScores(ChatColor.BLUE + "B" + ChatColor.WHITE + " Blue: " + InGameScoreboard.blueb);
                InGameScoreboard.redb = "§a" + red.getEntries().size();
                InGameScoreboard.obj.getScore(ChatColor.BLUE + "B" + ChatColor.WHITE + " Blue: " + InGameScoreboard.blueb).setScore(8);
            }
        } else if (e.getBlock().getType() == Material.GREEN_BED) {
            e.setDropItems(false);
            Player player = e.getPlayer();

            if (Teams.green.getEntries().contains(player.toString())) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't break your own bed!");
            } else {
                if (Teams.green.getEntries().size() > 0) {
                    greenPlayer.sendTitle("§cBED DESTROYED!", "§fYou will no longer respawn!", 5, 50, 5);
                }
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    for (Player play : Bukkit.getOnlinePlayers()) {
                        play.sendMessage("\n§f§lBED DESTRUCTION > " + "§aGreen Bed" + "§7 was destroyed by " + player.getPlayerListName() + "§7!\n");
                        world.playSound(play.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 1);
                    }
                }
            }
            GreenCanDie = false;
            if (Teams.green.getEntries().size() == 0) {
                InGameScoreboard.scoreboard.resetScores(ChatColor.GREEN + "G" + ChatColor.WHITE + " Green: " + InGameScoreboard.greenb);
                InGameScoreboard.redb = "§c✗";
                InGameScoreboard.obj.getScore(ChatColor.GREEN + "G" + ChatColor.WHITE + " Green: " + InGameScoreboard.greenb).setScore(7);
            } else {
                InGameScoreboard.scoreboard.resetScores(ChatColor.GREEN + "G" + ChatColor.WHITE + " Green: " + InGameScoreboard.greenb);
                InGameScoreboard.redb = "§a" + red.getEntries().size();
                InGameScoreboard.obj.getScore(ChatColor.GREEN + "G" + ChatColor.WHITE + " Green: " + InGameScoreboard.greenb).setScore(7);
            }
        }
        else if (e.getBlock().getType() == Material.YELLOW_BED) {
            e.setDropItems(false);
            Player player = e.getPlayer();

            if (Teams.yellow.getEntries().contains(player.toString())) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't break your own bed!");
            } else {
                if (Teams.yellow.getEntries().size() > 0) {
                    yellowPlayer.sendTitle("§cBED DESTROYED!", "§fYou will no longer respawn!", 5, 50, 5);
                }
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    for (Player play : Bukkit.getOnlinePlayers()) {
                        play.sendMessage("\n§f§lBED DESTRUCTION > " + "§eYellow Bed" + "§7 was destroyed by " + player.getPlayerListName() + "§7!\n");
                        world.playSound(play.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 1);
                    }
                }
            }
            YellowCanDie = false;
            if (yellow.getEntries().size() == 0) {
                InGameScoreboard.scoreboard.resetScores(ChatColor.YELLOW + "Y" + ChatColor.WHITE + " Yellow: " + InGameScoreboard.yellowb);
                InGameScoreboard.yellowb = "§c✗";
                InGameScoreboard.obj.getScore(ChatColor.YELLOW + "Y" + ChatColor.WHITE + " Yellow: " + InGameScoreboard.yellowb).setScore(6);
            } else {
                InGameScoreboard.scoreboard.resetScores(ChatColor.YELLOW + "Y" + ChatColor.WHITE + " Yellow: " + InGameScoreboard.yellowb);
                InGameScoreboard.yellowb = "§a" + yellow.getEntries().size();
                InGameScoreboard.obj.getScore(ChatColor.YELLOW + "Y" + ChatColor.WHITE + " Yellow: " + InGameScoreboard.yellowb).setScore(6);
            }
        }
        else if (e.getBlock().getType() == Material.CYAN_BED) {
            e.setDropItems(false);
            Player player = e.getPlayer();

            if (Teams.aqua.getEntries().contains(player.toString())) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't break your own bed!");
            } else {
                if (Teams.aqua.getEntries().size() > 0) {
                    aquaPlayer.sendTitle("§cBED DESTROYED!", "§fYou will no longer respawn!", 5, 50, 5);
                }
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    for (Player play : Bukkit.getOnlinePlayers()) {
                        play.sendMessage("\n§f§lBED DESTRUCTION > " + "§bAqua Bed" + "§7 was destroyed by " + player.getPlayerListName() + "§7!\n");
                        world.playSound(play.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 1);
                    }
                }
            }
            AquaCanDie = false;
            if (aqua.getEntries().size() == 0) {
                InGameScoreboard.scoreboard.resetScores(ChatColor.AQUA + "A" + ChatColor.WHITE + " Aqua: " + InGameScoreboard.aquab);
                InGameScoreboard.aquab = "§c✗";
                InGameScoreboard.obj.getScore(ChatColor.AQUA + "A" + ChatColor.WHITE + " Aqua: " + InGameScoreboard.aquab).setScore(5);
            } else {
                InGameScoreboard.scoreboard.resetScores(ChatColor.AQUA + "A" + ChatColor.WHITE + " Aqua: " + InGameScoreboard.aquab);
                InGameScoreboard.aquab = "§a" + white.getEntries().size();
                InGameScoreboard.obj.getScore(ChatColor.AQUA + "A" + ChatColor.WHITE + " Aqua: " + InGameScoreboard.aquab).setScore(5);
            }
        }
        else if (e.getBlock().getType() == Material.WHITE_BED) {
            e.setDropItems(false);
            Player player = e.getPlayer();

            if (Teams.white.getEntries().contains(player.toString())) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't break your own bed!");
            } else {
                if (Teams.white.getEntries().size() > 0) {
                    whitePlayer.sendTitle("§cBED DESTROYED!", "§fYou will no longer respawn!", 5, 50, 5);
                }
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    for (Player play : Bukkit.getOnlinePlayers()) {
                        play.sendMessage("\n§f§lBED DESTRUCTION > " + "§rWhite Bed" + "§7 was destroyed by " + player.getPlayerListName() + "§7!\n");
                        world.playSound(play.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 1);
                    }
                }
            }
            WhiteCanDie = false;
            if (pink.getEntries().size() == 0) {
                InGameScoreboard.scoreboard.resetScores("" + InGameScoreboard.whiteb);
                InGameScoreboard.pinkb = "§c✗";
                InGameScoreboard.obj.getScore("W White: " + InGameScoreboard.whiteb).setScore(4);
            } else {
                InGameScoreboard.scoreboard.resetScores( "W White: " + InGameScoreboard.whiteb);
                InGameScoreboard.pinkb = "§a" + aqua.getEntries().size();
                InGameScoreboard.obj.getScore("W White: " + InGameScoreboard.whiteb).setScore(4);
            }
        }
        else if (e.getBlock().getType() == Material.PINK_BED) {
            e.setDropItems(false);
            Player player = e.getPlayer();

            if (Teams.pink.getEntries().contains(player.toString())) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't break your own bed!");
            } else {
                if (Teams.pink.getEntries().size() > 0) {
                    pinkPlayer.sendTitle("§cBED DESTROYED!", "§fYou will no longer respawn!", 5, 50, 5);
                }
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    for (Player play : Bukkit.getOnlinePlayers()) {
                        play.sendMessage("\n§f§lBED DESTRUCTION > " + "§dRed Bed" + "§7 was destroyed by " + player.getPlayerListName() + "§7!\n");
                        world.playSound(play.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 1);
                    }
                }
            }
            PinkCanDie = false;
            if (pink.getEntries().size() == 0) {
                InGameScoreboard.scoreboard.resetScores(ChatColor.LIGHT_PURPLE + "P" + ChatColor.WHITE + " Pink: " + InGameScoreboard.pinkb);
                InGameScoreboard.pinkb = "§c✗";
                InGameScoreboard.obj.getScore(ChatColor.LIGHT_PURPLE + "P" + ChatColor.WHITE + " Pink: " + InGameScoreboard.pinkb).setScore(3);
            } else {
                InGameScoreboard.scoreboard.resetScores(ChatColor.LIGHT_PURPLE + "P" + ChatColor.WHITE + " Pink: " + InGameScoreboard.pinkb);
                InGameScoreboard.pinkb = "§a" + pink.getEntries().size();
                InGameScoreboard.obj.getScore(ChatColor.LIGHT_PURPLE + "P" + ChatColor.WHITE + " Pink: " + InGameScoreboard.pinkb).setScore(3);
            }
        }
        else if (e.getBlock().getType() == Material.GRAY_BED) {
            e.setDropItems(false);
            Player player = e.getPlayer();

            if (Teams.gray.getEntries().contains(player.toString())) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't break your own bed!");
            } else {
                if (Teams.gray.getEntries().size() > 0) {
                    grayPlayer.sendTitle("§cBED DESTROYED!", "§fYou will no longer respawn!", 5, 50, 5);
                }
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    for (Player play : Bukkit.getOnlinePlayers()) {
                        play.sendMessage("\n§f§lBED DESTRUCTION > " + "§7Gray Bed" + "§7 was destroyed by " + player.getPlayerListName() + "§7!\n");
                        world.playSound(play.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 1);
                    }
                }
            }
        }
        GrayCanDie = false;
        if (gray.getEntries().size() == 0) {
            InGameScoreboard.scoreboard.resetScores(ChatColor.GRAY + "S" + ChatColor.WHITE + " Gray: " + InGameScoreboard.grayb);
            InGameScoreboard.grayb = "§c✗";
            InGameScoreboard.obj.getScore(ChatColor.GRAY + "S" + ChatColor.WHITE + " Gray: " + InGameScoreboard.grayb).setScore(2);
        } else {
            InGameScoreboard.scoreboard.resetScores(ChatColor.GRAY + "S" + ChatColor.WHITE + " Gray: " + InGameScoreboard.grayb);
            InGameScoreboard.grayb = "§a" + pink.getEntries().size();
            InGameScoreboard.obj.getScore(ChatColor.GRAY + "S" + ChatColor.WHITE + " Gray: " + InGameScoreboard.grayb).setScore(2);
        }
    }
}
