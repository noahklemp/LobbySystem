package com.github.noahkalboussi.lobbysystem.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class CancelListener implements Listener {

    /** Event Cancels **/

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event)
    {
        event.getEntity().setFoodLevel(20);
    }

    @EventHandler
    public void onEntityDamage (EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerItemDrop (PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if(player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
     public void onBlockBreak (BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        else {

            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace (BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if(player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemPickup (PlayerPickupItemEvent event) {
        Player player = event.getPlayer();

        if(player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHandSwap (InventoryClickEvent event) {

        if(event.getWhoClicked().getGameMode() == GameMode.CREATIVE) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onModeChange (PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();

        if(player.getGameMode() == GameMode.SURVIVAL) {
            player.setGameMode(GameMode.ADVENTURE);
        }
    }
}
