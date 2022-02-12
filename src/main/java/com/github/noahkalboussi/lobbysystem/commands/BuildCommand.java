package com.github.noahkalboussi.lobbysystem.commands;

        import com.github.noahkalboussi.lobbysystem.items.NavigationItems;
        import org.bukkit.ChatColor;
        import org.bukkit.GameMode;
        import org.bukkit.command.Command;
        import org.bukkit.command.CommandExecutor;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) { return true; }
        Player player = (Player) commandSender;

        if(command.getName().equalsIgnoreCase("build")) {

            if(!(player.getGameMode() == GameMode.CREATIVE)) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(("§7[§6Lobby§7] ") + ChatColor.GREEN + "Enabled!");
                player.getInventory().clear();
            }
            else {
                player.setGameMode(GameMode.ADVENTURE);
                player.setAllowFlight(true);
                player.sendMessage(("§7[§6Lobby§7] ") + ChatColor.RED + "Disabled!");
                player.getInventory().clear();
                player.getInventory().setItem(0, NavigationItems.compass);
                player.getInventory().setItem(1, NavigationItems.disk);
                player.getInventory().setItem(7, NavigationItems.gadget);
                player.getInventory().setItem(8, NavigationItems.head);
            }

        }
        return true;
    }
}
