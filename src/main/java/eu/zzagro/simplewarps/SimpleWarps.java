package eu.zzagro.simplewarps;

import eu.zzagro.simplewarps.commands.DeleteWarpCmd;
import eu.zzagro.simplewarps.commands.SetWarpCmd;
import eu.zzagro.simplewarps.commands.WarpCmd;
import eu.zzagro.simplewarps.commands.WarpListCmd;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleWarps extends JavaPlugin {

    public String prefix = ChatColor.GOLD + "SimpleWarps " + ChatColor.WHITE + ">> ";

    @Override
    public void onEnable() {
        customConfig();

        getCommand("setwarp").setExecutor(new SetWarpCmd(this));
        getCommand("warp").setExecutor(new WarpCmd(this));
        getCommand("warplist").setExecutor(new WarpListCmd(this));
        getCommand("deletewarp").setExecutor(new DeleteWarpCmd(this));
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public void customConfig() {
        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
