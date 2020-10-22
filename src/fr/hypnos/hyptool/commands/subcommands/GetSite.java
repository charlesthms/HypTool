package fr.hypnos.hyptool.commands.subcommands;

import fr.hypnos.hyptool.Main;
import fr.hypnos.hyptool.commands.SubCommand;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GetSite extends SubCommand {

    Main plugin;

    public GetSite(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "site";
    }

    @Override
    public String getDescription() {
        return "Affiche le lien du site d'Helirium.";
    }

    @Override
    public String getSyntax() {
        return "/helirium site";
    }

    @Override
    public void runCommand(Player player, String[] args) {

        String broadcastPrefix = ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "Annonce" + ChatColor.DARK_AQUA + "] ";

        if (args.length > 1) {
            player.sendMessage(ChatColor.RED + "Trop d'arguments ! Utilisez: " + getSyntax());
        } else {
            TextComponent site = new TextComponent(broadcastPrefix+"§dHelirium");
            site.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§6Ouvir le site")));
            site.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://helirium.fr"));
            player.spigot().sendMessage(site);
        }
    }
}
