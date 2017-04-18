package com.cocoapebbles.ScottsPluginHoe.commands;
import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class CreateHoe implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel,
			String[] args) {
		if(!(sender instanceof Player))
		{
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		ItemStack item = new ItemStack(Material.DIAMOND_HOE);
		ItemMeta itemMeta=item.getItemMeta();
		
		ArrayList<String> my_lore=new ArrayList<String>();
		my_lore.add("A magic hoe");
		itemMeta.setLore(my_lore);
		item.setItemMeta(itemMeta);
		item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		player.getInventory().addItem(item);
		player.sendMessage("A gift for you");
		return true;
		// TODO Auto-generated method stub
	}

	public CreateHoe(){};
}
