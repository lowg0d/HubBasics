package me.lowgod.hubbasics.events;
import me.lowgod.hubbasics.utils.generateArmor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.lowgod.hubbasics.utils.giveStar.giveStar;

public class onPlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        //Give armor
        generateArmor.getConfigArmorAndGenerate(player);

        //give star
        giveStar(player);

    }

}
