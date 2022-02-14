package com.github.noahkalboussi.lobbysystem.item;

import com.github.noahkalboussi.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerHider implements Listener {

    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem().getItemMeta().equals(ItemManager.HiderGreen.getItemMeta())) {
                player.getInventory().remove(ItemManager.HiderGreen);
                player.getInventory().addItem(ItemManager.HiderRed);
                for(Player online : Bukkit.getOnlinePlayers()){
                    player.showPlayer(online);
                }
            }

            if (event.getItem().getItemMeta().equals(ItemManager.HiderRed.getItemMeta())) {
                player.getInventory().remove(ItemManager.HiderRed);
                player.getInventory().addItem(ItemManager.HiderGreen);
                for(Player online : Bukkit.getOnlinePlayers()){
                    player.hidePlayer(online);
                }
            }
        }

    }
}
