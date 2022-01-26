package com.luidenka.bedwars.teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scoreboard.*;
import static com.luidenka.bedwars.scoreboard.InGameScoreboard.scoreboard;

public class Teams {
    public static World world = Bukkit.getServer().getWorld("");
    public static String wname = world.getName();
    public static Location redl = new Location(world, -39.5, 63, -82.5);
    public static Location bluel = new Location(world, 40.5, 67, -82.5);
    public static Location greenl = new Location(world, 83.5, 67, -39.5);
    public static Location yellowl = new Location(world, 83.5, 63, 40.5);
    public static Location aqual = new Location(world, 40.5, 63, 83.5);
    public static Location whitel = new Location(world, -39.5, 67, 83.5);
    public static Location pinkl = new Location(world, -82.5, 67, 40.5);
    public static Location grayl = new Location(world, -82.5, 63, -39.5);
    public static Boolean RedCanDie = true;
    public static Boolean BlueCanDie = true;
    public static Boolean GreenCanDie = true;
    public static Boolean YellowCanDie = true;
    public static Boolean AquaCanDie = true;
    public static Boolean WhiteCanDie = true;
    public static Boolean PinkCanDie = true;
    public static Boolean GrayCanDie = true;
    public static Team red = scoreboard.registerNewTeam("Red");
    public static Team blue = scoreboard.registerNewTeam("Blue");
    public static Team gray = scoreboard.registerNewTeam("Gray");
    public static Team white = scoreboard.registerNewTeam("White");
    public static Team pink = scoreboard.registerNewTeam("Pink");
    public static Team aqua = scoreboard.registerNewTeam("Aqua");
    public static Team yellow = scoreboard.registerNewTeam("Yellow");
    public static Team green = scoreboard.registerNewTeam("Green");
}
