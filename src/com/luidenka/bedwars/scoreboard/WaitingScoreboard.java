package com.luidenka.bedwars.scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class WaitingScoreboard implements Listener{
    public static Scoreboard scoreboard;
    public static String status = "Waiting...";
    public static String mode = "";
    public static Integer players = 0;
    public static void Scoreboard (){
        ScoreboardManager manager = Bukkit.getServer().getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("waiting", "dummy",
                ChatColor.translateAlternateColorCodes('&', "&e&lBEDWARS"));
        obj.getScore(ChatColor.GRAY + DateTimeFormatter.ofPattern("yy/MM/dd").format(LocalDateTime.now())).setScore(11);
        obj.getScore("").setScore(10);
        obj.getScore("Map: "+ChatColor.GREEN+"").setScore(9);
        obj.getScore("Players: "+ChatColor.GREEN+players).setScore(8);
        obj.getScore("").setScore(7);
        obj.getScore(status).setScore(6);
        obj.getScore("").setScore(5);
        obj.getScore("Mode: "+ChatColor.GREEN+mode).setScore(4);
        obj.getScore("Version: "+ChatColor.GRAY+"v0.1 "+ChatColor.GOLD+"beta").setScore(3);
        obj.getScore("").setScore(2);
        obj.getScore(ChatColor.YELLOW+"mc.oms.net").setScore(1);
    }
}