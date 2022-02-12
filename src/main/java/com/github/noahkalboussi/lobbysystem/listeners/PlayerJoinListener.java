package com.github.noahkalboussi.lobbysystem.listeners;

import com.github.noahkalboussi.lobbysystem.items.NavigationItems;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("§7» " + ChatColor.YELLOW + player.getName());
        player.setGameMode(GameMode.ADVENTURE);
        player.setFoodLevel(20);
        player.setHealth(20);

        player.getInventory().clear();
        player.getInventory().setItem(0, NavigationItems.compass);
        player.getInventory().setItem(1, NavigationItems.disk);
        player.getInventory().setItem(7, NavigationItems.gadget);
        player.getInventory().setItem(8, NavigationItems.head);

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("scoreboard", "dummy");

        objective.setDisplayName("  §f§lSERVER.NET  ");
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
        objective.getScore("§a0 " + "§7/33").setScore(3);

        player.setScoreboard(scoreboard);




    }


}
