package me.lowgod.hubbasics.utils;

import me.lowgod.hubbasics.HubBasics;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.List;
import java.util.Map;

//######### MarvinLeiers - Marvin#2660 // thanks <3 ############//

public class generateArmor {
    public static void generateNewArmor(Player p, String helmetMaterial, String chestMaterial, String legginsMaterial,
                                        String bootsMaterial, String permission, String name, Color color, boolean glow){
        // get color

        Material helmet_material = Material.getMaterial(helmetMaterial);
        Material chestplate_material = Material.getMaterial(chestMaterial);
        Material leggings_material = Material.getMaterial(legginsMaterial);
        Material boots_material = Material.getMaterial(bootsMaterial);

        //ItemStacks
        Material type;
        ItemStack Helm = new ItemStack(helmet_material, 1);
        ItemStack Chest = new ItemStack(chestplate_material, 1);
        ItemStack Legs = new ItemStack(leggings_material, 1);
        ItemStack Boots = new ItemStack(boots_material, 1);


        //Glow option
        if (glow) {
            Helm.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            Chest.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            Legs.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            Boots.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        }

        //Durability set to max
        Helm.setDurability((short) -55);
        Chest.setDurability((short) -80);
        Legs.setDurability((short) -75);
        Boots.setDurability((short) -65);

        //ItemMeta
        LeatherArmorMeta Helm_meta = (LeatherArmorMeta) Helm.getItemMeta();
        LeatherArmorMeta Chest_meta = (LeatherArmorMeta) Chest.getItemMeta();
        LeatherArmorMeta Legs_meta = (LeatherArmorMeta) Legs.getItemMeta();
        LeatherArmorMeta Boots_meta = (LeatherArmorMeta) Boots.getItemMeta();

        //DisplayName
        Helm_meta.setDisplayName(CC.translate(name));
        Chest_meta.setDisplayName(CC.translate(name));
        Legs_meta.setDisplayName(CC.translate(name));
        Boots_meta.setDisplayName(CC.translate(name));

        //ArmorColor
        Helm_meta.setColor(color);
        Helm_meta.setColor(color);
        Chest_meta.setColor(color);
        Legs_meta.setColor(color);
        Boots_meta.setColor(color);

        //Set item meta to item
        Helm.setItemMeta(Helm_meta);
        Chest.setItemMeta(Chest_meta);
        Legs.setItemMeta(Legs_meta);
        Boots.setItemMeta(Boots_meta);

        // Check if player has permission
        if (p.hasPermission(permission)) {
            //Equip items to player
            p.getEquipment().setHelmet(Helm);
            p.getEquipment().setChestplate(Chest);
            p.getEquipment().setLeggings(Legs);
            p.getEquipment().setBoots(Boots);
        }

    }

    public static void getConfigArmorAndGenerate(Player player) {
        FileConfiguration config = HubBasics.get().getConfig();

        for (Map.Entry<String, Object> entry : config.getConfigurationSection("ARMORS.").getValues(false).entrySet()) {
            String path = "ARMORS." + entry.getKey(); // can be ARMORS.1, ARMORS.2, etc
            String armorPermission = config.getString(path + ".Permission");

            System.out.println(player.hasPermission(armorPermission) + " ?");

            if (!player.hasPermission(armorPermission))
                continue;

            /*Get Materials*/
            String helmetMaterial = config.getString(path + ".MATERIAL.helmet");
            String chestMaterial = config.getString(path + ".MATERIAL.chestplate");
            String leggingsMaterial = config.getString(path + ".MATERIAL.leggings");
            String bootsMaterial = config.getString(path + ".MATERIAL.boots");
            String name = config.getString(path + ".Name");

            Color color = getColor(config.getString(path + ".MATERIAL.color"));


            boolean glowEnabled = config.getBoolean(path + ".Glow");

            generateNewArmor(player, helmetMaterial, chestMaterial, leggingsMaterial, bootsMaterial, armorPermission, name, (Color) color, glowEnabled);
        }
    }
    static Color getColor(String color_string) {
        switch (color_string) {
            case "RED":
                return Color.RED;
            case "AQUA":
                return Color.AQUA;
            case "BLUE":
                return Color.BLUE;
            case "BLACK":
                return Color.BLACK;
            case "GRAY":
                return Color.GRAY;
            case "GREEN":
                return Color.GREEN;
            case "LIME":
                return Color.LIME;
            case "ORANGE":
                return Color.ORANGE;
            case "PURPLE":
                return Color.PURPLE;
            case "WHITE":
                return Color.WHITE;
            case "YELLOW":
                return Color.YELLOW;
            default:
                return null;
        }
    }
}
