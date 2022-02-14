package com.github.noahkalboussi.lobbysystem.inventory;

import com.github.noahkalboussi.lobbysystem.LobbySystem;
import com.github.noahkalboussi.lobbysystem.item.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Navigator implements Listener {
    FileConfiguration config = LobbySystem.plugin.getConfig();

    private final Inventory inv = Bukkit.createInventory(null, 3*9, "Choose a target");
    public void setItems() {
        inv.setItem(2, ItemManager.DailyReward);
        inv.setItem(4, ItemManager.Spawn);
        inv.setItem(6, ItemManager.Lottery);

        inv.setItem(9, ItemManager.Placeholder);
        inv.setItem(10, ItemManager.Placeholder);
        inv.setItem(11, ItemManager.Placeholder);
        inv.setItem(12, ItemManager.Placeholder);
        inv.setItem(13, ItemManager.Placeholder);
        inv.setItem(14, ItemManager.Placeholder);
        inv.setItem(15, ItemManager.Placeholder);
        inv.setItem(16, ItemManager.Placeholder);
        inv.setItem(17, ItemManager.Placeholder);
        inv.setItem(18, ItemManager.Placeholder);
        inv.setItem(19, ItemManager.Placeholder);
        inv.setItem(20, ItemManager.Placeholder);
        inv.setItem(21, ItemManager.Placeholder);
        inv.setItem(22, ItemManager.Placeholder);
        inv.setItem(23, ItemManager.Placeholder);
        inv.setItem(24, ItemManager.Placeholder);
        inv.setItem(25, ItemManager.Placeholder);
        inv.setItem(26, ItemManager.Placeholder);
    }

    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem().getItemMeta().equals(ItemManager.Navigator.getItemMeta())) {
                player.getInventory().clear();
                player.openInventory(inv);
                setItems();
            }
        }
    }

    @EventHandler
    public void onInventoryClose (InventoryCloseEvent event) {
        HumanEntity player = event.getPlayer();
        if(!event.getInventory().equals(inv)) return;
        player.getInventory().setItem(0, ItemManager.Navigator);
        player.getInventory().setItem(1, ItemManager.HiderGreen);
        player.getInventory().setItem(7, ItemManager.Items);
        player.getInventory().setItem(8, ItemManager.Profile);
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() == null || event.getCurrentItem().getType().isAir() || !event.getInventory().equals(inv)) return;

        if (event.getCurrentItem().getItemMeta().equals(ItemManager.Spawn.getItemMeta())) {
            player.teleport(new Location(player.getWorld(), config.getInt("Spawn.X"), config.getInt("Spawn.Y"), config.getInt("Spawn.Z")));
            player.closeInventory();
        }

        event.setCancelled(true);
    }
}

