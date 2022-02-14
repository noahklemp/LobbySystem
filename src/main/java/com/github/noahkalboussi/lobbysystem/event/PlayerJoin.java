package com.github.noahkalboussi.lobbysystem.event;

import com.github.noahkalboussi.lobbysystem.LobbySystem;
import com.github.noahkalboussi.lobbysystem.item.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Calendar;

public class PlayerJoin implements Listener {
    FileConfiguration config = LobbySystem.plugin.getConfig();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("§7» " + ChatColor.YELLOW + player.getName());
        player.sendTitle("§r.", "§fWelcome to §6§l" + config.getString("ServerName"), 1, 2, 1);

        player.teleport(new Location(player.getWorld(), config.getInt("Spawn.X"), config.getInt("Spawn.Y"), config.getInt("Spawn.Z")));

        if (config.getBoolean("AdventureMode") == true) {
            player.setGameMode(GameMode.ADVENTURE);
        } else {
            player.setGameMode(GameMode.SURVIVAL);
        }

        int year = Calendar.getInstance().get(Calendar.YEAR);

        player.getInventory().clear();

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("scoreboard", "dummy");
        objective.setDisplayName("  §f§l" + config.getString("ServerName") + "§r  ");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("§r ").setScore(14);
        objective.getScore("§fRank:").setScore(13);
        objective.getScore("§aPlayer").setScore(12);
        objective.getScore("§r  ").setScore(11);
        objective.getScore("§fCoins:").setScore(10);
        objective.getScore("§eAmount").setScore(9);
        objective.getScore("§r   ").setScore(8);
        objective.getScore("§fClan:").setScore(7);
        objective.getScore("§dNo Clan").setScore(6);
        objective.getScore("§r     ").setScore(5);
        objective.getScore("§fFriends:").setScore(4);
        objective.getScore("§a0" + "§7/33").setScore(3);

        if (config.getBoolean("Scoreboard") == true) {
            player.setScoreboard(scoreboard);
        }

        player.setLevel(year);
        player.setFoodLevel(20);
        player.setHealth(20);

        player.getInventory().setItem(0, ItemManager.Navigator);
        player.getInventory().setItem(1, ItemManager.HiderGreen);
        player.getInventory().setItem(7, ItemManager.Items);
        player.getInventory().setItem(8, ItemManager.Profile);

    }
}