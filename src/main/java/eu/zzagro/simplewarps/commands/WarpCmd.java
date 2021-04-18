package eu.zzagro.simplewarps.commands;

import eu.zzagro.simplewarps.SimpleWarps;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCmd implements CommandExecutor {

    private final SimpleWarps plugin;

    public WarpCmd(SimpleWarps plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("setwarps.warp")) {
                if (command.getName().equalsIgnoreCase("warp")) {
                    if (args.length != 1) {
                        player.sendMessage(plugin.prefix + ChatColor.RED + "Usage: /warp <name>");
                    } else {
                        String getName = new String(args[0]);
                        if (!(plugin.getConfig().contains(args[0]))) {
                            player.sendMessage(plugin.prefix + ChatColor.RED + "The Warp you entered doesn't exist!");
                        } else {
                            player.teleport((Location) plugin.getConfig().get(args[0] + ".location"));
                            player.sendMessage(plugin.prefix + ChatColor.GREEN + "Warped to " + ChatColor.GOLD + args[0]);
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
