package me.lowgod.hubbasics.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryClickEvent implements Listener {

    @EventHandler
    public void clickEvent(org.bukkit.event.inventory.InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("&5&oCosmetics"))
        {

            player.sendMessage("sexo online.com");

        }

        e.setCancelled(true);

    }

}
