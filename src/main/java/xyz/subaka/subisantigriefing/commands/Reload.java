package xyz.subaka.subisantigriefing.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.subaka.subisantigriefing.SubisAntiGriefing;

public class Reload implements CommandExecutor {

    private final SubisAntiGriefing plugin;

    public Reload(SubisAntiGriefing plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            // Reload the config file
            plugin.reloadConfig();
            sender.sendMessage("SubisAntiGriefing configuration reloaded.");

            // Disable and re-enable the plugin to apply changes
            plugin.getServer().getPluginManager().disablePlugin(plugin);
            plugin.getServer().getPluginManager().enablePlugin(plugin);
            return true;
        }
        return false;
    }
}
