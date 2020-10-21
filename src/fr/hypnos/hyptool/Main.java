package fr.hypnos.hyptool;


import fr.hypnos.hyptool.commands.CommandManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("ht").setExecutor(new CommandManager(this));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "HypTool successfully loaded !");
    }

    @Override
    public void onDisable() {
        getLogger().info("HypTool disabled.");
    }

}
