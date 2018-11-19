package com.cocoapebbles.backpack.events.player;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.cocoapebbles.backpack.Main;
import com.cocoapebbles.backpack.utils.ConfigManager;

public class PlayerJoin implements Listener {
    private Main plugin;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = (Player) event.getPlayer();
        ConfigManager cm = new ConfigManager(plugin, player);
        if (!cm.exists()) {
            FileConfiguration f = cm.getConfig();
            f.set("name", player.getName());
            f.set("uuid", player.getUniqueId().toString());
            Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat(
                    "dd-MM-yyyy HH:mm:ss");
            f.set("join_date", format.format(now));
            f.set("last_join", format.format(now));
            cm.saveConfig();
            Inventory backpack = Bukkit.createInventory(null, 9, "Backpack");
            plugin.invMap.put(player.getUniqueId().toString(), backpack);
        } else {
            FileConfiguration f = cm.getConfig();
            Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            f.set("last_join", format.format(now));
            cm.saveConfig();
            Inventory backpack = Bukkit.createInventory(null, 9, "Backpack");
            List<ItemStack> flat_backpack = (List<ItemStack>) f.getList("flat_backpack");
            if (flat_backpack != null) {
                for (ItemStack i : flat_backpack) {
                    if (i!=null)
                        backpack.addItem(i);
                }
            }
            plugin.invMap.put(player.getUniqueId().toString(), backpack);
        }

    }

    public PlayerJoin(Main plugin) {
        this.plugin = plugin;
    }

}
