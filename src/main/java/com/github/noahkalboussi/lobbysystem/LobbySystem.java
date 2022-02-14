package com.github.noahkalboussi.lobbysystem;

import com.github.noahkalboussi.lobbysystem.command.CommandManager;
import com.github.noahkalboussi.lobbysystem.event.*;
import com.github.noahkalboussi.lobbysystem.inventory.Navigator;
import com.github.noahkalboussi.lobbysystem.item.ItemManager;
import com.github.noahkalboussi.lobbysystem.item.PlayerHider;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;


public final class LobbySystem extends JavaPlugin implements Listener {
    FileConfiguration config = this.getConfig();

    public static LobbySystem plugin;

    @Override
    public void onEnable() {
        plugin = this;

        registerEvents();
        commandManager();
        manageWorld();

        ItemManager.init();

        this.saveDefaultConfig();

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if (config.getString("ActionBarMessage") == null || config.getBoolean("ActionBar") == false) return;

                Bukkit.getServer().getOnlinePlayers().forEach(player -> player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(config.getString("ActionBarMessage"))));

            }
        }, 0L, 35L);
    }

    @Override
    public void onDisable() {
    }

    public void commandManager() {
        getCommand("spawn").setExecutor(new CommandManager());
        getCommand("setSpawn").setExecutor(new CommandManager());
        getCommand("setHeight").setExecutor(new CommandManager());
    }

    public void manageWorld() {
        World world = getServer().getWorld("world");
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setGameRule(GameRule.DO_ENTITY_DROPS, false);
        world.setGameRule(GameRule.DO_FIRE_TICK, false);
        world.setGameRule(GameRule.DO_INSOMNIA, false);
        world.setGameRule(GameRule.DO_MOB_LOOT, false);
        world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        world.setGameRule(GameRule.DO_TRADER_SPAWNING, false);
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        world.setGameRule(GameRule.DISABLE_RAIDS, true);
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, true);
        world.setGameRule(GameRule.MOB_GRIEFING, false);
        world.setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
        world.setGameRule(GameRule.FALL_DAMAGE, false);
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new DoubleJump(), this);
        getServer().getPluginManager().registerEvents(new Navigator(), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new BlockPlace(), this);
        getServer().getPluginManager().registerEvents(new ItemDrop(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new ItemMove(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerHider(), this);
        getServer().getPluginManager().registerEvents(new FoodLevel(), this);
    }
}
