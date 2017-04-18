package com.cocoapebbles.ScottsPluginBackpack.events.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.cocoapebbles.ScottsPluginBackpack.Main;
import com.cocoapebbles.ScottsPluginBackpack.utils.ConfigManager;
public class PlayerQuit implements Listener {
	private Main plugin;
	@EventHandler
	public void OnPlayerQuit(PlayerQuitEvent e)
	{
		Player player = (Player) e.getPlayer();
		ConfigManager cm = new ConfigManager(plugin,player);
		FileConfiguration f = cm.getConfig();
		String playerKey=player.getUniqueId().toString();
		Inventory inv = plugin.invMap.get(playerKey);
		ItemStack[] items= inv.getContents();
		ArrayList<ItemStack> flat_backpack=new ArrayList<ItemStack>();
		for(ItemStack i : items)
		{
			flat_backpack.add(i);
		}
		f.set("flat_backpack",flat_backpack);
		cm.saveConfig();
		plugin.invMap.remove(playerKey);
	}
	public PlayerQuit(Main plugin){this.plugin = plugin;}

}
