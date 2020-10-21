package fr.hypnos.hyptool.commands;

import fr.hypnos.hyptool.Main;
import fr.hypnos.hyptool.commands.subcommands.Hello;
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

    private Main plugin;

    public CommandManager(Main mainInstance) {
        this.plugin = mainInstance;
        subcommands.add(new Hello(plugin));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length > 0) {
                for (SubCommand subcommand : subcommands) {
                    if (args[0].equalsIgnoreCase(subcommand.getName())) { // Si une des méthode getName()
                        subcommand.runCommand(player, args);
                    }
                }
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

        if (args.length == 1){
            // If argument exist then return the suggestions
            return subArgs;
        }
        return null;
    }
}
