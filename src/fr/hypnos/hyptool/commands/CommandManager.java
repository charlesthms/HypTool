package fr.hypnos.hyptool.commands;

import fr.hypnos.hyptool.Main;
import fr.hypnos.hyptool.commands.subcommands.GetSite;
import fr.hypnos.hyptool.commands.subcommands.Hello;
import fr.hypnos.hyptool.commands.subcommands.Reload;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor, TabCompleter {

    // New arraylist of subcommands inside package subcommands
    private ArrayList<SubCommand> subcommands = new ArrayList<>();
    // New arraylist of available commands
    private ArrayList<String> subArgs = new ArrayList<>();

    private final Main plugin;

    public CommandManager(Main mainInstance) {
        this.plugin = mainInstance;
        subcommands.add(new Hello(plugin));
        subcommands.add(new Reload(plugin));
        subcommands.add(new GetSite(plugin));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length > 0) {
                for (SubCommand subcommand : subcommands) {
                    if (args[0].equalsIgnoreCase(subcommand.getName())) { // Si une des méthode getName() existe
                        subcommand.runCommand(player, args);
                    }
                }
            } else {
                player.sendMessage("---------- " + plugin.prefix + "----------");

                // Display all the commands syntax + description
                for (SubCommand subCommand : subcommands) {
                    player.sendMessage(ChatColor.RED + subCommand.getSyntax() + " - " + subCommand.getDescription());
                }
                player.sendMessage("-----------------------------");
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        // Adding all subcommands into the suggestion arraylist
        for (SubCommand subCommand : subcommands) {
            subArgs.add(subCommand.getName());
        }

        if (args.length == 1) {
            // If argument exist then return the suggestions
            return subArgs;
        }
        return null;
    }
}
