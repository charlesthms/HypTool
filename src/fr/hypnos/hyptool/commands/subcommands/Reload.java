package fr.hypnos.hyptool.commands.subcommands;

import fr.hypnos.hyptool.Main;
import fr.hypnos.hyptool.commands.SubCommand;
import fr.hypnos.hyptool.scheduler.MessageManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Reload extends SubCommand {

    private final Main plugin;

    public Reload(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reload config.yml file.";
    }

    @Override
    public String getSyntax() {
        return "/reload";
    }

    @Override
    public void runCommand(Player player, String[] args) {

        if (args.length == 1) {
            plugin.reloadConfig();
            player.sendMessage(plugin.prefix + ChatColor.GREEN + "Config reloaded.");
        } else if (args.length > 1) {
            player.sendMessage(plugin.prefix + "Erreur de syntaxe, utilisez : " + getSyntax());
        }
    }
}
