package me.lowgod.hubbasics.commands;

import me.lowgod.hubbasics.HubBasics;
import me.lowgod.hubbasics.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hubBasicsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String hubAdminPermission = CC.translate(HubBasics.get().getConfig().getString("hub-admin-permission"));
        String helpMessage = CC.translate("&7&m----------------------------\n&b/hubbasics reload\n&b/hubbasics save\n&7&m----------------------------");

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission(hubAdminPermission)){
                if (args.length == 0){
                    player.sendMessage(helpMessage);
                }else if(args.length == 1){
                    if(args[0].equalsIgnoreCase("reload")){
                        HubBasics.get().reloadConfig();
                        player.sendMessage(CC.translate("&aConfig reloaded sucesfully"));
                    }else if(args[0].equalsIgnoreCase("save")){
                        HubBasics.get().saveConfig();
                        player.sendMessage(CC.translate("&aConfig sucesfully saved"));
                    }else{
                        player.sendMessage(helpMessage);
                    }
                }
            }
        }
        return true;
    }
}
