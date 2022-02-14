package com.github.noahkalboussi.lobbysystem.command;

import com.github.noahkalboussi.lobbysystem.LobbySystem;
import com.github.noahkalboussi.lobbysystem.item.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {
    FileConfiguration config = LobbySystem.plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) { return true; }
        Player player = (Player) commandSender;
        String Prefix = config.getString("Prefix");

        if (command.getName().equalsIgnoreCase("spawn")) {
            if (player.hasPermission("lobby.spawn")) {
                player.teleport(new Location(player.getWorld(), config.getInt("Spawn.X"), config.getInt("Spawn.Y"), config.getInt("Spawn.Z")));
            }
        }

        if (command.getName().equalsIgnoreCase("setSpawn")) {
            if (player.hasPermission("lobby.setspawn")) {
                player.sendMessage(Prefix + "§6§lSpawn §r§7set at §f"+ player.getLocation().getBlockX()+"§f "+player.getLocation().getBlockY()+"§f "+player.getLocation().getBlockZ());
            }
        }

        if (command.getName().equalsIgnoreCase("setHeight")) {
            if (player.hasPermission("lobby.setheight")) {
                player.sendMessage(Prefix + "§7Set respawn height to §f" + player.getLocation().getBlockY());
            }
        }

        return true;
    }
}
