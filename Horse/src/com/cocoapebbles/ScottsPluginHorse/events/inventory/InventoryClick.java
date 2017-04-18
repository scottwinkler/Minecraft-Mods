package com.cocoapebbles.ScottsPluginHorse.events.inventory;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Sound;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.HorseInventory;

public class InventoryClick implements Listener{
	@EventHandler
public void onInventoryClick(InventoryClickEvent event)
{

	if(event.getClickedInventory() instanceof HorseInventory)
	{
		@SuppressWarnings("deprecation")
		Horse horse =(Horse) event.getClickedInventory().getHolder();
		if (horse.getName()=="Roach")
		{
			Player player=(Player)event.getWhoClicked();
			player.sendMessage(ChatColor.RED + "No stealing from Roach!!");
			player.playSound(player.getLocation(), Sound.ENTITY_HORSE_DEATH, 3, 1);
			player.setItemOnCursor(null);
			event.setCancelled(true);
		}
	}
	}
}
