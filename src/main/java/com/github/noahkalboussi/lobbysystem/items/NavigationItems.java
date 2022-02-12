package com.github.noahkalboussi.lobbysystem.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class NavigationItems {

    public static ItemStack compass;
    public static ItemStack disk;
    public static ItemStack disk2;
    public static ItemStack gadget;
    public static ItemStack head;

    public static void init() {
        createCompass();
        createDisk();
        createDisk2();
        createGadget();
        createHead();

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

    private static void createDisk() {
        ItemStack item = new ItemStack(Material.MUSIC_DISC_CAT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a§lAll players visible §r§7(right click)");
        List<String> lore = new ArrayList<>();
        lore.add("§7description here");
        lore.add("§7description here");
        meta.setLore(lore);
        item.setItemMeta(meta);
        disk = item;
    }

    private static void createDisk2() {
        ItemStack item = new ItemStack(Material.MUSIC_DISC_CHIRP, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§c§lAll players invisible §r§7(right click)");
        List<String> lore = new ArrayList<>();
        lore.add("§7description here");
        lore.add("§7description here");
        meta.setLore(lore);
        item.setItemMeta(meta);
        disk2 = item;
    }
    private static void createGadget() {
        ItemStack item = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6§lItems §r§7(right click)");
        List<String> lore = new ArrayList<>();
        lore.add("§7description here");
        lore.add("§7description here");
        meta.setLore(lore);
        item.setItemMeta(meta);
        gadget = item;
    }
    private static void createHead() {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5§lProfile §r§7(right click)");
        List<String> lore = new ArrayList<>();
        lore.add("§7description here");
        lore.add("§7description here");
        meta.setLore(lore);
        item.setItemMeta(meta);
        head = item;
    }
}