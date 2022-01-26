package com.luidenka.bedwars;

import com.luidenka.bedwars.commands.Commands;
import com.luidenka.bedwars.scoreboard.LobbyScoreboard;
import com.luidenka.bedwars.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import com.luidenka.bedwars.scoreboard.WaitingScoreboard;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Bedwars extends JavaPlugin{
    public static Player redPlayer;
    public static Player bluePlayer;
    public static Player greenPlayer;
    public static Player yellowPlayer;
    public static Player aquaPlayer;
    public static Player whitePlayer;
    public static Player pinkPlayer;
    public static Player grayPlayer;
    @Override
    public void onEnable() {
        getCommand("test").setExecutor(new Commands());
        getPlayers();
        getLogger().info("Loaded OMS Bedwars!");
    }
    @Override
    public void onDisable() {
        getLogger().info("Unloaded OMS Bedwars!");
    }
    public void getPlayers() {
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (Teams.red.getEntries().contains(player.toString())) {
                        redPlayer = player;
                    }

                    if (Teams.blue.getEntries().contains(player.toString())) {
                        bluePlayer = player;
                    }

                    if (Teams.green.getEntries().contains(player.toString())) {
                        greenPlayer = player;
                    }

                    if (Teams.yellow.getEntries().contains(player.toString())) {
                        yellowPlayer = player;
                    }

                    if (Teams.aqua.getEntries().contains(player.toString())) {
                        aquaPlayer = player;
                    }

                    if (Teams.white.getEntries().contains(player.toString())) {
                        whitePlayer = player;
                    }

                    if (Teams.pink.getEntries().contains(player.toString())) {
                        pinkPlayer = player;
                    }

                    if (Teams.gray.getEntries().contains(player.toString())) {
                        grayPlayer = player;
                    }
                }
            }
        }, 400L, 5L);
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        for(Player p : getServer().getOnlinePlayers()){
            if(p.getWorld().getName() != "lobby"){
                p.setScoreboard(WaitingScoreboard.scoreboard);
            }
            else {
                p.setScoreboard(LobbyScoreboard.scoreboard);
            }
        }
    }
    public void sendToServer(Player player, String name) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(name);
        } catch (IOException eee) {
            Bukkit.getLogger().info("You'll never see me!");
        }
        player.sendPluginMessage(JavaPlugin.getProvidingPlugin(Commands.class), "BungeeCord", b.toByteArray());

    }
}