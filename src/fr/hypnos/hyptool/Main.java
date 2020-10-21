package fr.hypnos.hyptool;


import fr.hypnos.hyptool.commands.Commands;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Main plugin;

    public void setPlugin(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("ht").setExecutor(new Commands(this));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "HypTool successfully loaded !");
    }

    @Override
    public void onDisable() {
        getLogger().info("HypTool disabled.");
    }

}
