package eu.zzagro.simplewarps.commands;

import eu.zzagro.simplewarps.SimpleWarps;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCmd implements CommandExecutor {

    private final SimpleWarps plugin;

    public SetWarpCmd(SimpleWarps plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("simplewarps.setwarp")) {
                if (command.getName().equalsIgnoreCase("setwarp")) {
                    if (args.length != 1) {
                        player.sendMessage(plugin.prefix + ChatColor.RED + "Usage: /setwarp <name>");
                    } else {
                        String warpName = new String(args[0]);
                        if (!(plugin.getConfig().contains(args[0]))) {
                            plugin.getConfig().set(args[0] + ".location", player.getLocation());
                            plugin.saveConfig();
                            player.sendMessage(plugin.prefix + ChatColor.GREEN + "Warp " + ChatColor.GOLD + args[0] + ChatColor.GREEN + " successfully set!");
                        } else {
                            player.sendMessage(plugin.prefix + ChatColor.RED + "The Warp " + ChatColor.GOLD + args[0] + ChatColor.RED + " already exists!");
                        }
                    }
                }
            } else {
                player.sendMessage(plugin.prefix + ChatColor.RED + "You do not have the required permission!");
            }
        }
        return false;
    }
}
