package me.lowgod.hubbasics.commands;

import me.lowgod.hubbasics.HubBasics;
import me.lowgod.hubbasics.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // immortal del comando

        // strings de la config
        String FlyPermission = CC.translate(HubBasics.get().getConfig().getString("FLY.fly-permission"));
        String FlyGivePermission = CC.translate(HubBasics.get().getConfig().getString("FLY.fly-give-permission"));

        String NotPermissionMessage = CC.translate(HubBasics.get().getConfig().getString("FLY.fly-no-permission-message"));

        String FlyEnabledMessage = CC.translate(HubBasics.get().getConfig().getString("FLY.fly-enabled-message"));
        String FlyDisabledMessage = CC.translate(HubBasics.get().getConfig().getString("FLY.fly-disabled-message"));

        // si el que ejectulo el comando es un jugador
        if (sender instanceof Player) {
            Player p = (Player) sender;

            String FlyEnabledByMessage = CC.translate(HubBasics.get().getConfig().getString("FLY.fly-enabled-by-message").replace("{sender}", p.getDisplayName()));
            String FlyDisabledByMessage = CC.translate(HubBasics.get().getConfig().getString("FLY.fly-disabled-by-message").replace("{sender}", p.getDisplayName()));

            // si el comando no tiene argumentos
            if(args.length == 0){

                // si tiene permiso para ejecutar el comando /fly
                if (p.hasPermission(FlyPermission)){

                    // si tiene activado el permiso para volar
                    if (p.getAllowFlight() == false) {
                        p.setAllowFlight(true); // desactiva el permiso para volar
                        p.sendMessage(FlyEnabledMessage);

                        // si no esta activado el permiso apra volar lo activa
                    } else {
                        p.setAllowFlight(false); // activar el permiso para volar
                        p.sendMessage(FlyDisabledMessage);
                    }


                    // si no tiene permiso
                }else{
                    p.sendMessage(NotPermissionMessage);
                }


                // Si solo tiene un argumento
            }

            else if(args.length == 1){

                // si tiene permiso para dar o quitar fly a otros usuarios
                if (p.hasPermission(FlyGivePermission)){

                    Player target = Bukkit.getPlayerExact(args[0]);

                    if(target instanceof Player){
                        // si tiene activado el permiso para volar
                        if (target.getAllowFlight() == false) {
                            target.setAllowFlight(true); // desactiva el permiso para volar
                            target.sendMessage(FlyEnabledByMessage + " " + p.getDisplayName());
                            p.sendMessage(CC.translate("&aFly enabled to &e" + target.getDisplayName()));

                            // si no esta activado el permiso apra volar lo activa
                        } else {
                            target.setAllowFlight(false); // activar el permiso para volar
                            target.sendMessage(FlyDisabledByMessage + " " + p.getDisplayName());
                            p.sendMessage(CC.translate("&cFly disabled to &e" + target.getDisplayName()));
                        }

                        // si no tiene permisos
                    }else{
                        p.sendMessage(CC.translate("&cThat player doesen't exist"));
                    }

                }else{
                    p.sendMessage(NotPermissionMessage);
                }

                // si tiene mas de un argumento
            }else{
                p.sendMessage("Correct Usage: /fly");
            }


            /////////////////////

            // si el que ejecuto el comando es la consola
        } else {

            String FlyEnabledByMessage = CC.translate(HubBasics.get().getConfig().getString("FLY.fly-enabled-by-message")).replace("{sender}", "&7Console");
            String FlyDisabledByMessage = CC.translate(HubBasics.get().getConfig().getString("FLY.fly-disabled-by-message").replace("{sender}", "&7Console"));

            // SI los argumentos son menores que 0 es decir no hay
            if (args.length < 0) {
                System.out.println("Correct usage: /fly [player]");

                // en el caso de que haya 1
            } else if (args.length == 1) {
                //establece "target" como jugador
                Player target = Bukkit.getPlayerExact(args[0]);

                // si el jugador enviado por la consola es un jugador
                if (target instanceof Player) {

                    // si tiene activado el permiso para volar
                    if (target.getAllowFlight() == false) {
                        target.setAllowFlight(true); // desactiva el permiso para volar
                        target.sendMessage(CC.translate(FlyEnabledByMessage));
                        System.out.println("fly enabled for: " +target.getDisplayName());

                        // si no esta activado el permiso apra volar lo activa
                    } else {
                        target.setAllowFlight(false); // activar el permiso para volar
                        target.sendMessage(CC.translate(FlyDisabledByMessage));
                        System.out.println("fly disabled for: " +target.getDisplayName());
                    }
                    // en el caso de que haya mas argumentos
                } else {
                    System.out.println("That Players dosen't exits");
                }

            } else {
                System.out.println("Correct usage: /fly [player]");
            }
        }

        return true;
    }
}
