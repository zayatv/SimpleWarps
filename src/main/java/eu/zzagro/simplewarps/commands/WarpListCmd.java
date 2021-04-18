package eu.zzagro.simplewarps.commands;

import eu.zzagro.simplewarps.SimpleWarps;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpListCmd implements CommandExecutor {

    private final SimpleWarps plugin;

    public WarpListCmd(SimpleWarps plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("simplewarps.warplist")) {
                if (command.getName().equalsIgnoreCase("warplist")) {
                    player.sendMessage(plugin.prefix + ChatColor.GREEN + "All of your warps are listed below:");
                    for (String str : plugin.getConfig().getKeys(false)) {
                        player.sendMessage(ChatColor.WHITE + ">> " + ChatColor.GOLD + str);
                    }
                }
            } else {
                player.sendMessage(plugin.prefix + ChatColor.RED + "You do not have the required permission!");
            }
        }
        return false;
    }
}
