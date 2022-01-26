package com.luidenka.bedwars.commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("test")) {
            sender.sendMessage("This is a test command");
        }
        else if (cmd.getName().equalsIgnoreCase("nick")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Sorry, this command is only available to players!");
                return true;
            } else {
                if (args.length < 1) {
                    sender.sendMessage(ChatColor.RED + "Usage: /nick <nickname>");
                    return true;
                } else {
                    Player player = (Player) sender;
                        /*player.setPlayerListName(args[0]);
                        player.setDisplayName(args[0]);
                        player.sendMessage(ChatColor.GREEN + "You are now nicked as '" + player.getPlayerListName() + "'!");*/
                    player.sendMessage("§cThis command is being updated and is temporarily disabled!");
                }
            }
        }
        else if (cmd.getName().equalsIgnoreCase("nickreset")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Sorry, this command is only available to players!");
                return true;

            } else {
                Player player = (Player) sender;
                player.setPlayerListName(player.getName());
                player.setDisplayName(player.getName());
                player.sendMessage(ChatColor.RED + "You are no longer nicked!");
            }
        }

        return true;
    }
}
