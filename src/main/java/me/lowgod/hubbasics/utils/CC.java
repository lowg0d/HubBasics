package me.lowgod.hubbasics.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class CC
{
    public static String translate(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static List<String> translate(List<String> string)
    {
        if (string == null)
            return null;

        List<String> list = new ArrayList<>();

        for (String str : string)
            list.add(ChatColor.translateAlternateColorCodes('&', str));

        return list;
    }
}
