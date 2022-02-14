package com.github.noahkalboussi.lobbysystem.event;

import com.github.noahkalboussi.lobbysystem.LobbySystem;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
    FileConfiguration config = LobbySystem.plugin.getConfig();

    @EventHandler
    public void onPlayerMove (PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;

        if (player.getLocation().getBlockY() == config.getInt("RespawnHeight")) {
            player.teleport(new Location(player.getWorld(), config.getInt("Spawn.X"), config.getInt("Spawn.Y"), config.getInt("Spawn.Z")));
        }
    }
}
