package fr.hypnos.hyptool.commands.subcommands;

import fr.hypnos.hyptool.Main;
import fr.hypnos.hyptool.commands.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Hello extends SubCommand {

    private final Main plugin;

    public Hello(Main plugin) {
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
        return "/ht hello <message number>";
    }

    @Override
    public void runCommand(Player player, String[] args) {
        if (args.length == 1) {
            player.sendMessage(plugin.prefix + ChatColor.GREEN + "Pas assez d'arguments !\n" + getSyntax());
        } else if (args.length == 2) {
            String message = plugin.getConfig().getString("hello.mess" + args[1]);
            player.sendMessage(ChatColor.DARK_PURPLE + message + player.getName() + " !");
        } else if (args.length > 2) {
            player.sendMessage(ChatColor.GREEN + getSyntax());
        }
    }

}
