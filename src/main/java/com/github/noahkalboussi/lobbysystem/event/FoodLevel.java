package com.github.noahkalboussi.lobbysystem.event;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevel implements Listener {

    @EventHandler
    public void onFoodLevelChange (FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }
}
