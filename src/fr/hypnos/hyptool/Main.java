package fr.hypnos.hyptool;


import fr.hypnos.hyptool.commands.CommandManager;
import fr.hypnos.hyptool.scheduler.MessageManager;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


public class Main extends JavaPlugin {

    public final String prefix = ChatColor.GOLD + "[" + ChatColor.AQUA + "HypTool" + ChatColor.GOLD + "] " + ChatColor.RESET;

    @Override
    public void onEnable() {

        BukkitTask sendMessages = new MessageManager(this).runTaskTimer(this, 20L * 20, 20L * 60);

        saveDefaultConfig();
        getCommand("helirium").setExecutor(new CommandManager(this));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "HypTool successfully loaded !");
    }

    @Override
    public void onDisable() {
        getLogger().info("HypTool disabled.");
    }


}
