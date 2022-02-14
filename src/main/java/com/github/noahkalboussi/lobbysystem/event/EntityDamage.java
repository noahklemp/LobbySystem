package com.github.noahkalboussi.lobbysystem.event;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

    @EventHandler
    public void onEntityDamage (EntityDamageEvent event) {
        if (event.getEntity().getType() != EntityType.PLAYER) return;
        event.setCancelled(true);
    }
}
