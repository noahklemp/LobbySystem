package com.github.noahkalboussi.lobbysystem.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack Navigator;
    public static ItemStack HiderGreen;
    public static ItemStack HiderRed;
    public static ItemStack Items;
    public static ItemStack Profile;
    public static ItemStack Spawn;
    public static ItemStack DailyReward;
    public static ItemStack Lottery;
    public static ItemStack Placeholder;


    public static void init() {
        createCompass();
        createDisk();
        createDisk2();
        createGadget();
        createHead();
        createSpawn();
        createDailyReward();
        createLottery();
        createPlaceholder();
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
        Navigator = item;
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
        HiderGreen = item;
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
        HiderRed = item;
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
        Items = item;
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
        Profile = item;
    }

    private static void createSpawn() {
        ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a§lSpawn");
        List<String> lore = new ArrayList<>();
        lore.add("§7To Spawn");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Spawn = item;
    }

    private static void createDailyReward() {
        ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6§lDailyReward");
        List<String> lore = new ArrayList<>();
        lore.add("§7Claim your DailyReward!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        DailyReward = item;
    }

    private static void createLottery() {
        ItemStack item = new ItemStack(Material.HEART_OF_THE_SEA, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§e§lLottery");
        List<String> lore = new ArrayList<>();
        lore.add("§7Win prices at the Lottery!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Lottery = item;
    }

    private static void createPlaceholder() {
        ItemStack item = new ItemStack(Material.BARRIER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7Placeholder");
        item.setItemMeta(meta);
        Placeholder = item;
    }
}
