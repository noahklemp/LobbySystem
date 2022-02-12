package com.github.noahkalboussi.lobbysystem.listeners;

import com.github.noahkalboussi.lobbysystem.items.NavigationItems;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event) {
        Player player = event.getPlayer();

            if (event.getItem() != null) {

                /** NavigationItems **/

                if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) {


                if (event.getItem().getItemMeta().equals(NavigationItems.disk.getItemMeta())) {
                    player.getInventory().remove(NavigationItems.disk);
                    player.getInventory().setItem(1, NavigationItems.disk2);
                }

                if (event.getItem().getItemMeta().equals(NavigationItems.disk2.getItemMeta())) {
                    player.getInventory().remove(NavigationItems.disk2);
                    player.getInventory().setItem(1, NavigationItems.disk);
                }

                if (event.getItem().getItemMeta().equals(NavigationItems.gadget.getItemMeta())) {
                    player.sendMessage("worked...");
                }

                if (event.getItem().getItemMeta().equals(NavigationItems.head.getItemMeta())) {
                    player.sendMessage("worked...");
                }

                }
            }
    }
}
