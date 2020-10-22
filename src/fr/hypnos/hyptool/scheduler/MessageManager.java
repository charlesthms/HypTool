package fr.hypnos.hyptool.scheduler;

import fr.hypnos.hyptool.Main;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;


public class MessageManager extends BukkitRunnable {

    private final Main plugin;
    private final int configSize;
    private String[] messages;
    private int index;
    private final String broadcastPrefix = ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "Annonce" + ChatColor.DARK_AQUA + "] ";

    public MessageManager(Main main) {
        this.plugin = main;
        this.index = 0;
        this.configSize = plugin.getConfig().getStringList("messages").size();
        createMessage();
    }


    @Override
    public void run() {
        plugin.getServer().broadcastMessage(getNextMessage());
    }

    public String getNextMessage() {
        final String message = messages[index];
        this.index++;

        if (index > messages.length - 1) {
            index = 0;
        }
        return message;
    }

    public void createMessage() {
        this.messages = new String[this.configSize];
        boolean state = false;

        for (int i = 0; i < messages.length; i++) {
            messages[i] = broadcastPrefix + ChatColor.GREEN +plugin.getConfig().getStringList("messages").get(i);
        }
    }
}
