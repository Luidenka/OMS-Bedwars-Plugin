package com.luidenka.bedwars.events;

import com.luidenka.bedwars.teams.Teams;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import static com.luidenka.bedwars.events.Misc.playerPlacedBlocks;
import static com.luidenka.bedwars.teams.Teams.*;

public class PlayerDeath implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        Player killer = e.getEntity().getKiller();
        String deathMessage = "";
        if(e.getDeathMessage().contains("fell out of the world")){
            deathMessage = (player.getName()+ ChatColor.GRAY+" fell to the void.");
        }
        else if(e.getDeathMessage().contains(" didn't want to live in the same world as")){
            deathMessage = (player.getName()+ChatColor.GRAY+" was knocked to the void by" + killer +
                    ChatColor.GRAY+'.');
        }
        else if(e.getDeathMessage().contains("was slain by")) {
            deathMessage = (player.getName()+ChatColor.GRAY+" was killed by"+killer+ChatColor.GRAY+'.');
        }
        else if (red.getEntries().contains(player)) {
            if (RedCanDie = false) {
                deathMessage = deathMessage+ChatColor.AQUA+ChatColor.BOLD+" FINAL KILL!";
                player.sendMessage(ChatColor.RED+"You have been eliminated!");
            }
            else {
                haveBedSpec(player);
            }
        }
        else if (blue.getEntries().contains(player)) {
            if (BlueCanDie = false) {
                deathMessage = deathMessage+ChatColor.AQUA+ChatColor.BOLD+" FINAL KILL!";
                player.sendMessage(ChatColor.RED+"You have been eliminated!");
            }
            else {
                haveBedSpec(player);
            }
        }
        else if (green.getEntries().contains(player)) {
            if (GreenCanDie = false) {
                deathMessage = deathMessage+ChatColor.AQUA+ChatColor.BOLD+" FINAL KILL!";
                player.sendMessage(ChatColor.RED+"You have been eliminated!");
            }
            else {
                haveBedSpec(player);
            }
        }
        else if (yellow.getEntries().contains(player)) {
            if (YellowCanDie = false) {
                deathMessage = deathMessage+ChatColor.AQUA+ChatColor.BOLD+" FINAL KILL!";
                player.sendMessage(ChatColor.RED+"You have been eliminated!");
            }
            else {
                haveBedSpec(player);
            }
        }
        else if (aqua.getEntries().contains(player)) {
            if (AquaCanDie = false) {
                deathMessage = deathMessage+ChatColor.AQUA+ChatColor.BOLD+" FINAL KILL!";
                player.sendMessage(ChatColor.RED+"You have been eliminated!");
            }
            else {
                haveBedSpec(player);
            }
        }
        else if (white.getEntries().contains(player)) {
            if (WhiteCanDie = false) {
                deathMessage = deathMessage+ChatColor.AQUA+ChatColor.BOLD+" FINAL KILL!";
                player.sendMessage(ChatColor.RED+"You have been eliminated!");
            }
            else {
                haveBedSpec(player);
            }
        }
        else if (pink.getEntries().contains(player)) {
            if (PinkCanDie = false) {
                deathMessage = deathMessage+ChatColor.AQUA+ChatColor.BOLD+" FINAL KILL!";
                player.sendMessage(ChatColor.RED+"You have been eliminated!");
            }
            else {
                haveBedSpec(player);
            }
        }
        else if (gray.getEntries().contains(player)) {
            if (GrayCanDie = false) {
                deathMessage = deathMessage+ChatColor.AQUA+ChatColor.BOLD+" FINAL KILL!";
                player.sendMessage(ChatColor.RED+"You have been eliminated!");
            }
            else {
                haveBedSpec(player);
            }
        }
        e.setDeathMessage(deathMessage);
    }

    public void haveBedSpec(Player player) {
        player.getInventory().clear();
        player.setGameMode(GameMode.SPECTATOR);
        player.setAllowFlight(true);
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10000000, 1, true));
        player.teleport(new Location(Teams.world, 0, 105, 0));
        new BukkitRunnable() {
            private int seconds = 5;
            @Override
            public void run() {
                if (seconds > 1) {
                    player.sendTitle(ChatColor.RED + "YOU DIED!", ChatColor.YELLOW + "You will respawn in "
                                    + ChatColor.RED + seconds
                                    + ChatColor.YELLOW + " seconds!"
                            , 5, 10, 5);
                    seconds--;
                } else if (seconds == 1) {
                    player.sendTitle(ChatColor.RED + "YOU DIED!", ChatColor.YELLOW + "You will respawn in "
                                    + ChatColor.RED + seconds
                                    + ChatColor.YELLOW + " second!"
                            , 5, 10, 5);
                    seconds--;
                } else {
                    player.setAllowFlight(false);
                    player.setGameMode(GameMode.SURVIVAL);
                    player.setHealth(20);
                    player.removePotionEffect(PotionEffectType.INVISIBILITY);
                    player.teleport(Teams.redl);
                    player.getInventory().setItem(player.getInventory().firstEmpty(), new ItemStack(Material.WOODEN_SWORD, 1));
                    this.cancel();
                }
            }
        }.runTaskTimer(JavaPlugin.getProvidingPlugin(PlayerDeath.class), 0, 20);
    }
}
