package com.luidenka.bedwars.generator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Generators {

    public static ArrayList<Integer> taskID = new ArrayList<>();
    public static int taskID2;
    public static int taskID3;
    public static int taskID4;
    public static int taskID5;
    public static int taskID6;
    public static int taskID7;
    public static int taskID8;
    public static int taskID9;
    public static int taskID10;

    public Runnable redGenTask;

    public long redGenTime = 60;
    public long blueGenTime = 60;
    public long greenGenTime = 60;
    public long yellowGenTime = 60;
    public long aquaGenTime = 60;
    public long whiteGenTime = 60;
    public long pinkGenTime = 60;
    public long grayGenTime = 60;
    World world = Bukkit.getWorld("bw_0001");

    Location redGenerator = new Location(world, -39.5, 63, -86.0);
    Location blueGenerator = new Location(world, 40.5, 67, -86.0);
    Location greenGenerator = new Location(world, 87.0, 67, -39.5);
    Location yellowGenerator = new Location(world, 87.0, 63, 40.5);
    Location aquaGenerator = new Location(world, 40.5, 63, 87.0);
    Location whiteGenerator = new Location(world, -39.5, 67, 87.0);
    Location pinkGenerator = new Location(world, -86.0, 67, 40.5);
    Location grayGenerator = new Location(world, -86.0, 63, -39.5);

    Location diamondGenerator1 = new Location(world, 40.5, 62, 40.5);
    Location diamondGenerator2 = new Location(world, 40.5, 66, -39.5);
    Location diamondGenerator3 = new Location(world, -39.5, 62, -39.5);
    Location diamondGenerator4 = new Location(world, -39.5, 66, 40.5);

    Location emeraldgen1 = new Location(world, -11.5, 62, -11.5);
    Location emeraldgen2 = new Location(world, 12.5, 66, -11.5);
    Location emeraldgen3 = new Location(world, 12.5, 62, 12.5);
    Location emeraldgen4 = new Location(world, -11.5, 66, 12.5);

    public void GenerateIron() {

        taskID.add(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), redGenTask = new Runnable() {
            @Override
            public void run() {
                world.dropItem(redGenerator, new ItemStack(Material.IRON_INGOT));
            }
        }, 20L, redGenTime));

        taskID.add(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(blueGenerator, new ItemStack(Material.IRON_INGOT));
            }
        }, 20L, blueGenTime));

        taskID.add(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(greenGenerator, new ItemStack(Material.IRON_INGOT));
            }
        }, 20L, greenGenTime));

        taskID.add(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(yellowGenerator, new ItemStack(Material.IRON_INGOT));
            }
        }, 20L, yellowGenTime));

        taskID.add(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(aquaGenerator, new ItemStack(Material.IRON_INGOT));
            }
        }, 20L, aquaGenTime));

        taskID.add(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(whiteGenerator, new ItemStack(Material.IRON_INGOT));
            }
        }, 20L, whiteGenTime));

        taskID.add(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(pinkGenerator, new ItemStack(Material.IRON_INGOT));
            }
        }, 20L, pinkGenTime));

        taskID.add(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(grayGenerator, new ItemStack(Material.IRON_INGOT));
            }
        }, 20L, grayGenTime));
    }

    public void GenerateGold() {
        taskID2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(redGenerator, new ItemStack(Material.GOLD_INGOT));
                world.dropItem(blueGenerator, new ItemStack(Material.GOLD_INGOT));
                world.dropItem(greenGenerator, new ItemStack(Material.GOLD_INGOT));
                world.dropItem(yellowGenerator, new ItemStack(Material.GOLD_INGOT));
                world.dropItem(aquaGenerator, new ItemStack(Material.GOLD_INGOT));
                world.dropItem(whiteGenerator, new ItemStack(Material.GOLD_INGOT));
                world.dropItem(pinkGenerator, new ItemStack(Material.GOLD_INGOT));
                world.dropItem(grayGenerator, new ItemStack(Material.GOLD_INGOT));
            }
        }, 20L, 240L);
    }

    public void GenerateDiamonds() {
        taskID3 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(diamondGenerator1, new ItemStack(Material.DIAMOND));
            }
        }, 20L, 600L);

        taskID4 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(diamondGenerator2, new ItemStack(Material.DIAMOND));
            }
        }, 20L, 600L);

        taskID5 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(diamondGenerator3, new ItemStack(Material.DIAMOND));
            }
        }, 20L, 600L);

        taskID6 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(diamondGenerator4, new ItemStack(Material.DIAMOND));
            }
        }, 20L, 600L);
    }

    public void GenerateEmeralds() {
        taskID7 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(emeraldgen1, new ItemStack(Material.EMERALD));
            }
        }, 20L, 1280L);

        taskID8 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(emeraldgen2, new ItemStack(Material.EMERALD));
            }
        }, 20L, 1280L);

        taskID9 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(emeraldgen3, new ItemStack(Material.EMERALD));
            }
        }, 20L, 1280L);

        taskID10 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Generators.class), new Runnable() {
            @Override
            public void run() {
                world.dropItem(emeraldgen4, new ItemStack(Material.EMERALD));
            }
        }, 20L, 1280L);
    }
}