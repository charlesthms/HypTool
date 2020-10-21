package fr.hypnos.hyptool.commands;


import fr.hypnos.hyptool.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Commands implements CommandExecutor, TabCompleter {

    private Main plugin;

    public Commands(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        String message = plugin.getConfig().getString("message.mess1");
        final String prefix = ChatColor.AQUA+"["+ChatColor.GOLD+"HypTool"+ChatColor.AQUA+"] "+ChatColor.RESET;

        if (command.getName().equalsIgnoreCase("ht")) {
            for (String arg : args) {

                if (commandSender instanceof Player) {
                    // Check if the sender is a player
                    Player player = (Player) commandSender;

                    if (arg.equalsIgnoreCase("welcome")){
                        player.sendMessage(message + player.getName() + " !");
                        return true;
                    } else if (arg.equalsIgnoreCase("reload")) {
                        // Reloading config
                        plugin.reloadConfig();
                        player.sendMessage(prefix + ChatColor.GREEN+"Configuration reloaded !");
                        return true;
                    }

                } else {
                    // Console display
                    System.out.println("- Affichage console -\nCommande utilisee : " + command.getName() + "\nArgument : "+ Arrays.toString(args));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        // New arraylist of available commands
        ArrayList<String> subArgs = new ArrayList<>();
        subArgs.add("welcome");
        subArgs.add("reload");

        if (args.length == 1){
            // If argument exist then return the suggestions
            return subArgs;
        }
        return null;
    }
}
