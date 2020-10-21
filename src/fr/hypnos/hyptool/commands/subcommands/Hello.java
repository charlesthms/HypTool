package fr.hypnos.hyptool.commands.subcommands;

import fr.hypnos.hyptool.Main;
import fr.hypnos.hyptool.commands.CommandManager;
import fr.hypnos.hyptool.commands.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Hello extends SubCommand{

    private Main plugin;

    public Hello(Main plugin) {
        super();
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public String getDescription() {
        return "Display a cool message.";
    }

    @Override
    public String getSyntax() {
        return "Usage : /ht hello";
    }

    @Override
    public void runCommand(Player player, String[] args) {

        plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Command working");

        final String prefix = ChatColor.GOLD+"["+ChatColor.AQUA+"HypTool"+ChatColor.GOLD+"] "+ChatColor.RESET;

        if (args.length == 1) {
            player.sendMessage(prefix + ChatColor.DARK_PURPLE + "Bonjour " + player.getName());
        } else {
            getSyntax();
        }

    }

}
