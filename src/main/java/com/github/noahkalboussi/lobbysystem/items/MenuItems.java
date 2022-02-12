package com.github.noahkalboussi.lobbysystem.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MenuItems {

    public static ItemStack compass;


    public static void init() {
        createCompass();

    }

    private static void createCompass() {
        ItemStack item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§c§lNavigator §r§7(right click)");
        List<String> lore = new ArrayList<>();
        lore.add("§7description here");
        lore.add("§7description here");
        meta.setLore(lore);
        item.setItemMeta(meta);
        compass = item;
    }

}
