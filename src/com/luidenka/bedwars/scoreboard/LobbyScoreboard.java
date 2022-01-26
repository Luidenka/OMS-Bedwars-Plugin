package com.luidenka.bedwars.scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public class LobbyScoreboard implements Listener{
    public static Scoreboard scoreboard;
    public static void Scoreboard (){
        ScoreboardManager manager = Bukkit.getServer().getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("waiting", "dummy",
                ChatColor.translateAlternateColorCodes('&', "&e&lBEDWARS"));
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(LobbyScoreboard.class), new Runnable() {
            @Override
            public void run() {
        obj.getScore("").setScore(13);
        obj.getScore("Your Level: "+ChatColor.GRAY+"1").setScore(12);
        obj.getScore("").setScore(11);
        obj.getScore("Progress: 0/500").setScore(10);
        obj.getScore("").setScore(9);
        obj.getScore("Loot Chests: "+ChatColor.YELLOW+"0").setScore(8);
        obj.getScore("").setScore(7);
        obj.getScore("Coins: "+ChatColor.GOLD+"0").setScore(6);
        obj.getScore("").setScore(5);
        obj.getScore("Total Kills: "+ChatColor.GREEN+"0").setScore(4);
        obj.getScore("Total Wins: "+ChatColor.GREEN+"0").setScore(3);
        obj.getScore("").setScore(2);
        obj.getScore(ChatColor.YELLOW+"mc.oms.net").setScore(1);
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.setScoreboard(scoreboard);
                }
            }
        }, 0L, 20L);
    }
}
