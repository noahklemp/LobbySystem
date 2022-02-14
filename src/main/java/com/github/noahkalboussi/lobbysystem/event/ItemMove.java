package com.github.noahkalboussi.lobbysystem.event;

import com.github.noahkalboussi.lobbysystem.inventory.Navigator;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class ItemMove implements Listener {
    @EventHandler
    public void onItemMove (InventoryClickEvent event) {
        if (event.getWhoClicked().getGameMode() == GameMode.CREATIVE || !event.getClickedInventory().getType().equals(InventoryType.PLAYER)) return;

        event.setCancelled(true);
    }
}
