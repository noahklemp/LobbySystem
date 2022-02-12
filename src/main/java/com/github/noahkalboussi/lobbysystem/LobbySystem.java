package com.github.noahkalboussi.lobbysystem;

import com.github.noahkalboussi.lobbysystem.commands.BuildCommand;
import com.github.noahkalboussi.lobbysystem.commands.ConfigCommand;
import com.github.noahkalboussi.lobbysystem.listeners.*;
import com.github.noahkalboussi.lobbysystem.items.NavigationItems;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbySystem extends JavaPlugin {

    /** config.yml **/
    FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        registerEvents();
        commandManager();
        manageWorld();

        NavigationItems.init();

        this.saveDefaultConfig();

    }

    @Override
    public void onDisable() {
    }

    /** Register Event Classes **/

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new CancelListener(), this);
        getServer().getPluginManager().registerEvents(new DoubleJump(), this);
    }

    /** Command Manager **/

    public void commandManager() {
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("config").setExecutor(new ConfigCommand());
    }

    /** World Manager **/

    public void manageWorld() {
        World world = getServer().getWorld("world");
        world.setGameRule(GameRule.KEEP_INVENTORY, true);
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        world.setGameRule(GameRule.DISABLE_RAIDS, true);
        world.setGameRule(GameRule.DO_ENTITY_DROPS, false);
        world.setGameRule(GameRule.DO_FIRE_TICK, false);
        world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        world.setGameRule(GameRule.MOB_GRIEFING, false);
        world.setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
    }
    /** Chat Format **/

    @EventHandler
    public void onMessage(PlayerChatEvent event) {
        event.setFormat(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.WHITE + " §7» " + event.getMessage());
    }



    /** ... **/


}
