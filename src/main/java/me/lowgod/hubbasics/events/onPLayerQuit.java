package me.lowgod.hubbasics.events;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onPLayerQuit implements Listener{
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        player.getInventory().clear();
        player.getEquipment().clear();
    }
}
