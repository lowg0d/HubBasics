package me.lowgod.hubbasics;

import me.lowgod.hubbasics.commands.FlyCommand;
import me.lowgod.hubbasics.commands.hubBasicsCommand;
import me.lowgod.hubbasics.events.onPLayerQuit;
import me.lowgod.hubbasics.events.onPlayerJoin;
import me.lowgod.hubbasics.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class HubBasics extends JavaPlugin {

    //--- Get Console sender ---
    ConsoleCommandSender c = Bukkit.getConsoleSender();

    @Override
    public void onEnable() {
        String PluginLogPrefix = "[HubBasics]";

        // Plugin startup
        c.sendMessage(CC.translate("&5=============================================")); // log
        c.sendMessage(CC.translate("&dLoading HubBasics V: &f" + getDescription().getVersion())); // log
        c.sendMessage(CC.translate("&dSupport discord: &bhttps://discord.gg/jdXWKxUkVu\n")); // lo
        // Loads Config
        System.out.println(PluginLogPrefix + "Loading Config..."); // log
        this.setupConfig(); // setUp config method
        c.sendMessage(CC.translate("&a"+PluginLogPrefix + "&aConfig sucesfully loaded !")); // log
        // Load Commands
        System.out.println(PluginLogPrefix + "Loading Commands..."); // log
        this.setupCommands(); // setUp commands
        c.sendMessage(CC.translate("&a"+PluginLogPrefix +"&aCommands sucesfully loaded !")); // log
        // Load events
        System.out.println(PluginLogPrefix +"Loading Listeners..."); // log
        this.setupEvents();
        c.sendMessage(CC.translate("&a"+PluginLogPrefix +"&aListeners sucesfully loaded !")); // log
        c.sendMessage(CC.translate("&5=============================================")); // log
    }

    /*
    --- ENABLE METHODS ---
                            */

    // commands
    private void setupCommands() {
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("hubbasics").setExecutor(new hubBasicsCommand());
    }

    //Events
    private void setupEvents() {
        getServer().getPluginManager().registerEvents(new onPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new onPLayerQuit(), this);
    }

    // get config
    private void setupConfig(){
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }


    // -- GET MAIN --
    public static HubBasics get() {
        return getPlugin(HubBasics.class);
    }
    //Colors
        /*
        int RED = 0xFF0000;
        int AQUA = 0x00FFFF;
        int BLACK = 0x000000;
        int BLUE = 0x0000FF;
        int GRAY = 0x808080;
        int GREEN = 0x008000;
        int LIME = 0x00FF00;
        int ORANGE = 0xFFA500;
        int PURPLE = 0x800080;
        int WHITE = 0xFFFFFF;
        int YELLOW = 0xFFFF00;
        */

}
