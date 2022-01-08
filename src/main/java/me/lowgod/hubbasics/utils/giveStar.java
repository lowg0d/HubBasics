package me.lowgod.hubbasics.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class giveStar {

    public static void giveStar(Player player)
    {

        Material type;
        ItemStack star = new ItemStack(Material.NETHER_STAR, 1);

        ItemMeta star_meta = star.getItemMeta();

        star_meta.setDisplayName(CC.translate("&5&oCosmetics"));

        star.setItemMeta(star_meta);

        player.getInventory().setItem(7, star);

    }

}
