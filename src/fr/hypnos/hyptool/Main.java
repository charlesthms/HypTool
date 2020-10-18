package fr.hypnos.hyptool;


import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        Helirium helirium = new Helirium();

        getLogger().info("HypTool successfully loaded !");
        this.getCommand("helirium").setExecutor(helirium);
    }

    @Override
    public void onDisable() {
        getLogger().info("HypTool disabled.");
    }
}
