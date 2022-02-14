package com.github.noahkalboussi.lobbysystem.event;

import com.github.noahkalboussi.lobbysystem.LobbySystem;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import java.util.ArrayList;
import java.util.List;

public class DoubleJump implements Listener {
    FileConfiguration config = LobbySystem.plugin.getConfig();

    private List<Player> doubleJump;

    public DoubleJump() {
        doubleJump = new ArrayList<>();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setAllowFlight(true);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        doubleJump.remove(event.getPlayer());
    }

    @EventHandler
    public void onToggleFlight(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        GameMode gameMode = player.getGameMode();

        if(gameMode == GameMode.CREATIVE || gameMode == GameMode.SPECTATOR || player.isFlying() || config.getBoolean("DoubleJump") == false) return;

        event.setCancelled(true);
        doubleJump.add(player);

        player.setAllowFlight(false);
        player.setFlying(false);
        player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));

    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if ((player.isOnGround() || event.getTo().getBlock().isLiquid()) && doubleJump.remove(player)) {
            player.setAllowFlight(true);
        }

    }
}
