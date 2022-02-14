package com.github.noahkalboussi.lobbysystem.event;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDrop implements Listener {

    @EventHandler
    public void onPlayerItemDrop(PlayerDropItemEvent event) {
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(true);
    }

}
