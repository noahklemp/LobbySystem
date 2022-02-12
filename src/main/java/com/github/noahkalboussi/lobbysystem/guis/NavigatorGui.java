package com.github.noahkalboussi.lobbysystem.guis;

import com.github.noahkalboussi.lobbysystem.items.NavigationItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NavigatorGui implements Listener {

    public static Inventory inv = Bukkit.createInventory(null, 3*9, "");

    static {
        inv.setItem(0, new ItemStack(Material.DIRT, 1));
        inv.setItem(8, new ItemStack(Material.GOLD_BLOCK, 1));
        //The first parameter, is the slot that is assigned to. Starts counting at 0
    }

    @EventHandler
    public void openInventory (PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getItem() != null) {

            if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) {

                if (event.getItem().getItemMeta().equals(NavigationItems.compass.getItemMeta())) {
                    player.openInventory(inv);
                }


            }
        }
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("My custom Inventory!")) { // The inventory is our custom Inventory
            if (event.getCurrentItem().getType() == Material.DIRT) {

                player.closeInventory();
            }
        }
    }



}

