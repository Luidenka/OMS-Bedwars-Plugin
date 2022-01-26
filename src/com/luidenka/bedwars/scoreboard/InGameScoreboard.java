package com.luidenka.bedwars.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import com.luidenka.bedwars.teams.Teams;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InGameScoreboard implements Listener {
    public static Scoreboard scoreboard;
    public static String redb = "§a✓";
    public static String blueb = "§a✓";
    public static String greenb = "§a✓";
    public static String yellowb = "§a✓";
    public static String aquab = "§a✓";
    public static String whiteb = "§a✓";
    public static String pinkb = "§a✓";
    public static String grayb = "§a✓";
    public static Objective obj = scoreboard.registerNewObjective("ingame", "dummy", ChatColor.translateAlternateColorCodes('&', "&e&lBEDWARS"));

    public static void Scoreboard() {
        ScoreboardManager manager = Bukkit.getServer().getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("ingame", "dummy",
                ChatColor.translateAlternateColorCodes('&', "&e&lBEDWARS"));
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(InGameScoreboard.class), new Runnable() {
            @Override
            public void run() {
                obj.getScore(ChatColor.GRAY + DateTimeFormatter.ofPattern("yy/MM/dd").format(LocalDateTime.now())).setScore(11);
                obj.getScore("").setScore(10);
                obj.getScore(ChatColor.RED + "R" + ChatColor.WHITE + " Red: " + redb).setScore(9);
                obj.getScore(ChatColor.BLUE + "B" + ChatColor.WHITE + " Blue: " + blueb).setScore(8);
                obj.getScore(ChatColor.GREEN + "G" + ChatColor.WHITE + " Green: " + greenb).setScore(7);
                obj.getScore(ChatColor.YELLOW + "Y" + ChatColor.WHITE + " Yellow: " + yellowb).setScore(6);
                obj.getScore(ChatColor.AQUA + "A" + ChatColor.WHITE + " Aqua: " + aquab).setScore(5);
                obj.getScore(ChatColor.WHITE + "W" + ChatColor.WHITE + " White: " + whiteb).setScore(4);
                obj.getScore("§dP" + ChatColor.WHITE + " Pink: " + pinkb).setScore(3);
                obj.getScore(ChatColor.GRAY + "S" + ChatColor.WHITE + " Gray: " + grayb).setScore(2);
                obj.getScore("").setScore(1);
                obj.getScore(ChatColor.YELLOW + "mc.oms.net").setScore(0);
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.setScoreboard(scoreboard);
                }
            }
        }, 0L, 20L);
    }
}
